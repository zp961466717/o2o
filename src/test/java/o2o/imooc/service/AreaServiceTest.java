package o2o.imooc.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.entity.Area;
import com.imooc.service.AreaService;

import o2o.imooc.BaseTest;

public class AreaServiceTest extends BaseTest {

	@Autowired
	private AreaService areaService;
	@Test
	public void testGetAreaList() {
		List<Area>areaList = areaService.getAreaList();
		assertEquals("西区",areaList.get(0).getAreaName());
		
	}
}
