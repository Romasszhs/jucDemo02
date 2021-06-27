package com.hang.designs.buider.demo01;

public class Product {
    private String buildA;
    private String buildB;
    private String buildC;
    private String buildD;

    public Product(String buildA, String buildB, String buildC, String buildD) {
        this.buildA = buildA;
        this.buildB = buildB;
        this.buildC = buildC;
        this.buildD = buildD;
    }

    public Product() {
    }

    public String getBuildA() {
        return buildA;
    }

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public String getBuildB() {
        return buildB;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public String getBuildC() {
        return buildC;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public String getBuildD() {
        return buildD;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }

    @Override
    public String toString() {
        return "Product{" +
                "buildA='" + buildA + '\'' +
                ", buildB='" + buildB + '\'' +
                ", buildC='" + buildC + '\'' +
                ", buildD='" + buildD + '\'' +
                '}';
    }
}
