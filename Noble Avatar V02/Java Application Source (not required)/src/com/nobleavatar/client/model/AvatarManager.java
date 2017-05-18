package com.nobleavatar.client.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The avatar manager. 
 * 
 * @author king
 * @since June 24, 2008
 */
public final class AvatarManager {

  /**
   * Private constructor to disable instantiation.
   */
  private AvatarManager() {
    // not used
  }
  
  /**
   * Loads an avatar.
   *
   * @param file  The file.
   * @return  The avatar.
   * @throws IOException  If something goes wrong.
   */
  public static Avatar load(File file) throws IOException {
    return load(new FileInputStream(file));
  }
  
  /**
   * Loads an avatar.
   *
   * @param inputStream  The input stream.
   * @return  The avatar.
   * @throws IOException  If something goes wrong.
   */
  public static Avatar load(InputStream inputStream) throws IOException {
    Avatar avatar = new Avatar();
    
    // load the avatar
    DataInputStream dataInputStream = new DataInputStream(inputStream);
    avatar.setId(dataInputStream.readLong());
    dataInputStream.close();
    
    // return avatar
    return avatar;
  }
  
  /**
   * Saves an avatar.
   *
   * @param avatar  The avatar to save.
   * @param file  The file.
   * @throws IOException  If something goes wrong.
   */
  public static void save(Avatar avatar, File file) throws IOException {
    save(avatar, new FileOutputStream(file));
  }
  
  /**
   * Saves an avatar.
   *
   * @param avatar  The avatar to save.
   * @param outputStream  Where to save to.
   * @throws IOException  If something goes wrong.
   */
  public static void save(Avatar avatar, OutputStream outputStream) throws IOException {
    // save the avatar
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
    dataOutputStream.writeLong(avatar.getId());
    dataOutputStream.close();
  }
}
