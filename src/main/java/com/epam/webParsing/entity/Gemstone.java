package com.epam.webParsing.entity;

import java.util.Objects;

public class Gemstone implements XmlEntity {
    private String name;
    private String preciousness;
    private String origin;
    private String color;
    private double transparency;
    private int cuttingMethod;
    private double value;


    public Gemstone() {
        this.name = "";
        this.preciousness = "";
        this.origin = "";
        this.color = "";
        this.transparency = 0;
        this.cuttingMethod = 4;
        this.value = 0;
    }

    public Gemstone(String name, String preciousness, String origin, String color, Double transparency, Integer cuttingMethod, Double value) {
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.color = color;
        this.transparency = transparency;
        this.cuttingMethod = cuttingMethod;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String colour) {
        this.color = colour;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public int getCuttingMethod() {
        return cuttingMethod;
    }

    public void setCuttingMethod(int cuttingMethod) {
        this.cuttingMethod = cuttingMethod;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gemstone gemstone = (Gemstone) o;
        return Double.compare(gemstone.transparency, transparency) == 0 &&
                Double.compare(gemstone.value, value) == 0 &&
                Objects.equals(name, gemstone.name) &&
                Objects.equals(preciousness, gemstone.preciousness) &&
                Objects.equals(origin, gemstone.origin) &&
                Objects.equals(color, gemstone.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, preciousness, origin, color, transparency, value);
    }

    @Override
    public String toString() {
        return "Gemstone@ name: " + name + " preciousness: " + preciousness + " origin: " + origin + " color: " +
                color + " transparency: " + transparency + " cuttingMethod: " + cuttingMethod + " value: " + value;
    }
}
