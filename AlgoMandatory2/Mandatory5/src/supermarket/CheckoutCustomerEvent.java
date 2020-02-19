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
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;

        //regner ut hvor lang tid kunden bruker på å skanne og betale og legger det til i chekoutTime.
        customer.checkoutTime = checkout.calcScanPay(customer);
        System.out.println("CheckoutTime: " + customer.checkoutTime + "Name: " + customer.name);

        // regner ut que time
        customer.queueWaitDuration = checkout.calcQue(checkout.customers, customer);
    

        // fjerner kunden fra listen 
        checkout.customers.remove(customer);
        System.out.println(customer.name + " has been removed from que" + checkout.customers.size());


    }


    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }

}
