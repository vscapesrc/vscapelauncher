package org.bear.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public final class a extends JButton implements MouseListener {
   public a(String var1, Color var2) {
      super(var1);
      this.setBackground(var2);
      this.setForeground(new Color(255, 255, 255));
      this.setBorderPainted(false);
      this.setFocusable(false);
      this.addMouseListener(this);
   }

   public final void mouseClicked(MouseEvent var1) {
   }

   public final void mouseEntered(MouseEvent var1) {
      this.setBackground(this.getBackground().darker());
   }

   public final void mouseExited(MouseEvent var1) {
      this.setBackground(this.getBackground().brighter());
   }

   public final void mousePressed(MouseEvent var1) {
   }

   public final void mouseReleased(MouseEvent var1) {
   }
}
