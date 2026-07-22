public class PasswordStrengthChecker {

    static void checkPassword(String password){

        try{

            if(password==null)
                throw new NullPointerException();

            if(password.isEmpty()){
                System.out.println("Password cannot be empty");
                return;
            }

            if(password.length()<8){
                System.out.println("Password too short");
                return;
            }

            if(!Character.isUpperCase(password.charAt(0))){
                System.out.println("First character must be uppercase");
                return;
            }

            if(!Character.isDigit(password.charAt(password.length()-1))){
                System.out.println("Last character must be digit");
                return;
            }

            if(!(password.contains("@")||password.contains("#")
                    ||password.contains("$")||password.contains("%")
                    ||password.contains("&")||password.contains("*"))){

                System.out.println("Special character required");
                return;
            }

            System.out.println("Strong Password");

        }
        catch(NullPointerException e){
            System.out.println("Password cannot be null");
        }
    }

    public static void main(String[] args){

        checkPassword("Java@123");
    }
}