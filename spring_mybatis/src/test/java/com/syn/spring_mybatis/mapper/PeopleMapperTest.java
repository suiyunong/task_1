package com.syn.spring_mybatis.mapper;

import com.syn.spring_mybatis.Pojo.People;
import com.syn.spring_mybatis.mapper.PeopleMapper;
import com.syn.spring_mybatis.tools.DBTools;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class PeopleMapperTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    PeopleMapper mapper = (PeopleMapper) applicationContext.getBean("peopleMapper");
    List<People> peopleList = new ArrayList<People>();
    People people = new People();

//    添加数据并返回ID
@Test
public void add() {
    people.setName("盐22注解");
    people.setQq("61212773747");
    people.setType("java");
    people.setEntro_time(121727127);
    people.setSchool("西南大学");
    people.setNumber(274455);
    people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
    people.setSlogan("我欲乘风");
    people.setBrother("刘宁");
    people.setCreate_at(System.currentTimeMillis());
    people.setUpdate_at(System.currentTimeMillis());
    int id = mapper.add(people);
    System.out.println(id);
    if (id == 1) {
        System.out.println("添加数据成功");
        System.out.println("返回id：" + people.getId());
    }

}

    @Test
    public void batchAdd() {
//        Long start = System.currentTimeMillis();
        //1、批量插入数据方法1——使用for循环
//            for (int i = 0; i < 10; i++) {
//                people.setName("冯添加"+(i+1));
//                people.setQq("61212773747"+(i+1));
//                people.setType("java");
//                people.setEntro_time(121727127);
//                people.setSchool("西南交通大学");
//                people.setNumber(27373+(i+1));
//                people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
//                people.setSlogan("我欲乘风");
//                people.setBrother("刘宁");
//                people.setCreate_at(System.currentTimeMillis());
//                people.setUpdate_at(System.currentTimeMillis());
//               int add= mapper.add(people);
//               System.out.println(add);
//                if (add == 1) {
//                System.out.println("更新数据成功");
//                System.out.println("返回id：" + people.getId());
//            }
//            }
        //2、批量插入数据方法2——使用mybatis batch模式
//            for (int i = 0; i < 10; i++) {
//                people.setName("张添加"+(i+1));
//                people.setQq("61212773747"+(i+1));
//                people.setType("java");
//                people.setEntro_time(121727127);
//                people.setSchool("西南大学");
//                people.setNumber(27373+(i+1));
//                people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
//                people.setSlogan("我欲乘风");
//                people.setBrother("刘宁");
//                people.setCreate_at(System.currentTimeMillis());
//                people.setUpdate_at(System.currentTimeMillis());
//                int add= mapper.add(people);
//                if (add == 1) {
//                    System.out.println("更新数据成功");
//                    System.out.println("返回id：" + people.getId());
//                }
//            }
        //3、批量插入数据方法3——foreach方式插入
        Long start = System.currentTimeMillis();
        List<People> peopleList = new ArrayList<People>();
//            插入数据的条数，判断是否插入成功要用到
        int counts = 3;
        for (int i = 0; i < 3; i++) {
            people = new People();
            people.setName("lao添加" + (i + 1));
            people.setQq("61212773747" + (i + 1));
            people.setType("java");
            people.setEntro_time(121727127);
            people.setSchool("西南大学");
            people.setNumber(27373 + (i + 1));
            people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
            people.setSlogan("我欲乘风");
            people.setBrother("刘宁");
            people.setCreate_at(System.currentTimeMillis());
            people.setUpdate_at(System.currentTimeMillis());
            peopleList.add(people);
        }
        int addResult = mapper.batchAdd(peopleList);
        if (addResult == counts) {
            System.out.println("批量添加数据成功");
        } else {
            System.out.println("批量添加数据失败");
        }
        Long end = System.currentTimeMillis();
        System.out.println("批量添加耗时：" + (end - start));

    }

    @Test
    public void update() {
        people.setId(42);
        people.setName("刘222武器");
        people.setType("PM");
        mapper.update(people);

    }


    @Test
    public void batchUpdate() {
        for (int i = 0; i < 3; i++) {
            people = new People();
            people.setId(231 + i);
            people.setName("林更新" + i);
            people.setType("PM");
            peopleList.add(people);
        }
        mapper.batchUpdate(peopleList);

    }

    @Test
    public void delete() {
        int id = mapper.delete(43);
        if (id == 1) {
            System.out.println("删除数据成功");
        } else {
            System.out.println("删除数据失败，数据可能不存在");
        }
}

    @Test
    public void batchDelete() {
        int[] arr = {1015, 1016};
        mapper.batchDelete(arr);
    }


    @Test
    public void findById() {
        peopleList = mapper.findById(59);
        for (People p : peopleList
                ) {
            DBTools.printPeople(p);
        }
    }

    @Test
    public void findByName() {
        peopleList = mapper.findByName("高抗");
        for (People p : peopleList
                ) {
            DBTools.printPeople(p);
        }
    }

    @Test
    public void findByNumber() {
        peopleList = mapper.findByNumber(9527);
        for (People p : peopleList
                ) {
            DBTools.printPeople(p);
        }
    }
}