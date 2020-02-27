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

    public JoinQeueEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
        this.checkout = customer.chooseCheckout(customer);

		System.out.println(customer.name + " has " + customer.numProducts 
        + " products in the cart and has used " + customer.shoppingDuration 
        + " seconds before going to " + checkout.name); 

        checkout.customers.add(customer);

        //regner ut hvor lang tid kunden kommer til å bruke på å skanne og betale og legger det til i chekoutTime.
        customer.scanPayTime = checkout.calcScanPay(customer); 

        //regner ut tiden i kø
        customer.queueWaitDuration = checkout.calcQue(checkout.customers, customer);

        System.out.println(checkout.name + " had a queue of " + (checkout.customers.size()-1) + ", therefore " +
        customer.name + " had to wait " + customer.queueWaitDuration + " seconds ");

    }


    @Override
    public Event happen() {
        return new CheckoutCustomerEvent(customer, checkout);
    }

}
