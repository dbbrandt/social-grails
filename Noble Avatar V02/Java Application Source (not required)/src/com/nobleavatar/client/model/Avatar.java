package com.nobleavatar.client.model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Represents an avatar. 
 * 
 * @author king
 * @since May 17, 2008
 */
public class Avatar implements Serializable {

  /** The colors. */
  public static final Color[] COLORS = {
    // grays (8)
    new Color(0xFFFFFF),
    new Color(0xF0F0F0),
    new Color(0xDDDDDD),
    new Color(0xB2B2B2),
    new Color(0x808080),
    new Color(0x5F5F5F),
    new Color(0x303030),
    new Color(0x000000),
    
    // colors
    new Color(0xC00000),
    new Color(0xFF0000),
    new Color(0xFF8000),
    new Color(0xFFF9B4),
    new Color(0xFFFF00),
    new Color(0x00FF00),
    new Color(0x00C000),
    new Color(0x00773A),
    new Color(0xB2E3F6),
    new Color(0x00FFFF),
    new Color(0x00C0FF),
    new Color(0x0000FF),
    new Color(0x0000B0),
    new Color(0x440E62),
    new Color(0xC000FF),
    new Color(0xFF00FF),
    new Color(0xF060A2),
    new Color(0xFFABFF),
    new Color(0x754C24),
    new Color(0xA67C52),
    new Color(0xC6A682),
  };
  
  /** Enabled or disabled (0 = disabled). */
  private final int enablingCombinations = 2;
  /** Enabling factor. */
  private final long enablingFactor = 1;
  
  /** Male or female. */
  private final int genderCombinations = 2;
  /** Gender factor. */
  private final long genderFactor = enablingFactor * enablingCombinations;
  
  /** Number of heads. */
  private final int headCombinations = 6;
  /** Factor for heads. */
  private final long headFactor = genderFactor * genderCombinations;
  /** Number of eyes. */
  private final int eyeCombinations = 4;
  /** Factor for eyes. */
  private final long eyeFactor = headFactor * headCombinations;
  /** Number of mouths and noses. */
  private final int mouthCombinations = 4;
  /** Factor for mouths. */
  private final long mouthFactor = eyeFactor * eyeCombinations;
  /** Number of hairs (0 = no hair). */
  private final int hairCombinations = 14;
  /** Factor for hairs. */
  private final long hairFactor = mouthFactor * mouthCombinations;

  /** Number of beards (0 = no beard). */
  private final int beardCombinations = 5;
  /** Factor for beards. */
  private final long beardFactor = hairFactor * hairCombinations;
  /** Number of mustaches (0 = no mustache). */
  private final int mustacheCombinations = 2;
  /** Factor for mustaches. */
  private final long mustacheFactor = beardFactor * beardCombinations;
  /** Number of sideburns (0 = no side burn). */
  private final int sideburnCombinations = 2;
  /** Factor for sideburns. */
  private final long sideburnFactor = mustacheFactor * mustacheCombinations;
  /** Number of scars (0 = no scars). */
  private final int scarCombinations = 3;
  /** Factor for scars. */
  private final long scarFactor = sideburnFactor * sideburnCombinations;
  
  /** Number of glasses (0 = no glasses). */
  private final int glassesCombinations = 5;
  /** Factor for glasses. */
  private final long glassesFactor = scarFactor * scarCombinations;
  /** Number of necklaces (0 = no necklace). */
  private final int necklaceCombinations = 8;
  /** Factor for necklaces. */
  private final long necklaceFactor = glassesFactor * glassesCombinations;
  /** Number of hair accessories (0 = no hair accessory). */
  private final int hairAccessoryCombinations = 19;
  /** Factor for hair accessories. */
  private final long hairAccessoryFactor = necklaceFactor * necklaceCombinations;
  /** Number of eye patches (0 = no eye patch). */
  private final int eyePatchCombinations = 3;
  /** Factor for eye patches. */
  private final long eyePatchFactor = hairAccessoryFactor * hairAccessoryCombinations;
  /** Number feather boas (0 = no feather boa). */
  private final int featherBoaCombinations = 5;
  /** Factor for feather boas. */
  private final long featherBoaFactor = eyePatchFactor * eyePatchCombinations;
  
  /** Number of background colors (0 = transparent). */
  private final int backgroundCombinations = COLORS.length + 1;
  /** Factor for background colors. */
  private final long backgroundFactor = featherBoaFactor * featherBoaCombinations;
  /** Number of foreground colors. */
  private final int foregroundCombinations = COLORS.length;
  /** Factor for foreground colors. */
  private final long foregroundFactor = backgroundFactor * backgroundCombinations;
  /** Number of background patterns (0 = no pattern). */
  private final int patternCombinations = 20;
  /** Factor for background patterns. */
  private final long patternFactor = foregroundFactor * foregroundCombinations;
  
  /** The total combinations. */
  private final long totalAvatars = patternFactor 
                                  * patternCombinations 
                                  / enablingCombinations 
                                  / genderCombinations;
    
  /** The avatar ID number representing the single components that make up a face. */
  private long id;

  
  /**
   * Default avatar constructor. 
   */
  public Avatar() {
    this(0);
  }
  
  /**
   * Avatar constructor.
   * 
   * @param id  The id.
   */
  public Avatar(long id) {
    this.id = id;
  }
  
  /**
   * Returns the id.
   *
   * @return  Returns the id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id  The id to set.
   */
  public void setId(long id) {
    this.id = id;
  }
  
  /**
   * Returns the value for the given combinations and factor.
   *
   * @param combinations  The combinations.
   * @param factor  The factor.
   * @return  The value.
   */
  private int getValue(long combinations, long factor) {
    return (int)((id / factor) % combinations);
  }
  
  /**
   * Sets the value for the given combinations and factor.
   *
   * @param combinations  The combinations.
   * @param factor  The factor.
   * @param value  The value.
   */
  private void setValue(long combinations, long factor, int value) {
    id += ((value - ((id / factor) % combinations)) * factor);
  }
  
  /**
   * Returns if enabled.
   * 
   * @return  true for enabled.
   */
  public boolean isEnabled() {
    return getValue(enablingCombinations, enablingFactor) > 0;
  }
  
  /**
   * Sets if enabled.
   * 
   * @param enabled  True for enabled.
   */
  public void setEnabled(boolean enabled) {
    setValue(enablingCombinations, enablingFactor, enabled ? 1 : 0);
  }
  
  /**
   * The enabling combinations.
   *
   * @return  The enabling combinations.
   */
  public int getEnablingCombinations() {
    return enablingCombinations;
  }
    
  /**
   * Returns if male.
   * 
   * @return  true for male.
   */
  public boolean isMale() {
    return getValue(genderCombinations, genderFactor) > 0;
  }
  
  /**
   * Sets if male.
   * 
   * @param male  True for male.
   */
  public void setMale(boolean male) {
    setValue(genderCombinations, genderFactor, male ? 1 : 0);
  }
  
  /**
   * The gender combinations.
   *
   * @return  The gender combinations.
   */
  public int getGenderCombinations() {
    return genderCombinations;
  }
  
  /**
   * Returns the head.
   * 
   * @return  The head.
   */
  public int getHead() {
    return getValue(headCombinations, headFactor);
  }
  
  /**
   * Sets the head.
   * 
   * @param head  The head.
   */
  public void setHead(int head) {
    setValue(headCombinations, headFactor, head);
  }
  
  /**
   * The head combinations.
   *
   * @return  The head combinations.
   */
  public int getHeadCombinations() {
    return headCombinations;
  }

  /**
   * Returns the eye.
   * 
   * @return  The eye.
   */
  public int getEye() {
    return getValue(eyeCombinations, eyeFactor);
  }
  
  /**
   * Sets the eye.
   * 
   * @param eye  The eye.
   */
  public void setEye(int eye) {
    setValue(eyeCombinations, eyeFactor, eye);
  }
  
  /**
   * The eye combinations.
   *
   * @return  The eye combinations.
   */
  public int getEyeCombinations() {
    return eyeCombinations;
  }

  /**
   * Returns the mouth.
   * 
   * @return  The mouth.
   */
  public int getMouth() {
    return getValue(mouthCombinations, mouthFactor);
  }
  
  /**
   * Sets the mouth.
   * 
   * @param mouth  The mouth.
   */
  public void setMouth(int mouth) {
    setValue(mouthCombinations, mouthFactor, mouth);
  }
  
  /**
   * The mouth combinations.
   *
   * @return  The mouth combinations.
   */
  public int getMouthCombinations() {
    return mouthCombinations;
  }

  /**
   * Returns the hair.
   * 
   * @return  The hair.
   */
  public int getHair() {
    return getValue(hairCombinations, hairFactor);
  }
  
  /**
   * Sets the hair.
   * 
   * @param hair  The hair.
   */
  public void setHair(int hair) {
    setValue(hairCombinations, hairFactor, hair);
  }
  
  /**
   * The hair combinations.
   *
   * @return  The hair combinations.
   */
  public int getHairCombinations() {
    return hairCombinations;
  }

  /**
   * Returns the beard.
   * 
   * @return  The beard.
   */
  public int getBeard() {
    return getValue(beardCombinations, beardFactor);
  }
  
  /**
   * Sets the beard.
   * 
   * @param beard  The beard.
   */
  public void setBeard(int beard) {
    setValue(beardCombinations, beardFactor, beard);
  }
  
  /**
   * The beard combinations.
   *
   * @return  The beard combinations.
   */
  public int getBeardCombinations() {
    return beardCombinations;
  }

  /**
   * Returns the mustache.
   * 
   * @return  The mustache.
   */
  public int getMustache() {
    return getValue(mustacheCombinations, mustacheFactor);
  }
  
  /**
   * Sets the mustache.
   * 
   * @param mustache  The mustache.
   */
  public void setMustache(int mustache) {
    setValue(mustacheCombinations, mustacheFactor, mustache);
  }
  
  /**
   * The mustache combinations.
   *
   * @return  The mustache combinations.
   */
  public int getMustacheCombinations() {
    return mustacheCombinations;
  }

  /**
   * Returns the sideburn.
   * 
   * @return  The sideburn.
   */
  public int getSideburn() {
    return getValue(sideburnCombinations, sideburnFactor);
  }
  
  /**
   * Sets the sideburn.
   * 
   * @param sideburn  The sideburn.
   */
  public void setSideburn(int sideburn) {
    setValue(sideburnCombinations, sideburnFactor, sideburn);
  }
  
  /**
   * The sideburn combinations.
   *
   * @return  The sideburn combinations.
   */
  public int getSideburnCombinations() {
    return sideburnCombinations;
  }

  /**
   * Returns the scar.
   * 
   * @return  The scar.
   */
  public int getScar() {
    return getValue(scarCombinations, scarFactor);
  }
  
  /**
   * Sets the scar.
   * 
   * @param scar  The scar.
   */
  public void setScar(int scar) {
    setValue(scarCombinations, scarFactor, scar);
  }
  
  /**
   * The scar combinations.
   *
   * @return  The scar combinations.
   */
  public int getScarCombinations() {
    return scarCombinations;
  }

  /**
   * Returns the glasses.
   * 
   * @return  The glasses.
   */
  public int getGlasses() {
    return getValue(glassesCombinations, glassesFactor);
  }
  
  /**
   * Sets the glasses.
   * 
   * @param glasses  The glasses.
   */
  public void setGlasses(int glasses) {
    setValue(glassesCombinations, glassesFactor, glasses);
  }
  
  /**
   * The glasses combinations.
   *
   * @return  The glasses combinations.
   */
  public int getGlassesCombinations() {
    return glassesCombinations;
  }

  /**
   * Returns the necklace.
   * 
   * @return  The necklace.
   */
  public int getNecklace() {
    return getValue(necklaceCombinations, necklaceFactor);
  }
  
  /**
   * Sets the necklace.
   * 
   * @param necklace  The necklace.
   */
  public void setNecklace(int necklace) {
    setValue(necklaceCombinations, necklaceFactor, necklace);
  }
  
  /**
   * The necklace combinations.
   *
   * @return  The necklace combinations.
   */
  public int getNecklaceCombinations() {
    return necklaceCombinations;
  }

  /**
   * Returns the hair accessory.
   * 
   * @return  The hair accessory.
   */
  public int getHairAccessory() {
    return getValue(hairAccessoryCombinations, hairAccessoryFactor);
  }
  
  /**
   * Sets the hair accessory.
   * 
   * @param hairAccessory  The hair accessory.
   */
  public void setHairAccessory(int hairAccessory) {
    setValue(hairAccessoryCombinations, hairAccessoryFactor, hairAccessory);
  }
  
  /**
   * The hair accessory combinations.
   *
   * @return  The hair accessory combinations.
   */
  public int getHairAccessoryCombinations() {
    return hairAccessoryCombinations;
  }

  /**
   * Returns the eye patch.
   * 
   * @return  The eye patch.
   */
  public int getEyePatch() {
    return getValue(eyePatchCombinations, eyePatchFactor);
  }
  
  /**
   * Sets the eye patch.
   * 
   * @param eyePatch  The eye patch.
   */
  public void setEyePatch(int eyePatch) {
    setValue(eyePatchCombinations, eyePatchFactor, eyePatch);
  }
  
  /**
   * The eye patch combinations.
   *
   * @return  The eye patch combinations.
   */
  public int getEyePatchCombinations() {
    return eyePatchCombinations;
  }
  
  /**
   * Returns the feather boa.
   * 
   * @return  The feather boa.
   */
  public int getFeatherBoa() {
    return getValue(featherBoaCombinations, featherBoaFactor);
  }
  
  /**
   * Sets the feather boa.
   * 
   * @param featherBoa  The feather boa.
   */
  public void setFeatherBoa(int featherBoa) {
    setValue(featherBoaCombinations, featherBoaFactor, featherBoa);
  }
  
  /**
   * The feather boa combinations.
   *
   * @return  The feather boa combinations.
   */
  public int getFeatherBoaCombinations() {
    return featherBoaCombinations;
  }

  /**
   * Returns the background color.
   * 
   * @return  The background color.
   */
  public int getBackground() {
    return getValue(backgroundCombinations, backgroundFactor);
  }
  
  /**
   * Sets the background color.
   * 
   * @param background  The background color.
   */
  public void setBackground(int background) {
    setValue(backgroundCombinations, backgroundFactor, background);
  }
  
  /**
   * The background color combinations.
   *
   * @return  The background color combinations.
   */
  public int getBackgroundCombinations() {
    return backgroundCombinations;
  }

  /**
   * Returns the foreground color.
   * 
   * @return  The foreground color.
   */
  public int getForeground() {
    return getValue(foregroundCombinations, foregroundFactor);
  }
  
  /**
   * Sets the foreground color.
   * 
   * @param foreground  The foreground color.
   */
  public void setForeground(int foreground) {
    setValue(foregroundCombinations, foregroundFactor, foreground);
  }
  
  /**
   * The foreground color combinations.
   *
   * @return  The foreground color combinations.
   */
  public int getForegroundCombinations() {
    return foregroundCombinations;
  }

  /**
   * Returns the background pattern.
   * 
   * @return  The background pattern.
   */
  public int getPattern() {
    return getValue(patternCombinations, patternFactor);
  }
  
  /**
   * Sets the background pattern.
   * 
   * @param pattern  The background pattern.
   */
  public void setPattern(int pattern) {
    setValue(patternCombinations, patternFactor, pattern);
  }
  
  /**
   * The background pattern combinations.
   *
   * @return  The background pattern combinations.
   */
  public int getPatternCombinations() {
    return patternCombinations;
  }  
  
  /**
   * Returns the total number of avatars.
   *
   * @return  The total number of avatar combinations.
   */
  public long getTotalAvatars() {
    return totalAvatars;
  }
}
