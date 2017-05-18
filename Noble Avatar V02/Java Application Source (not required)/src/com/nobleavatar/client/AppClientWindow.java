package com.nobleavatar.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.noblemaster.lib.access.Access;
import com.noblemaster.lib.access.ImageLoader;
import com.noblemaster.lib.notifier.NotifierListener;
import com.noblemaster.lib.out.log.Error;
import com.noblemaster.lib.out.log.FileOutputUnit;
import com.noblemaster.lib.out.log.MultiOutputUnit;
import com.noblemaster.lib.out.log.SystemOutputUnit;


/**
 * City game window.
 *
 * @author Christoph Aschwanden
 * @since April 14, 2007
 */
class AppClientWindow extends JFrame implements NotifierListener<Core.CoreChange> {

  /**
   * Creates the main full-screen window which displays the game.
   *
   * @param core  The core to start the application with.
   */
  public AppClientWindow(final Core core) {
    super(Configuration.getInstance().getString("client.Title"));
    
    // init main frame
    setIconImage(ImageLoader.getInstance().getImage("conf/image/logo/WindowIcon.gif"));
    addComponentListener(new ComponentAdapter() {
      // hack to make sure that minimum size is followed
      // -> setMinimumSize(...) does not work as of JDK5.0
      public void componentResized(ComponentEvent event) {      
        if (!isUndecorated()) {
          // just resize so it isn't below minimum
          int minimumWidth = Configuration.MINIMUM_PANEL_SIZE.width;
          int minimumHeight = Configuration.MINIMUM_PANEL_SIZE.height;
          int width = (getWidth() < minimumWidth) ? minimumWidth : getWidth();
          int height = (getHeight() < minimumHeight) ? minimumHeight : getHeight();
          Dimension size = new Dimension(width, height);
          setSize(size);
          Configuration.getInstance().setWindowSize(size);
          Configuration.getInstance().saveConfiguration();
        }
      }
      public void componentMoved(ComponentEvent event) {
        if (!isUndecorated()) {
          int x = getX();
          int y = getY();
          Point position = new Point(x, y);
          Configuration.getInstance().setWindowPosition(position);
          Configuration.getInstance().saveConfiguration();
        }
      }
    });
    
    // exit if close clicked
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        core.exit();
      }
    });

    // set background color
    setBackground(Color.BLACK);

    // set default startup size
    setFullScreen(Configuration.getInstance().isFullScreen());
    
    // Add core menu
    CoreMenu coreMenu = new CoreMenu(core);
    setJMenuBar(coreMenu);

    // Add simulation panel
    CorePanel corePanel = new CorePanel(core);
    corePanel.setSize(getSize());
    setContentPane(corePanel);
    
    // add listener for changes
    core.addNotifierListener(this);

    // make the window visible
    setVisible(true);
    validate();
  }
  
  /**
   * If something changes; i.e. frame minimized.
   * 
   * @param change  The change that occured.
   */
  public void update(Core.CoreChange change) {
    if (change == Core.CoreChange.FULL_SCREEN_MODE) {
      // make full-screen
      setFullScreen(true);
    }
    else if (change == Core.CoreChange.WINDOW_MODE) {
      // make window
      setFullScreen(false);
    }
    else if (change == Core.CoreChange.MINIMIZE) {
      // iconify
      setState(Frame.ICONIFIED);
    }
  }
  
  /**
   * Sets the program to full screen.
   * 
   * @param fullScreen  True for full screen, false otherwise.
   */
  public void setFullScreen(boolean fullScreen) {
    dispose();  // needs to be called before change (makes invisible)
    
    if (!fullScreen) {
      // change to non-fullscreen mode
      setResizable(true);
      setUndecorated(false);

      // set location and size
      Point position = Configuration.getInstance().getWindowPosition();
      Dimension size = Configuration.getInstance().getWindowSize();
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = position.x;
      int y = position.y;
      int width = size.width;
      int height = size.height;
      if (x < 0) {
        x = 0;
      }
      if (y < 0) {
        y = 0;
      }
      if (x + width > screenSize.width) {
        width = screenSize.width - x;
      }
      if (y + height > screenSize.height) {
        height = screenSize.height - y;
      }
      setLocation(new Point(x, y));
      setSize(new Dimension(width, height));    
      if ((width >= (screenSize.width - 40)) && (height >= (screenSize.height - 40))) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
      }
    }
    else {
      // make fullscreen
      setResizable(false);
      setUndecorated(true);

      // set output unit to log screen change information
      SystemOutputUnit consoleOutput = new SystemOutputUnit();
      MultiOutputUnit output = new MultiOutputUnit();
      output.add(consoleOutput);
      output.setShowTime(true);
      try {
        FileOutputUnit fileOutput = new FileOutputUnit(Access.getInstance().getScenarioDir() 
                                                     + "/logs/screen.log", true);
        output.add(fileOutput);
      }
      catch (IOException e) {
        Error.out("Cannot create screen.log file: " + e);
      }
      
      // set default values
      int bitDepth = 16;
      int minWidth = Configuration.MINIMUM_PANEL_SIZE.width;
      int minHeight = Configuration.MINIMUM_PANEL_SIZE.height;
      int preferredWidth = 1024;
      int preferredHeight = 768;
      
      // get default graphics environment
      GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice device = environment.getDefaultScreenDevice();  
      DisplayMode currentMode = device.getDisplayMode();
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      
      // Full screen window (hardware accelerated - doesn't seem to work!)
      boolean hardwareAccelerated = device.isFullScreenSupported();  // problems on certain computers!
      boolean fullScreenWindow;
      if (hardwareAccelerated) {
        try {
          // try to set full screen mode
          device.setFullScreenWindow(this);    
          setLocation(0, 0);
          setSize(toolkit.getScreenSize().width, toolkit.getScreenSize().height);
          fullScreenWindow = true;
          output.out("Hardware Accelerated Full Screen Mode Entered.");
        }
        catch (Exception e) {
          // if error, just make window full screen
          device.setFullScreenWindow(null);
          setLocation(0, 0);
          setSize(toolkit.getScreenSize().width, toolkit.getScreenSize().height);
          fullScreenWindow = false;
          output.out("NON-Hardware Accelerated Full Screen Mode Entered.");
        }
      }
      else {
        // non hardware accelerated by default
        fullScreenWindow = false;
        setLocation(0, 0);
        setSize(toolkit.getScreenSize().width, toolkit.getScreenSize().height);      
        output.out("NON-Hardware Accelerated Full Screen Mode Entered (Default).");
      }
  
      // Screen resolution
      if ((currentMode.getWidth() < minWidth) 
       || (currentMode.getHeight() < minHeight)
       || (currentMode.getBitDepth() < bitDepth)) {
        
        // Try resolution with same size & bit depth
        DisplayMode[] modes = device.getDisplayModes();
        for (int i = 0; i < modes.length; i++) {
          if ((modes[i].getWidth() == preferredWidth) 
           && (modes[i].getHeight() == preferredHeight)
           && (modes[i].getBitDepth() == bitDepth)) {
            try {
              output.out("Changing screen resolution (Preferred): " 
                                 + modes[i].getWidth() + "x" + modes[i].getHeight() + "x" + modes[i].getBitDepth());
              device.setDisplayMode(modes[i]);
              setSize(toolkit.getScreenSize().width, toolkit.getScreenSize().height);
            }
            catch (Exception e) {
              output.out("Error changing screen resolution (Preferred): " + e);
            }
            return;
          }
        }
        
        // Try resolution with bigger size
        for (int i = 0; i < modes.length; i++) {
          if ((modes[i].getWidth() >= minWidth) 
           && (modes[i].getHeight() >= minHeight)
           && (modes[i].getBitDepth() == bitDepth)) {
            try {
              output.out("Changing screen resolution (Minimum): "
                                 + modes[i].getWidth() + "x" + modes[i].getHeight() + "x" + modes[i].getBitDepth());
              device.setDisplayMode(modes[i]);
              setSize(toolkit.getScreenSize().width, toolkit.getScreenSize().height);
            }
            catch (Exception e) {
              output.out("Error changing screen resolution (Minimum): " + e);
            }
            return;
          }
        }
        output.out("Screen resolution cannot be changed - using default: "
                   + currentMode.getWidth() + "x" + currentMode.getHeight() + "x" + currentMode.getBitDepth());
      }
      else {
        output.out("Screen resolution not changed - using current one: "
                   + currentMode.getWidth() + "x" + currentMode.getHeight() + "x" + currentMode.getBitDepth());
      }
    }
    
    // and make visible again
    setVisible(true);
  }    
}