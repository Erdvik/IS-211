/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import eventsim.EventSim;

/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values
    public static final int MAX_PRODUCTS = 20;
    public static final int MIN_PRODUCTS = 0;

    // customer will spend ranom amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 100;
    public static final int MIN_SHOP_TIME = 1;

    SuperMarket shop;
    String name;

    int beginShoppingTime; //ferdig 
    int shoppingDuration; //ferdig
    int numProducts; //ferdig
    int endShoppingTime; //ferdig
    
    int queueWaitDuration; // hvor lenge kunden venter i køen
    // (get checkout list, loop gjennom listen, få checkout 
    //duration for hver kunde og legg det til i quewaitduration )

    int checkoutTime; // hvor lenge kunden bruker på å betale

    int checkoutDuration; //hvor lenge kunden er i kassen totalt (quewait + checkouttime)


    int leaveTime; //customer.checkoutTime + customer.checkoutDuration;  

    int scanPayTime; //ferdig

    public Customer(SuperMarket shop, int i) {
        this.shop = shop;
        name = "Cust" + i;
        beginShoppingTime = i;
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        endShoppingTime = beginShoppingTime + shoppingDuration; 
    }

    // not finished
    public Checkout chooseCheckout(Customer customer) {

        Checkout checkout = customer.shop.checkouts[0];
        

        for(Checkout c : customer.shop.checkouts) {

            if (c.customers.size() == 0) {
                return c;
            }
          
            else if(c.customers.size() == checkout.customers.size())  {
                checkout = c;
            }
            else {
                System.out.println("Feil");
            }

        }

        return checkout;
    }
}
