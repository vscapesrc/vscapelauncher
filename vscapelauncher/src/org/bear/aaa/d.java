package org.bear.aaa;

import java.io.File;

import org.bear.aaa.a;
import org.bear.aaa.b;
import org.bear.aaa.e;
import org.bear.aaa.f;

public final class d {
   public static f a;
   public static b b;

   static {
      a = f.a;
   }

   public static boolean a() {
      return a == f.b;
   }

   public static void b() {
      (new e()).start();
   }

   public static f getJarPath() throws Throwable {
      if(!(new File(org.bear.a.clientJarPath())).exists()) {
         return f.FILE_DOESNTEXIST;
      } else {
         String var0 = org.bear.aaa.a.getLocalClientMD5String();
         String var1;
         return (var1 = org.bear.aaa.a.getRemoteClientMD5String()) != null && var0 != null?(!var1.equalsIgnoreCase(var0)?f.e:f.b):f.d;
      }
   }
}
