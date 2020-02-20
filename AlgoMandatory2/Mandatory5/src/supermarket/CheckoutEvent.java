package supermarket;

import eventsim.Event;
import eventsim.EventSim;


public class CheckoutEvent extends Event {
    Customer customer;
    Checkout checkout;

    public CheckoutEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
        this.checkout = customer.chooseCheckout(customer);
  
        System.out.println(customer.name + " has " + customer.numProducts 
        + " products in the cart and has used " + customer.shoppingDuration 
        + " minutes before going to " + checkout.name); 

        checkout.customers.add(customer);

        System.out.println(". It had a que of " + checkout.customers.size() + " people.");

        //checkout.calcQue(checkout.customers, customer);

        //System.out.println(customer.name + " had to wait " + checkoutQueTime(customer) + " minutes"); 


        // //regner ut hvor lang tid kunden bruker på å skanne og betale og legger det til i chekoutTime.
        // customer.checkoutTime = checkout.calcScanPay(customer);
        // System.out.println("CheckoutTime: " + customer.checkoutTime + "Name: " + customer.name);

        // // regner ut que time
        // customer.queueWaitDuration = checkout.calcQue(checkout.customers, customer);
    

        // // fjerner kunden fra listen 
        // checkout.customers.remove(customer);
        // System.out.println(customer.name + " has been removed from que" + checkout.customers.size());
    }


    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }

}