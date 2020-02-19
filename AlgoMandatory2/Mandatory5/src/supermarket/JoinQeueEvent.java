/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * 
 *
 * @author evenal
 */
public class JoinQeueEvent extends Event {
    Customer customer;
    Checkout checkout;

    public JoinQeueEvent(Customer customer, Checkout checkout) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
        // System.out.println(checkout.name + " had a queue of " + checkout.customers.length + ", therefore " +
        // customer.name + " had to wait " + customer.checkoutDuration + " " +  customer.checkoutTime + " "
        // + customer.queueWaitDuration);

    }


    @Override
    public Event happen() {
        return new CheckoutCustomerEvent(customer);
    }

}
