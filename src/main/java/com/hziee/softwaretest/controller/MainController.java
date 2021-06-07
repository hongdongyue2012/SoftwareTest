package com.hziee.softwaretest.controller;

import com.hziee.softwaretest.entity.Goods;
import com.hziee.softwaretest.entity.GoodsStore;
import com.hziee.softwaretest.entity.Order;
import com.hziee.softwaretest.service.GoodsService;
import com.hziee.softwaretest.service.GoodsStoreService;
import com.hziee.softwaretest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */

@Controller
public class MainController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsStoreService goodsStoreService;

	@Autowired
	private OrderService orderService;

	/**
	 * 展示主页面
	 *
	 * @return 返回到主页面
	 */
	@RequestMapping("show_main_page")
	public String showMainPage() {
		return "main_page";
	}

	/**
	 * 跳转到商品展示页
	 *
	 * @return 商品展示页
	 */
	@RequestMapping("show_goods")
	public String showGoods(Model model) {

		// 获得所有商品的列表 存入model中
		List<Goods> goodsList = null;
		goodsList = goodsService.SelectAllGoods();
		model.addAttribute("goods_list", goodsList);

		return "show_goods";
	}

	/**
	 * 跳转到商品添加页
	 *
	 * @return 返回到商品添加页
	 */
	@RequestMapping("show_insert_goods")
	public String showInsertGoods() {
		return "insert_goods";
	}

	/**
	 * 商品添加数据方法
	 *
	 * @param request 带有数据的请求
	 * @param model 数据传输中间件
	 * @return 返回到跳转商品列表
	 * @throws ParseException 异常处理
	 */
	@ResponseBody
	@RequestMapping("insert_goods")
	public String InsertGoods(HttpServletRequest request, Model model) throws ParseException {
		String goods_name = request.getParameter("goods_name");
		int goods_type = Integer.parseInt(request.getParameter("goods_type"));
		int goods_in_price = Integer.parseInt(request.getParameter("goods_in_price"));
		int goods_out_price = Integer.parseInt(request.getParameter("goods_out_price"));
		String goods_manufacture_date_str = request.getParameter("goods_manufacture_date");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		java.sql.Date time = null;
		try {
			d = format.parse(goods_manufacture_date_str);
			time = new java.sql.Date(d.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

		int goods_expiration_date = Integer.parseInt(request.getParameter("goods_expiration_date"));
		String goods_qrcode = request.getParameter("goods_qrcode");

		Goods goods = new Goods(0, goods_name, goods_type, goods_in_price, goods_out_price, time, goods_expiration_date, goods_qrcode);

		int i = goodsService.insertGoods(goods);
		if (i > 0) {
			System.out.println("更改成功");
//			return "OK";
		} else {
			System.out.println("更改失败");
//			return "FALSE";
		}
		 return "redirect:show_goods";
	}



	/**
	 * 更新商品
	 *
	 * @param request 附带前端数据
	 * @return 跳转到展示数据页面请求
	 * @throws ParseException 捕获parse错误
	 */
	@RequestMapping("update_goods")
	public String updateGoods(HttpServletRequest request) throws ParseException {

		// 从request中获取数据
		long goods_id = Long.parseLong(request.getParameter("goods_id"));
		String goods_name = request.getParameter("goods_name");
		int goods_type = Integer.parseInt(request.getParameter("goods_type"));
		int goods_in_price = Integer.parseInt(request.getParameter("goods_in_price"));
		int goods_out_price = Integer.parseInt(request.getParameter("goods_out_price"));
		String goods_manufacture_date_str = request.getParameter("goods_manufacture_date");
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date Time = (Date) formatter.parse(goods_manufacture_date_str);
		int goods_expiration_date = Integer.parseInt(request.getParameter("goods_expiration_date"));
		String goods_qrcode = request.getParameter("goods_qrcode");

		// 包装成Goods类的对象并进行更新
		Goods goods = new Goods(goods_id, goods_name, goods_type, goods_in_price, goods_out_price, Time, goods_expiration_date, goods_qrcode);
		goodsService.updateGoods(goods);

		return "redirect:show_goods";
	}

	/**
	 * 删除商品
	 *
	 * @param request 附带前端数据
	 * @return 跳转到展示商品页面请求
	 */
	@RequestMapping("delete_goods")
	public String deleteGoods(HttpServletRequest request) {
		request.getParameter("");
		return "redirect:show_goods";
	}





	/**
	 * 跳转到库存展示页
	 *
	 * @return 库存展示页
	 */
	@RequestMapping("show_store")
	public String showStore() {
		// 获得所有库存的列表 存入model中
		List<GoodsStore> goodsStoreList = null;
		goodsStoreList = goodsStoreService.selectAllGoodsStore();
		return "store_list";
	}

	/**
	 * 跳转到订单展示页
	 *
	 * @return 订单展示页
	 */
	@RequestMapping("show_order")
	public String showOrder() {

		// 获得所有订单的列表 存入model中
		List<Order> orderList = null;
		orderList = orderService.selectAllOrder();
		return "order_list";
	}
}
