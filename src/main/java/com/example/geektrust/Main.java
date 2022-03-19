package com.example.geektrust;
import java.io.*;
import java.util.Scanner;  

public class Main {
    public static void main(String[] args)  {
        try{
            FileInputStream fis=new FileInputStream(args[0]);       
            Scanner sc=new Scanner(fis);    
            Bill bill = new Bill();
            while(sc.hasNextLine())  
            {  
                String line = sc.nextLine();  
                String[] lineArray = line.split(" ");
                if(lineArray[0].equals("ALLOT_WATER")) bill.allotWater(lineArray[1],lineArray[2]);
                else if(lineArray[0].equals("ADD_GUESTS")) bill.addGuests(lineArray[1]);
                else if(lineArray[0].equals("BILL")) {
                    System.out.println(bill.getTotalWater()+" "+bill.getTotalBill());
                }   
            }  
            sc.close();       
        }   
        catch (Exception e) {
            e.printStackTrace();  
        }
	}
}
