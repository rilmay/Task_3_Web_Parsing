package com.epam.webParsing.entity;

import com.epam.webParsing.entity.xmlEntityInterface.XmlEntity;

import java.util.Objects;

public class Gemstone implements XmlEntity {
    private String name;
    private String preciousness;
    private String origin;
    private String colour;
    private double transparency;
    private int cuttingMethod;
    private double value;


    public Gemstone() {
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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
                Objects.equals(colour, gemstone.colour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, preciousness, origin, colour, transparency, value);
    }

    @Override
    public String toString() {
        return "Gemstone@ name: " + name + " preciousness: " + preciousness + " origin: " + origin + " colour:" +
                colour + " transparency: " + transparency + " cuttingMethod: " + cuttingMethod + " value" + value;
    }
}
