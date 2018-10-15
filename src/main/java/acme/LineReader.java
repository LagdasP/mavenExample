package acme;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import acme.model.LineSegment2D;

public class LineReader
{
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    private static final ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
    
    private static final Validator validator = validationFactory.getValidator();
    
    private static final Logger logger = LoggerFactory.getLogger(LineReader.class);
    
    public static void main(String[] args) throws IOException
    {
        LineSegment2D u1 = objectMapper.readValue(System.in, LineSegment2D.class);
        logger.info("Read object from STDIN: {}", u1);
        
        Set<ConstraintViolation<LineSegment2D>> constraintViolations = validator.validate(u1);
        if (constraintViolations.isEmpty()) {
            // The object is valid
            System.out.printf("%s%n", objectMapper.writeValueAsString(u1));
        } else {
            // The object is considered invalid
            for (ConstraintViolation<LineSegment2D> violation: constraintViolations) {
                logger.error("property `{}` ({}): {}", 
                    violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage());
            }
        }
    }
}
