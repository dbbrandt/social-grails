package com.nobleavatar.client;

import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.JApplet;
import javax.swing.UIManager;

import com.nobleavatar.client.view.gui.plaf.GameLookAndFeel;
import com.noblemaster.lib.access.Access;
import com.noblemaster.lib.access.AudioException;
import com.noblemaster.lib.access.AudioExceptionListener;
import com.noblemaster.lib.access.AudioLoader;
import com.noblemaster.lib.notifier.NotifierListener;
import com.noblemaster.lib.out.log.Error;
import com.noblemaster.lib.out.log.ErrorOutputUnit;
import com.noblemaster.lib.out.log.FileOutputUnit;
import com.noblemaster.lib.out.log.MultiOutputUnit;

/**
 * Main class to run the client.
 * 
 * @author Christoph Aschwanden
 * @since April 11, 2008
 */
public final class AppClient extends JApplet implements NotifierListener<Core.CoreChange> {

  /**
   * Initialization, either Applet or Application.
   * 
   * @param parameter  The parameter to use for initialization.
   * @return  The core.
   */
  public static Core initialize(String parameter) {
    // start memory tracker
    // king.lib.util.MemoryTracker.getInstance().start();
    
    // output version
    System.out.println("Release: " + AppClientRelease.getReleaseVersion()
                             + " " + AppClientRelease.getReleaseTime());
    
    // Set error output
    MultiOutputUnit multiOutput = new MultiOutputUnit();
    ErrorOutputUnit errorOutput = new ErrorOutputUnit();
    multiOutput.add(errorOutput);
    multiOutput.setShowTime(true);
    try {
      FileOutputUnit fileOutput = new FileOutputUnit(Access.getInstance().getScenarioDir() 
                                                   + "/logs/error.log", true);
      multiOutput.add(fileOutput);
    }
    catch (IOException e) {
      System.out.println("Cannot create error.log file: " + e);
    }
    Error.setOutputUnit(multiOutput);
        
    // Set UI Manager
    try {
      UIManager.setLookAndFeel(new GameLookAndFeel());
    }
    catch (Exception e) {
      Error.out(e);
    }
    UIManager.getLookAndFeelDefaults().put("ClassLoader", GameLookAndFeel.class.getClassLoader());
    
    // monitor Swing is fully executed on EDT.
    com.noblemaster.lib.misc.RepaintManagerHandler.installThreadCheckingRepaintManager();
    
    // Tooltips heavyweight, so always visible and shown quickly
    ToolTipManager.sharedInstance().setInitialDelay(300);
    ToolTipManager.sharedInstance().setReshowDelay(0);
    ToolTipManager.sharedInstance().setDismissDelay(8000);
    
    // Listen for audio errors
    AudioLoader.getInstance().addAudioExceptionListener(new AudioExceptionListener() {
      public void audioExceptionThrown(AudioException audioException) {
        Error.out("Error playing audio: " + audioException);
      }
    });  
    
    // the core to use
    return new Core(parameter);
  }
  
  /**
   * Init used for applet.
   */
  public void init() {
    // Start Applet in Swing EDT (safer)
    final AppClient applet = this;
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        // Init access (applet)
        try {
          Access.init(applet);
        }
        catch (Exception e) {
          Error.out("Error during init: " + e);
        }
        
        // initialize
        Core core = initialize(getParameter("args"));
        
        // Add core menu
        CoreMenu coreMenu = new CoreMenu(core);
        setJMenuBar(coreMenu);
        
        // Add core panel
        CorePanel corePanel = new CorePanel(core);
        corePanel.setSize(getSize());
        setContentPane(corePanel);
        
        // add listener for changes
        core.addNotifierListener(applet);   
      }
    });
  }

  /**
   * If something changes in the simulation. I.e. applet minimized.
   * 
   * @param change  The change that occured.
   */
  public void update(Core.CoreChange change) {
    if (change == Core.CoreChange.FULL_SCREEN_MODE) {
      // full-screen: impossible for applet
    }
    else if (change == Core.CoreChange.WINDOW_MODE) {
      // make window: impossible for applet
    }
    else if (change == Core.CoreChange.MINIMIZE) {
      // iconify: impossible for applet
    }
  }
    
  /**
   * Main method to start the application.
   * 
   * @param args  The arguments during program start.
   */
  public static void main(final String[] args) {
    // Start application in Swing EDT (safer)
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        // analyze parameter
        String parameter = ((args == null) || (args.length == 0)) ? null : args[0];
        if (parameter == null) {
          System.setProperty("jarexe", "true");
          System.setProperty("webstart.dir", "NobleAvatar");
        }
        
        // Init access (webstart or regular application)
        try {
          Access.init();
        }
        catch (Exception e) {
          Error.out("Error during init: " + e);
        }

        // initialize
        Core core = initialize(parameter);
        
        // open window
        new AppClientWindow(core);
      }
    });
  }
}