package com.example.geektrust;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.geektrust.Apartment;
import com.example.geektrust.Bill;
import com.example.geektrust.Main;
import com.example.geektrust.Water;

public class MainTest {

    @Test
    public void getResidentCountFor2BHK(){
        Apartment apartment = new Apartment(2);      
    	assertEquals(3,apartment.getResidentCount());
    }

    @Test
    public void getResidentCountFor3BHK(){
    	Apartment apartmenttemp = new Apartment(3);
    	assertEquals(5,apartmenttemp.getResidentCount());
    }

    @Test
    public void checkOneTimeGuestAddition(){
        Apartment apartment = new Apartment(2);      
        apartment.setGuestCount(2);
    	assertEquals(2,apartment.getGuestCount());
    }

    @Test
    public void checkTwoTimesGuestAddition(){
        Apartment apartment = new Apartment(2);      
        apartment.setGuestCount(2);
        apartment.setGuestCount(2);
    	assertEquals(4,apartment.getGuestCount());
    }

    @Test
    public void calculateResidentWaterBill(){
    	Bill bill = new Bill();
        bill.allotWater("2","2:1");
    	assertEquals(1050,bill.getResidentsBill());
    }

    @Test
    public void calculateTankerWaterBill(){
        Bill bill = new Bill();
        bill.allotWater("2","2:1");
        bill.addGuests("10");
    	assertEquals(11500,bill.getTankerBill());
    }


    @Test
    public void calculateTotalWaterBill(){
        Bill bill = new Bill();
        bill.allotWater("2","2:1");
        bill.addGuests("10");    	
        assertEquals(12550,bill.getTotalBill());
    }

    @Test
    public void getTotalWaterConsumed(){
        Bill bill = new Bill();
        bill.allotWater("2","2:1");
        bill.addGuests("10");     	
        assertEquals(3900,bill.getTotalWater());
    }
}
 