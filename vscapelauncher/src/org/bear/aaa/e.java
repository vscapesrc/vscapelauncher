package org.bear.aaa;

import org.bear.aaa.b;
import org.bear.aaa.d;
import org.bear.aaa.f;

final class e extends Thread {
   public final void run() {
      org.bear.ui.b.b.setEnabled(false);
      org.bear.ui.b.a.setString("Checking for Client Updates...");
      f var1;
      try {
		d.a = var1 = d.getJarPath();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return;
	}
      if(var1 == f.b) {
         org.bear.ui.b.b.setEnabled(true);
         org.bear.ui.b.a.setString("Client is up-to date!");
         org.bear.ui.b.a.setValue(100);
      } else {
         if(var1 == f.FILE_DOESNTEXIST || var1 == f.e) {
            b var2 = d.b = new b("https://dl.dropboxusercontent.com/u/31306161/vscape/client/vidyascape.jar");
            (new Thread(var2)).start();
         }

      }
   }
}
