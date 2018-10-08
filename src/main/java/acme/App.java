package acme;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Date d = new java.util.Date();  
        System.err.println("Hello World (at " + d.toString() + ")!");
        
        for (String path: Arrays.asList("/samples/1.csv")) {
            System.err.printf(" -- Contents of classpath:%s -- %n", path);
            try (Scanner in = new Scanner(App.class.getResourceAsStream(path))) {
                while (in.hasNextLine())
                    System.err.println(in.nextLine());
            }
        }
    }
}
