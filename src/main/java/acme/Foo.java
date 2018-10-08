package acme;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import acme.model.Point2D;

public class Foo
{
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) throws IOException
    {
        Point2D p1 = objectMapper.readValue(System.in, Point2D.class);
        
        logger.info("Read object from STDIN: {}", p1);
        
        String s1 = objectMapper.writeValueAsString(p1);
        
        System.out.printf("%s%n", s1);
    }
}
