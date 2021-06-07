package com.hziee.softwaretest.support;

import java.lang.reflect.Field;
import java.util.Date;

/*
  Created By MYH on 2021/4/22
  Using SoftWare  :   IntelliJ IDEA
  ProjectName     :   shop
 */

/**
 * SQL语句的辅助类
 */
public class SQLHelper {

	/**
	 * 通过传入实体类生成SQL语句
	 *
	 * @param obj        传入的实体类
	 * @param table_name 表名
	 * @param key_name   键名
	 * @param type       类型 0建表 1增 2删 3改 4查
	 * @return 返回sql语句
	 */
	public String generateInsertSQL(Object obj, String database_name, String table_name, String key_name, int type, String option) {

		System.out.println("System.out.println By SQLHelper.");

		switch (type) {
			default:
				System.out.println("输入数据错误");
				return "";
			case 0:
				return createTableSQL(obj, table_name, key_name);
			case 1:
				return insertItemSQL(obj, database_name, table_name);
			case 2:
				return deleteItemSQL(database_name, table_name, key_name);
			case 3:
				return updateItemSQL(obj, database_name, table_name);
			case 4:
				return queryItemSQL(database_name, table_name, option);
		}
	}

	/**
	 * 增表方法
	 *
	 * @param obj        传入的对象
	 * @param table_name 表名
	 * @param key_name   键名
	 * @return 返回增表字符串
	 */
	private String createTableSQL(Object obj, String table_name, String key_name) {
		// 定义前缀和后缀
		String sql_prefix = "CREATE TABLE `" + table_name + "`(";
		String sql_key = "PRIMARY KEY (`" + key_name + "`)";
		String sql_suffix = ");";

		StringBuilder generatedSql = new StringBuilder(sql_prefix);        // 使用前缀生成一个默认生成字符串

		Field[] declaredTypeAndName = getDeclaredTypeAndNameByClass(obj);        //获取声明的类型和名字
		for (Field field : declaredTypeAndName) {        // 通过循环添加sql语句项
			String sql_item = generateSqlByTypeAndName(field.getType(), field.getName());
			generatedSql.append(sql_item);
		}

		// 拼接字符串
		generatedSql.append(sql_key).append(sql_suffix);

		// 生成字符串 返回
		return new String(generatedSql);
	}

	/**
	 * 根据传入数据自动生成mybatis增加sql语句
	 *
	 * @param obj           传入的对象
	 * @param database_name 数据库名
	 * @param table_name    数据表名
	 * @return 返回生成的sql语句
	 */
	private String insertItemSQL(Object obj, String database_name, String table_name) {

		// 定义前缀和后缀
		String sql_prefix_1 = "insert into `" + database_name + "`.`" + table_name + "`(";
		String sql_prefix_2 = ") values(";
		String sql_suffix = ");";

		StringBuilder stringBuilder1 = new StringBuilder();
		StringBuilder stringBuilder2 = new StringBuilder();

		Field[] declaredField = getDeclaredTypeAndNameByClass(obj);
		for (Field field : declaredField) {
			stringBuilder1.append(field.getName()).append(",");
			stringBuilder2.append("#{").append(field.getName()).append("},");
		}
		String s1 = stringBuilder1.substring(0, stringBuilder1.length() - 1).toString();
		String s2 = stringBuilder2.substring(0, stringBuilder2.length() - 1).toString();

		return sql_prefix_1 + s1 + sql_prefix_2 + s2 + sql_suffix;
	}

	/**
	 * 根据传入数据自动生成mybatis删除sql语句
	 *
	 * @param database_name 数据库名
	 * @param table_name    数据表名
	 * @param key_name      键名
	 * @return 返回生成的sql语句
	 */
	private String deleteItemSQL(String database_name, String table_name, String key_name) {
		return "delete from `" + database_name + "`.`" + table_name + "` where " + key_name + "=#{" + key_name + "};";
	}

	/**
	 * 根据传入数据自动生成mybatis更新sql语句
	 *
	 * @param obj           更新数据类型
	 * @param database_name 数据库名
	 * @param table_name    数据表名
	 * @return 返回生成的sql语句
	 */
	private String updateItemSQL(Object obj, String database_name, String table_name) {
		// 定义前缀和后缀
		String sql_prefix = "update `" + database_name + "`.`" + table_name + "` set ";
		String sql_suffix = ";";

		StringBuilder sb1 = new StringBuilder();

		Field[] declaredField = getDeclaredTypeAndNameByClass(obj);
		int i = 1;
		for (Field field : declaredField) {
			if (i == 1) {
				i++;
				continue;
			}
			sb1.append(field.getName()).append("=#{").append(field.getName()).append("},");
		}

		String substring = sb1.substring(0, sb1.length() - 1);
		String string = " where " + declaredField[0].getName() + "=#{" + declaredField[0].getName() + "}";
		return sql_prefix + substring + string + sql_suffix;
	}

	/**
	 * 根据传入数据自动生成mybatis查询语句 可以自带附加语句
	 *
	 * @param database_name 数据库名
	 * @param table_name    数据表名
	 * @param option        附加参数
	 * @return 返回生成的sql语句
	 */
	private String queryItemSQL(String database_name, String table_name, String option) {
		return "select * from `" + database_name + "`.`" + table_name + "` " + option + ";";
	}

	/**
	 * 通过一个实体类 获取一个类的属性类型和属性
	 *
	 * @param object 传入的实体类
	 * @return 返回一个字段列表
	 */
	private Field[] getDeclaredTypeAndNameByClass(Object object) {
		return object.getClass().getDeclaredFields();    //获取该类的字段
	}

	/**
	 * 拼接单SQL语句item
	 *
	 * @param type 属性类型
	 * @param name 属性名
	 * @return 拼接好的字符串
	 */
	private String generateSqlByTypeAndName(Class<?> type, String name) {
		return "`" + name + "` " + returnStringInSqlByType(type) + " NOT NULL,";
	}

	/**
	 * 通过属性类型返回SQL中的类型名 可以在此添加内容以匹配更多的类型
	 *
	 * @param type 传入类型
	 * @return 返回对应的类型字符串
	 */
	private String returnStringInSqlByType(Class<?> type) {
		String typeString = "";
		if (type == int.class) {
			typeString = "INT";
		} else if (type == String.class) {
			typeString = "VARCHAR(81)";
		} else if (type == Date.class) {
			typeString = "DATE";
		} else if (type == float.class) {
			typeString = "FLOAT";
		} else if (type == double.class) {
			typeString = "DOUBLE";
		} else {
			System.out.println("找不到对应的类..");
			return null;
		}
		return typeString;
	}

	/**
	 * 查询所有的SQL语句
	 *
	 * @param database_name 查询的数据库名
	 * @param table_name    查询的数据表名
	 * @return SQL语句
	 */
	public String selectAllItems(String database_name, String table_name) {
		return "select * from `" + database_name + "`.`" + table_name + "`;";
	}

}
