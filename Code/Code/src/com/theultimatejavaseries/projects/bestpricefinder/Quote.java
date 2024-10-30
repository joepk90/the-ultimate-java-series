package com.theultimatejavaseries.projects.bestpricefinder;

public class Quote {
    private final String site;
    private final int price;

    public Quote(String site, Integer price) {
        this.site = site;
        this.price = price;
    }

    public String getSite() {
        return site;
    }

    public Integer getPrice() {
        return price;
    }

    public String toString() {
        return "Quote{site='" + getSite() + "', price=" + getPrice() + "}";
    }
}
