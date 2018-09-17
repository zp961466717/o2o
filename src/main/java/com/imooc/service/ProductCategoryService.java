package com.imooc.service;

import java.util.List;

import com.imooc.dto.ProductCategoryExecution;
import com.imooc.entity.ProductCategory;
import com.imooc.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
	 /**
     * 查询指定某个店铺下的所有商品类别信息
     * 
     * @param long shopId
     * @return List<ProductCategory>
     */
    List<ProductCategory> getProductCategoryList(long shopId);
    /**
     * 
     * @param productCategory
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;
    /**
     * 将此商品类别下的商品的类别id置为空，在删除掉该商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     */
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId);
}
