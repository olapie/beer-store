package com.olapie.beerstore.domain.model.exception;

import lombok.NonNull;
import org.springframework.util.StringUtils;

public class InvalidParamException extends BadRequestException {
    InvalidParamException(@NonNull String paramName, String reason) {
        super(StringUtils.hasLength(reason) ?
                String.format("invalid param %s: %s", paramName, reason) :
                String.format("invalid param %s", paramName));
    }
}
