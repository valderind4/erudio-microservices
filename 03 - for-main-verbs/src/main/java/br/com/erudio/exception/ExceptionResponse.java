package br.com.erudio.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = -6298672019176170456L;

    private Date timestamp;
    private String message;
    private String details;

}
