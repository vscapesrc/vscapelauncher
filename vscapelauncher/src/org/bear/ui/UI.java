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
import org.bear.ui.ColoredButton;
import org.bear.ui.Mouse;
import org.bear.ui.WindowDragger;

public final class UI extends JFrame implements ActionListener {
   private static int c;
   private static int d;
   public static JProgressBar progress;
   public static ColoredButton launchButton;
   private static Point mouseClickPoint;

   static {
      launchButton = new ColoredButton("Play", org.bear.Constants.PLAYBUTTON_COLOR);
   }

   public UI() {
      this.setPreferredSize(org.bear.Constants.WINDOW_DIMENSION);
      c = (int)this.getPreferredSize().getWidth();
      d = (int)this.getPreferredSize().getHeight();
      this.setTitle("/v/scape launcher - v0.1");
      this.setUndecorated(true);
      this.setLayout((LayoutManager)null);
      this.getRootPane().setBorder(new LineBorder(Color.BLACK));
      this.getContentPane().setBackground(org.bear.Constants.BACKGROUND_COLOR);
      JPanel var2;
      (var2 = new JPanel()).setLayout((LayoutManager)null);
      var2.setBounds(0, 0, c, 25);
      var2.setBackground(new Color(60, 60, 60));
      ColoredButton var3;
      (var3 = new ColoredButton("X", new Color(225, 80, 80))).setBounds(c - 50, 0, 50, 25);
      var3.setActionCommand("close");
      var3.addActionListener(this);
      var2.add(var3);
      (var3 = new ColoredButton("-", new Color(100, 100, 100))).setBounds(c - 100, 0, 50, 25);
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
      (var4 = new JLabel(org.bear.b.Launcher.getIcon("logo.png"))).setBounds(c / 2 - 70, 30, 139, 50);
      this.add(var4);
      (progress = new JProgressBar()).setUI(new LauncherFrame$1(this));
      progress.setBounds(0, d - 70, c, 35);
      progress.setBackground(org.bear.Constants.BACKGROUND_COLOR.darker());
      progress.setBorderPainted(false);
      progress.setStringPainted(true);
      progress.setString("Client up-to date!");
      progress.setBorder(new EmptyBorder(0, 0, 0, 0));
      progress.setForeground(org.bear.Constants.UPTODATE_COLOR);
      this.add(progress);
      launchButton.setActionCommand("play");
      launchButton.addActionListener(this);
      launchButton.setHorizontalAlignment(0);
      launchButton.setBounds(0, d - 35, c, 35);
      this.add(launchButton);
      this.setIconImage(org.bear.b.Launcher.getIcon("icon.png").getImage());
      this.addMouseListener(new Mouse(this));
      this.addMouseMotionListener(new WindowDragger(this));
      this.pack();
      org.bear.aaa.UpdateManager.startUpdater();
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
         } else if(!org.bear.aaa.UpdateManager.upToDate()) {
            org.bear.aaa.UpdateManager.startUpdater();
            return;
         } else {
            org.bear.b.Launcher.launchGame();
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
   static void mousePressed(Point var0) {
      mouseClickPoint = var0;
   }

   // $FF: synthetic method
   static Point getMousePoint() {
      return mouseClickPoint;
   }
}
