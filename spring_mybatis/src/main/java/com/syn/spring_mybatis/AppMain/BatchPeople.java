package com.syn.spring_mybatis.AppMain;

import com.syn.spring_mybatis.Pojo.People;
import com.syn.spring_mybatis.mapper.PeopleMapper;
import com.syn.spring_mybatis.tools.DBTools;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.ArrayList;
import java.util.List;

public class BatchPeople {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:**/applicationContext.xml");
        PeopleMapper mapper = (PeopleMapper) applicationContext.getBean("peopleMapper");
        List<People> peopleList = new ArrayList<People>();
        System.out.println("仅仅输出可以吗");
        peopleList=mapper.findById(47);
        for (People p : peopleList
                ) {
            DBTools.printPeople(p);
        }
//        People people = new People();

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
//            Long start = System.currentTimeMillis();
//            List<People> peopleList = new ArrayList<People>();
//            for (int i = 0; i < 10; i++) {
//                people = new People();
//                people.setName("赵添加"+(i+1));
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
//                peopleList.add(people);
////                int[] adds= mapper.batchAdd(peopleList);
//                mapper.batchAdd(peopleList);
//                Boolean addResult = true;
//                for (int add : adds
//                        ) {
//                    if (add != 1) {
//                        addResult = false;
//                }
//                }
//                if (addResult) {
//                    System.out.println("批量添加数据成功");
//                } else {
//                    System.out.println("批量添加数据失败");
//                }

//            }
//            Long end = System.currentTimeMillis();
//            System.out.println("批量添加耗时：" +(end - start));

//            4、批量更新
//            for (int i = 0; i < 10; i++) {
//                People people=new People();
//                people.setId(231+i);
//                people.setName("林更新"+i);
//                people.setType("PM");
//                peopleList.add(people);
//            }
//            mapper.batchUpdate2(peopleList);
//            5、批量删除
//            int[] arr={1015,1016};
//            mapper.batchDelete(arr);







// 不关闭连接池的情况下，在Main函数里写1000个循环调用会出现什么情况





    }
}
