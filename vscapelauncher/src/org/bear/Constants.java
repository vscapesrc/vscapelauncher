package org.bear;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

public final class Constants {
   private static final String DATA_DIR;
   public static final Dimension WINDOW_DIMENSION;
   public static final Color BACKGROUND_COLOR;
   public static final Color PLAYBUTTON_COLOR;
   public static final Color UPTODATE_COLOR;

   static {
      DATA_DIR = File.separator + "vscape" + File.separator;
      WINDOW_DIMENSION = new Dimension(300, 155);
      BACKGROUND_COLOR = new Color(40, 40, 40);
      PLAYBUTTON_COLOR = new Color(80, 80, 80);
      UPTODATE_COLOR = new Color(60, 160, 220);
      new Color(60, 160, 220);
   }

   public static String clientJarPath() {
	   StringBuilder sb;
	   File file;
	   
	   sb = new StringBuilder(String.valueOf(System.getProperty("user.home")));
	   sb.append(DATA_DIR);
	   file = new File(sb.toString());
	   
	   if(!file.exists()) {
		   file.mkdir();
	   }
	   
	   sb.append("vidyascape.jar");
	   return sb.toString();
   }
}
