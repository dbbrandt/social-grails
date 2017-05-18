package com.nobleavatar.client.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.nobleavatar.client.Configuration;
import com.nobleavatar.client.model.Avatar;
import com.nobleavatar.client.view.gui.HorizontalLine;
import com.noblemaster.lib.access.ImageLoader;
import com.noblemaster.lib.access.ImageLoader.ImageType;
import com.nobleavatar.client.view.AvatarPartsPanel.AvatarSelectionListener;

/**
 * The avatar edit panel. 
 *
 * @author    king 
 * @since     May 20, 2008
 */
public class AvatarEditPanel extends JPanel {
 
  /** The formatter. */
  private final DecimalFormat formatter = new DecimalFormat("###,###,###,###,###,###,###,###");

  /** The avatar panel. */
  private AvatarPanel avatarPanel;
  
  /** The id label. */
  private JLabel idLabel;
  
  /** The tabbed pane. */
  private JTabbedPane avatarTabbedPane;
  
  /** The head panel. */
  private AvatarPartsPanel headPanel;
  /** The eye panel. */
  private AvatarPartsPanel eyePanel;
  /** The mouth panel. */
  private AvatarPartsPanel mouthPanel;
  
  /** The hair panel. */
  private AvatarPartsPanel hairPanel;

  /** The facial hair tab panel. */
  private JPanel facialHairTabPanel;
  /** The beard panel. */
  private AvatarPartsPanel beardPanel;
  /** The mustache panel. */
  private AvatarPartsPanel mustachePanel;
  /** The sideburn panel. */
  private AvatarPartsPanel sideburnPanel;

  /** The glasses panel. */
  private AvatarPartsPanel glassesPanel;
  /** The eye patch panel. */
  private AvatarPartsPanel eyePatchPanel;
  /** The scar panel. */
  private AvatarPartsPanel scarPanel;

  /** The hat panel. */
  private AvatarPartsPanel hatPanel;

  /** The necklace panel. */
  private AvatarPartsPanel necklacePanel;
  /** The boa panel. */
  private AvatarPartsPanel boaPanel;

  /** The background panel. */
  private AvatarPartsPanel backgroundPanel;

  /** The pattern panel. */
  private AvatarPartsPanel patternPanel;
  /** The foreground panel. */
  private AvatarPartsPanel foregroundPanel;

  
  /**
   * Default constructor for avatar edit panel.
   */
  public AvatarEditPanel() {
    this(null);
  }
  
  /**
   * Constructor for avatar edit panel.
   * 
   * @param avatar  The avatar.
   */
  public AvatarEditPanel(Avatar avatar) {
    AvatarImage avatarImage = AvatarImage.getInstance();
    
    // set look
    setOpaque(false);
    setLayout(new FormLayout(
        "right:80px, fill:1px:grow, pref"
      , "pref, 10px, fill:1px:grow, 0px, pref"
    ));
    CellConstraints cc = new CellConstraints();
    
    // add avatar panel
    avatarPanel = new AvatarPanel();
    add(avatarPanel, cc.xy(1, 1));
    
    // add gender selection panel
    JPanel genderPanel = new JPanel();
    genderPanel.setOpaque(false);
    genderPanel.setLayout(new FormLayout(
        "pref, 2px, pref"
      , "pref, 1px, 16px"
    ));
    add(genderPanel, cc.xy(3, 1));
    
    ButtonGroup genderGroup = new ButtonGroup();
    JRadioButton maleRadio = new JRadioButton(Configuration.getInstance().getString("avatar.male"));
    maleRadio.setOpaque(false);
    maleRadio.setFocusPainted(false);
    maleRadio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        avatarPanel.getAvatar().setMale(true); 
        update();
        repaint();
      }     
    });
    genderPanel.add(maleRadio, cc.xy(1, 1));
    genderGroup.add(maleRadio);   
    maleRadio.setSelected(avatar.isMale());
    
    JRadioButton femaleRadio = new JRadioButton(Configuration.getInstance().getString("avatar.female"));
    femaleRadio.setOpaque(false);
    femaleRadio.setFocusPainted(false);
    femaleRadio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        avatarPanel.getAvatar().setMale(false);        
        update();
        repaint();
      }     
    });
    genderPanel.add(femaleRadio, cc.xy(3, 1));
    genderGroup.add(femaleRadio);
    femaleRadio.setSelected(!avatar.isMale());
    
    // add horizontal line
    genderPanel.add(new HorizontalLine(), cc.xyw(1, 2, 3));
    
    // add info label
    idLabel = new JLabel();
    idLabel.setHorizontalAlignment(SwingConstants.CENTER);
    idLabel.setFont(idLabel.getFont().deriveFont(Font.PLAIN, 10.0f));
    genderPanel.add(idLabel, cc.xyw(1, 3, 3));   

    // add tabbed pane
    avatarTabbedPane = new JTabbedPane();
    avatarTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    add(avatarTabbedPane, cc.xyw(1, 3, 3));
    
    // variables used
    int combinations;
    int margin = 3;
    int width = avatarImage.getPreferredSize().width;
    int height = avatarImage.getPreferredSize().height;
    Image[][] colorImages = new Image[2][Avatar.COLORS.length];
    for (int i = 0; i < colorImages[0].length; i++) {
      // create the images
      Image image = ImageLoader.getInstance().createImage(width, height, ImageType.TRANSLUCENT);
      Graphics g = image.getGraphics();
      g.setColor(Avatar.COLORS[i]);
      g.fillRoundRect(margin, margin, width - (2 * margin), height - (2 * margin), 5, 5);
      colorImages[0][i] = image;
      colorImages[1][i] = image;
    }
    
    // add face tab (head, eyes, mouth)
    JPanel headTabPanel = createTabPanel(3);
    avatarTabbedPane.addTab(Configuration.getInstance().getString("avatar.Head"), headTabPanel);
    
    combinations = avatar.getHeadCombinations();
    headPanel = new AvatarPartsPanel(avatarImage.getHeads(), combinations);
    headPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setHead(index);
        updateId();
        repaint();
      }      
    });
    headTabPanel.add(headPanel, cc.xy(2, 2));
    
    headTabPanel.add(new HorizontalLine(), cc.xy(2, 4));
    
    combinations = avatar.getEyeCombinations();
    eyePanel = new AvatarPartsPanel(avatarImage.getEyes(), combinations);
    eyePanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setEye(index);
        updateId();
        repaint();
      }      
    });
    headTabPanel.add(eyePanel, cc.xy(2, 6));
    
    headTabPanel.add(new HorizontalLine(), cc.xy(2, 8));

    combinations = avatar.getMouthCombinations();
    mouthPanel = new AvatarPartsPanel(avatarImage.getMouths(), combinations);
    mouthPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setMouth(index);
        updateId();
        repaint();
      }      
    });
    headTabPanel.add(mouthPanel, cc.xy(2, 10));

    // add hair tab (hair)
    JPanel hairTabPanel = createTabPanel(1);
    avatarTabbedPane.addTab(Configuration.getInstance().getString("avatar.Hair"), hairTabPanel);
    
    combinations = avatar.getHairCombinations();
    hairPanel = new AvatarPartsPanel(avatarImage.getHairs(), combinations);
    hairPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setHair(index);
        updateId();
        repaint();
      }      
    });
    hairTabPanel.add(hairPanel, cc.xy(2, 2));

    // add feature tab (glasses, eye patch, scar))
    JPanel featureTabPanel = createTabPanel(3);
    avatarTabbedPane.addTab(Configuration.getInstance().getString("avatar.Feature"), featureTabPanel);
    
    combinations = avatar.getGlassesCombinations();
    glassesPanel = new AvatarPartsPanel(avatarImage.getGlasses(), combinations);
    glassesPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setGlasses(index);
        updateId();
        repaint();
      }      
    });
    featureTabPanel.add(glassesPanel, cc.xy(2, 2));
    
    featureTabPanel.add(new HorizontalLine(), cc.xy(2, 4));
    
    combinations = avatar.getEyePatchCombinations();
    eyePatchPanel = new AvatarPartsPanel(avatarImage.getEyePatches(), combinations);
    eyePatchPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setEyePatch(index);
        updateId();
        repaint();
      }      
    });
    featureTabPanel.add(eyePatchPanel, cc.xy(2, 6));
    
    featureTabPanel.add(new HorizontalLine(), cc.xy(2, 8));

    combinations = avatar.getScarCombinations();
    scarPanel = new AvatarPartsPanel(avatarImage.getScars(), combinations);
    scarPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setScar(index);
        updateId();
        repaint();
      }      
    });
    featureTabPanel.add(scarPanel, cc.xy(2, 10));

    // add feature tab (beard, mustache, sideburns)
    facialHairTabPanel = createTabPanel(3);
    
    combinations = avatar.getBeardCombinations();
    beardPanel = new AvatarPartsPanel(avatarImage.getBeards(), combinations);
    beardPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setBeard(index);
        updateId();
        repaint();
      }      
    });
    facialHairTabPanel.add(beardPanel, cc.xy(2, 2));
    
    facialHairTabPanel.add(new HorizontalLine(), cc.xy(2, 4));
    
    combinations = avatar.getMustacheCombinations();
    mustachePanel = new AvatarPartsPanel(avatarImage.getMustaches(), combinations);
    mustachePanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setMustache(index);
        updateId();
        repaint();
      }      
    });
    facialHairTabPanel.add(mustachePanel, cc.xy(2, 6));
    
    facialHairTabPanel.add(new HorizontalLine(), cc.xy(2, 8));

    combinations = avatar.getSideburnCombinations();
    sideburnPanel = new AvatarPartsPanel(avatarImage.getSideburns(), combinations);
    sideburnPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setSideburn(index);
        updateId();
        repaint();
      }      
    });
    facialHairTabPanel.add(sideburnPanel, cc.xy(2, 10));

    // add hat tab (hair accessory)
    JPanel hatTabPanel = createTabPanel(1);
    avatarTabbedPane.addTab(Configuration.getInstance().getString("avatar.Hat"), hatTabPanel);
    
    combinations = avatar.getHairAccessoryCombinations();
    hatPanel = new AvatarPartsPanel(avatarImage.getHairAccessories(), combinations);
    hatPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setHairAccessory(index);
        updateId();
        repaint();
      }      
    });
    hatTabPanel.add(hatPanel, cc.xy(2, 2));

    // add accessory tab (necklace, feather boa)
    JPanel accessoryTabPanel = createTabPanel(2);
    avatarTabbedPane.addTab(Configuration.getInstance().getString("avatar.Accessory"), accessoryTabPanel);
    
    combinations = avatar.getNecklaceCombinations();
    necklacePanel = new AvatarPartsPanel(avatarImage.getNecklaces(), combinations);
    necklacePanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setNecklace(index);
        updateId();
        repaint();
      }      
    });
    accessoryTabPanel.add(necklacePanel, cc.xy(2, 2));
    
    accessoryTabPanel.add(new HorizontalLine(), cc.xy(2, 4));
    
    combinations = avatar.getFeatherBoaCombinations();
    boaPanel = new AvatarPartsPanel(avatarImage.getBoas(), combinations);
    boaPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setFeatherBoa(index);
        updateId();
        repaint();
      }      
    });
    accessoryTabPanel.add(boaPanel, cc.xy(2, 6));

    // add background tab (background)
    JPanel backgroundTabPanel = createTabPanel(1);
    avatarTabbedPane.addTab(Configuration.getInstance().getString("avatar.Background"), backgroundTabPanel);
    
    combinations = avatar.getBackgroundCombinations();
    backgroundPanel = new AvatarPartsPanel(colorImages, combinations);
    backgroundPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setBackground(index);
        updateId();
        repaint();
      }      
    });
    backgroundTabPanel.add(backgroundPanel, cc.xy(2, 2));

    // add pattern tab (pattern, foreground)
    JPanel patternTabPanel = createTabPanel(2);
    avatarTabbedPane.addTab(Configuration.getInstance().getString("avatar.Pattern"), patternTabPanel);
    
    combinations = avatar.getPatternCombinations();
    patternPanel = new AvatarPartsPanel(avatarImage.getPatterns(), combinations);
    patternPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setPattern(index);
        updateId();
        repaint();
      }      
    });
    patternTabPanel.add(patternPanel, cc.xy(2, 2));

    patternTabPanel.add(new HorizontalLine(), cc.xy(2, 4));
    
    combinations = avatar.getForegroundCombinations();
    foregroundPanel = new AvatarPartsPanel(colorImages, combinations);
    foregroundPanel.addAvatarSelectionListener(new AvatarSelectionListener() {
      public void handleSelection(int index) {
        avatarPanel.getAvatar().setForeground(index);
        updateId();
        repaint();
      }      
    });
    patternTabPanel.add(foregroundPanel, cc.xy(2, 6));

    // add info label
    JLabel infoLabel = new JLabel();
    String infoText = "~" + formatter.format(avatar.getTotalAvatars()) + " combinations";
    infoLabel.setText(infoText);
    infoLabel.setFont(infoLabel.getFont().deriveFont(Font.PLAIN, 10.0f));
    add(infoLabel, cc.xy(3, 5));
    
    // set avatar
    setAvatar(avatar);
  }
  
  /**
   * Returns the avatar.
   *
   * @return  Returns the avatar.
   */
  public Avatar getAvatar() {
    return avatarPanel.getAvatar();
  }

  /**
   * Sets the avatar.
   *
   * @param avatar  The avatar to set.
   */
  public void setAvatar(Avatar avatar) {
    avatarPanel.setAvatar(avatar);
    
    // and update
    update();
  }
  
  /**
   * Creates a tab panel.
   *
   * @param rows  The number of rows.
   * @return  The panel.
   */
  private JPanel createTabPanel(int rows) {
    // define row layout
    String yLayout = "3px";
    for (int i = 0; i < rows; i++) {
      yLayout = yLayout + ", pref, 2px, 1px, 2px";
    }
    yLayout = yLayout + ", fill:1px:grow";
    
    // create panel
    JPanel panel = new JPanel();
    panel.setOpaque(false);
    panel.setLayout(new FormLayout("3px, fill:1px:grow, 3px", yLayout));
    return panel;
  }
  
  /**
   * Updates the avatar panel.
   */
  private void update() {
    Avatar avatar = avatarPanel.getAvatar();
    
    // update parts
    if (avatar != null) {
      boolean male = avatar.isMale();
      
      headPanel.update(male, avatar.getHead());
      eyePanel.update(male, avatar.getEye());
      mouthPanel.update(male, avatar.getMouth());

      hairPanel.update(male, avatar.getHair());
      
      beardPanel.update(male, avatar.getBeard());
      mustachePanel.update(male, avatar.getMustache());
      sideburnPanel.update(male, avatar.getSideburn());

      glassesPanel.update(male, avatar.getGlasses());
      eyePatchPanel.update(male, avatar.getEyePatch());
      scarPanel.update(male, avatar.getScar());

      hatPanel.update(male, avatar.getHairAccessory());      

      necklacePanel.update(male, avatar.getNecklace());
      boaPanel.update(male, avatar.getFeatherBoa());

      backgroundPanel.update(male, avatar.getBackground());      

      patternPanel.update(male, avatar.getPattern());
      foregroundPanel.update(male, avatar.getForeground());

      // update id label
      updateId();
      
      // update gender specific tabs
      String title = Configuration.getInstance().getString("avatar.FacialHair");
      boolean exists = avatarTabbedPane.indexOfTab(title) >= 0;
      if (male) {
        if (!exists) {
          avatarTabbedPane.insertTab(title, null, facialHairTabPanel, null, 2);
        }
      }
      else {
        if (exists) {
          avatarTabbedPane.remove(facialHairTabPanel);
        }
      }
      revalidate();
      repaint();
    }
  }
  
  /**
   * Updates the avatar id. 
   */
  private void updateId() {
    Avatar avatar = avatarPanel.getAvatar();
    idLabel.setText("id# " + formatter.format(avatar.getId()));
  }
}
