package org.bear;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

public final class a {
   private static final String e;
   public static final Dimension a;
   public static final Color b;
   public static final Color c;
   public static final Color d;

   static {
      e = File.separator + "vscape" + File.separator;
      a = new Dimension(300, 155);
      b = new Color(40, 40, 40);
      c = new Color(80, 80, 80);
      d = new Color(60, 160, 220);
      new Color(60, 160, 220);
   }

   public static String clientJarPath() {
	   StringBuilder sb;
	   File file;
	   
	   sb = new StringBuilder(String.valueOf(System.getProperty("user.home")));
	   sb.append(e);
	   file = new File(sb.toString());
	   
	   if(!file.exists()) {
		   file.mkdir();
	   }
	   
	   sb.append("vidyascape.jar");
	   return sb.toString();
   }
}
