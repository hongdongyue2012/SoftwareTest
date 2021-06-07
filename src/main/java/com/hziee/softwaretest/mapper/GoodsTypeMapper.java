package com.hziee.softwaretest.mapper;

import com.hziee.softwaretest.entity.GoodsType;
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
public interface GoodsTypeMapper {

	/**
	 * 添加商品类型
	 *
	 * @param goodsType 商品类型信息
	 * @return 更改条数
	 */
	@Insert("insert into `software_test`.`goods_type`(goods_type_id,goods_type_name) values(#{goods_type_id},#{goods_type_name});")
	int insertGoodsType(GoodsType goodsType);

	/**
	 * 删除商品类型
	 *
	 * @param goods_type_id 商品类型id
	 * @return 更改条数
	 */
	@Delete("delete from `software_test`.`goods_type` where goods_type_id=#{goods_type_id};")
	int deleteGoodsType(@Param("goods_type_id") int goods_type_id);

	/**
	 * 修改商品类型
	 *
	 * @param goodsType 商品类型信息
	 * @return 更改条数
	 */
	@Update("update `software_test`.`goods_type` set goods_type_name=#{goods_type_name} where goods_type_id=#{goods_type_id};")
	int updateGoodsType(GoodsType goodsType);

	/**
	 * 查询所有商品类型
	 *
	 * @return 所有商品类型列表
	 */
	@Select("select * from `software_test`.`goods_type`;")
	List<GoodsType> selectAllGoodsType();

	/**
	 * 查询某个商品类型
	 *
	 * @param goods_type_id 商品类型id
	 * @return 某个商品类型信息
	 */
	@Select("select * from `software_test`.`goods_type` where goods_type_id=#{godos_type_id};")
	GoodsType selectAGoodsType(@Param("goods_type_id") int goods_type_id);

}
