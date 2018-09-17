package com.imooc.service;

import java.util.List;

import com.imooc.entity.ShopCategory;

public interface ShopCategoryService {
    /**
     * 根据查询条件获取shopCategory列表
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
