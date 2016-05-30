package data.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author 刘佳兴
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class APIException extends RuntimeException {

    private String[] arguments;

    public APIException(String message) {
        super(message);
    }

    public APIException(String message, String[] arguments) {
        super(message);
        this.arguments = arguments;
    }

}
