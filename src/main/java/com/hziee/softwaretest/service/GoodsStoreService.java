package com.hziee.softwaretest.service;

import com.hziee.softwaretest.entity.GoodsStore;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */
public interface GoodsStoreService {

	//添加商品的库存信息
	public int insertGoodsStore(GoodsStore goodsStore);

	//删除商品库存信息
	public int deleteGoodsStore(int goods_store_id);

	//查询某条商品库存信息
	public GoodsStore selectAGoodsStore(int goods_store_id);

	//修改商品库存信息
	public int updateGoodsStore(GoodsStore goodsStore);

	//查询商品库存信息列表
	public List<GoodsStore> selectAllGoodsStore();
}
