package acme;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import acme.model.Point2D;

public class PointReader
{
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    private static final ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
    
    private static final Validator validator = validationFactory.getValidator();
    
    private static final Logger logger = LoggerFactory.getLogger(PointReader.class);
    
    public static void main(String[] args) throws IOException
    {
        Point2D p1 = objectMapper.readValue(System.in, Point2D.class);
        logger.info("Read object from STDIN: {}", p1);
        
        Set<ConstraintViolation<Point2D>> constraintViolations = validator.validate(p1);
        if (constraintViolations.isEmpty()) {
            // The object is valid
            System.out.printf("%s%n", objectMapper.writeValueAsString(p1));
        } else {
            // The object is considered invalid
            for (ConstraintViolation<Point2D> violation: constraintViolations) {
                logger.error("property `{}` ({}): {}", 
                    violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage());
            }
        }
        
    }
}
