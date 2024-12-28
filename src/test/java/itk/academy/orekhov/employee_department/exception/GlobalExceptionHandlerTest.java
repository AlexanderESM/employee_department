package itk.academy.orekhov.employee_department.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

/**
 * Test class for GlobalExceptionHandler.
 */
class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void testHandleApiException() {
        // Arrange
        String errorMessage = "API exception occurred";
        ApiException apiException = new ApiException(errorMessage);

        // Act
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleApiException(apiException);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        ErrorResponse errorResponse = response.getBody();
        assertNotNull(errorResponse);
        assertEquals(HttpStatus.BAD_REQUEST.value(), errorResponse.getStatus());
        assertEquals(errorMessage, errorResponse.getMessage());
        assertNotNull(errorResponse.getTimestamp());
    }

    @Test
    void testHandleNullPointerException() {
        // Arrange
        NullPointerException nullPointerException = new NullPointerException();

        // Act
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleNullPointerException(nullPointerException);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        ErrorResponse errorResponse = response.getBody();
        assertNotNull(errorResponse);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorResponse.getStatus());
        assertEquals("Null pointer exception occurred", errorResponse.getMessage());
        assertNotNull(errorResponse.getTimestamp());
    }
}
