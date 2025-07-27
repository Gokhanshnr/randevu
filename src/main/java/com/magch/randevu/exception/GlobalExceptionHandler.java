package com.magch.randevu.exception;

import com.magch.randevu.domain.models.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.net.URI;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        //ExceptionLogger.logException(ex, true);
        ErrorResponse errorResponse = new ErrorResponse("Bir hata oluştu message: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Object> handleGlobalException(NoResourceFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Resource not found", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BaseResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return ResponseEntity.ok().body(BaseResponse.fault(ex.getMessage()));
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneralException(GeneralException generalException) {
        if (!generalException.isSuccess())
            return ResponseEntity.ok(BaseResponse.fault(generalException.getErrorCode(), generalException.getMessage()));

        return ResponseEntity.ok(BaseResponse.ok(generalException.getErrorCode(), generalException.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BaseResponse<Object>> handleUserNotFoundException(UserNotFoundException generalException) {
        return ResponseEntity
                .ok()
                .body(BaseResponse.fault("403", (generalException.getMessage() != null) ? generalException.getMessage() : "User not found"));
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneralException(AuthorizationDeniedException authorizationDeniedException) {
        return ResponseEntity
                .ok()
                .body(BaseResponse.fault("403", (authorizationDeniedException.getMessage() != null) ? authorizationDeniedException.getMessage() : "User not found"));
    }


    @ExceptionHandler(AttemptLimitExceededException.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneralException(AttemptLimitExceededException generalException) {
        return ResponseEntity.ok(BaseResponse.fault(null, (generalException.getMessage())));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneralException(AccessDeniedException generalException) {
        return ResponseEntity.ok(BaseResponse.fault(null, (generalException.getMessage())));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneralException(NullPointerException generalException) {
        return ResponseEntity.ok(BaseResponse.fault(null, (generalException.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Object>> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return ResponseEntity.ok(BaseResponse.fault(null, message));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<BaseResponse<Object>> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String message = String.format("Geçersiz parametre '%s' için beklenen tip: %s",
                ex.getName(), ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "unknown");
        return ResponseEntity.ok(BaseResponse.fault(null, message));
    }


}
