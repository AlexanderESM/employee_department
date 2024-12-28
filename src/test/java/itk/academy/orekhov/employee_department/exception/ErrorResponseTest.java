package itk.academy.orekhov.employee_department.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class ErrorResponseTest {

    @Test
    public void testConstructorAndGetters() {
        LocalDateTime timestamp = LocalDateTime.now();
        ErrorResponse errorResponse = new ErrorResponse(404, "Not Found", timestamp);

        assertEquals(404, errorResponse.getStatus());
        assertEquals("Not Found", errorResponse.getMessage());
        assertEquals(timestamp, errorResponse.getTimestamp());
    }

    @Test
    public void testSetters() {
        LocalDateTime timestamp = LocalDateTime.now().plusHours(1);
        ErrorResponse errorResponse = new ErrorResponse(500, "Internal Server Error", timestamp);

        errorResponse.setStatus(400);
        errorResponse.setMessage("Bad Request");
        errorResponse.setTimestamp(LocalDateTime.now());

        assertEquals(400, errorResponse.getStatus());
        assertEquals("Bad Request", errorResponse.getMessage());
        assertNotEquals(timestamp, errorResponse.getTimestamp());
    }
}
