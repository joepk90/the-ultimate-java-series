public final class CheckBox extends UIControl {
    @Override
    public void render() {
       System.out.println("Render CheckBox");
    }

    // not possible because the enable method has been set to final
    // @Override
    // public void enable() {
    //     isEnabled = true;
    // }
}


// not possible because checkbox has been declared as final
// public class NewCheckBox extends Checkbox {}