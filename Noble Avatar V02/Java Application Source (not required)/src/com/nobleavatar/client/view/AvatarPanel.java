package com.nobleavatar.client.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.nobleavatar.client.model.Avatar;

/**
 * The avatar panel. 
 *
 * @author    king 
 * @since     May 19, 2008
 */
public class AvatarPanel extends JPanel {
 
  /** The avatar. */
  private Avatar avatar;
  
  
  /**
   * Default constructor for avatar panel.
   */
  public AvatarPanel() {
    this(null);
  }
  
  /**
   * Constructor for avatar panel.
   * 
   * @param avatar  The avatar.
   */
  public AvatarPanel(Avatar avatar) {
    // set look
    setOpaque(false);
    
    // set avatar
    setAvatar(avatar);
  }

  /**
   * Returns the preferred size.
   *
   * @return  The preferred size.
   */
  @Override
  public Dimension getPreferredSize() {
    return AvatarImage.getInstance().getPreferredSize();
  }
  
  /**
   * Returns the avatar.
   *
   * @return  Returns the avatar.
   */
  public Avatar getAvatar() {
    return avatar;
  }

  /**
   * Sets the avatar.
   *
   * @param avatar  The avatar to set.
   */
  public void setAvatar(Avatar avatar) {
    this.avatar = avatar;
  }
  
  /**
   * Paints the avatar.
   *
   * @param g  Where to draw to.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    AvatarImage.getInstance().paint(g, avatar);
  }
}
