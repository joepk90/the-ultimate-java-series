package com.theultimatejavaseries.bestpricefinder;

public class Quote {
    private String site;
    private Integer price;

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
