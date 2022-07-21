package com.Xie.test;

import com.Xie.mappers.EmpMapper;
import com.Xie.pojo.Emp;
import com.Xie.utils.SessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description: 接口测试
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/15 10:07
 */
public class EmpTest_3 {
    public static void main(String[] args) {
        //1.获取会话
        SqlSession session = SessionUtils.getSession();

        //2.获取接口的实现类对象
        EmpMapper mapper = session.getMapper(EmpMapper.class);//接口多态

        //3.调用接口中定义的功能
        List<Emp> list = mapper.queryEmp();
        list.forEach(System.out::println);

        Emp emp = mapper.queryEmpByNo(7369);
        System.out.println(emp);

        emp = mapper.queryEmpByNameSal("SMITH", 800);
        System.out.println(emp);

        //4.关闭会话
        session.close();
    }
}
