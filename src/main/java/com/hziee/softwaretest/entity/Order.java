package com.hziee.softwaretest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  private long order_id;
  private long order_goods_id;
  private long order_num;
  private java.sql.Date order_date;

}
