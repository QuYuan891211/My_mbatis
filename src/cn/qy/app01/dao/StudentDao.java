package cn.qy.app01.dao;

import cn.qy.app01.entity.Student;
import cn.qy.app01.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.sql.Connection;

public class StudentDao {
    public void add1(Student student){
            SqlSession sqlSession = MyBatisUtil.getSession();
        try {
            int i = sqlSession.insert("myNamespace.add1",student);

            sqlSession.commit();
            System.out.println("本次操作影响了" + i + "行数据");
        }catch (Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);

        }finally {
            MyBatisUtil.closeSession();
        }

    }

    public Student findById(int id) throws Exception{
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtil.getSession();
            Student student = sqlSession.selectOne("myNamespace.findById",id);
            sqlSession.commit();
            return student;
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MyBatisUtil.closeSession();
        }
    }


    public void deletById(int id) throws Exception{
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSession();
        }catch (Exception e){

        }finally {

        }
    }

    public static void main(String[] arg) throws Exception {
        Connection connection = MyBatisUtil.getSession().getConnection();
        String result = connection != null?"链接成功":"链接失败";
        System.out.println(result);
        StudentDao studentDao = new StudentDao();
//        studentDao.add1(new Student(4,"cao3",25.2));
//        studentDao.add1(new Student(1,"cao3",25.2));
//        studentDao.add1(new Student(2,"cao3",25.2));
//        studentDao.add1(new Student(3,"cao3",25.2));
        Student student = studentDao.findById(2);
        System.out.println(student.getId() + " " + student.getName()+ " " + student.getSal());
    }

}
