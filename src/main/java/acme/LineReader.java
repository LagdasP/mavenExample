package acme;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import acme.model.LineSegment2D;

public class LineReader
{
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    private static final Logger logger = LoggerFactory.getLogger(LineReader.class);
    
    public static void main(String[] args) throws IOException
    {
        LineSegment2D u1 = objectMapper.readValue(System.in, LineSegment2D.class);
        
        logger.info("Read object from STDIN: {}", u1);
        
        String s1 = objectMapper.writeValueAsString(u1);
        
        System.out.printf("%s%n", s1);
    }
}
