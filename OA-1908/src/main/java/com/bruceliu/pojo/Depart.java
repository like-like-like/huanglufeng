package com.bruceliu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depart {

  private long id;
  private String name;
  private String createtime;
  private long del;

}
