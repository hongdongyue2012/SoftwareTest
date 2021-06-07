package com.hziee.softwaretest.mapper;

import com.hziee.softwaretest.entity.GoodsStore;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */

@Mapper
@Repository
public interface GoodsStoreMapper {

	/**
	 * 添加商品库存信息
	 *
	 * @param goodsStore 商品库存信息
	 * @return 更改条数
	 */
	@Insert("insert into `software_test`.`goods_store`(goods_store_id,goods_id,goods_num) values(#{goods_store_id},#{goods_id},#{goods_num});")
	int insertGoodsStore(GoodsStore goodsStore);

	/**
	 * 删除商品库存信息
	 *
	 * @param goods_store_id 商品库存信息id
	 * @return 更改条数
	 */
	@Delete("delete from `software_test`.`goods_store` where goods_store_id=#{goods_store_id};")
	int deleteGoodsStore(@Param("goods_store_id") int goods_store_id);

	/**
	 * 修改商品库存信息
	 *
	 * @param goodsStore 商品库存信息
	 * @return 更改条数
	 */
	@Update("update `software_test`.`goods_store` set goods_id=#{goods_id},goods_num=#{goods_num} where goods_store_id=#{goods_store_id};")
	int updateGoodsStore(GoodsStore goodsStore);

	/**
	 * 查询商品库存信息列表
	 *
	 * @return 商品库存信息列表
	 */
	@Select("select * from `software_test`.`goods_store`;")
	List<GoodsStore> selectAllGoodsStore();

	/**
	 * 查询某条商品库存信息
	 *
	 * @param goods_store_id 商品库存信息id
	 * @return 某条商品库存信息
	 */
	@Select("select * from `software_test`.`goods_store` where goods_id=#{goods_id}")
	GoodsStore selectAGoodsStore(@Param("goods_store_id") int goods_store_id);
}
