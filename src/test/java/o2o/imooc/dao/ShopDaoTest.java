package o2o.imooc.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.dao.ShopDao;
import com.imooc.entity.Area;
import com.imooc.entity.PersonInfo;
import com.imooc.entity.Shop;
import com.imooc.entity.ShopCategory;

import o2o.imooc.BaseTest;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

    @Test
    public void testQueryShopListAndCount(){
        
            Shop shopCondition = new Shop();
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1L);
            shopCondition.setOwner(owner);
            List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
            System.out.println(shopList.size());
            int i = shopDao.queryShopCount(shopCondition);
            System.out.println(i);
}
	@Test
	@Ignore
	public void testQueryByshopId() {

		Shop shop = shopDao.queryByShopId(1L);
		System.out.println("areaname" + shop.getArea().getAreaName());
		System.out.println("areaId" + shop.getArea().getAreaId());

	}

	@Test
	@Ignore
	public void testInsertShop() {
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
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testupdateShop() {
		Shop shop = new Shop();
		shop.setShopId(2L);
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
}