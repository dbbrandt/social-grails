package com.nobleavatar.client.state;

import com.nobleavatar.client.model.Avatar;

/**
 * Generator state.
 * 
 * @author king
 * @since April 14, 2007
 */
public class GeneratorState extends State {

  /** The avatar. */
  private Avatar avatar;
  
  
  /**
   * Constructor.
   */
  public GeneratorState() {
    // build avatar
    avatar = new Avatar();
    avatar.setId(2537256961585L);
  }
  
  /**
   * Called once the state is started.
   */
  public void start() {
    // not used
  }
  
  /**
   * Called once the state is stopped. 
   */
  public void stop() {
    // not used
  }
  
  /**
   * Returns the avatar.
   *
   * @return  The avatar.
   */
  public Avatar getAvatar() {
    return avatar;
  }
  
  /**
   * Hides.
   */
  public void hide() {
    getCore().minimize();
  }
}
