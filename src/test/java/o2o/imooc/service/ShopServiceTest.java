package o2o.imooc.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.dto.ImageHolder;
import com.imooc.dto.ShopExecution;
import com.imooc.entity.Area;
import com.imooc.entity.PersonInfo;
import com.imooc.entity.Shop;
import com.imooc.entity.ShopCategory;
import com.imooc.enums.ShopStateEnum;
import com.imooc.service.ShopService;

import o2o.imooc.BaseTest;



public class ShopServiceTest extends BaseTest{
    @Autowired
    private ShopService shopService;
    
    @Test
    public void testGetShopList(){
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(1L);
        shopCondition.setShopCategory(sc);
        ShopExecution se=shopService.getShopList(shopCondition, 1, 2);
        System.out.println("店铺列表数目："+se.getShopList().size());
        System.out.println("店铺总数"+se.getCount());
    }

    
    @Test
    @Ignore
    public void testModifyShop() throws FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后的店铺名称");
        File shopImg = new File("d:/haha.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHoder=new ImageHolder("haha1.jpg",is);
        ShopExecution shopExecution = shopService.modifyShop(shop,imageHoder);
        System.out.println("新的图片地址是: "+shopExecution.getShop().getShopImg());
    }

    
    @Test
    @Ignore
    public void testAddShop() throws FileNotFoundException{
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("/time.jpg");
        InputStream is=new FileInputStream(shopImg);
        ImageHolder imageHoder=new ImageHolder(shopImg.getName(),is);
        ShopExecution se = shopService.addShop(shop,imageHoder);
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}


