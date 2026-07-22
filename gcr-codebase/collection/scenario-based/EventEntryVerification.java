import java.util.*;

public class EventEntryVerification {
    public static void main(String[] args) {

        HashSet<String> participants = new HashSet<>();

        register(participants, "a@gmail.com");
        register(participants, "b@gmail.com");
        register(participants, "a@gmail.com");

        System.out.println("\nParticipants:");

        for (String p : participants)
            System.out.println(p);

        System.out.println("Total = " + participants.size());
    }

    static void register(HashSet<String> set, String email) {

        if (set.add(email))
            System.out.println(email + " Registered");
        else
            System.out.println(email + " Duplicate");
    }
}