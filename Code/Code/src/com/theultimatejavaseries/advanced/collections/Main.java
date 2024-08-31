package com.theultimatejavaseries.advanced.collections;

import com.theultimatejavaseries.advanced.generics.GenericList;

public class Main {
    public static void main(String[] args) {
        theNeedForIterables();
    }

    public static void theNeedForIterables() {
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");

        // unable to iterate over the list without exposing the items property on the
        // GenericList class
        // for (var item : list.items)
        // System.out.println(item);
    }
}
