package cn.syn.mybatis.mapper;


import cn.syn.mybatis.Pojo.People;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * mybatis xml 配置方式，专门对People类操作的接口
 */
public interface PeopleMapper {
//    添加方法，添加成功返回id
     int add(People people);

    //批量添加
     int batchAdd(List<People> peopleList);

    //更新方法
     void update(@Param("people") People people);

    //批量更新方法
    void batchUpdate(List<People> peopleList);

    //删除方法
     int delete(@Param("id") int id);

    //批量删除
    void batchDelete(int[] ids);

//    查找方法
    List<People> findById(@Param("id") int id);

    List<People> findByName(@Param("name") String name);

    List<People> findByNumber(@Param("number") int number);
}
