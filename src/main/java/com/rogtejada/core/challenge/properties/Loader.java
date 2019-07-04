package com.rogtejada.core.challenge.properties;

import com.rogtejada.core.challenge.exception.ReadingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Loader {
    public static Properties loadProperties(){
        try(FileInputStream dbProperties = new FileInputStream("application.properties")){
            Properties properties = new Properties();
            properties.load(dbProperties);
            return properties;
        }catch(IOException e){
            throw new ReadingException(e.getMessage());
        }
    }
}
