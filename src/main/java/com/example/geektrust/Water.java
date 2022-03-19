package com.example.geektrust;

public class Water {
    private double corporationWater;
    private double borewellWater;
    private double tankerWater;

    public void setCorporationWater(double corporationWater){
        this.corporationWater = corporationWater;
    }

    public double getCorporationWater(){
        return this.corporationWater;
    }

    public void setBorewellWater(double borewellWater){
        this.borewellWater = borewellWater;
    }

    public double getBorewellWater(){
        return this.borewellWater;
    }

    public void setTankerWater(double tankerWater){
        this.tankerWater = tankerWater;
    }

    public double getTankerWater(){
        return this.tankerWater;
    }
}
