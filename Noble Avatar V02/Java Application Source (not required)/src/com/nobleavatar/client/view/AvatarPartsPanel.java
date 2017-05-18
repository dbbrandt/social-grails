package com.nobleavatar.client.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * The avatar parts panel. 
 *
 * @author    king 
 * @since     June 9, 2008
 */
public class AvatarPartsPanel extends JPanel {
 
  /** The listener. */
  static interface AvatarSelectionListener {
    
    /**
     * Called when a selection occurred.
     * 
     * @param index  The selected index.
     */
    void handleSelection(int index);
  }

  /** The listeners. */
  private transient List<AvatarSelectionListener> listeners = new ArrayList<AvatarSelectionListener>();

  /** The images. */
  private Image[][] images;
  /** The combinations. */
  private int combinations;
  
  /** The buttons. */
  private List<AvatarButton> buttons;
  
  
  /**
   * Constructor for avatar parts panel.
   * 
   * @param images  The images in the format [gender][index].
   * @param combinations  The combinations.
   */
  public AvatarPartsPanel(Image[][] images, int combinations) {
    this.images = images;
    this.combinations = combinations;    
    int buttonWidth = images[0][0].getWidth(this) * 3 / 4;
    int buttonHeight = images[0][0].getHeight(this) * 3 / 4;
    final Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);
    
    // set look
    setOpaque(false);
    
    // set layout
    String xLayout = "pref, 3px, pref, 3px, pref, 3px, pref, 3px, pref, 3px, "
                   + "pref, 3px, pref, 3px, pref, 3px, pref, 3px, pref";
    int rows = ((combinations - 1) / 10) + 1;
    String yLayout = "pref";
    for (int i = 1; i < rows; i++) {
      yLayout = yLayout + ", 3px, pref";
    }
    setLayout(new FormLayout(xLayout, yLayout));
    CellConstraints cc = new CellConstraints();
    
    // add buttons
    ButtonGroup group = new ButtonGroup();
    buttons = new ArrayList<AvatarButton>();
    for (int i = 0; i < combinations; i++) {
      AvatarButton button = new AvatarButton(buttonSize);
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          AvatarButton button = (AvatarButton)event.getSource();
          if (button.isSelected()) {
            int index = buttons.indexOf(button);
            
            // notify listeners
            for (int i = 0; i < listeners.size(); i++) {
              listeners.get(i).handleSelection(index);
            }
          }
        }
      });
      buttons.add(button);
      group.add(button);
      add(button, cc.xy(1 + ((i % 10) * 2), 1 + ((i / 10) * 2)));
    }
    
    // and update
    update(true, 0);
  }
  
  /**
   * Updates the panel.
   *
   * @param male  True for male.
   * @param index  The selected index.
   */
  public void update(boolean male, int index) {
    // set the correct image
    int genderIndex = male ? 0 : 1;
    int buttonOffset = images[genderIndex].length < combinations ? 1 : 0;
    for (int i = 0; i < images[genderIndex].length; i++) {
      buttons.get(i + buttonOffset).setImage(images[genderIndex][i]);
    }
    
    // set selection
    if (!buttons.get(index).isSelected()) {
      buttons.get(index).setSelected(true);
    }
  }
  
  /**
   * Adds a listener.
   * 
   * @param listener  The listener.
   */
  public void addAvatarSelectionListener(AvatarSelectionListener listener) {
    listeners.add(listener);
  }
  
  /**
   * Removes a listener.
   * 
   * @param listener  The listener.
   */
  public void removeAvatarSelectionListener(AvatarSelectionListener listener) {
    listeners.remove(listener);
  }
}
