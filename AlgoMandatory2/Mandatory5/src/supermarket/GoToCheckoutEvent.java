/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * Event for når kunden går til kassen 
 *
 * @author magne og kanta
 */
public class GoToCheckoutEvent extends Event {
    Customer customer;
    Checkout checkout;

    public GoToCheckoutEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
             
    }

    @Override
    public Event happen() {
        return new JoinQeueEvent(customer);
    }

}
