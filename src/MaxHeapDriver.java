import com.sun.jdi.InterfaceType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class MaxHeapDriver
{
    public static void main(String[] args) throws IOException {
        // Read in input file
        File file = new File("C:\\Users\\perez\\Desktop\\CS 2400\\Project-4\\data_random.txt");
        Scanner sc = new Scanner(file);

        // Test the two methods of creating heaps
        // Initialize array of data points
        Integer[] contents = {1, 2, 3, 4, 5, 6, 7};

        // Create instance of MaxHeap
        MaxHeap<Integer> heap1 = new MaxHeap<>();

        heap1.sequentialInsertion(contents);

        System.out.println(heap1.getNumSwaps());

        // Let's try with the optimal method
        MaxHeap<Integer> heap2 = new MaxHeap<>(contents);

        System.out.println(heap2.getNumSwaps());


        // Perform sequential insertions for the 100 integers
        // Insert all 100 characters into an array
        int[] inputContent = new int[100];

        while (sc.hasNextLine())
        {
            for (int i = 0; i < inputContent.length; i++)
            inputContent[i] = Integer.parseInt(sc.nextLine());
        }

        




        // Write to file
        try
        {
            FileWriter fileWrite = new FileWriter("output.txt");

            while (sc.hasNext())
            {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e)
        {
            System.out.println("An error has occurred. ");
            e.printStackTrace();
        }
    }
}
