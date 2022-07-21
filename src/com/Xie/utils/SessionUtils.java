package com.Xie.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Description: XXX
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/12 18:01
 */
public class SessionUtils {
    private static SqlSessionFactory factory = null;

    static{
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //获取会话
    public static SqlSession getSession(){
        SqlSession session = null;
        if(factory != null){
            //session = factory.openSession();//默认手动提交
            session = factory.openSession(true);//自动提交事务
        }
        return session;
    }
}
