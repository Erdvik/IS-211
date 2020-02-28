package supermarket;

import eventsim.Event;


/**
 * A customer enters the shop and starts buying stuff
 *
 * @author magne og kanta
 */
public class BeginShoppingEvent extends Event {
    Customer customer;

    //shopping event 
    public BeginShoppingEvent(Customer customer) {
        super(customer.beginShoppingTime); //shoping time starter for kunden
        this.customer = customer;
        System.out.println(customer.name + " has entered store " + customer.shop.name + " at " + customer.beginShoppingTime);
    }


    @Override
    public Event happen() { 
        //om kunden ikke har produkter, så avslutter shopping eventet
        if (customer.numProducts == 0) {
            return new EndShoppingEvent(customer);
        }
        else {
            return new GoToCheckoutEvent(customer); //om kunden har plukket produkter, går til kassen
            }
    }
}
