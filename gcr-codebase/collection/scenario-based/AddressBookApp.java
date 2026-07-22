import java.util.*;

class Contact {
    String name, phone, email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

public class AddressBookApp {
    public static void main(String[] args) {

        ArrayList<Contact> contacts = new ArrayList<>();
        HashMap<String, Contact> map = new HashMap<>();
        HashSet<String> phones = new HashSet<>();

        addContact(contacts, map, phones, "Rahul", "9876543210", "rahul@gmail.com");
        addContact(contacts, map, phones, "Aman", "9999999999", "aman@gmail.com");
        addContact(contacts, map, phones, "Rahul2", "9876543210", "r2@gmail.com");

        System.out.println("\nSearch Rahul:");
        System.out.println(map.get("Rahul").email);

        deleteContact(contacts, map, phones, "Aman");

        Collections.sort(contacts, (a, b) -> a.name.compareTo(b.name));

        System.out.println("\nContacts:");
        for (Contact c : contacts)
            System.out.println(c.name + " " + c.phone + " " + c.email);
    }

    static void addContact(ArrayList<Contact> list, HashMap<String, Contact> map,
                           HashSet<String> phones, String name, String phone, String email) {

        if (phones.add(phone)) {
            Contact c = new Contact(name, phone, email);
            list.add(c);
            map.put(name, c);
        } else
            System.out.println("Duplicate Phone Number");
    }

    static void deleteContact(ArrayList<Contact> list,
                              HashMap<String, Contact> map,
                              HashSet<String> phones,
                              String name) {

        Contact c = map.remove(name);

        if (c != null) {
            list.remove(c);
            phones.remove(c.phone);
        }
    }
}