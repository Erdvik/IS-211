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
public class GoToCheckoutEvent extends Event {
    Customer customer;
    Checkout checkout;

    public GoToCheckoutEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
        checkout = customer.chooseCheckout(customer);
		System.out.println(customer.name + " has " + customer.numProducts 
        + " products in the cart and has used " + customer.shoppingDuration 
        + " minutes before going to " + checkout.name); 
    }


    @Override
    public Event happen() {
        return new JoinQeueEvent(customer, checkout);
    }

}
