package com.cloudinfo.company.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto {
    private String message;
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
}
