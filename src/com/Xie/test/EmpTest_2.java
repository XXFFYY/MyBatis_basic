package com.Xie.test;

import com.Xie.pojo.Emp;
import com.Xie.utils.SessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 测试结果类型
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/13 11:08
 */
public class EmpTest_2 {
    public static void main(String[] args) {
        //1.获取会话
        SqlSession session = SessionUtils.getSession();

        //2.执行sql
        Date date = session.selectOne("com.Xie.mappers.EmpMapper.queryDateByNo", 7369);
        System.out.println(date);

        List<Emp> list = session.selectList("com.Xie.mappers.EmpMapper.queryEmpByNameLike", "S");
        System.out.println(list);

        Map<String, Object> map = session.selectOne("com.Xie.mappers.EmpMapper.queryEmpMapByNo", 7369);
        System.out.println(map);

        List<Map<String, Object>> list1 = session.selectList("com.Xie.mappers.EmpMapper.queryEmpMapByDeptNo", 1);
        System.out.println(list1);
        //3.关闭会话
        session.close();
    }
}
