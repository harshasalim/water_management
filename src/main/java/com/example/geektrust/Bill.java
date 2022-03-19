package com.example.geektrust;

public class Bill {
    static int PERDAY_CONSUMPTION = 10;
    static int MONTH_DAYS = 30;

    static int CORPORATION_RATE = 1;
    static double BOREWELL_RATE = 1.5;

    static int TANKER_SLAB500_RATE = 2;
    static int TANKER_SLAB1500_RATE = 3;
    static int TANKER_SLAB3000_RATE = 5;
    static int TANKER_SLABMAX_RATE = 8;

    static int FIVE_HUNDRED = 500;
    static int ONE_THOUSAND = 1000;
    static int ONE_THOUSAND_FIVE_HUNDRED = 1500;
    static int THREE_THOUSAND = 3000;
    
    private Apartment apartment;
    private Water water;

    public double[] splitRatio(String ratio){
        String[] ratioComponents = ratio.split(":");
        int ratioNumerator = Integer.parseInt(ratioComponents[0]);
        int ratioDenominator = Integer.parseInt(ratioComponents[1]);
        double corporationWaterRatio = (double)ratioNumerator/(ratioNumerator+ratioDenominator);
        double borewellWaterRatio = (double)ratioDenominator/(ratioNumerator+ratioDenominator);
        double[] splitRatios = {corporationWaterRatio,borewellWaterRatio};
        return splitRatios;
    }

    public void allotWater(String bedroomCount, String ratio){
        this.apartment = new Apartment(Integer.parseInt(bedroomCount));
        int totalResidentsConsumption = this.apartment.getResidentCount()*PERDAY_CONSUMPTION*MONTH_DAYS;
        
        double[] waterSplitRatio = splitRatio(ratio);
        
        this.water = new Water();
        this.water.setCorporationWater(Math.round(totalResidentsConsumption*waterSplitRatio[0]));
        this.water.setBorewellWater(Math.round(totalResidentsConsumption*waterSplitRatio[1]));

    }

    public void addGuests(String guestCount){
        this.apartment.setGuestCount(Integer.parseInt(guestCount));
        this.water.setTankerWater(this.apartment.getGuestCount() * PERDAY_CONSUMPTION*MONTH_DAYS);
    }

    public double getTankerBill(){
        double tankerBill = 0;
        double tankerWater = this.water.getTankerWater();

        if(tankerWater <= FIVE_HUNDRED){
            tankerBill = tankerWater * TANKER_SLAB500_RATE;
        }
        else if(tankerWater > FIVE_HUNDRED && tankerWater <= ONE_THOUSAND_FIVE_HUNDRED){        
            tankerBill = (FIVE_HUNDRED * TANKER_SLAB500_RATE) + ((tankerWater - FIVE_HUNDRED) * TANKER_SLAB1500_RATE);
        }
        else if(tankerWater > ONE_THOUSAND_FIVE_HUNDRED && tankerWater <= THREE_THOUSAND){
            tankerBill = (FIVE_HUNDRED * TANKER_SLAB500_RATE) + (ONE_THOUSAND * TANKER_SLAB1500_RATE)
                    + ((tankerWater - ONE_THOUSAND_FIVE_HUNDRED) * TANKER_SLAB3000_RATE);
        }
        else{
            tankerBill = (FIVE_HUNDRED * TANKER_SLAB500_RATE) + (ONE_THOUSAND * TANKER_SLAB1500_RATE)
                    + (ONE_THOUSAND_FIVE_HUNDRED * TANKER_SLAB3000_RATE) + ((tankerWater - THREE_THOUSAND) * TANKER_SLABMAX_RATE) ;
        }
        return tankerBill; 
    }

    public double getResidentsBill(){
        return ((this.water.getCorporationWater()*(double)CORPORATION_RATE)+(this.water.getBorewellWater()*(double)BOREWELL_RATE));
    }

    public int getTotalBill(){
        return (int)Math.round(getResidentsBill() + getTankerBill());
    }

    public int getTotalWater(){
        return (int)Math.round((this.water.getTankerWater() + this.water.getCorporationWater() + this.water.getBorewellWater()));
    }
}
