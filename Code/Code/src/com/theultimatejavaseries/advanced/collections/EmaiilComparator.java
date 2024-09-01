package com.theultimatejavaseries.advanced.collections;

import java.util.Comparator;

public class EmaiilComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }

}
