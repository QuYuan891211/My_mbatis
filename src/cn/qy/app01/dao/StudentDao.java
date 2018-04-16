package cn.qy.app01.dao;

import cn.qy.app01.entity.Student;
import cn.qy.app01.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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


    public void deleteById(int id) throws Exception{
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSession();
            sqlSession.delete("myNamespace.deleteById",id);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    public List<Student> findAll(){
        List<Student> list = new LinkedList<>();
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtil.getSession();
            list = sqlSession.selectList("myNamespace.findAll");
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
            return list;
        }
    }

    public void dynamicAdd(Student student){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSession();
            sqlSession.insert("myNamespace.dynamicInsert",student);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    public void dynamicDelete(int... ids) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSession();
            sqlSession.delete("myNamespace.dynamicDelete",ids);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }

    public void dynamicUpdate(Student student){
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtil.getSession();
            sqlSession.update("myNamespace.dynamicUpdate",student);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
        }
    }


    public List<Student> dynamicFind(String name, Double sal){
        List<Student> list = new LinkedList<>();
        SqlSession sqlSession = null;
        try{
            sqlSession = MyBatisUtil.getSession();
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("pname",name);
            map.put("psal",sal);
            list = sqlSession.selectList("myNamespace.dynamicFind",map);
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            throw e;
        }finally {
            MyBatisUtil.closeSession();
            return list;
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
//        Student student = studentDao.findById(2);
//        System.out.println(student.getId() + " " + student.getName()+ " " + student.getSal());
//        studentDao.deleteById(2);
//        List<Student> list = studentDao.findAll();
//        for(Student s: list){
//            System.out.println(s.getId() + " " + s.getName() + " " + s.getSal());
//        }
//        studentDao.dynamicUpdate(new Student(4,"sss",52.5));
//        List<Student> list = studentDao.dynamicFind("cao3",null);
//        for(Student s: list){
//           System.out.println(s.getId() + " " + s.getName() + " " + s.getSal());
//        }

//        studentDao.dynamicDelete(1,3);
            studentDao.dynamicAdd(new Student(55,"lz",null));
    }

}
