package com.hziee.softwaretest.service.imp;

import com.hziee.softwaretest.entity.Goods;
import com.hziee.softwaretest.mapper.GoodsMapper;
import com.hziee.softwaretest.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hziee.softwaretest.mapper.GoodsMapper;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */
@Service
public class GoodsServiceImp implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public int insertGoods(Goods goods) {
		return goodsMapper.insertGoods(goods);
	}

	@Override
	public int deleteGoods(int goods_id) {
		return goodsMapper.deleteGoods(goods_id);
	}

	@Override
	public int updateGoods(Goods goods) {
		return goodsMapper.updateGoods(goods);
	}

	@Override
	public List<Goods> SelectAllGoods() {
		return goodsMapper.selectAllGoods();
	}

	@Override
	public Goods selectAGoods(int goods_id) {
		return goodsMapper.selectAGoods(goods_id);
	}
}
