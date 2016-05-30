package data.exception;

import lombok.Data;

/**
 * @author 刘佳兴
 */
@Data
public class ErrorResponse {

    //返回码， 0表示成功，其他表示错误
    private Integer result;

    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer result, String message) {
        this.result = result;
        this.message = message;
    }
}
