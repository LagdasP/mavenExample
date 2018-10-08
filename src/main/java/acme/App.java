package acme;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    
    public static void main( String[] args ) throws IOException
    {
        Date d = new java.util.Date();  
        logger.info("Hello World (at {})", d.toString());
        
        for (String path: Arrays.asList("/samples/1.csv")) {
            System.err.printf(" -- Contents of classpath:%s -- %n", path);
            try (Scanner in = new Scanner(App.class.getResourceAsStream(path))) {
                while (in.hasNextLine())
                    System.err.println(in.nextLine());
            }
            System.err.println(" -- ");
        }
    }
}
