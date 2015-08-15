package org.bear.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.bear.ui.UI;

final class Mouse extends MouseAdapter {
   // $FF: synthetic field
   private UI ui;

   Mouse(UI var1) {
      this.ui = var1;
   }

   public final void mousePressed(MouseEvent e) {
      UI.mousePressed(e.getPoint());
      this.ui.getComponentAt(UI.getMousePoint());
   }
}
