package com.nobleavatar.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.nobleavatar.client.AppClientRelease;
import com.nobleavatar.client.Configuration;
import com.nobleavatar.client.view.gui.NarrowBevelBorder;
import com.noblemaster.lib.LibraryVersion;
import com.noblemaster.lib.access.ImageLoader;
import com.noblemaster.lib.out.gui.DocumentTextPane;

/**
 * Represents a credits info dialog.
 * 
 * @author king
 * @since March 9, 2008
 */
public class CreditsDialog extends JDialog {
  
  /**
   * Fancy dialog constructor. 
   * 
   * @param component  The component who is creating the dialog.
   */
  public CreditsDialog(Component component) {   
    super(JOptionPane.getFrameForComponent(component));
    
    // no border
    setUndecorated(true);
    
    // set the size based on image
    final Dimension size = new Dimension(500, 400);
    setSize(size);
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);    
    
    // set location
    Window window = getOwner();
    Dimension windowSize = window.getSize();
    Point windowLocation = window.getLocation();
    if ((windowLocation.x != 0) && (windowLocation.y != 0)) {
      setLocation(windowLocation.x + ((windowSize.width - size.width) / 2)
                , windowLocation.y + ((windowSize.height - size.height) / 2));
    }
    else {
      // if owner location is (0, 0) - happens when owner is already removed from screen
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
    }
    
    // set action panel
    JPanel actionPanel = new JPanel();
    actionPanel.setOpaque(true);
    actionPanel.setBackground(new Color(0xD8E9EF));
    actionPanel.setBorder(new PanelBorder());  
    actionPanel.setLayout(null);
    actionPanel.setSize(size);
    
    // set modal
    setModal(true);
    
    // Add text panel for text
    DocumentTextPane textArea = new DocumentTextPane();
    textArea.addHeader("Noble Avatar\u2122 Generator\n");
    textArea.addHeader("Copyright \u00A9 2005-2008 by Noble Master Games\n");
    textArea.addLineBreak();
    textArea.addHeader("Credits\n");
    textArea.addParagraph("Developed by Dr. Christoph Aschwanden: http://www.noblemaster.com \n");
    textArea.addParagraph("Avatars by mei-li nieuwland: http://liea.deviantart.com \n");
    textArea.addParagraph("ESRB Rating by Cheat Code Central: http://www.cheatcc.com \n");
    textArea.addLineBreak();
    textArea.addHeader("Web Site\n");
    textArea.addParagraph("Noble Avatar\u2122: http://www.nobleavatar.com \n");
    textArea.addParagraph("Noble Master Games: http://www.noblemaster.com \n");
    textArea.addLineBreak();
    textArea.addHeader("System\n");
    textArea.addParagraph("Release Version: " + AppClientRelease.getReleaseVersion() + "\n");
    textArea.addParagraph("Release Date: " + AppClientRelease.getReleaseTime() + "\n");
    textArea.addParagraph("Library Version: " + LibraryVersion.getReleaseVersion() + "\n");
    textArea.addParagraph("Library Date: " + LibraryVersion.getReleaseTime() + "\n");
    textArea.addParagraph("Java Version: " + System.getProperty("java.vm.version") + "\n");
    textArea.addParagraph("Operating System: " + System.getProperty("os.name") + "\n");
    textArea.addParagraph("OS Version: " + System.getProperty("os.version") + "\n");
    textArea.addLineBreak();
    textArea.addHeader("Tools\n");
    textArea.addParagraph("Eclipse for Development: http://www.eclipse.org \n");
    textArea.addLineBreak();
    textArea.addHeader("ESRB Rating\n");
    textArea.addImage(ImageLoader.getInstance().getImage("conf/image/interface/ESRB.gif"));    
    textArea.setCaretPosition(0);
    JScrollPane textAreaScrollPane = new JScrollPane(textArea);
    textAreaScrollPane.setBorder(new NarrowBevelBorder());
    textAreaScrollPane.setSize(size.width - 76, size.height - 57);
    textAreaScrollPane.setLocation(38, 25);
    actionPanel.add(textAreaScrollPane);

    // add OK button
    JButton button = new JButton();
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        setVisible(false);
      }
    });
    button.setSize(120, 18);
    Dimension buttonSize = button.getSize();
    int x = (size.width - buttonSize.width) / 2;
    int y = size.height - buttonSize.height - 10;
    button.setLocation(x, y);
    button.setText(Configuration.getInstance().getString("general.OK"));
    actionPanel.add(button); 
    
    // set action panel as content
    setContentPane(actionPanel);
  }
}