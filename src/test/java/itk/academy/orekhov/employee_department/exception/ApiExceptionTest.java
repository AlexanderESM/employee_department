package itk.academy.orekhov.employee_department.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Custom API error occurred";
        ApiException exception = new ApiException(message);

        // Verify that the exception message is set correctly
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testConstructorWithoutMessage() {
        ApiException exception = new ApiException(null);

        // Verify that the exception message is null
        assertNull(exception.getMessage());
    }
}
