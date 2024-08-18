package com.theultimatejavaseries.oop;
public abstract class UIControl {
    
    /**
     * Protected Access Modifiers
     * - protected makes the field public, but only within the same package (package com.ultimatejavaseries;)
     * - declaring a field or method as protected, makes it acceissble to
     * instances of the UIControl object within this package
     * - the protected access modifier is considered bad practice
     */

    // protected boolean isEnabled = true;

    private boolean isEnabled = true;

    public UIControl(boolean isEnabled) {
        this.isEnabled = isEnabled;
        System.out.println("UIControl");
    }

    // rather than commenting out, method overloading has been used
    public UIControl() {
        this.isEnabled = false;
        System.out.println("UIControl");
    }

    public abstract void render();

    public final void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
