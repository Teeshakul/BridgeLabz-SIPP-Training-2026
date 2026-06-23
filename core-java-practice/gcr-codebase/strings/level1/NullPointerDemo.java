public class NullPointerDemo {

    static void handleException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException Handled");
        }
    }

    public static void main(String[] args) {
        handleException();
    }
}