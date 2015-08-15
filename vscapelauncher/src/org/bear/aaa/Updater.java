package org.bear.aaa;

import org.bear.aaa.Downloader;
import org.bear.aaa.UpdateManager;
import org.bear.aaa.Status;

final class Updater extends Thread {
   public final void run() {
      org.bear.ui.UI.launchButton.setEnabled(false);
      org.bear.ui.UI.progress.setString("Checking for Client Updates...");
      Status status;
      try {
		UpdateManager.updateStatus = status = UpdateManager.checkUpToDate();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return;
	}
      if(status == Status.CLIENT_UPTODATE) {
         org.bear.ui.UI.launchButton.setEnabled(true);
         org.bear.ui.UI.progress.setString("Client is up-to date!");
         org.bear.ui.UI.progress.setValue(100);
      } else {
         if(status == Status.FILE_DOESNTEXIST || status == Status.CLIENT_OUTOFDATE) {
            Downloader var2 = UpdateManager.downloader = new Downloader("https://dl.dropboxusercontent.com/u/31306161/vscape/client/vidyascape.jar");
            (new Thread(var2)).start();
         }

      }
   }
}
