package com.theultimatejavaseries.oop;

public class Browser {
    public void navigate(String address) {
        String ip = findIpAddress(address);
        String html = sentHttpRequest(ip);
        System.out.println(html);
    }

    private String findIpAddress(String address) {
        return "127.0.0.1";
    }

    private String sentHttpRequest(String address) {
        return "<html></html>";
    }
}
