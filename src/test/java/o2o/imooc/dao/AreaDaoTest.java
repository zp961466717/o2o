package o2o.imooc.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.dao.AreaDao;
import com.imooc.entity.Area;

import o2o.imooc.BaseTest;

public class AreaDaoTest extends BaseTest{
    @Autowired
    private AreaDao areaDao;
    
    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }
}
