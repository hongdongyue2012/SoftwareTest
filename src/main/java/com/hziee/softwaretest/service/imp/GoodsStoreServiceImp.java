package com.hziee.softwaretest.service.imp;

import com.hziee.softwaretest.entity.GoodsStore;
import com.hziee.softwaretest.mapper.GoodsStoreMapper;
import com.hziee.softwaretest.service.GoodsStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By MYH on 2021/6/6
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   SoftwareTest
 */
@Service
public class GoodsStoreServiceImp implements GoodsStoreService {
	@Autowired
	GoodsStoreMapper goodsStoreMapper;

	@Override
	public int insertGoodsStore(GoodsStore goodsStore) {
		return goodsStoreMapper.insertGoodsStore(goodsStore);
	}

	@Override
	public int deleteGoodsStore(int goods_store_id) {
		return goodsStoreMapper.deleteGoodsStore(goods_store_id);
	}

	@Override
	public GoodsStore selectAGoodsStore(int goods_store_id) {
		return goodsStoreMapper.selectAGoodsStore(goods_store_id);
	}

	@Override
	public int updateGoodsStore(GoodsStore goodsStore) {
		return goodsStoreMapper.updateGoodsStore(goodsStore);
	}

	@Override
	public List<GoodsStore> selectAllGoodsStore() {
		return goodsStoreMapper.selectAllGoodsStore();
	}
}
