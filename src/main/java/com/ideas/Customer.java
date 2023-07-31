package com.ideas;

import com.ideas.enums.CustomerType;

public class Customer {
    private final CustomerType customerType;

    public Customer(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }
}
