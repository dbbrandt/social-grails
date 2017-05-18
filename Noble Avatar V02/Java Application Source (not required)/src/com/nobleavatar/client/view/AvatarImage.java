package com.nobleavatar.client.view;

import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import com.nobleavatar.client.model.Avatar;
import com.nobleavatar.client.view.gui.composite.ColorComposite;
import com.noblemaster.lib.access.ImageLoader;

/**
 * Entity image.
 *
 * @author  Christoph Aschwanden
 * @since  May 20, 2008
 */
public final class AvatarImage {
  
  /** The one and only instance. */
  private static AvatarImage instance = new AvatarImage();
  
  /** The default avatar. */
  private Avatar defaultAvatar = new Avatar();
  
  /** The image for disabled avatar. */
  private Image disabledImage;
  
  /** The patterns. */
  private Image[][] patterns;
  /** The heads. */
  private Image[][] heads;
  /** The eyes. */
  private Image[][] eyes;
  /** The mouths. */
  private Image[][] mouths;
  /** The scars. */
  private Image[][] scars;
  /** The beards. */
  private Image[][] beards;
  /** The mustaches. */
  private Image[][] mustaches;
  /** The sideburns. */
  private Image[][] sideburns;  
  /** The glasses. */
  private Image[][] glasses;
  /** The eye patches. */
  private Image[][] eyePatches;
  /** The necklaces. */
  private Image[][] necklaces;
  /** The hairs. */
  private Image[][] hairs;
  /** The hair accessories. */
  private Image[][] hairAccessories;
  /** The boas. */
  private Image[][] boas;


  /**
   * Constructor.
   */
  private AvatarImage() {
    // parameters
    String path = "conf/avatar/";

    // load avatar images
    disabledImage = ImageLoader.getInstance().getImage(path + "disabled.gif");
    
    // load heads
    heads = new Image[2][defaultAvatar.getHeadCombinations()];
    for (int i = 0; i < heads[0].length; i++) {
      int id = i + 1;
      heads[0][i] = ImageLoader.getInstance().getImage(path + "head-m" + id + ".png");
      heads[1][i] = ImageLoader.getInstance().getImage(path + "head-f" + id + ".png");
    }

    // load eyes
    eyes = new Image[2][defaultAvatar.getEyeCombinations()];
    for (int i = 0; i < eyes[0].length; i++) {
      int id = i + 1;
      eyes[0][i] = ImageLoader.getInstance().getImage(path + "eye-m" + id + ".png");
      eyes[1][i] = ImageLoader.getInstance().getImage(path + "eye-f" + id + ".png");
    }

    // load mouths
    mouths = new Image[2][defaultAvatar.getMouthCombinations()];
    for (int i = 0; i < mouths[0].length; i++) {
      int id = i + 1;
      mouths[0][i] = ImageLoader.getInstance().getImage(path + "mouth-m" + id + ".png");
      mouths[1][i] = ImageLoader.getInstance().getImage(path + "mouth-f" + id + ".png");
    }

    // load scars
    scars = new Image[2][defaultAvatar.getScarCombinations() - 1];
    for (int i = 0; i < scars[0].length; i++) {
      int id = i + 1;
      scars[0][i] = ImageLoader.getInstance().getImage(path + "scar-" + id + ".png");
      scars[1][i] = scars[0][i];
    }

    // load beards
    beards = new Image[2][defaultAvatar.getBeardCombinations() - 1];
    for (int i = 0; i < beards[0].length; i++) {
      int id = i + 1;
      beards[0][i] = ImageLoader.getInstance().getImage(path + "beard-m" + id + ".png");
      beards[1][i] = beards[0][i];
    }

    // load mustaches
    mustaches = new Image[2][defaultAvatar.getMustacheCombinations() - 1];
    for (int i = 0; i < mustaches[0].length; i++) {
      int id = i + 1;
      mustaches[0][i] = ImageLoader.getInstance().getImage(path + "mustache-m" + id + ".png");
      mustaches[1][i] = mustaches[0][i];
    }

    // load sideburns
    sideburns = new Image[2][defaultAvatar.getSideburnCombinations() - 1];
    for (int i = 0; i < sideburns[0].length; i++) {
      int id = i + 1;
      sideburns[0][i] = ImageLoader.getInstance().getImage(path + "sideburn-m" + id + ".png");
      sideburns[1][i] = sideburns[0][i];
    }

    // load glasses
    glasses = new Image[2][defaultAvatar.getGlassesCombinations() - 1];
    for (int i = 0; i < glasses[0].length; i++) {
      int id = i + 1;
      glasses[0][i] = ImageLoader.getInstance().getImage(path + "glasses-" + id + ".png");
      glasses[1][i] = glasses[0][i];
    }
    
    // load eye patches
    eyePatches = new Image[2][defaultAvatar.getEyePatchCombinations() - 1];
    for (int i = 0; i < eyePatches[0].length; i++) {
      int id = i + 1;
      eyePatches[0][i] = ImageLoader.getInstance().getImage(path + "eyepatch-" + id + ".png");
      eyePatches[1][i] = eyePatches[0][i];
    }

    // load necklaces
    necklaces = new Image[2][defaultAvatar.getNecklaceCombinations() - 1];
    for (int i = 0; i < necklaces[0].length; i++) {
      int id = i + 1;
      if (id < 6) {
        necklaces[0][i] = ImageLoader.getInstance().getImage(path + "necklace-" + id + ".png");
        necklaces[1][i] = necklaces[0][i];
      }
      else {
        necklaces[0][i] = ImageLoader.getInstance().getImage(path + "necklace-m" + id + ".png");
        necklaces[1][i] = ImageLoader.getInstance().getImage(path + "necklace-f" + id + ".png");
      }
    }

    // load hairs
    hairs = new Image[2][defaultAvatar.getHairCombinations() - 1];
    for (int i = 0; i < hairs[0].length; i++) {
      int id = i + 1;
      hairs[0][i] = ImageLoader.getInstance().getImage(path + "hair-m" + id + ".png");
      hairs[1][i] = ImageLoader.getInstance().getImage(path + "hair-f" + id + ".png");
    }

    // load hair accessories
    hairAccessories = new Image[2][defaultAvatar.getHairAccessoryCombinations() - 1];
    for (int i = 0; i < hairAccessories[0].length; i++) {
      int id = i + 1;
      if (id < 18) {
        hairAccessories[0][i] = ImageLoader.getInstance().getImage(path + "accessory-" + id + ".png");
        hairAccessories[1][i] = hairAccessories[0][i];
      }
      else {
        hairAccessories[0][i] = ImageLoader.getInstance().getImage(path + "accessory-m" + id + ".png");
        hairAccessories[1][i] = ImageLoader.getInstance().getImage(path + "accessory-f" + id + ".png");
      }
    }
    
    // load feather boas
    boas = new Image[2][defaultAvatar.getFeatherBoaCombinations() - 1];
    for (int i = 0; i < boas[0].length; i++) {
      int id = i + 1;
      boas[0][i] = ImageLoader.getInstance().getImage(path + "boa-" + id + ".png");
      boas[1][i] = boas[0][i];
    }
    
    // load patterns
    patterns = new Image[2][defaultAvatar.getPatternCombinations() - 1];
    for (int i = 0; i < patterns[0].length; i++) {
      int id = i + 1;
      patterns[0][i] = ImageLoader.getInstance().getImage(path + "pattern-" + id + ".png");
      patterns[1][i] = patterns[0][i];
    }
  }
  
  /**
   * Returns the singleton instance.
   *
   * @return  The sole instance.
   */
  public static AvatarImage getInstance() {
    return instance;
  }
  
  /**
   * Returns the preferred size.
   *
   * @return  The preferred size.
   */
  public Dimension getPreferredSize() {
    return new Dimension(disabledImage.getWidth(null), disabledImage.getHeight(null));
  }
  
  /**
   * Returns the image for the given avatar.
   *
   * @param avatar  The avatar.
   * @return  The image.
   */
  public BufferedImage get(Avatar avatar) {
    // create new image
    Dimension size = getPreferredSize();
    BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    
    // draw avatar onto image
    if (avatar != null) {
      if (avatar.isEnabled()) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        // paramters 
        int width = disabledImage.getWidth(null);
        int height = disabledImage.getHeight(null);
        boolean male = avatar.isMale();
        int genderIndex = male ? 0 : 1;
        
        // draw background
        int background = avatar.getBackground();
        if (background > 0) {
          background--;
          g.setColor(Avatar.COLORS[background]);
          g.fillRect(0, 0, width, height);
        }
        
        // draw pattern with foreground color
        int pattern = avatar.getPattern();
        if (pattern > 0) {
          pattern--;
          int foreground = avatar.getForeground();
          
          // draw with selected color
          Composite oldComposite = g2.getComposite();
          g2.setComposite(new ColorComposite(1.0f, Avatar.COLORS[foreground]));
          g2.drawImage(patterns[genderIndex][pattern], 0, 0, null);
          g2.setComposite(oldComposite);
        }
        
        // draw head
        int head = avatar.getHead();
        g.drawImage(heads[genderIndex][head], 0, 0, null);

        // draw eye
        int eye = avatar.getEye();
        g.drawImage(eyes[genderIndex][eye], 0, 0, null);

        // draw mouth
        int mouth = avatar.getMouth();
        g.drawImage(mouths[genderIndex][mouth], 0, 0, null);

        // draw scar
        int scar = avatar.getScar();
        if (scar > 0) {
          scar--;
          g.drawImage(scars[genderIndex][scar], 0, 0, null);
        }

        // facial hair for males
        if (male) {
          // draw beard
          int beard = avatar.getBeard();
          if (beard > 0) {
            beard--;
            g.drawImage(beards[genderIndex][beard], 0, 0, null);
          }

          // draw mustache
          int mustache = avatar.getMustache();
          if (mustache > 0) {
            mustache--;
            g.drawImage(mustaches[genderIndex][mustache], 0, 0, null);
          }
  
          // draw sideburn
          int sideburn = avatar.getSideburn();
          if (sideburn > 0) {
            sideburn--;
            g.drawImage(sideburns[genderIndex][sideburn], 0, 0, null);
          }
        }
        
        // draw glasses
        int glass = avatar.getGlasses();
        if (glass > 0) {
          glass--;
          g.drawImage(glasses[genderIndex][glass], 0, 0, null);
        }
        
        // draw eye patch
        int eyePatch = avatar.getEyePatch();
        if (eyePatch > 0) {
          eyePatch--;
          g.drawImage(eyePatches[genderIndex][eyePatch], 0, 0, null);
        }

        // draw necklace
        int necklace = avatar.getNecklace();
        if (necklace > 0) {
          necklace--;
          g.drawImage(necklaces[genderIndex][necklace], 0, 0, null);
        }

        // draw hair
        int hair = avatar.getHair();
        if (hair > 0) {
          hair--;
          g.drawImage(hairs[genderIndex][hair], 0, 0, null);
        }

        // draw hair accessory
        int hairAccessory = avatar.getHairAccessory();
        if (hairAccessory > 0) {
          hairAccessory--;
          g.drawImage(hairAccessories[genderIndex][hairAccessory], 0, 0, null);
        }

        // draw feather boa
        int boa = avatar.getFeatherBoa();
        if (boa > 0) {
          boa--;
          g.drawImage(boas[genderIndex][boa], 0, 0, null);
        }
      }
      else {
        // draw disabled image
        g.drawImage(disabledImage, 0, 0, null);
      }
    }
    
    // and return the completed image
    return image;
  }
  
  /**
   * Draws an avatar.
   *
   * @param g  Where to draw to.
   * @param avatar  The avatar to draw.
   */
  public void paint(Graphics g, Avatar avatar) {
    g.drawImage(get(avatar), 0, 0, null);
  }
  
  /**
   * Returns the patterns.
   *
   * @return  The images.
   */
  public Image[][] getPatterns() {
    return patterns;
  }
  
  /**
   * Returns the heads.
   *
   * @return  The images.
   */
  public Image[][] getHeads() {
    return heads;
  }
  
  /**
   * Returns the eyes.
   *
   * @return  The images.
   */
  public Image[][] getEyes() {
    return eyes;
  }
  
  /**
   * Returns the mouths.
   *
   * @return  The images.
   */
  public Image[][] getMouths() {
    return mouths;
  }
  
  /**
   * Returns the scars.
   *
   * @return  The images.
   */
  public Image[][] getScars() {
    return scars;
  }
  
  /**
   * Returns the beards.
   *
   * @return  The images.
   */
  public Image[][] getBeards() {
    return beards;
  }
  
  /**
   * Returns the mustaches.
   *
   * @return  The images.
   */
  public Image[][] getMustaches() {
    return mustaches;
  }
  
  /**
   * Returns the sideburns.
   *
   * @return  The images.
   */
  public Image[][] getSideburns() {
    return sideburns;
  }
  
  /**
   * Returns the glasses.
   *
   * @return  The images.
   */
  public Image[][] getGlasses() {
    return glasses;
  }
  
  /**
   * Returns the eye patches.
   *
   * @return  The images.
   */
  public Image[][] getEyePatches() {
    return eyePatches;
  }
  
  /**
   * Returns the necklaces.
   *
   * @return  The images.
   */
  public Image[][] getNecklaces() {
    return necklaces;
  }
  
  /**
   * Returns the hairs.
   *
   * @return  The images.
   */
  public Image[][] getHairs() {
    return hairs;
  }
  
  /**
   * Returns the hair accessories.
   *
   * @return  The images.
   */
  public Image[][] getHairAccessories() {
    return hairAccessories;
  }
  
  /**
   * Returns the boas.
   *
   * @return  The images.
   */
  public Image[][] getBoas() {
    return boas;
  }
}