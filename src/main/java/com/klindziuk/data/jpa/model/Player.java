/*
 * Copyright (c) 2023. Dandelion tutorials
 */

package com.klindziuk.data.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "player")
@Data
@Accessors(chain = true)
public class Player {

  @Id
  private Long id;
  private String name;
  private Integer age;
  private String club;
  private String nationality;

}
