import java.util.ArrayList;

public class Repository<T> {

    ArrayList<T> list = new ArrayList<>();

    public void add(T obj) {
        list.add(obj);
    }

    public void display() {

        for (T obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {

        Repository<String> repo = new Repository<>();

        repo.add("Java");
        repo.add("Python");
        repo.add("C++");

        repo.display();
    }
}