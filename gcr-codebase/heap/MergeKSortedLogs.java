import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedLogs {

    static class Entry {

        int value;
        int listIndex;
        int elementIndex;

        Entry(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    static List<Integer> merge(List<List<Integer>> lists) {

        PriorityQueue<Entry> minHeap =
                new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i = 0; i < lists.size(); i++) {

            if (!lists.get(i).isEmpty()) {

                minHeap.offer(new Entry(
                        lists.get(i).get(0),
                        i,
                        0));
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {

            Entry current = minHeap.poll();

            result.add(current.value);

            int nextIndex = current.elementIndex + 1;

            if (nextIndex < lists.get(current.listIndex).size()) {

                minHeap.offer(new Entry(
                        lists.get(current.listIndex).get(nextIndex),
                        current.listIndex,
                        nextIndex));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sorted lists: ");
        int k = sc.nextInt();

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < k; i++) {

            System.out.print("Enter size of list " + (i + 1) + ": ");
            int size = sc.nextInt();

            List<Integer> list = new ArrayList<>();

            System.out.println("Enter sorted elements:");

            for (int j = 0; j < size; j++)
                list.add(sc.nextInt());

            lists.add(list);
        }

        List<Integer> merged = merge(lists);

        System.out.println("Merged Sorted List:");

        System.out.println(merged);
    }
}