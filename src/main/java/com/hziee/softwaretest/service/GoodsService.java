package com.hziee.softwaretest.service;

import com.hziee.softwaretest.entity.Goods;
import org.apache.ibatis.annotations.Param;
import com.hziee.softwaretest.entity.Goods;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */
public interface GoodsService {

	//添加商品
	public int insertGoods(Goods goods);

	//删除商品
	public int deleteGoods(int goods_id);

	//更新商品
	public int updateGoods(Goods goods);

	//查询所有商品
	public List<Goods> SelectAllGoods();

	//查询指定商品
	public Goods selectAGoods(int goods_id);
}