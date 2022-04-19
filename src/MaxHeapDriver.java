import com.sun.jdi.InterfaceType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class MaxHeapDriver
{
    public static void main(String[] args) throws IOException {
        // Read in the sorted_data input file
        File file = new File("data_sorted.txt");
        Scanner sc = new Scanner(file);

        // Read in data from the input files
        Integer[] inputContent = new Integer[100];
        for (int i = 0; i < 100; i++)
        {
            inputContent[i] = sc.nextInt();
        }

        // Perform sequential insertions for the 100 integers
        MaxHeap<Integer> sequentialHeap = new MaxHeap<>(inputContent, true);


        // Perform optimal insertion for the 100 integers
        MaxHeap<Integer> optimalHeap = new MaxHeap<>(inputContent);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Read in the random_data input file
        File randomFile = new File("data_random.txt");
        Scanner randomScanner = new Scanner(randomFile);


        // Read in data form the input file
        Integer[] randomInputContent = new Integer[100];
        for (int i = 0; i < 100; i++)
        {
            randomInputContent[i] = randomScanner.nextInt();
        }

        // Perform sequential insertions for the 100 integers
        MaxHeap<Integer> sequentialRandomHeap = new MaxHeap<>(randomInputContent, true);

        // Perform optimal insertion for the 100 integers
        MaxHeap<Integer> optimalRandomHeap = new MaxHeap<>(randomInputContent);


        try
        {
            FileWriter fileWrite = new FileWriter("output.txt");

            // Write sequential results to file
            outputToFile(sequentialHeap, fileWrite, "sequential");

            // Create space between the results
            fileWrite.write("\n\n");

            // Write to optimal results to file
            outputToFile(optimalHeap, fileWrite, "optimal");

            // Create space between the results
            fileWrite.write("\n\n");

            // Write sequential results to file
            outputToFile(sequentialRandomHeap, fileWrite, "sequential");

            // Create space between the results
            fileWrite.write("\n\n");

            // Write optimal results to file
            outputToFile(optimalRandomHeap, fileWrite, "optimal");

            fileWrite.close();
        } catch (IOException e)
        {
            System.out.println("An error has occurred. ");
            e.printStackTrace();
        }

    }

    private static void outputToFile(MaxHeap<Integer> insertedHeap, FileWriter fileWrite, String method) throws IOException
    {
        // Create array from heap
        Comparable[] heapArray = insertedHeap.getHeap();

        // Output the first 10 integers of the array to the output file
        fileWrite.write("Heap built using " + method + " insertions: ");
        for (int i = 1; i <= 10; i++)
        {
            fileWrite.write( (Integer) heapArray[i] + ",");
        }
        fileWrite.write("...");

        // Output the number of swaps performed into the output file
        fileWrite.write("\n");
        fileWrite.write("Number of swaps in the heap creation: ");

        fileWrite.write(String.valueOf(insertedHeap.getNumSwaps()));

        // Perform 10 removals on the heap
        for (int i = 0; i < 10; i++)
        {
            insertedHeap.removeMax();
        }

        // Output the first 10 integers of the resulting array
        fileWrite.write("\n");
        fileWrite.write("Heap after 10 removals: ");
        Comparable[] heapArrayAfterRemoval = insertedHeap.getHeap();
        for (int i = 1; i <= 10; i++)
        {
            fileWrite.write((Integer) heapArrayAfterRemoval[i] + ",");
        }
        fileWrite.write("...");
    }
}
