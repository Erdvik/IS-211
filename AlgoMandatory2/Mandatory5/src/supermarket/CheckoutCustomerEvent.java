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
public class CheckoutCustomerEvent extends Event {
    Customer customer;

    public CheckoutCustomerEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }

}
