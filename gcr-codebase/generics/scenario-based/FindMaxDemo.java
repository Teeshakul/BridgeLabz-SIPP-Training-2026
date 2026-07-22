public class FindMaxDemo {

    public static <T extends Comparable<T>> T findMax(T[] arr) {

        T max = arr[0];

        for (T element : arr) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Integer[] numbers = {10, 40, 25, 60, 15};

        System.out.println("Maximum = " + findMax(numbers));

        String[] names = {"Aman", "Rahul", "Teesha"};

        System.out.println("Maximum = " + findMax(names));
    }
}