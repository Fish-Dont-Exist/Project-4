import com.sun.jdi.InterfaceType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class MaxHeapDriver
{
    public static void main(String[] args) throws FileNotFoundException {
        // Read in input file
        File file = new File("C:\\Users\\perez\\Desktop\\CS 2400\\Project-4\\data_random.txt");
        Scanner sc = new Scanner(file);

        // Initialize array of data points
        Integer[] contents = {1, 2, 3, 4, 5, 6, 7};

        // Create instance of MaxHeap
        MaxHeap<Integer> heap1 = new MaxHeap<>();

        heap1.sequentialInsertion(contents);

        System.out.println(heap1.getSize());

        // Let's try with the optimal method
        MaxHeap<Integer> heap2 = new MaxHeap<>(contents);

        System.out.println(heap2);

    }

    public static String sequentialInsertions()
    {
        // Implement the remove method of a max-heap
        return null;
    }

    public static String optimalMethod()
    {
        // Implement the remove method of a max-heap
        return null;
    }
}
