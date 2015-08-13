package org.bear.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import org.bear.ui.b;

final class d extends MouseMotionAdapter {
   // $FF: synthetic field
   private b a;

   d(b var1) {
	  super();
      this.a = var1;
   }

   public final void mouseDragged(MouseEvent var1) {
      int var2 = b.a().x;
      int var3 = b.a().y;
      if(var2 >= 0 && (double)var2 <= this.a.getPreferredSize().getWidth() && var3 >= 0 && var3 <= 25) {
         var2 = this.a.getLocation().x;
         var3 = this.a.getLocation().y;
         int var4 = var2 + var1.getX() - (var2 + b.a().x);
         int var5 = var3 + var1.getY() - (var3 + b.a().y);
         var2 += var4;
         var5 += var3;
         this.a.setLocation(var2, var5);
      }

   }
}
