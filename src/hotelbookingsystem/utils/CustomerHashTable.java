package hotelbookingsystem.utils;

import hotelbookingsystem.models.Customer;

public class CustomerHashTable {

    private HashTable<String, Customer> table;

    public CustomerHashTable(int size) {
        this.table = new HashTable<>(size);
    }

    public void put(Customer customer) {
        this.table.put(customer.getLastName(), customer);
    }

    public Customer get(String lastName) {
        return this.table.get(lastName);
    }

    public void remove(String lastName) {
        this.table.remove(lastName);
    }
}
