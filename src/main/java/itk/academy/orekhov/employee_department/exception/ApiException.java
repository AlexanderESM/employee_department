package itk.academy.orekhov.employee_department.exception;

/**
 * Custom exception for application errors.
 */
public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
