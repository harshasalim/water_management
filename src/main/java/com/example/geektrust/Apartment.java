package com.example.geektrust;

public class Apartment {
    static int CAPACITY_2BHK = 3;
    static int CAPACITY_3BHK = 5;

    static int TWO = 2;
    static int THREE = 3;

    private int residentCount;
    private int guestCount;

    Apartment(int bedroomCount){
        if(bedroomCount == TWO)
            this.residentCount = CAPACITY_2BHK;
        else if(bedroomCount == THREE)
            this.residentCount = CAPACITY_3BHK;
        else 
            this.residentCount = 0;
        this.guestCount = 0;
    }

    public int getResidentCount(){
        return this.residentCount;
    }

    public void setGuestCount(int guestCount){
        this.guestCount += guestCount;
    }

    public int getGuestCount(){
        return this.guestCount;
    }

}
