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
public class EndShoppingEvent extends Event {
    Customer customer;


    public EndShoppingEvent(Customer customer) {
        super(EventSim.getClock() + customer.checkoutDuration);
        this.customer = customer;

        //fjerner kunden fra butikken
        customer.shop.customers.remove(customer);

        //customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        customer.leaveTime = EventSim.getClock();

        System.out.println(EventSim.getClock()+ customer.name + " leaved the store at time: " + customer.leaveTime);
    }


    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return null;
        
    }


    @Override
    public String toString() {
        return "EndShoppingEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.shoppingDuration + '}';
    }

}
