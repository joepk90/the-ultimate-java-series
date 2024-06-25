public class TextBox extends UIControl {

    public TextBox() {
        super(true); // super must be called as the first statement at the top of the contructor
        System.out.println("TextBox");
    }

    private String text = "";

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
