package com.imooc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.entity.ProductCategory;

public interface ProductCategoryDao {
	  /**
     * 通过shop id 查询店铺商品类别
     * 
     * @param long
     *            shopId
     * @return List<ProductCategory>
     */
    List<ProductCategory> queryProductCategoryList(long shopId);
    /**
     * 批量增加商品类别
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);
    /**
     * 根据productCategoryId和shopId删除商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     */
    /**
     * 删除指定商品类别
     * 
     * @param productCategoryId
     * @param shopId
     * @return effectedNum
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
