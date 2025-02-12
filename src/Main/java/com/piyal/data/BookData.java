package com.piyal.data;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BookData(String name, String author, Double price, Integer totalPage) {
}