package com.hziee.softwaretest.support;

import com.hziee.softwaretest.entity.Goods;
import com.hziee.softwaretest.entity.GoodsStore;
import org.junit.Test;

/**
 * Created By MYH on 2021/5/27
 * Using SoftWare  :   IntelliJ IDEA
 * ProjectName     :   taopiaopiao
 */
public class TestSqlHelper {

	@Test
	public void test() {

		// 自定义参数列表
		Object object = new GoodsStore();
		String database_name = "software_test";
		String table_name = "goods_store";
		String key_name = "goods_store_id";
		String options = "";

		SQLHelper sqlHelper = new SQLHelper();
		for (int i = 1; i <= 4; i++) {
			String s = sqlHelper.generateInsertSQL(object, database_name, table_name, key_name, i, options);
			System.out.println(s);
		}
	}
}

