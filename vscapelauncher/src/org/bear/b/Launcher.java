package org.bear.b;

import java.io.File;
import javax.swing.ImageIcon;
import org.bear.ui.UI;

public class Launcher {
   public static void launchGame() {
      UI.launchButton.setEnabled(false);

      try {
         ProcessBuilder pb;
         (pb = new ProcessBuilder(new String[]{"java", "-jar", org.bear.Constants.clientJarPath()})).directory(new File(System.getProperty("java.home") + File.separator + "bin"));
         pb.start();
         System.exit(0);
      } catch (Exception var1) {
         UI.launchButton.setEnabled(true);
      }
   }

   public static ImageIcon getIcon(String name) {
      return new ImageIcon(Launcher.class.getResource("/resources/img/" + name));
   }
}
