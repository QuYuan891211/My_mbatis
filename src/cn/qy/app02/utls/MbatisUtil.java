package cn.qy.app02.utls;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;

public class MbatisUtil {
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private MbatisUtil(){}
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession=  sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return  sqlSession;
    }
    public static void closeSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }
}
