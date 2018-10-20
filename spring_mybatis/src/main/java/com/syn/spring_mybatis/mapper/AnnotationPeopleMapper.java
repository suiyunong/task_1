package com.syn.spring_mybatis.mapper;

import com.syn.spring_mybatis.Pojo.People;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 专门对People类操作的接口
 */
public interface AnnotationPeopleMapper {

    /*
     * 这是基于注解的映射方式，实现对数据的增删改查，将sql语句直接写在注解的括号中
     * 这是一个接口，其不需要类去实现它
     * 下边分别是插入，删除，修改，查询一个记录，查询所有的记录
     * */
//    添加方法
    @Insert("insert into people(name,qq,type,entro_time,school,number,diary_link,slogan,brother,create_at,update_at) values " +
            "(#{name},#{qq},#{type},#{entro_time},#{school},#{number},#{diary_link},#{slogan},#{brother},#{create_at},#{update_at})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void add(People people);

    @Select("select * from people where id=#{id}")
    List<People> findById(int id);

    @Select("select * from people where name=#{name}")
    List<People> findByName(String name);

    @Select("select * from people where number=#{number}")
    List<People> findByNumber(int number);

    //查找所有
    @Select("select * from people")
    List<People> findAll();

    //更新方法
    @Update("update people set name=#{name},qq=#{qq},type=#{type},entro_time=#{entro_time},school=#{school},number=#{number}," +
            "diary_link=#{diary_link},slogan=#{slogan},brother=#{brother},create_at=#{create_at},update_at=#{update_at} where id=#{id}")
     void update(People people);

    //更新方法2，只更新name字段，测试没有成功
    @Update("update people set name=#{name} where id=#{id}")
    void update2(People people);

    //删除方法
    @Delete("delete from people where id=#{id}")
    public void delete(int id);

}
