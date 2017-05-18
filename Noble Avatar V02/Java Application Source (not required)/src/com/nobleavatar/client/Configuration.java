package com.nobleavatar.client;

import java.awt.Dimension;
import java.awt.Point;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import com.noblemaster.lib.access.Access;
import com.noblemaster.lib.access.AudioLoader;
import com.noblemaster.lib.access.hookup.LocalHookup;
import com.noblemaster.lib.out.log.Error;


/**
 * Game configuration such as last login name and password or screen
 * resolution used.
 * 
 * @author king
 * @since November 24, 2005
 */
public final class Configuration {

  /** The minimum panel size. */
  public static final Dimension MINIMUM_PANEL_SIZE = new Dimension(600, 420);
  
  /** Properties file for user. */
  private static final String USER_PROPERTIES = Access.getInstance().getScenarioDir() + "/user.properties";

  /** Last name of the user. */
  private static final String USER_NAME = "USER-NAME";
  /** Last password of the user. */
  private static final String USER_PASSWORD = "USER-PASSWORD";
  /** Full-screen mode versus windowed mode. */
  private static final String FULL_SCREEN_MODE = "FULL-SCREEN-MODE";
  /** Play audio. */
  private static final String PLAY_AUDIO = "PLAY-AUDIO";
  /** Play shouts. */
  private static final String PLAY_SHOUTS = "PLAY-SHOUTS";
  /** Language selected. */
  private static final String LANGUAGE = "LANGUAGE";
  /** Country selected. */
  private static final String COUNTRY = "COUNTRY";
  /** The computer ID - cheat detection. */
  private static final String COMPUTER_ID = "MAP-CONFIG";
  /** The window pos x. */
  private static final String WINDOW_X = "WINDOW-X";
  /** The window pos y. */
  private static final String WINDOW_Y = "WINDOW-Y";
  /** The window width. */
  private static final String WINDOW_WIDTH = "WINDOW-WIDTH";
  /** The window height. */
  private static final String WINDOW_HEIGHT = "WINDOW-HEIGHT";
  
  /** The default username. */
  private static final String DEFAULT_USER_NAME = "";
  /** The default password. */
  private static final String DEFAULT_USER_PASSWORD = encrypt("");
  /** The default full-screen mode. */
  private static final boolean DEFAULT_FULL_SCREEN_MODE = false;
  /** The default play audio mode. */
  private static final boolean DEFAULT_PLAY_AUDIO = true;
  /** The default play shouts mode. */
  private static final boolean DEFAULT_PLAY_SHOUTS = true;
  /** The default language. */
  private static final String DEFAULT_LANGUAGE = Locale.getDefault().getLanguage();
  /** The default country. */
  private static final String DEFAULT_COUNTRY = Locale.getDefault().getCountry();
  /** The default computer ID. */
  private static final long DEFAULT_COMPUTER_ID = (new Random()).nextLong();
  /** The default window pos x. */
  private static final int DEFAULT_WINDOW_X = 0;
  /** The default window pos y. */
  private static final int DEFAULT_WINDOW_Y = 0;
  /** The default window width. */
  private static final int DEFAULT_WINDOW_WIDTH = MINIMUM_PANEL_SIZE.width;
  /** The default window height. */
  private static final int DEFAULT_WINDOW_HEIGHT = MINIMUM_PANEL_SIZE.height;
    
  /** Username. */
  private String username = DEFAULT_USER_NAME;
  /** Password. */
  private String password = DEFAULT_USER_PASSWORD;
  /** Full-screen mode. */
  private boolean fullScreenMode = DEFAULT_FULL_SCREEN_MODE;
  /** Play audio mode. */
  private boolean playAudio = DEFAULT_PLAY_AUDIO;
  /** Play shouts mode. */
  private boolean playShouts = DEFAULT_PLAY_SHOUTS;
  /** The selected language. */
  private Locale locale = new Locale(DEFAULT_LANGUAGE, DEFAULT_COUNTRY);
  /** The computer ID. */
  private long computerID = DEFAULT_COMPUTER_ID;
  /** The window position. */
  private Point windowPosition = new Point(DEFAULT_WINDOW_X, DEFAULT_WINDOW_Y);
  /** The window size. */
  private Dimension windowSize = new Dimension(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
  
  /** Singleton. */
  private static Configuration configuration = new Configuration();
  
  
  /**
   * Loads the last configuration.
   */
  private Configuration() {
    loadConfiguration();
  }
  
  /**
   * Returns the only instance.
   * 
   * @return  The only instance.
   */
  public static Configuration getInstance() {
    return configuration;
  }
  
  /**
   * Loads the last configuration.
   */
  public void loadConfiguration() {
    // Preload last configuration
    try {
      InputStream inputStream = LocalHookup.getInstance().getInputStream(USER_PROPERTIES);
      Properties properties = new Properties();
      properties.load(inputStream);
      this.username = (String)properties.getProperty(USER_NAME, DEFAULT_USER_NAME);
      this.password = (String)properties.getProperty(USER_PASSWORD, DEFAULT_USER_PASSWORD);
      setFullScreen(Boolean.parseBoolean(properties.getProperty(FULL_SCREEN_MODE
                  , new Boolean(DEFAULT_FULL_SCREEN_MODE).toString())));
      setPlayAudio(Boolean.parseBoolean(properties.getProperty(PLAY_AUDIO
                 , new Boolean(DEFAULT_PLAY_AUDIO).toString())));
      setPlayShouts(Boolean.parseBoolean(properties.getProperty(PLAY_SHOUTS
                 , new Boolean(DEFAULT_PLAY_SHOUTS).toString())));
      String language = (String)properties.getProperty(LANGUAGE, DEFAULT_LANGUAGE);
      String country = (String)properties.getProperty(COUNTRY, DEFAULT_COUNTRY);
      if (country.length() > 0) {
        this.locale = new Locale(language, country);
      }
      else {
        this.locale = new Locale(language);
      }
      this.computerID = Long.parseLong((String)properties.getProperty(COMPUTER_ID, "" + DEFAULT_COMPUTER_ID));
      int windowX = Integer.parseInt((String)properties.getProperty(WINDOW_X, "" + DEFAULT_WINDOW_X));
      int windowY = Integer.parseInt((String)properties.getProperty(WINDOW_Y, "" + DEFAULT_WINDOW_Y));
      int windowWidth = Integer.parseInt((String)properties.getProperty(WINDOW_WIDTH, "" + DEFAULT_WINDOW_WIDTH));
      int windowHeight = Integer.parseInt((String)properties.getProperty(WINDOW_HEIGHT, "" + DEFAULT_WINDOW_HEIGHT));
      this.windowPosition = new Point(windowX, windowY);
      this.windowSize = new Dimension(windowWidth, windowHeight);
      inputStream.close();
      
      // consistency check
      if (!isPlayAudio()) {
        setPlayShouts(false);
      }
    }
    catch (Exception e) {
      Error.out("Cannot load (" + USER_PROPERTIES + "):" + e);
    }
  }

  /** 
   * Saves the current configuration to file.
   */
  public void saveConfiguration() {
    // store data
    try {
      OutputStream outputStream = LocalHookup.getInstance().getOutputStream(USER_PROPERTIES, false);
      Properties properties = new Properties();
      properties.put(USER_NAME, this.username);
      properties.put(USER_PASSWORD, this.password);
      properties.put(FULL_SCREEN_MODE, new Boolean(this.fullScreenMode).toString());
      properties.put(PLAY_AUDIO, new Boolean(this.playAudio).toString());
      properties.put(PLAY_SHOUTS, new Boolean(this.playShouts).toString());
      properties.put(LANGUAGE, this.locale.getLanguage());
      properties.put(COUNTRY, this.locale.getCountry());
      properties.put(COMPUTER_ID, "" + this.computerID);
      properties.put(WINDOW_X, "" + this.windowPosition.x);
      properties.put(WINDOW_Y, "" + this.windowPosition.y);
      properties.put(WINDOW_WIDTH, "" + this.windowSize.width);
      properties.put(WINDOW_HEIGHT, "" + this.windowSize.height);
      
      properties.store(outputStream, "Default User Parameters");
      outputStream.close();
    }
    catch (Exception e) {
      Error.out("Cannot save (" + USER_PROPERTIES + "):" + e);
    }
  }
  
  /**
   * Returns the last username used.
   * 
   * @return  The last username used.
   */
  public String getUsername() {
    return this.username;
  }
  
  /**
   * Sets the username.
   * 
   * @param username  The username for this configuration.
   */
  public void setUsername(String username) {
    this.username = username;
  }
  
  /**
   * Returns the last password used.
   * 
   * @return  The last password used.
   */
  public String getPassword() {
    return decrypt(this.password);
  }
  
  /**
   * Sets the password.
   * 
   * @param password  The password for this configuration.
   */
  public void setPassword(String password) {
    this.password = encrypt(password);
  }
  
  /** 
   * Returns true if full screen mode is set.
   * 
   * @return  True if full screen mode, false for windowed.
   */
  public boolean isFullScreen() {
    return this.fullScreenMode;
  }
  
  /**
   * Sets if full screen versus windowed.
   * 
   * @param fullScreen  True for full-screen, false for windowed mode.
   */
  public void setFullScreen(boolean fullScreen) {
    this.fullScreenMode = fullScreen;
  }
  
  /**
   * Returns true if playing audio.
   * 
   * @return Returns the play audio.
   */
  public boolean isPlayAudio() {
    return playAudio;
  }

  /**
   * Set if audio player enabled.
   * 
   * @param playAudio The play audio to set.
   */
  public void setPlayAudio(boolean playAudio) {
    this.playAudio = playAudio;
    AudioLoader.getInstance().setAudioEnabled(playAudio);
  }

  /**
   * Returns true if shouts are played.
   * 
   * @return  True for played.
   */
  public boolean isPlayShouts() {
    return playShouts;
  }
  
  /**
   * Set if shouts player enabled.
   * 
   * @param playShouts The play shouts to set.
   */
  public void setPlayShouts(boolean playShouts) {
    this.playShouts = playShouts;
  }

  /**
   * Returns the selected language. "ur" for Urdu = L33T
   * 
   * @return Returns the language.
   */
  public Locale getLocale() {
    return locale;
  }

  /**
   * Sets the language.
   * 
   * @param locale The language to set.
   */
  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  /**
   * Returns the window position.
   * 
   * @return Returns the window position.
   */
  public Point getWindowPosition() {
    return windowPosition;
  }

  /**
   * Sets the window position.
   * 
   * @param windowPosition The window position to set.
   */
  public void setWindowPosition(Point windowPosition) {
    this.windowPosition = windowPosition;
  }

  /**
   * Returns the window size.
   * 
   * @return Returns the window size.
   */
  public Dimension getWindowSize() {
    return windowSize;
  }

  /**
   * Sets the window size.
   * 
   * @param windowSize The window size to set.
   */
  public void setWindowSize(Dimension windowSize) {
    this.windowSize = windowSize;
  }

  /**
   * Returns the resource bundle with all the messages given for the selected language.
   * <p>
   * Instructions for Translators:
   * 1. Translate ALL the text for selected language - otherwise errors occur!
   * 2. Copy your MessagesBundle_??.properties to {AO-directory}/scenario/*
   *    (the AO directory is located in the user directory)
   * 3. Rename your file to MessagesBundle_xx.properties
   * 4. Run AO and select l33t (skull language icon)
   * 
   * @return  The resource bundle for the selected language.
   */
  private ResourceBundle getMessages() {
    return ResourceBundle.getBundle("com.nobleavatar.client.message.MessagesBundle", locale);
  }

  /**
   * Returns the message for the given key.
   * 
   * @param key  The key. E.g. "role.Housing".
   * @return  The message.
   */
  public String getString(String key) {
    try {
      return getMessages().getString(key);
    }
    catch (MissingResourceException e) {
      // returns key, if resource cannot be found!
      return key;
    }
  }
  
  /**
   * Returns the url for the manual for the selected language.
   * 
   * @return  The manual bundle for the selected language.
   */
  public String getManualURL() {
    String code = this.locale.getLanguage();
    if ((this.locale.getCountry() != null) && (!this.locale.getCountry().equals(""))) {
      code = code + "_" + this.locale.getCountry();
    }
    URL url = this.getClass().getClassLoader().getResource("conf/text/manual/Manual_" + code + ".html");
    if (url != null) {
      return url.toString();
    }
    else {
      return this.getClass().getClassLoader().getResource("conf/text/manual/Manual.html").toString();
    }
  }

  /**
   * Returns the computer ID.
   * 
   * @return  The computer ID.
   */
  public long getComputerID() {
    return this.computerID;
  }
  
  /**
   * Encrypts a text so it is harder to read.
   * 
   * @param text  The text to encrypt.
   * @return  The encrypted text.
   */
  private static String encrypt(String text) {
    String encryptedText = "";
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if ((ch >= '0') && (ch <= '9')) {
        ch = (char)((int)'0' + ((int)'9' - (int)ch));
      }
      else if ((ch >= 'a') && (ch <= 'z')) {
        ch = (char)((int)'a' + ((int)'z' - (int)ch));
      }
      else if ((ch >= 'A') && (ch <= 'Z')) {
        ch = (char)((int)'A' + ((int)'Z' - (int)ch));
      }
      encryptedText = ch + encryptedText;
    }
    return encryptedText;
  }
  
  /**
   * Decrypts a text that has been encrypted with the encrypt method.
   * 
   * @param text  The text to decrypt.
   * @return  The decrypted text.
   */
  private static String decrypt(String text) {
    return encrypt(text);
  }
}
