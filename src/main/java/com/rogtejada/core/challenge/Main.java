package com.rogtejada.core.challenge;

import com.rogtejada.core.challenge.dao.FileListenerDao;
import com.rogtejada.core.challenge.dao.FileListenerDaoDat;
import com.rogtejada.core.challenge.observer.FileObserver;
import com.rogtejada.core.challenge.observer.FileObserverDat;

public class Main {
    public static void main(String[] args) {
        FileObserver fileObserver = new FileObserverDat();
        FileListenerDao fileListenerDao = new FileListenerDaoDat();
        fileListenerDao.setOutputFileName("done.dat");
        fileObserver.attachListener(fileListenerDao);
        fileObserver.run();
    }
}
