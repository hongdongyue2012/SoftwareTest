package com.hziee.softwaretest.mapper;

import com.hziee.softwaretest.entity.Goods;
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
public interface GoodsMapper {

	/**
	 * 添加商品
	 *
	 * @param goods 商品信息
	 * @return 更改条数
	 */
	@Insert("insert into `software_test`.`goods`(goods_id,goods_name,goods_type,goods_in_price,goods_out_price,goods_manufacture_date,goods_expiration_date,goods_qrcode) values(#{goods_id},#{goods_name},#{goods_type},#{goods_in_price},#{goods_out_price},#{goods_manufacture_date},#{goods_expiration_date},#{goods_qrcode});")
	int insertGoods(Goods goods);

	/**
	 * 删除商品
	 *
	 * @param goods_id 商品id
	 * @return 更改条数
	 */
	@Delete("delete from `software_test`.`goods` where goods_id=#{goods_id};")
	int deleteGoods(@Param("goods_id") int goods_id);

	/**
	 * 更新商品
	 *
	 * @param goods 商品信息
	 * @return 更改条数
	 */
	@Update("update `software_test`.`goods` set goods_name=#{goods_name},goods_type=#{goods_type},goods_in_price=#{goods_in_price},goods_out_price=#{goods_out_price},goods_manufacture_date=#{goods_manufacture_date},goods_expiration_date=#{goods_expiration_date},goods_qrcode=#{goods_qrcode} where goods_id=#{goods_id};\n")
	int updateGoods(Goods goods);

	/**
	 * 查询商品列表
	 *
	 * @return 商品列表
	 */
	@Select("select * from `software_test`.`goods`;")
	List<Goods> selectAllGoods();

	/**
	 * 查询某商品信息
	 *
	 * @param goods_id 商品id
	 * @return 某商品信息
	 */
	@Select("select * from `software_test`.`goods` where goods_id=#{goods_id};")
	Goods selectAGoods(@Param("goods_id") int goods_id);

}
