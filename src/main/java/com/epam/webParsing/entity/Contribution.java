package com.epam.webParsing.entity;

import java.util.Objects;

public class Contribution implements XmlEntity {
    private String name;
    private String country;
    private String type;
    private String depositor;
    private int accountId;
    private double amountOfDeposit;
    private double profitability;
    private double timeConstraints;

    public Contribution(String name, String country, String type, String depositor, int accountId, double amountOfDeposit, double profitability, double timeConstraints) {
        this.name = name;
        this.country = country;
        this.type = type;
        this.depositor = depositor;
        this.accountId = accountId;
        this.amountOfDeposit = amountOfDeposit;
        this.profitability = profitability;
        this.timeConstraints = timeConstraints;
    }

    public Contribution() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmountOfDeposit() {
        return amountOfDeposit;
    }

    public void setAmountOfDeposit(double amountOfDeposit) {
        this.amountOfDeposit = amountOfDeposit;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public double getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(double timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribution that = (Contribution) o;
        return accountId == that.accountId &&
                Double.compare(that.amountOfDeposit, amountOfDeposit) == 0 &&
                Double.compare(that.profitability, profitability) == 0 &&
                Double.compare(that.timeConstraints, timeConstraints) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country) &&
                Objects.equals(type, that.type) &&
                Objects.equals(depositor, that.depositor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, country, type, depositor, accountId, amountOfDeposit, profitability, timeConstraints);
    }

    @Override
    public String toString() {
        return "Contribution@ name: " + name + " country: " + country + " type: " + type + " depositor: " + depositor +
                " accountId: " + accountId + " amountOfDeposit: " + amountOfDeposit + " profitability: " +
                profitability + " timeConstraints: " + timeConstraints;
    }
}
