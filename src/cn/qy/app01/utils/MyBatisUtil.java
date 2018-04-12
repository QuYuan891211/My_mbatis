package cn.qy.app01.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader) ;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    private MyBatisUtil(){};

    public static SqlSession getSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession != null){
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
