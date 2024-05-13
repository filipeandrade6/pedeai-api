package org.jfm.util;

import org.jfm.controller.rest.dto.ClienteDto;
import org.jfm.exception.ErrorDetails;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class ValidatorUtil {

    public static void validateNotNull(Object param, String paramName) {
        if (param == null) {
            Response response = Response.status(Response.Status.BAD_REQUEST)
                                .entity(new ErrorDetails(paramName + " não pode ser nulo"))
                                .build();
            throw new WebApplicationException(response);
        }
    }

    public static void validateNotBlank(String param, String paramName) {
        if (param == null || param.trim().isEmpty()) {
            Response response = Response.status(Response.Status.BAD_REQUEST)
                                .entity(new ErrorDetails(paramName + " não pode ser vazio"))
                                .build();
            throw new WebApplicationException(response);
        }
    }

    public static void validateClienteDto(ClienteDto clienteDto) {
        if (clienteDto == null) {
            Response response = Response.status(Response.Status.BAD_REQUEST)
                                .entity(new ErrorDetails("Dados do cliente inválido"))
                                .build();
            throw new WebApplicationException(response);
        }

        if (clienteDto.nome() == null || clienteDto.nome().trim().isEmpty()) {
            Response response = Response.status(Response.Status.BAD_REQUEST)
                                .entity(new ErrorDetails("Campo nome não pode ser vazio"))
                                .build();
            throw new WebApplicationException(response);
        }

        if (clienteDto.cpf() == null || clienteDto.cpf().trim().isEmpty()) {
            Response response = Response.status(Response.Status.BAD_REQUEST)
                                .entity(new ErrorDetails("Campo cpf não pode ser vazio"))
                                .build();
            throw new WebApplicationException(response);
        }

        if (clienteDto.email() == null || clienteDto.email().trim().isEmpty()) {
            Response response = Response.status(Response.Status.BAD_REQUEST)
                                .entity(new ErrorDetails("Campo email não pode ser vazio"))
                                .build();
            throw new WebApplicationException(response);
        }

    }
    
}
