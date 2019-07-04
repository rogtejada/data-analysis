package com.rogtejada.core.challenge.observer;

import com.rogtejada.core.challenge.properties.Loader;

import java.io.IOException;
import java.nio.file.*;
import java.util.Properties;

public class FileObserverDat extends FileObserver implements Runnable {
    private static final String PATH_TO_OBSERVE = System.getProperty("user.home") + Loader.loadProperties().getProperty("path.in");
    private static final String FILE_SPECIFICATION = Loader.loadProperties().getProperty("file.specification");

    @Override
    public void run() {
        try {

            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(PATH_TO_OBSERVE);

            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    if(event.context().toString().endsWith(FILE_SPECIFICATION)){
                        notifyAllSubscribers(PATH_TO_OBSERVE, event.context().toString());
                    }
                }
                key.reset();
            }
        }catch(IOException e)    {
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
