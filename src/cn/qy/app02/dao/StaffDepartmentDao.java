package cn.qy.app02.dao;

import cn.qy.app02.entity.Department;
import cn.qy.app02.entity.Staff;
import cn.qy.app02.utls.MbatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.util.List;

//一对多
public class StaffDepartmentDao {
    //查询某部门有多少员工
    public List<Staff> findStaffByDepartment(String name){
        SqlSession sqlSession = null;
        try {
            sqlSession = MbatisUtil.getSqlSession();
            return sqlSession.selectList("departmentNamespace.findStaffByDepartment",name);
        }catch (Exception e){
            throw e;
        }finally {
            MbatisUtil.closeSqlSession();
        }
    }

    //查询某员工在什么部门
    public Department findDepartmentByStaff(String name){
        SqlSession sqlSession = null;
        try {
           sqlSession = MbatisUtil.getSqlSession();
           return sqlSession.selectOne("staffNamespace.findDepartmentByStaff",name);
        }catch (Exception e){
            throw e;
        }finally {
            MbatisUtil.closeSqlSession();
        }
    }

    public static void main(String[] args) throws Exception{
        Connection connection = MbatisUtil.getSqlSession().getConnection();
        String result = connection != null?"链接成功":"链接失败";
        System.out.println(result);
        StaffDepartmentDao dao = new StaffDepartmentDao();
        List<Staff> list = dao.findStaffByDepartment("java");
        for(Staff s  : list){
            System.out.println(s.getId()+":"+s.getName()+":"+s.getDepartment().getId()+":"+s.getDepartment().getName());
        }

        Department department = dao.findDepartmentByStaff("caoxi");
        System.out.println(department.getId()+":"+department.getName()+":");
    }

}
