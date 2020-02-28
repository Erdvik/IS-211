
package supermarket;

import eventsim.EventSim;

/**
 * Klassen for kunder
 * 
 * @author magne og kanta
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

    int beginShoppingTime;  //når kunden starter å handle
    int shoppingDuration; //hvor lenge kunden bruker til å plukke produkter 
    int numProducts; //antall produkter plukket
    int endShoppingTime; //når kunden er ferdig å plukke varer
    int queueWaitDuration; // hvor lenge kunden venter i køen
    int checkoutDuration; //hvor lenge kunden er i kassen totalt (quewait + checkouttime)
    int leaveTime; //customer.checkoutTime + customer.checkoutDuration;  
    int scanPayTime; //hvor lenge kunden bruker på å scanne varer og betale

    public Customer(SuperMarket shop, int i) {
        this.shop = shop;
        name = "Cust" + i;
        beginShoppingTime = i;
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        endShoppingTime = beginShoppingTime + shoppingDuration; 
    }

    //velger kassen med færrest kunder i køen
    public Checkout chooseCheckout(Customer customer) {

        Checkout checkout = customer.shop.checkouts[0];
        

        for(Checkout c : customer.shop.checkouts) {

            if (c.customers.size() == 0) {
                return c;
            }
          
            else if(c.customers.size() < checkout.customers.size())  {
                checkout = c;
            }
            else {
                System.out.println(c.name + " has a que of " + c.customers.size() + ". " + customer.name + " goes to the next checkout");
            }

        }
        return checkout;
    }
}
