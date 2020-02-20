/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * A customer enters the shop and starts buying stuff maybe
 *
 * @author evenal
 */
public class BeginShoppingEvent extends Event {
    Customer customer;


    public BeginShoppingEvent(Customer customer) {
        super(customer.beginShoppingTime);
        this.customer = customer;
        System.out.println(EventSim.getClock() + customer.name + " has entered store " + customer.shop.name + " at " + EventSim.getClock());
    }


    @Override
    public Event happen() { 
        if (customer.numProducts == 0) {
            return new EndShoppingEvent(customer);
        }
        else {
            return new GoToCheckoutEvent(customer);
            }
    }
}
