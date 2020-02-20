/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;

import eventsim.EventSim;

/**
 *
 * @author evenal
 */
public class Checkout {
    // amount of time per prouct (to scan barcode)
    public static final int PROD_DURATION = 2;
    // amount of time to pay
    public static final int PAY_DURATION = 10;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    SuperMarket shop;
    String name;
    ArrayList<Customer> customers; 


    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout" + i;
        customers = new ArrayList<Customer>();
    }



   
    // kalkulerer hvor lang tid det tar å scanne og betale for varene for en kunde
    public int calcScanPay(Customer customer) {
        
        int scanPay = PAY_DURATION + PROD_DURATION * customer.numProducts;
        return scanPay;
    }

    //regner ut hvor lenge kunden må vente i kø
    public int calcQue(ArrayList<Customer> customers, Customer customer) {
        
       
        int queTime = 0; 
        int tqueTime = queTime - customer.checkoutTime;

        for (Customer c : customers) {

            queTime = queTime + c.checkoutTime;
            System.out.println("que time loop: " + queTime);
        }
        System.out.println("Time " + EventSim.getClock() + ". final que time " + tqueTime);
        
        return tqueTime; 
        
    } 



    
}
