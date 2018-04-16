package cn.qy.app02.dao;

import cn.qy.app02.entity.Department;
import cn.qy.app02.entity.District;
import cn.qy.app02.entity.Police;
import cn.qy.app02.entity.Staff;
import cn.qy.app02.utls.MbatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.util.List;

//多对多
public class PoliceDistrictDao {
    //查询某区域有多少警察
    public List<Police> findPoliceByDistrict(String name){
        SqlSession sqlSession = null;
        try {
            sqlSession = MbatisUtil.getSqlSession();
            return sqlSession.selectList("policeNamespace.findPoliceByDistrict",name);
        }catch (Exception e){
            throw e;
        }finally {
            MbatisUtil.closeSqlSession();
        }
    }

    //查询某警察管多少区域
    public List<District> findDistrictByPolice(String name){
        SqlSession sqlSession = null;
        try {
            sqlSession = MbatisUtil.getSqlSession();
            return sqlSession.selectList("districtNamespace.findDistrictByPolice",name);
        }catch (Exception e){
            throw e;
        }finally {
            MbatisUtil.closeSqlSession();
        }
    }
    public static void main(String[] args) throws Exception{
        Connection connection = MbatisUtil.getSqlSession().getConnection();
        String result = connection != null?"链接成功":"链接失败";
        System.out.println(result);
        PoliceDistrictDao dao = new PoliceDistrictDao();
        List<Police> list = dao.findPoliceByDistrict("chaoyang");
        for(Police s  : list){
            System.out.println(s.getId()+":"+s.getName()+":");
        }

        List<District> list2 = dao.findDistrictByPolice("caoxi");
        for(District s  : list2){
            System.out.println(s.getId()+":"+s.getName()+":");
        }
    }
}
