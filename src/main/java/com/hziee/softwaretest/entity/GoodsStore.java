package com.hziee.softwaretest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsStore {

  private long goods_store_id;
  private long goods_id;
  private long goods_num;

}
