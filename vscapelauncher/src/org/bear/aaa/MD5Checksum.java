package org.bear.aaa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Checksum {
   private static final char[] HEXTOCHAR = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

   public static String getLocalClientMD5String() throws Throwable {
      File localJarFile = new File(org.bear.Constants.clientJarPath());

      try {
         Throwable var1 = null;

         try {
            FileInputStream var12 = new FileInputStream(localJarFile);

            String var10000;
            try {
               var10000 = getMD5(var12, "MD5");
            } finally {
               var12.close();
            }

            return var10000;
         } catch (Throwable var10) {
            if(var1 == null) {
               var1 = var10;
            } else if(var1 != var10) {
               var1.addSuppressed(var10);
            }

            throw var1;
         }
      } catch (Exception var11) {
         var11.printStackTrace();
         return null;
      }
   }

   public static String getRemoteClientMD5String() throws Throwable {
      try {
         Throwable var0 = null;

         try {
            InputStream is = (new URL("https://dl.dropboxusercontent.com/u/31306161/vscape/client/vidyascape.jar")).openStream();

            String md5String;
            try {
               md5String = getMD5(is, "MD5");
            } finally {
               if(is != null) {
                  is.close();
               }

            }

            return md5String;
         } catch (Throwable var10) {
            if(var0 == null) {
               var0 = var10;
            } else if(var0 != var10) {
               var0.addSuppressed(var10);
            }

            throw var0;
         }
      } catch (Exception var11) {
         var11.printStackTrace();
         return null;
      }
   }

   private static String getMD5(InputStream var0, String var1) {
      byte[] var2 = new byte[4096];
      MessageDigest var3;
      (var3 = a(var1)).reset();

      int var4;
      try {
         while((var4 = var0.read(var2)) != -1) {
            var3.update(var2, 0, var4);
         }
      } catch (IOException var5) {
         System.err.println("Error making a \'" + var1 + "\' digest on the inputstream");
      }

      return md5DigestToString(var3.digest());
   }

   private static String md5DigestToString(byte[] var0) {
      int var1;
      char[] var2 = new char[(var1 = var0.length) << 1];
      int var3 = 0;

      for(int var4 = 0; var4 < var1; ++var4) {
         var2[var3++] = HEXTOCHAR[var0[var4] >> 4 & 15];
         var2[var3++] = HEXTOCHAR[var0[var4] & 15];
      }

      return new String(var2);
   }

   private static MessageDigest a(String var0) {
      MessageDigest var1 = null;

      try {
         var1 = MessageDigest.getInstance(var0);
      } catch (NoSuchAlgorithmException var2) {
         System.err.println("The \'" + var0 + "\' algorithm is not available");
      }

      return var1;
   }
}
