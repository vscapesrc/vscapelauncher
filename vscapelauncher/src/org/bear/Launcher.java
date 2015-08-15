package org.bear;

import java.awt.Component;
import org.bear.ui.UI;

public class Launcher {
   private static UI ui;

   public static void main(String[] var0) {
      (ui = new UI()).setVisible(true);
      ui.setLocationRelativeTo((Component)null);
   }
}
