package com.nobleavatar.client.state;

import java.awt.Color;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.nobleavatar.client.view.AvatarEditPanel;
import com.nobleavatar.client.view.PanelBorder;

/**
 * Generator state panel. 
 *
 * @author  king 
 * @since   April 1, 2008
 */
public class GeneratorStatePanel extends JPanel {
  
  /**
   * Constructor for the panel.
   * 
   * @param state  The state associated with this panel.
   */
  public GeneratorStatePanel(GeneratorState state) {
    // set look
    setOpaque(true);
    setBackground(new Color(0xD8E9EF));
    setBorder(new PanelBorder());
    
    // set layout
    setLayout(new FormLayout(
        "5px, fill:1px:grow, 5px"
      , "20px, fill:1px:grow, 5px"
    ));
    CellConstraints cc = new CellConstraints();
    
    // add avatar edit panel
    AvatarEditPanel avatarEditPanel = new AvatarEditPanel(state.getAvatar());
    add(avatarEditPanel, cc.xy(2, 2));
  }
}
