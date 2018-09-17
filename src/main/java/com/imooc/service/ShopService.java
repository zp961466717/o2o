package com.imooc.service;




import com.imooc.dto.ImageHolder;
import com.imooc.dto.ShopExecution;
import com.imooc.entity.Shop;
import com.imooc.exceptions.ShopOperationException;

public interface ShopService {
	 /**
     * 根据shopCondition分页返回相应店铺列表
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);

    /**
     * 根据店铺ID查询店铺
     * 
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 修改店铺
     * 
     * @param shop
     * @param inputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder shopImgInputStream) throws ShopOperationException;

    /**
     * 添加店铺
     * 
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
	ShopExecution addShop(Shop shop,ImageHolder shopImgInputStream) throws ShopOperationException;

	

}
