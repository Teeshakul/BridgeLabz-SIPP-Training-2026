public class ProfitLoss {
    public static void main(String[] args) {
        int cp = 129, sp = 191;
        int profit = sp - cp;

        System.out.println("Profit = " + profit);
        System.out.println("Profit % = " + (profit * 100.0 / cp));
    }
}