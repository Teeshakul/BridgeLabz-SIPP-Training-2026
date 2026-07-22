import java.util.ArrayList;

public class GenericStack<T> {

    ArrayList<T> stack = new ArrayList<>();

    public void push(T value) {
        stack.add(value);
    }

    public T pop() {

        if (stack.isEmpty()) {
            return null;
        }

        return stack.remove(stack.size() - 1);
    }

    public T peek() {

        if (stack.isEmpty()) {
            return null;
        }

        return stack.get(stack.size() - 1);
    }

    public void display() {
        System.out.println(stack);
    }

    public static void main(String[] args) {

        GenericStack<Integer> s = new GenericStack<>();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Pop = " + s.pop());

        s.display();

        System.out.println("Peek = " + s.peek());
    }
}