/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.utils;
import hotelbookingsystem.models.Customer;
/**
 *
 * @author Escal
 */
public class CustomerHashTable extends HashTable<String, Customer> {

    public CustomerHashTable(int size) {
        super(size);
    }

    public void put(Customer customer) {
        super.put(customer.getLastName(), customer);
    }

    public Customer get(String lastName) {
        return super.get(lastName);
    }

    public void remove(String lastName) {
        super.remove(lastName);
    }
}

