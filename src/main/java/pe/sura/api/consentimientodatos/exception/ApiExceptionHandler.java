package pe.sura.api.consentimientodatos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pe.sura.api.consentimientodatos.util.ApiError;
import pe.sura.api.consentimientodatos.util.Constantes;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleValidationError(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		FieldError fieldError = bindingResult.getFieldError();
		String objectName = fieldError.getObjectName();
		String fieldName = fieldError.getField();
		String message = fieldError.getDefaultMessage();
		if(Constantes.CONSENTIMIENTO.equals(objectName)) {
			if(Constantes.CONS_ID_EMPRESA.equals(fieldName)) {
				message = Constantes.CONS_IDEMPRESA_ERROR_MSG;
			} else if(Constantes.CONS_ID_CANAL.equals(fieldName)) {
				message = Constantes.CONS_IDCANAL_ERROR_MSG;
			} else if(Constantes.CONS_ID_TIPO_DOCUMENTO.equals(fieldName)) {
				message = Constantes.CONS_IDTIPODOCUMENTO_ERROR_MSG;
			} else if(Constantes.CONS_ESTADO.equals(fieldName)) {
				message = Constantes.CONS_ESTADO_ERROR_MSG;
			}
		}
		return new ApiError(fieldError.getCode(), message);
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Constantes.NOT_FOUND_MESSAGE)
	public static class NotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = Constantes.INTERNAL_SERVER_MESSAGE)
	public static class InternalServerException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}
