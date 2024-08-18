package com.theultimatejavaseries.oop;
public class TextBox extends UIControl {
    private String text = "";
    
    public TextBox() {
        super(true); // super must be called as the first statement at the top of the contructor
        // this.isEnabled // inherited fields (private members) are not accessible in sub classes
        System.out.println("TextBox");
    }

    @Override
    public void render() {
       System.out.println("Render TextBox");
    }

    @Override
    public String toString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void clearText() {
        text = "";
    }

    
}
