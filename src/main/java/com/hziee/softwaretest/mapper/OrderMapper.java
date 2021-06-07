package com.hziee.softwaretest.mapper;

import com.hziee.softwaretest.entity.Order;
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
public interface OrderMapper {

	/**
	 * 添加订单信息
	 *
	 * @param order 订单信息
	 * @return 更改条数
	 */
	@Insert("insert into `software_test`.`order`(order_id,order_goods_id,order_num,order_date) values(#{order_id},#{order_goods_id},#{order_num},#{order_date});")
	int insertOrder(Order order);

	/**
	 * 删除订单信息
	 *
	 * @param order_id 订单id
	 * @return 更改条数
	 */
	@Delete("delete from `software_test`.`order` where order_id=#{order_id};")
	int deleteOrder(@Param("order_id") int order_id);

	/**
	 * 修改订单信息
	 *
	 * @param order 订单信息
	 * @return 更改条数
	 */
	@Update("update `software_test`.`order` set order_goods_id=#{order_goods_id},order_num=#{order_num},order_date=#{order_date} where order_id=#{order_id};")
	int updateOrder(Order order);

	/**
	 * 查询所有订单信息
	 *
	 * @return 所有订单信息
	 */
	@Select("select * from `software_test`.`order`;")
	List<Order> selectAllOrder();

	/**
	 * 查询某条订单信息
	 *
	 * @param order_id 订单id
	 * @return 某条订单嘻嘻
	 */
	@Select("select * from `software_test`.`order` where order_id=#{order_id};")
	Order selectAOrder(@Param("order_id") int order_id);

}
