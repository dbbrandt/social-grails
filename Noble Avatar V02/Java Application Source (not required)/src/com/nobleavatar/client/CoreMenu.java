package com.nobleavatar.client;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.nobleavatar.client.model.Avatar;
import com.nobleavatar.client.model.AvatarManager;
import com.nobleavatar.client.state.GeneratorState;
import com.nobleavatar.client.state.State;
import com.nobleavatar.client.view.AvatarImage;
import com.nobleavatar.client.view.CreditsDialog;
import com.noblemaster.lib.access.Access;
import com.noblemaster.lib.access.AccessException;
import com.noblemaster.lib.misc.SimpleFileFilter;
import com.noblemaster.lib.notifier.NotifierListener;
import com.noblemaster.lib.out.log.Error;

/**
 * The menu bar. 
 *
 * @author   king
 * @since    June 23, 2008
 */
public class CoreMenu extends JMenuBar implements NotifierListener<Core.CoreChange> {

  /** The core associated with this panel. */
  private Core core;

  /** The avatar file or null for none. */
  private File avatarFile;
  
  /** The file menu. */
  private JMenu fileMenu;
  /** The new menu item. */
  private JMenuItem newMenuItem;
  /** The load menu item. */
  private JMenuItem loadMenuItem;
  /** The save menu item. */
  private JMenuItem saveMenuItem;
  /** The save as menu item. */
  private JMenuItem saveAsMenuItem;
  /** The export menu item. */
  private JMenuItem exportMenuItem;
  
  /** The help menu. */
  private JMenu helpMenu;
  /** The noble avatar www menu item. */
  private JMenuItem nobleavatarMenuItem;
  /** The about menu item. */
  private JMenuItem aboutMenuItem;
  
  
  /**
   * Constructor for menu. 
   * 
   * @param core  The core associated with this menu.
   */
  public CoreMenu(final Core core) {
    this.core = core;
    
    // parameters
    final String avatarFormat = "navatar";
    final String avatarDescription = "Noble Avatar File";
    final CoreMenu menu = this;
    
    // build file menu
    fileMenu = new JMenu(Configuration.getInstance().getString("menu.File"));
    add(fileMenu);
    
    newMenuItem = new JMenuItem(Configuration.getInstance().getString("general.New"));
    newMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // and save avatar
        State state = core.getState();
        if (state instanceof GeneratorState) {
          GeneratorState generatorState = (GeneratorState)state;
          
          // and reset avatar
          Avatar avatar = generatorState.getAvatar();
          boolean male = avatar.isMale();
          avatar.setId(0);
          avatar.setEnabled(true);
          avatar.setMale(male);
          avatarFile = null;
          saveMenuItem.setEnabled(false);
        }        
      }
    });
    fileMenu.add(newMenuItem);

    fileMenu.addSeparator();

    loadMenuItem = new JMenuItem(Configuration.getInstance().getString("general.Load"));
    loadMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // and load avatar
        State state = core.getState();
        if (state instanceof GeneratorState) {
          GeneratorState generatorState = (GeneratorState)state;
          
          // open file dialog
          JFileChooser chooser = new JFileChooser(Access.getInstance().getScenarioDir());
          chooser.addChoosableFileFilter(new SimpleFileFilter(avatarFormat, avatarDescription));
          chooser.setMultiSelectionEnabled(false);
          int returnValue = chooser.showDialog(JOptionPane.getFrameForComponent(menu)
                                             , Configuration.getInstance().getString("general.Load"));
          if (returnValue == JFileChooser.APPROVE_OPTION) {
            avatarFile = chooser.getSelectedFile();
            saveMenuItem.setEnabled(true);

            // and load avatar
            try {
              Avatar avatar = AvatarManager.load(avatarFile);
              generatorState.getAvatar().setId(avatar.getId());

              // and repaint
              JOptionPane.getFrameForComponent(menu).repaint();
            }
            catch (IOException e) {
              JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(menu)
                  , Configuration.getInstance().getString("error.ErrorMessage") + " " + e.getMessage()
                  , Configuration.getInstance().getString("error.Title")
                  , JOptionPane.ERROR_MESSAGE);
            }
          }
        }        
      }
    });
    fileMenu.add(loadMenuItem);
    
    saveMenuItem = new JMenuItem(Configuration.getInstance().getString("general.Save"));
    saveMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // and save avatar
        State state = core.getState();
        if (state instanceof GeneratorState) {
          GeneratorState generatorState = (GeneratorState)state;
          
          // and save avatar
          Avatar avatar = generatorState.getAvatar();
          saveAvatar(avatar, JOptionPane.getFrameForComponent(menu));
        }        
      }
    });
    fileMenu.add(saveMenuItem);
    saveMenuItem.setEnabled(false);
    
    saveAsMenuItem = new JMenuItem(Configuration.getInstance().getString("general.SaveAs"));
    saveAsMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // and save avatar as...
        State state = core.getState();
        if (state instanceof GeneratorState) {
          GeneratorState generatorState = (GeneratorState)state;
          
          // open file dialog
          JFileChooser chooser = new JFileChooser(Access.getInstance().getScenarioDir());
          chooser.addChoosableFileFilter(new SimpleFileFilter(avatarFormat, avatarDescription));
          chooser.setMultiSelectionEnabled(false);
          int returnValue = chooser.showDialog(JOptionPane.getFrameForComponent(menu)
                                             , Configuration.getInstance().getString("general.Save"));
          if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (!file.getAbsolutePath().endsWith("." + avatarFormat)) {
              // add .format if missing
              file = new File(file.getAbsolutePath() + "." + avatarFormat);
            }
            avatarFile = file;
            saveMenuItem.setEnabled(true);
            
            // and save avatar
            Avatar avatar = generatorState.getAvatar();
            saveAvatar(avatar, JOptionPane.getFrameForComponent(menu));
          }
        }
      }
    });
    fileMenu.add(saveAsMenuItem);
    
    fileMenu.addSeparator();
    
    exportMenuItem = new JMenuItem(Configuration.getInstance().getString("menuitem.ExportImage"));
    exportMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // export image
        State state = core.getState();
        if (state instanceof GeneratorState) {
          GeneratorState generatorState = (GeneratorState)state;
          
          // open file dialog
          String format = "png";
          JFileChooser chooser = new JFileChooser(Access.getInstance().getScenarioDir());
          chooser.addChoosableFileFilter(new SimpleFileFilter(format, "PNG Image File"));
          chooser.setMultiSelectionEnabled(false);
          int returnValue = chooser.showDialog(JOptionPane.getFrameForComponent(menu)
                                             , Configuration.getInstance().getString("general.Export"));
          if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (!file.getAbsolutePath().endsWith("." + format)) {
              // add .format if missing
              file = new File(file.getAbsolutePath() + "." + format);
            }

            // and export image
            Avatar avatar = generatorState.getAvatar();
            BufferedImage image = AvatarImage.getInstance().get(avatar);
            try {
              ImageIO.write(image, format, file);
              JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(menu)
                  , Configuration.getInstance().getString("dialog.ImageExportText")
                  , Configuration.getInstance().getString("dialog.ImageExportTitle")
                  , JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException e) {
              JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(menu)
                  , Configuration.getInstance().getString("error.ErrorMessage") + " " + e.getMessage()
                  , Configuration.getInstance().getString("error.Title")
                  , JOptionPane.ERROR_MESSAGE);
            }
          }
        }
      }
    });
    fileMenu.add(exportMenuItem);
    
    fileMenu.addSeparator();
    
    JMenuItem exitMenuItem = new JMenuItem(Configuration.getInstance().getString("menuitem.Exit"));
    exitMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // and quit
        System.exit(0);
      }
    });
    fileMenu.add(exitMenuItem);
    
    // build help menu
    helpMenu = new JMenu(Configuration.getInstance().getString("menu.Help"));
    add(helpMenu);
    
    String nobleavatarDomain = "NobleAvatar.com";
    final String nobleavatarURL = "http://www." + nobleavatarDomain;
    nobleavatarMenuItem = new JMenuItem("<html><u>" + nobleavatarDomain + "</u></html>");
    nobleavatarMenuItem.setForeground(Color.BLUE);
    nobleavatarMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        try {
          Access.getInstance().openURL(nobleavatarURL);
        }
        catch (AccessException e) {
          Error.out(e);
        }
      }
    });
    helpMenu.add(nobleavatarMenuItem);

    helpMenu.addSeparator();
    
    aboutMenuItem = new JMenuItem(Configuration.getInstance().getString("menuitem.About"));
    aboutMenuItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // show the about dialog
        CreditsDialog dialog = new CreditsDialog(JOptionPane.getFrameForComponent(menu));
        dialog.setVisible(true);
      }
    });
    helpMenu.add(aboutMenuItem);
    
    // Observe what happens in the core and change the display accordingly
    update(Core.CoreChange.STATE);
  }
  
  /**
   * Called when the component got added.
   */
  @Override
  public void addNotify() {
    super.addNotify();
    
    // listen to changes
    core.addNotifierListener(this);
  }
  
  /**
   * Called when the component got removed.
   */
  @Override
  public void removeNotify() {
    // listen to changes
    core.removeNotifierListener(this);
    
    super.removeNotify();    
  }

  /**
   * If something changes in the core. 
   * 
   * @param change  The change that occured.
   */
  public void update(Core.CoreChange change) {
    State state = core.getState();
    if (state instanceof GeneratorState) {
      // not used so far...
    }
    else {
      Error.out("State not supported: " + state);
    }
    
    // and update
    revalidate();
    repaint();
  }
  
  /**
   * Saves an avatar.
   *
   * @param avatar  The avatar.
   * @param frame  The associated frame.
   */
  private void saveAvatar(Avatar avatar, Frame frame) {
    try {
      AvatarManager.save(avatar, avatarFile);
      JOptionPane.showMessageDialog(frame
          , Configuration.getInstance().getString("dialog.AvatarSaveText")
          , Configuration.getInstance().getString("dialog.AvatarSaveTitle")
          , JOptionPane.INFORMATION_MESSAGE);
    }
    catch (IOException e) {
      JOptionPane.showMessageDialog(frame
          , Configuration.getInstance().getString("error.ErrorMessage") + " " + e.getMessage()
          , Configuration.getInstance().getString("error.Title")
          , JOptionPane.ERROR_MESSAGE);
    }
  }
}
