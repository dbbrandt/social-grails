package com.nobleavatar.client.state;

import com.nobleavatar.client.Core;

/**
 * Abstract definition of a state.
 * 
 * @author king
 * @since April 14, 2007
 */
public abstract class State {

  /** Each state is associated with a core. */
  private Core core;
  
  
  /**
   * Called once the state is started.
   */
  public abstract void start();
  
  /**
   * Called once the state is stopped. 
   */
  public abstract void stop();

  /**
   * Exits the application.
   */
  public void exit() {
    core.exit();
  }
  
  /**
   * Returns the core.
   * 
   * @return Returns the core.
   */
  protected Core getCore() {
    return core;
  }

  /**
   * Sets the core.
   * 
   * @param core The core to set.
   */
  public void setCore(Core core) {
    this.core = core;
  }
}
