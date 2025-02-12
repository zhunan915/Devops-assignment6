package com.piyal.model.error;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record CustomError(String message, int code) {
}