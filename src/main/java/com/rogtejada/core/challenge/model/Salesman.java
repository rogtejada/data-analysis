package com.rogtejada.core.challenge.model;

public class Salesman {
    private String cpf;
    private String name;
    private Double salary;
    private Double amountSold=0D;

    public Salesman() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(Double amountSold) {
        this.amountSold += amountSold;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", amountSold=" + amountSold +
                '}';
    }
}
