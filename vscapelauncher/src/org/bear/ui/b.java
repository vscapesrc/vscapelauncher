package org.bear.ui;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import org.bear.ui.LauncherFrame$1;
import org.bear.ui.a;
import org.bear.ui.c;
import org.bear.ui.d;

public final class b extends JFrame implements ActionListener {
   private static int c;
   private static int d;
   public static JProgressBar a;
   public static a b;
   private static Point e;

   static {
      b = new a("Play", org.bear.a.c);
   }

   public b() {
      this.setPreferredSize(org.bear.a.a);
      c = (int)this.getPreferredSize().getWidth();
      d = (int)this.getPreferredSize().getHeight();
      this.setTitle("/v/scape launcher - v0.1");
      this.setUndecorated(true);
      this.setLayout((LayoutManager)null);
      this.getRootPane().setBorder(new LineBorder(Color.BLACK));
      this.getContentPane().setBackground(org.bear.a.b);
      JPanel var2;
      (var2 = new JPanel()).setLayout((LayoutManager)null);
      var2.setBounds(0, 0, c, 25);
      var2.setBackground(new Color(60, 60, 60));
      a var3;
      (var3 = new a("X", new Color(225, 80, 80))).setBounds(c - 50, 0, 50, 25);
      var3.setActionCommand("close");
      var3.addActionListener(this);
      var2.add(var3);
      (var3 = new a("-", new Color(100, 100, 100))).setBounds(c - 100, 0, 50, 25);
      var3.setActionCommand("minimize");
      var3.addActionListener(this);
      var2.add(var3);
      JLabel var5;
      (var5 = new JLabel("/v/scape launcher - v0.1")).setForeground(Color.WHITE);
      var5.setHorizontalAlignment(2);
      var5.setBounds(10, 0, c - 10, 25);
      var2.add(var5);
      this.add(var2);
      JLabel var4;
      (var4 = new JLabel(org.bear.b.a.a("logo.png"))).setBounds(c / 2 - 70, 30, 139, 50);
      this.add(var4);
      (a = new JProgressBar()).setUI(new LauncherFrame$1(this));
      a.setBounds(0, d - 70, c, 35);
      a.setBackground(org.bear.a.b.darker());
      a.setBorderPainted(false);
      a.setStringPainted(true);
      a.setString("Client up-to date!");
      a.setBorder(new EmptyBorder(0, 0, 0, 0));
      a.setForeground(org.bear.a.d);
      this.add(a);
      b.setActionCommand("play");
      b.addActionListener(this);
      b.setHorizontalAlignment(0);
      b.setBounds(0, d - 35, c, 35);
      this.add(b);
      this.setIconImage(org.bear.b.a.a("icon.png").getImage());
      this.addMouseListener(new c(this));
      this.addMouseMotionListener(new d(this));
      this.pack();
      org.bear.aaa.d.b();
   }

   public final void actionPerformed(ActionEvent var1) {
      String var2;
      switch((var2 = var1.getActionCommand()).hashCode()) {
      case -1359067490:
         if(!var2.equals("minimize")) {
            return;
         }

         this.setState(1);
         return;
      case 3443508:
         if(!var2.equals("play")) {
            return;
         } else if(!org.bear.aaa.d.a()) {
            org.bear.aaa.d.b();
            return;
         } else {
            org.bear.b.a.a();
         }
      default:
         return;
      case 94756344:
         if(var2.equals("close")) {
            System.exit(0);
         }
      }
   }

   // $FF: synthetic method
   static void a(Point var0) {
      e = var0;
   }

   // $FF: synthetic method
   static Point a() {
      return e;
   }
}
