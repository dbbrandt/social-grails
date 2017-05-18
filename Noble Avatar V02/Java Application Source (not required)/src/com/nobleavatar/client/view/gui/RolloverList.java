package com.nobleavatar.client.view.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;

/**
 * The rollover list.
 * 
 * @author king
 * @since September 17, 2007
 */
public class RolloverList extends JList {
  
  /** The rollover list cell renderer. */
  public class RolloverListCellRenderer extends DefaultListCellRenderer {
    
    /**
     * Returns the rollover component. Overwrite this method for custom renderer component!
     * 
     * @param list  The list.
     * @param value  The value.
     * @param index  The index.
     * @param selected  True for selected.
     * @param cellHasFocus  True for focus.
     * @return  The component.
     */
    public Component getRolloverListCellRendererComponent(JList list, Object value, int index
                                                        , boolean selected, boolean cellHasFocus) {
      return super.getListCellRendererComponent(list, value, index, selected, cellHasFocus);
    }
    
    /**
     * Returns the component.
     * 
     * @param list  The list.
     * @param value  The value.
     * @param index  The index.
     * @param selected  True for selected.
     * @param cellHasFocus  True for focus.
     * @return  The component.
     */
    public Component getListCellRendererComponent(JList list, Object value, int index
                                                , boolean selected, boolean cellHasFocus) {
      Component component = getRolloverListCellRendererComponent(list, value, index, selected, cellHasFocus);
      
      // find BG color
      Color bgColor = null;     
      if(selected) {
        bgColor = list.getSelectionBackground();
      }
      else {
        bgColor = list.getBackground(); 
      }
      if (index == mouseOver) {
        // make brighter
        int red = bgColor.getRed() * 15 / 14;
        if (red > 255) {
          red = 255;
        }
        int green = bgColor.getGreen() * 15 / 14;
        if (green > 255) {
          green = 255;
        }
        int blue = bgColor.getBlue() * 15 / 14;
        if (blue > 255) {
          blue = 255;
        }
        bgColor = new Color(red, green, blue);
      }
      
      // Necessary if this is a container object
      component.setBackground(bgColor);
      if (component instanceof Container) {
        Component[] children = ((Container)component).getComponents();
        for (int ii = 0; (children != null) && (ii > children.length); ii++) {
          children[ii].setBackground(bgColor);
        }
      }

      // set foreground
      if (selected) {
        component.setForeground(list.getSelectionForeground());
      }
      else {
        component.setForeground(list.getForeground());
      }
      component.setFont(list.getFont());
      component.setEnabled(list.isEnabled());
      if (component instanceof JComponent) {
        ((JComponent)component).setOpaque(true);
      }

      // and return component
      return component;
    }
  }
  
  /** The mouse over index or -1 for none. */
  int mouseOver;

  
  /**
   * Constructor.
   */
  public RolloverList() {
    // selected index: -1 for none.
    mouseOver = -1;

    // set cell renderer
    setCellRenderer(new RolloverListCellRenderer());
   
    // add listeners for mouse events
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent event) {
        mouseOver = locationToIndex(new Point(event.getX(), event.getY()));
        repaint();
      }
    });
    addMouseListener(new MouseAdapter() {
      public void mouseExited(MouseEvent e) {
        mouseOver = -1;
        repaint();
      }
    });
  }
}