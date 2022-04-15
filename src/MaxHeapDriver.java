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
        // Read in input file
        File file = new File("dat_sorted.txt");
        Scanner sc = new Scanner(file);

        // Read in data from the input files
        Integer[] inputConetent = new Integer[100];
        for (int i = 0; i < 100; i++)
        {
            inputConetent[i] = sc.nextInt();
        }

        // Perform sequential insertions for the 100 integers
        MaxHeap<Integer> sequentialHeap = new MaxHeap<>(inputConetent, true);


        // Perform optimal insertion for the 100 integers
        MaxHeap<Integer> optimalHeap = new MaxHeap<>(inputConetent);


        try
        {
            FileWriter fileWrite = new FileWriter("output.txt");

            // Write sequential results to file 
        } catch (IOException e)
        {
            System.out.println("An error has occurred. ");
            e.printStackTrace();
        }
    }

    private void outputToFile()
    {

    }
}
