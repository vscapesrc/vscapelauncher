package org.bear.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import org.bear.ui.UI;

final class WindowDragger extends MouseMotionAdapter {
   // $FF: synthetic field
   private UI ui;

   WindowDragger(UI ui) {
	  super();
      this.ui = ui;
   }
   
   static int TITLEBAR_HEIGHT = 25;

   public final void mouseDragged(MouseEvent e) {
      int clickX = UI.getMousePoint().x;
      int clickY = UI.getMousePoint().y;
      
      if(clickX >= 0 && (double)clickX <= this.ui.getPreferredSize().getWidth() && clickY >= 0 && clickY <= TITLEBAR_HEIGHT) {
         int windowX = this.ui.getLocation().x;
         int windowY = this.ui.getLocation().y;
         int dx = windowX + e.getX() - (windowX + UI.getMousePoint().x);
         int dy = windowY + e.getY() - (windowY + UI.getMousePoint().y);
         
         windowX += dx;
         windowY += dy;
         this.ui.setLocation(windowX, windowY);
      }

   }
}
