package org.bear.b;

import java.io.File;
import javax.swing.ImageIcon;
import org.bear.ui.b;

public class a {
   public static void a() {
      b.b.setEnabled(false);

      try {
         ProcessBuilder var0;
         (var0 = new ProcessBuilder(new String[]{"java", "-jar", org.bear.a.clientJarPath()})).directory(new File(System.getProperty("java.home") + File.separator + "bin"));
         var0.start();
         System.exit(0);
      } catch (Exception var1) {
         b.b.setEnabled(true);
      }
   }

   public static ImageIcon a(String var0) {
      return new ImageIcon(a.class.getResource("/resources/img/" + var0));
   }
}
