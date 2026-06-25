interface LuggageScanner {

    void scanLuggage();

    default void displaySecurityGuidelines() {
        System.out.println("Keep luggage ready for scanning.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo.length() == 8;
    }
}

interface PassportVerifier {

    void verifyPassport();

    default void displaySecurityGuidelines() {
        System.out.println("Carry a valid passport.");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    public void scanLuggage() {
        System.out.println("Luggage Scanned");
    }

    public void verifyPassport() {
        System.out.println("Passport Verified");
    }

    @Override
    public void displaySecurityGuidelines() {
        System.out.println("Follow Airport Security Rules.");
    }
}

public class AirportSecuritySystemDemo {
    public static void main(String[] args) {

        String[] names = {"Rahul", "Aman", "Priya"};
        String[] passports = {"AB123456", "1234", "XY987654"};

        AirportSecuritySystem a = new AirportSecuritySystem();

        a.displaySecurityGuidelines();

        for (int i = 0; i < names.length; i++) {
            System.out.println("\nPassenger: " + names[i]);

            if (LuggageScanner.isPassportNumberValid(passports[i])) {
                a.scanLuggage();
                a.verifyPassport();
                System.out.println("Allowed to Board");
            } else {
                System.out.println("Boarding Denied");
            }
        }
    }
}