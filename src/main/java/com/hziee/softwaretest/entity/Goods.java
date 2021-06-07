package com.hziee.softwaretest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

	private long goods_id;
	private String goods_name;
	private long goods_type;
	private double goods_in_price;
	private double goods_out_price;
	private java.sql.Date goods_manufacture_date;
	private long goods_expiration_date;
	private String goods_qrcode;

}
