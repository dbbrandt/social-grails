package com.nobleavatar.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.nobleavatar.client.state.GeneratorState;
import com.nobleavatar.client.state.GeneratorStatePanel;
import com.nobleavatar.client.state.State;
import com.noblemaster.lib.notifier.NotifierListener;

/**
 * Core panel. 
 *
 * @author  king 
 * @since   April 14, 2007
 */
public class CorePanel extends JPanel implements NotifierListener<Core.CoreChange> {
  
  /** The core associated with this panel. */
  private Core core;
  
  /** The current state panel. */
  private Component statePanel = null;

  
  /**
   * Constructor for the core panel.
   * 
   * @param core  The core associated with this panel.
   */
  public CorePanel(Core core) {
    this.core = core;

    // set background color
    setBackground(Color.LIGHT_GRAY);
    setOpaque(true);
    
    // set layout
    setLayout(new BorderLayout());

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
    if ((change == Core.CoreChange.STATE) || (change == Core.CoreChange.RELOAD)) {
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          State state = core.getState();
          
          // remove previous display
          if (statePanel != null) {
            remove(statePanel);
          }
      
          // add new display
          if (state instanceof GeneratorState) {
            statePanel = new GeneratorStatePanel((GeneratorState)state);
          }
          
          // add if found
          if (statePanel != null) {
            add(statePanel, BorderLayout.CENTER);
          }
          
          // clean up previous panel
          System.gc();
          System.runFinalization();
      
          // draw the new state
          validate();
          repaint();
        }
      });
    }
  }
}
