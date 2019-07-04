package com.rogtejada.core.challenge.observer;

import com.rogtejada.core.challenge.dao.FileListenerDao;

import java.util.LinkedList;
import java.util.List;

public abstract class FileObserver implements Runnable{
    private List<FileListenerDao> listeners = new LinkedList<>();

    public void attachListener(FileListenerDao listener) {
        listeners.add(listener);
    }

    public void detachListener(FileListenerDao listener){
        listeners.remove(listener);
    }

    public void notifyAllSubscribers(String filePath, String fileName){
        for(FileListenerDao listener: listeners){
            listener.readFile(filePath, fileName);
        }
    }
}
