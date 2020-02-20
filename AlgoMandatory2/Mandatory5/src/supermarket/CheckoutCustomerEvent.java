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
    Checkout checkout;
    Customer customer;

    public CheckoutCustomerEvent(Customer customer, Checkout checkout) {
        super(EventSim.getClock());
        this.customer = customer;
        
        //legger til hvor lenge kunden var i kassen totalt
        customer.checkoutDuration = customer.queueWaitDuration + customer.scanPayTime;

        System.out.println(EventSim.getClock()+ customer.name+ " used " + customer.checkoutDuration +
         " seconds total in the checkout");

        // fjerner kunden fra listen 
        checkout.customers.remove(customer);
        System.out.println(customer.name + " has been removed from que" + checkout.customers.size());


    }


    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }

}
