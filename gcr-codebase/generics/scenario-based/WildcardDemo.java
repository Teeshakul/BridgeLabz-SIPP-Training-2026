import java.util.*;

public class WildcardDemo {

    public static void printList(List<?> list) {

        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30);

        List<String> names = Arrays.asList("Rahul", "Aman", "Teesha");

        System.out.println("Numbers:");
        printList(numbers);

        System.out.println("Names:");
        printList(names);

        Repository<String> repo = new Repository<>();

        repo.add("Java");
        repo.add("Python");

        System.out.println("Repository:");
        repo.display();
    }
}