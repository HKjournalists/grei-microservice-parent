package data.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 *
 * 刘佳兴
 */
@ControllerAdvice
public class ExceptionAdvice {
	private static final String SEPARATOR = "-";
	private Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

	@Autowired
	MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
	ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		logger.debug("MethodArgumentNotValidException: ", e);
		String msg = messageSource.getMessage("request.data.field.valid", null, LocaleContextHolder.getLocale());
		Assert.notNull(msg);
		return new ResponseEntity<>(new ErrorResponse(Integer.valueOf(msg.split(SEPARATOR)[0]), msg.split(SEPARATOR)[1]), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(APIException.class)
	@ResponseBody
	ResponseEntity<ErrorResponse> apiException(APIException e) {
		logger.debug("APIException: ", e);
		String msg = messageSource.getMessage(e.getMessage(), e.getArguments(), LocaleContextHolder.getLocale());
		Assert.notNull(msg);
		return new ResponseEntity<>(new ErrorResponse(Integer.valueOf(msg.split(SEPARATOR)[0]), msg.split(SEPARATOR)[1]), HttpStatus.BAD_REQUEST);
	}

}
