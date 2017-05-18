package com.nobleavatar.client;

import com.nobleavatar.client.state.GeneratorState;
import com.nobleavatar.client.state.State;
import com.noblemaster.lib.notifier.NotifierAdapter;

/**
 * Main object which contains the program flow management from login to
 * running a game.
 * 
 * @author king
 * @since April 14, 2007
 */
public class Core extends NotifierAdapter<Core.CoreChange> {

  /** Possible changes that can occur. */
  public static enum CoreChange { STATE, MINIMIZE, FULL_SCREEN_MODE, WINDOW_MODE, RELOAD };

  /** Contains the current state. */
  private State state;
  
  
  /**
   * Constructor for the core.
   * 
   * @param parameter  The parameters if any.
   */
  public Core(String parameter)  {
    // init first state
    setState(new GeneratorState());
  }
  
  /**
   * Returns the current state or null if there is none yet.
   * 
   * @return  The current state or null if there is none.
   */
  public State getState() {
    return this.state;
  }

  /**
   * Sets a new state in the simulation.
   * 
   * @param state  A new state in the simulation.
   */
  public void setState(State state) {
    // stop previous state
    if (this.state != null) {
      this.state.stop();
    }
    
    // init new state
    this.state = state;
    this.state.setCore(this);
    this.state.start();
    
    // notify all observers that we went to a new state in the sequence.
    fire(CoreChange.STATE);
  }
  
  /**
   * Minimizes the game, e.g. to hide from employer.
   */
  public void minimize() {
    fire(CoreChange.MINIMIZE);
  }

  /**
   * Reloads the current state.
   */
  public void reload() {
    fire(CoreChange.RELOAD);
  }
  
  /**
   * Changes the game window from full screen to window and vice versa.
   * 
   * @param fullScreen  True if new mode should be full screen.
   */
  public void modeChange(boolean fullScreen) {
    if (fullScreen) {
      fire(CoreChange.FULL_SCREEN_MODE);
    }
    else {
      fire(CoreChange.WINDOW_MODE);
    }
  }

  /**
   * Called on exit.
   */
  public void exit() {
    // And exit
    System.exit(0);
  }
}
