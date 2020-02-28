
package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * når kunden er ferdig og forlater butikken
 *
 * @author magne og kanta
 */
public class EndShoppingEvent extends Event {
    Customer customer;

    public EndShoppingEvent(Customer customer) {
        super(EventSim.getClock() + customer.checkoutDuration);
        this.customer = customer;

        //fjerner kunden fra butikken
        customer.shop.customers.remove(customer);

        //regner ut når kunden forlater butikken 
        customer.leaveTime = customer.beginShoppingTime + customer.shoppingDuration + customer.checkoutDuration;
        

        System.out.println(customer.name + " leaved the store at time: " + customer.leaveTime);
    }


    @Override
    public Event happen() {
        return null;    
    }


    @Override
    public String toString() {
        return "EndShoppingEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.shoppingDuration + '}';
    }

}
