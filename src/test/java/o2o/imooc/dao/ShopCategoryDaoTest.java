package o2o.imooc.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.dao.ShopCategoryDao;
import com.imooc.entity.ShopCategory;

import o2o.imooc.BaseTest;



public class ShopCategoryDaoTest extends BaseTest{
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testQueryShopCategory(){
        List<ShopCategory> shopCategoryList=shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(2,shopCategoryList.size());
        
        ShopCategory testCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(1L);
        testCategory.setParent(parentCategory);
        shopCategoryList=shopCategoryDao.queryShopCategory(testCategory);
        assertEquals(2,shopCategoryList.size());
       System.out.println(shopCategoryList.get(0).getShopCategoryName());

    }
}