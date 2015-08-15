package org.bear.aaa;

import java.io.File;

import org.bear.aaa.MD5Checksum;
import org.bear.aaa.Downloader;
import org.bear.aaa.Updater;
import org.bear.aaa.Status;

public final class UpdateManager {
   public static Status updateStatus;
   public static Downloader downloader;

   static {
      updateStatus = Status.a;
   }

   public static boolean upToDate() {
      return updateStatus == Status.CLIENT_UPTODATE;
   }

   public static void startUpdater() {
      (new Updater()).start();
   }

   public static Status checkUpToDate() throws Throwable {
      if(!(new File(org.bear.Constants.clientJarPath())).exists()) {
         return Status.FILE_DOESNTEXIST;
      } else {
         String localMD5 = org.bear.aaa.MD5Checksum.getLocalClientMD5String();
         String remoteMD5;
         return (remoteMD5 = org.bear.aaa.MD5Checksum.getRemoteClientMD5String()) != null && localMD5 != null?(!remoteMD5.equalsIgnoreCase(localMD5)?Status.CLIENT_OUTOFDATE:Status.CLIENT_UPTODATE):Status.HASHING_PROBLEM;
      }
   }
}
