package com.Service;

import com.POJO.Node;
import com.POJO.Road;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SelectAllImpl implements SelectAll {

    @Override
    public List<Node> selectAllNode() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();

        List<Node> list = sqlSession.selectList("selectAllNode");

        return list;
    }

    @Override
    public List<Road> selectAllRoad() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();

        List<Road> list = sqlSession.selectList("selectAllRoad");

        return list;
    }

    @Override
    public int addNode(Node node) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);

        int index = sqlSession.insert("addNode",node);
        return index;
    }

    @Override
    public int deletNode(int id) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);

        int index = sqlSession.delete("deletNode",id);
        return index;
    }

    @Override
    public int addRoad(Road road) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);

        int index = sqlSession.insert("addRoad",road);
        return index;
    }

    @Override
    public int deletRoad(int id) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession(true);

        int index = sqlSession.delete("deletRoad",id);
        return index;
    }

}
