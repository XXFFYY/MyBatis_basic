package com.Xie.test;

import com.Xie.utils.SessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Description: 更新操作
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/13 10:24
 */
/*
    更新操作事物默认手动提交
 */
public class DeptTest_3 {
    public static void main(String[] args) {
        //1.获取会话
        SqlSession session = SessionUtils.getSession();

        //2.执行sql
//        int rows = session.insert("com.Xie.mappers.DeptMapper.addDept", new Dept(4,"嘻嘻","good"));

//        if(rows > 0)
//        {
//            session.commit();
//        }else{
//            session.rollback();
//        }
        //int rows = session.insert("com.Xie.mappers.DeptMapper.updateDept", new Dept(4,"无敌","good"));

        int rows = session.insert("com.Xie.mappers.DeptMapper.deleteDept", 4);
        System.out.println(rows > 0? "成功" : "失败");

        //3.关闭
        session.close();
    }
}
