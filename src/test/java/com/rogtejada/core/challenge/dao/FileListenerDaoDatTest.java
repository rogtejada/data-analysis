package com.rogtejada.core.challenge.dao;

import com.rogtejada.core.challenge.properties.Loader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FileListenerDaoDatTest {
    private static final String OUTPUT_TEST_PATH = System.getProperty("user.home") + Loader.loadProperties().getProperty("path.out");
    private static final String INPUT_TEST_PATH = System.getProperty("user.home") + Loader.loadProperties().getProperty("path.in");
    private FileListenerDaoDat fileListenerDaoDat = new FileListenerDaoDat();

    @Before
    public void init(){
        try {
            File file = new File(INPUT_TEST_PATH + "/" + Loader.loadProperties().getProperty("test.input.file.name"));
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("001;1234567891234;Diego;50000");
            bufferedWriter.newLine();
            bufferedWriter.write("001;3245678865434;Renato;40000.99");
            bufferedWriter.newLine();
            bufferedWriter.write("002;2345675434544345;Jose da Silva;Rural");
            bufferedWriter.newLine();
            bufferedWriter.write("002;2345675433444345;EduardoPereira;Rural");
            bufferedWriter.newLine();
            bufferedWriter.write("003;10;[1-10-100,2-30-2.50,3-40-3.10];Diego");
            bufferedWriter.newLine();
            bufferedWriter.write("003;08;[1-34-10,2-33-1.50,3-40-0.10];Renato");
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException  e){
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        File file = new File(INPUT_TEST_PATH + "/test.dat");
        file.delete();
    }

    @Test
    public void readAndWriteOutputFile() {
        List<String> lines = new ArrayList<>();
        try{
            fileListenerDaoDat.setOutputFileName( Loader.loadProperties().getProperty("test.output.file.name"));
            fileListenerDaoDat.readFile(INPUT_TEST_PATH, Loader.loadProperties().getProperty("test.input.file.name"));
            BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_TEST_PATH + "/" + Loader.loadProperties().getProperty("test.output.file.name")));
            String line;
            while ((line = reader.readLine()) != null) {
                  lines.add(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        assertEquals(true, lines.get(0).endsWith("2"));
        assertEquals(true, lines.get(1).endsWith("2"));
        assertEquals(true, lines.get(2).endsWith("10"));
        assertEquals(true, lines.get(3).endsWith("393.5}"));
    }
}