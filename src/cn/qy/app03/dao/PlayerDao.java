package cn.qy.app03.dao;

import cn.qy.app03.entity.Player;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlayerDao {
    private SqlSessionFactory sqlSessionFactory;
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }




    public void add(Player player) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("playerNamespace.add", player);
            sqlSession.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            sqlSession.close();
        }
    }

        public static void main(String[] agrs) throws Exception{
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});

            PlayerDao playerDao = new PlayerDao();
            playerDao.add(new Player(33,"jordan",66.6));
         }

    }

