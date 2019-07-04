package com.rogtejada.core.challenge.dao;

import com.rogtejada.core.challenge.model.*;
import com.rogtejada.core.challenge.properties.Loader;
import com.rogtejada.core.challenge.service.ClientManager;
import com.rogtejada.core.challenge.service.SaleManager;
import com.rogtejada.core.challenge.service.SalesmanManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileListenerDaoDat implements FileListenerDao {
    private String dataDivisor;
    private String outputFileName;
    private static final int SALESMAN = 001;
    private static final int CLIENT = 002;
    private static final int SALE = 003;
    private static final String OUTPUT_PATH = System.getProperty("user.home") + Loader.loadProperties().getProperty("path.out");


    private SalesmanManager salesmanManager = SalesmanManager.getInstance();
    private ClientManager clientManager = ClientManager.getInstance();
    private SaleManager saleManager = SaleManager.getInstance();
    private List<String> errorList = new ArrayList<>();

    @Override
    public void setOutputFileName(String name){
        this.outputFileName = name;
    }

    @Override
    public void readFile(String filePath, String fileName) {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath + "/" + fileName));

            while ((line = reader.readLine()) != null) {
                dataDivisor=Character.toString(line.charAt(3));
                String[] lineFields = line.split(dataDivisor);

                if (lineFields.length != 4) {
                    errorList.add(line + " - FileName: " + fileName);
                } else {
                    analyzeLine(lineFields);
                }
            }
            writeOutputFile(fileName);
            if(!errorList.isEmpty()) {
                writeErrorLog();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeOutputFile(String fileName){
        try {
            File file = new File(OUTPUT_PATH + "/" + outputFileName);
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            OutputModel outputModel = new OutputModel();
            outputModel.setClientQuantity(clientManager.generateNumberOfClients());
            outputModel.setSalemanQuantity(salesmanManager.generateNumberOfSalesman());
            outputModel.setMostExpansiveSale(saleManager.getMostExpansiveSale());
            outputModel.setWorstSalesmanEver(salesmanManager.getWorstSalesmanEver());
            bufferedWriter.write(outputModel.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeErrorLog(){
        try {
            File file = new File(OUTPUT_PATH + "/" + Loader.loadProperties().getProperty("error.log"));
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String error : errorList) {
                bufferedWriter.write("Error found in line: " + error);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void analyzeLine(String[] informations) {
        switch(Integer.parseInt(informations[0])){
            case SALESMAN:
                instantiateSalesman(informations);
                break;

            case CLIENT:
                instantiateClient(informations);
                break;

            case SALE:
                instantiateSale(informations);
                break;

            default:
                errorList.add("Cannot Convert Information:" + informations);
         }
    }

    private void instantiateSalesman(String[] informations){
        Salesman salesman = new Salesman();
        salesman.setCpf(informations[1]);
        salesman.setName(informations[2]);
        salesman.setSalary(Double.parseDouble(informations[3]));
        salesmanManager.addSalesman(salesman);
    }

    private void instantiateClient(String[] informations){
        Client client = new Client();
        client.setCnpj(informations[1]);
        client.setName(informations[2]);
        client.setBusinessArea(informations[3]);
        clientManager.addClient(client);
    }

    private void instantiateSale(String[] informations){
        Sale sale = new Sale();
        sale.setId(Integer.parseInt(informations[1]));
        informations[2] = informations[2].replace("[", "");
        informations[2] = informations[2].replace("]", "");
        String[] saleInformation = informations[2].split(",");
        for(String sales:saleInformation){
            Item item = new Item();
            String[] salesField = sales.split("-");
            item.setId(Integer.parseInt(salesField[0]));
            item.setQuantity(Integer.parseInt(salesField[1]));
            item.setPrice(Double.parseDouble(salesField[2]));
            sale.addItem(item);
        }
        sale.setSalesmanName(informations[3]);
        saleManager.addSale(sale);
    }

}
