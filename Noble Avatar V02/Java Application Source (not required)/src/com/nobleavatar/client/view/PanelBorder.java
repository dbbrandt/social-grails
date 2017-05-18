package com.nobleavatar.client.view;

import java.awt.Image;

import com.nobleavatar.client.view.gui.ImageBorder;
import com.noblemaster.lib.access.ImageLoader;

/**
 * The panel border.
 *
 * @author    king 
 * @since     June 23, 2008
 */
public class PanelBorder extends ImageBorder {

  /**
   * Constructor.
   */
  public PanelBorder() {
    super(new Image[] {
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder00.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder01.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder02.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder03.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder04.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder05.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder06.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder07.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder08.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder09.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder10.gif"),
      ImageLoader.getInstance().getImage("conf/image/interface/border/PanelBorder11.gif"),
    });
  }
}
