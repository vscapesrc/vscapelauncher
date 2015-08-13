package org.bear.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.bear.ui.b;

final class c extends MouseAdapter {
   // $FF: synthetic field
   private b a;

   c(b var1) {
      this.a = var1;
   }

   public final void mousePressed(MouseEvent var1) {
      b.a(var1.getPoint());
      this.a.getComponentAt(b.a());
   }
}
