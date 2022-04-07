import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world ");

        // Read in input file
        File file = new File("C:\\Users\\perez\\Desktop\\CS 2400\\Project-4\\data_random.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext())
        {
            System.out.println(sc.nextLine());
        }

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
