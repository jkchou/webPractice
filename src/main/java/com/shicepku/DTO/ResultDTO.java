package com.shicepku.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDTO {
    private Integer code;
    private Map<String, Object> data;
    private String message;

    public static ResultDTO success(Map<String, Object> data, String message) {
        return ResultDTO.builder().code(200).data(data).message(message).build();
    }

    public static ResultDTO fail(Integer code, String message) {
        return ResultDTO.builder().code(code).message(message).build();
    }
}
