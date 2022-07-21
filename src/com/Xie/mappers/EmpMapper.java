package com.Xie.mappers;

import com.Xie.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 测试接口绑定方案
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/15 9:57
 */
public interface EmpMapper {
    //查询所有用户信息
    List<Emp> queryEmp();

    //根据用户编号查询用户信息
    Emp queryEmpByNo(int deptno);

    //实现多参数传递
    //根据用户名与薪资一起查询
    Emp queryEmpByNameSal(@Param("ename") String ename, @Param("sal") double sal);
}
