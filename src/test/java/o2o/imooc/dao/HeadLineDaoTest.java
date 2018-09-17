package o2o.imooc.dao;



import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.dao.HeadLineDao;
import com.imooc.entity.HeadLine;

import o2o.imooc.BaseTest;



public class HeadLineDaoTest extends BaseTest {
    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void testQueryArea() {
        List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
        //assertEquals(4, headLineList.size());
        System.out.println(headLineList.size());
    }
}
