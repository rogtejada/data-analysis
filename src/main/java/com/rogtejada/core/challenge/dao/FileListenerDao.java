package com.rogtejada.core.challenge.dao;

public interface FileListenerDao {
    void readFile(String filePath, String fileName);
    void writeOutputFile(String fileName);
    void writeErrorLog();
    void setOutputFileName(String name);
}
