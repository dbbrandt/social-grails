package com.nobleavatar.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;

import javax.swing.JToggleButton;

/**
 * Represents an avatar image button. 
 *
 * @author    king 
 * @since     June 9, 2008
 */
public class AvatarButton extends JToggleButton {
  
  /** The button normal color. */
  private final Color buttonNormalColor = new Color(0xA19B95);
  /** The button normal color. */
  private final Color buttonRolloverColor = new Color(0xAEA7A1);
  /** The button normal color. */
  private final Color buttonSelectedColor = new Color(0xD0C8C0);
  
  /** The 3D effect box over color. */
  private final Color box3dEffectColor = new Color(1.0f, 1.0f, 1.0f, 0.2f);

  /** The image. */
  private Image image;

  
  /**
   * Constructor for the button.
   * 
   * @param size  The size.
   */
  public AvatarButton(Dimension size) {
    // set transparent
    setOpaque(false);
    setBorderPainted(false);
        
    // set the size
    setSize(size);
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    
    // Enable rollover
    setRolloverEnabled(true);
  }

  /**
   * Returns the image.
   *
   * @return  Returns the image.
   */
  public Image getImage() {
    return image;
  }

  /**
   * Sets the image.
   *
   * @param image  The image to set.
   */
  public void setImage(Image image) {
    this.image = image;
  }

  /**
   * Draws this component.
   *
   * @param g  Graphics context.
   */
  public void paintComponent(Graphics g) {
    // do antialiased rendering
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    
    // parameters
    int width = getWidth();
    int height = getHeight();
    Polygon polygon = new Polygon();
    polygon.addPoint(0, 3);
    polygon.addPoint(3, 0);
    polygon.addPoint(width - 4, 0);
    polygon.addPoint(width - 1, 3);
    polygon.addPoint(width - 1, height - 4);
    polygon.addPoint(width - 4, height - 1);
    polygon.addPoint(3, height - 1);
    polygon.addPoint(0, height - 4);
    
    // draw button background
    if (model.isPressed() || isSelected()) {
      // selected
      g.setColor(buttonSelectedColor);        
    }
    else if (model.isRollover()) {
      // rollover
      g.setColor(buttonRolloverColor);        
    }
    else {
      // normal
      g.setColor(buttonNormalColor);        
    }
    
    g2.fill(polygon);
    g2.setColor(g.getColor().darker());
    g2.draw(polygon);
    
    if (model.isPressed() || isSelected()) {
      // selected
      g.setColor(buttonSelectedColor.brighter());
      g.drawLine(3, height - 1, width - 4, height - 1);
      g.drawLine(width - 1, 3, width - 1, height - 4);
      g.drawLine(width - 1, height - 4, width - 4, height - 1);
    }
    else {
      g.setColor(buttonNormalColor.brighter());
      g.drawLine(3, 0, width - 4, 0);
      g.drawLine(0, 3, 0, height - 4);
      g.drawLine(3, 0, 0, 3);
    }
    
    // draw image
    if (image != null) {
      // image for button
      int imageWidth = width * 2 / 3;
      int imageHeight = height * 2 / 3;
      int x = (width - imageWidth) / 2;
      int y = (height - imageHeight) / 2;
      
      // highlight depending on rollover or button pressed
      if (model.isPressed() || isSelected()) {
        // selected
        g.drawImage(this.image, x, y + 2, imageWidth, imageHeight, this);        
      }
      else if (model.isRollover()) {
        // rollover
        g.drawImage(this.image, x, y + 0, imageWidth, imageHeight, this);
      }
      else {
        // normal
        g.drawImage(this.image, x, y + 0, imageWidth, imageHeight, this);        
      }
    }
    
    // draw over
    g.setColor(box3dEffectColor);
    g.fillRect(0, 0, width, height / 2);
  }  
}
