package com.hziee.softwaretest.service.imp;

import com.hziee.softwaretest.entity.Goods;
import com.hziee.softwaretest.entity.GoodsType;
import com.hziee.softwaretest.mapper.GoodsTypeMapper;
import com.hziee.softwaretest.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */
@Service
public class GoodsTypeServiceImp implements GoodsTypeService {
	@Autowired
	private GoodsTypeMapper goodsTypeMapper;

	@Override
	public int insertGoodsType(GoodsType goodsType) {
		return goodsTypeMapper.insertGoodsType(goodsType);
	}

	@Override
	public int deleteGoodsType(int goodsType_id) {
		return goodsTypeMapper.deleteGoodsType(goodsType_id);
	}

	@Override
	public List<GoodsType> selectAllGoodsType() {
		return goodsTypeMapper.selectAllGoodsType();
	}

	@Override
	public GoodsType selectAGoodsType(int goods_type_id) {
		return goodsTypeMapper.selectAGoodsType(goods_type_id);
	}

	@Override
	public int updateGoodsType(GoodsType goodsType) {
		return goodsTypeMapper.updateGoodsType(goodsType);
	}
}
