/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

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
    public static final int MAX_PRODUCTS = 50;
    public static final int MIN_PRODUCTS = 0;

    // customer will spend ranom amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 100;
    public static final int MIN_SHOP_TIME = 1;

    SuperMarket shop;
    String name;

    int beginShoppingTime; //har
    int shoppingDuration; //har
    int numProducts; //har
    int endShoppingTime; //har
    int queueWaitDuration; // ikke
    int checkoutTime; // ikke
    int checkoutDuration; //har
    int leaveTime; //har

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
        return customer.shop.checkouts[0];
    }
}
