package com.project.recycleit.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
public class ErrorResponse {
    private Integer errCode;
    private String errMsg;
    private Date timestamp;

    public ErrorResponse(Integer errCode, String errMsg, Date timestamp) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.timestamp = timestamp;
    }
}
