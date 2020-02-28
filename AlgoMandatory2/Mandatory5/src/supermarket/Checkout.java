package supermarket;

import java.util.ArrayList;

/**
 *
 * @author magne og kanta
 */
public class Checkout {
    // amount of time per prouct (to scan barcode)
    public static final int PROD_DURATION = 2;
    // amount of time to pay
    public static final int PAY_DURATION = 10;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    SuperMarket shop;
    String name;
    ArrayList<Customer> customers; //liste med kunder i køen 


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

        for (Customer c : customers) {

            if (!c.equals(customer)) {
            queTime = queTime + c.scanPayTime;
            }
        }       
        return queTime; 
        
    } 



    
}
