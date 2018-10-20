package cn.syn.mybatis.mapper;

import cn.syn.mybatis.Pojo.People;
import cn.syn.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AnnotationPeopleMapperTest {

    SqlSession session = DBTools.getSession();
    AnnotationPeopleMapper mapper = session.getMapper(AnnotationPeopleMapper.class);
    List<People> peopleList = new ArrayList<People>();
    People people = new People();
    @Test
    public void add() {
        people.setName("随注解");
        people.setQq("61212773747");
        people.setType("java");
        people.setEntro_time(121727127);
        people.setSchool("西南大学");
        people.setNumber(27373);
        people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
        people.setSlogan("我欲乘风");
        people.setBrother("刘宁");
        people.setCreate_at(System.currentTimeMillis());
        people.setUpdate_at(System.currentTimeMillis());
        mapper.add(people);
        System.out.println("返回id：" + people.getId());
        session.commit();
    }

    @Test
    public void findById() {
        peopleList=mapper.findById(48);
        for (People p : peopleList
                ) {
            DBTools.printPeople(p);
        }
    }

    @Test
    public void findByName() {
        peopleList=mapper.findByName("高抗");
        for (People p : peopleList
                ) {
            DBTools.printPeople(p);
        }
    }

    @Test
    public void findByNumber() {
        peopleList=mapper.findByNumber(27373);
        for (People p : peopleList
                ) {
            DBTools.printPeople(p);
        }
    }

    @Test
    public void update() {
        people.setId(46);
        people.setName("刘dad武器");
        people.setQq("61212773747");
        people.setType("PM");
        people.setEntro_time(121727127);
        people.setSchool("西南大学");
        people.setNumber(27373);
        people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
        people.setSlogan("我欲乘风");
        people.setBrother("刘宁");
        people.setCreate_at(System.currentTimeMillis());
        people.setUpdate_at(System.currentTimeMillis());
        mapper.update(people);
        session.commit();
    }
    //    只更改一个字段，name字段
    @Test
    public void update2() {
        people.setId(46);
        people.setName("zhao武器");
        mapper.update2(people);
        session.commit();
    }
    @Test
    public void delete() {
        mapper.delete(44);
        session.commit();
    }
}