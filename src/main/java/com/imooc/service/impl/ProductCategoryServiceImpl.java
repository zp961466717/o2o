package com.imooc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.dao.ProductCategoryDao;
import com.imooc.dto.ProductCategoryExecution;
import com.imooc.entity.ProductCategory;
import com.imooc.enums.ProductCategoryStateEnum;
import com.imooc.exceptions.ProductCategoryOperationException;
import com.imooc.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	ProductCategoryDao productCategoryDao;

	@Override
	public List<ProductCategory> getProductCategoryList(long shopId) {
		return productCategoryDao.queryProductCategoryList(shopId);
	}

	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		// TODO Auto-generated method stub
	     if (productCategoryList != null && productCategoryList.size() > 0) {
	            try {
	                int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
	                if (effectedNum <= 0) {
	                    throw new ProductCategoryOperationException("店铺类别创建失败");
	                } else {
	                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
	                }

	            } catch (Exception e) {
	                throw new ProductCategoryOperationException("batchAddProductCategory error: " + e.getMessage());
	            }
	        } else {
	            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
	        }
	}

	@Override
    @Transactional
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException {
        // 删除该productCategory
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
        }
    }

	



}
