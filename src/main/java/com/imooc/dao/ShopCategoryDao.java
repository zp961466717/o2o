package com.imooc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.entity.ShopCategory;

public interface ShopCategoryDao {
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")
	ShopCategory shopCategoryCondition);

}
