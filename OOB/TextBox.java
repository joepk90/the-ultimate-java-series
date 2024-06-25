public class TextBox extends UIControl {

    public TextBox() {
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
