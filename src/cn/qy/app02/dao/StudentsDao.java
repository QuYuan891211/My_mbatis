package cn.qy.app02.dao;

import cn.qy.app02.entity.Students;
import cn.qy.app02.utls.MbatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;

//一对一
public class StudentsDao {
    public Students findById(int id) throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MbatisUtil.getSqlSession();
            return sqlSession.selectOne("studentNamespace.findById",id);
        }catch (Exception e){
            throw e;
        }finally {
            MbatisUtil.closeSqlSession();
        }
    }

    public static void main(String[] args)throws Exception{
        Connection connection = MbatisUtil.getSqlSession().getConnection();
        String result = connection != null?"链接成功":"链接失败";
        System.out.println(result);
        StudentsDao studentsDao = new StudentsDao();
        Students student = studentsDao.findById(1);

        System.out.println(student.getId() + " " + student.getName() +" " +  student.getCard().getCode() + " " +student.getCard().getAddress());

    }
}
