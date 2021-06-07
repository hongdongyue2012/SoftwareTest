package com.hziee.softwaretest.service;

import com.hziee.softwaretest.entity.GoodsType;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */
public interface GoodsTypeService {

	//添加商品类型
	public int insertGoodsType(GoodsType goodsType);

	//删除商品类型
	public int deleteGoodsType(int goodsType_id);

	//查询所有商品类型
	public List<GoodsType> selectAllGoodsType();

	//查询某个商品类型
	public GoodsType selectAGoodsType(int goods_type_id);

	//修改商品类型
	public int updateGoodsType(GoodsType goodsType);

}
