package com.piyal.model;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Id;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedEntity(value = "books")
@Serdeable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
  @Id
  private Long id;
  private String name;
  private String author;
  private Double price;
  private Integer totalPage;
}