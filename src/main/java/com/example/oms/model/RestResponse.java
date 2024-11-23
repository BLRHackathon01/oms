package com.example.oms.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RestResponse<D> {
    HttpStatus status = HttpStatus.OK;
    String statusMessage;
    D data;

}
