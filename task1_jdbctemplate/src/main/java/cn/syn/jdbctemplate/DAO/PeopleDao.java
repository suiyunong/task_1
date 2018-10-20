package cn.syn.jdbctemplate.DAO;
import cn.syn.jdbctemplate.Pojo.People;

import java.util.List;

/**
 * 专门对People类操作的接口
 */
public interface PeopleDao {
    //添加方法，添加成功返回id
     int add(People people);

    //批量添加
     int[] batchAdd(List<People> peopleList);

    //批量添加并返回id
     void batchAddReturnId(List<People> peopleList);

    //更新方法
     boolean update(People people);

    //批量更新方法
     int[] batchUpdate(List<People> peopleList);

    //删除方法
     boolean delete(int id);

    //批量删除
     int[] batchDelete(int[] ids);

    //查找方法
    List<People> findById(int id);

    List<People> findByName(String name);

    List<People> findByNumber(int number);

    List<People> findByNumber2(int number);

    //查找所有
    List<People> findAll();
}
