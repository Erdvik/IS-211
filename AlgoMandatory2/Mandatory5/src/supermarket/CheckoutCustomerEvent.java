package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * Når en kunde blir behandlet i kassen
 * 
 * @author magne og kanta
 */
public class CheckoutCustomerEvent extends Event {
    Checkout checkout;
    Customer customer;

    public CheckoutCustomerEvent(Customer customer, Checkout checkout) {
        super(EventSim.getClock());
        this.customer = customer;
        
        //legger til hvor lenge kunden var i kassen totalt
        customer.checkoutDuration = customer.queueWaitDuration + customer.scanPayTime;

        System.out.println(customer.name+ " used " + customer.checkoutDuration +
         " seconds total in the checkout");

        // fjerner kunden fra kasse-køen 
        checkout.customers.remove(customer);
        System.out.println(customer.name + " has been removed from que" + checkout.customers.size());


    }


    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }

}
