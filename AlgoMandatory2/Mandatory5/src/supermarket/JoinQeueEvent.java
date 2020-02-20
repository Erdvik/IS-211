/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;

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
        this.checkout = checkout;

        checkout.customers.add(customer);

        //regner ut tiden i kø
        customer.queueWaitDuration = checkout.calcQue(checkout.customers, customer);

        System.out.println(EventSim.getClock()+ checkout.name + " had a queue of " + checkout.customers.size() + ", therefore " +
        customer.name + " had to wait " + customer.queueWaitDuration + " seconds ");

    }


    @Override
    public Event happen() {
        return new CheckoutCustomerEvent(customer, checkout);
    }

}
