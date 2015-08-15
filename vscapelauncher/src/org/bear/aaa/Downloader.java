package org.bear.aaa;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;

import org.bear.aaa.c;
import org.bear.aaa.UpdateManager;

public final class Downloader extends Observable implements Runnable {
   private URL a;
   private int b;
   private int c;
   private c d;

   public Downloader(String var1) {
      try {
         this.a = new URL(var1);
      } catch (MalformedURLException var2) {
         var2.printStackTrace();
      }

      this.b = -1;
      this.c = 0;
      this.d = org.bear.aaa.c.a;
   }

   public final void run() {
      org.bear.ui.UI.launchButton.setEnabled(false);
      RandomAccessFile var1 = null;
      InputStream var2 = null;
      boolean var15 = false;

      label221: {
         try {
            var15 = true;
            File var3;
            if((var3 = new File(org.bear.Constants.clientJarPath())).exists()) {
               var3.delete();
            }

            HttpURLConnection var4;
            (var4 = (HttpURLConnection)this.a.openConnection()).setRequestProperty("Range", "bytes=" + this.c + "-");
            var4.connect();
            if(var4.getResponseCode() / 100 != 2) {
               this.a();
            }

            int var5;
            if((var5 = var4.getContentLength()) <= 0) {
               this.a();
            }

            if(this.b == -1) {
               this.b = var5;
               this.b();
            }

            (var1 = new RandomAccessFile(var3, "rw")).seek((long)this.c);
            var2 = var4.getInputStream();
            int var24 = 0;

            while(this.d == org.bear.aaa.c.a) {
               byte[] var25;
               if(this.b - this.c > 1024) {
                  var25 = new byte[1024];
               } else {
                  var25 = new byte[this.b - this.c];
               }

               if((var5 = var2.read(var25)) == -1) {
                  break;
               }

               int var6;
               if((var6 = (int)((float)this.c / (float)this.b * 100.0F)) > var24) {
                  org.bear.ui.UI.progress.setValue(var6);
                  var24 = var6;
                  org.bear.ui.UI.progress.setString("Downloading Update: " + var6 + "%");
               }

               var1.write(var25, 0, var5);
               this.c += var5;
               this.b();
            }

            if(this.d == org.bear.aaa.c.a) {
               this.d = org.bear.aaa.c.b;
               this.b();
               org.bear.aaa.UpdateManager.startUpdater();
               var15 = false;
            } else {
               var15 = false;
            }
            break label221;
         } catch (Exception var22) {
            this.a();
            var15 = false;
         } finally {
            if(var15) {
               if(var1 != null) {
                  try {
                     var1.close();
                  } catch (Exception var18) {
                     ;
                  }
               }

               if(var2 != null) {
                  try {
                     var2.close();
                  } catch (Exception var17) {
                     ;
                  }
               }

            }
         }

         if(var1 != null) {
            try {
               var1.close();
            } catch (Exception var20) {
               ;
            }
         }

         if(var2 != null) {
            try {
               var2.close();
               return;
            } catch (Exception var16) {
               return;
            }
         }

         return;
      }

      try {
         var1.close();
      } catch (Exception var19) {
         ;
      }

      if(var2 != null) {
         try {
            var2.close();
            return;
         } catch (Exception var21) {
            ;
         }
      }

   }

   private void a() {
      this.d = org.bear.aaa.c.c;
      this.b();
   }

   private void b() {
      this.setChanged();
      this.notifyObservers();
   }
}
