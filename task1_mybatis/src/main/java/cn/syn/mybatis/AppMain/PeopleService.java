package cn.syn.mybatis.AppMain;

import cn.syn.mybatis.Pojo.People;
import cn.syn.mybatis.mapper.PeopleMapper;
import cn.syn.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class PeopleService {
    public static void main(String[] args) {
        SqlSession session= DBTools.getSession();
        PeopleMapper mapper=session.getMapper(PeopleMapper.class);
        List<People> peopleList = new ArrayList<People>();
        People people = new People();
        try {

//            String name = mapper.findByIdReturnName(2);
//            System.out.println("id为2的数据的姓名：" + name);




//             peopleList= mapper.findById(3);
//            peopleList = mapper.findAll();

//            peopleList=mapper.findByName("高抗");
////            peopleList=mapper.findByNumber(9527);
//
//            for (People p : peopleList
//                    ) {
//                DBTools.printPeople(p);
//            }
            //更改id为42的数据，将type改为运营
//            people.setId(42);
//            people.setName("刘武器");
////            people.setQq("61212773747");
//            people.setType("PM");
////            people.setEntro_time(121727127);
////            people.setSchool("东北大学");
////            people.setNumber(27373);
////            people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
////            people.setSlogan("我欲乘风");
////            people.setBrother("刘宁");
////            people.setCreate_at(System.currentTimeMillis());
////            people.setUpdate_at(System.currentTimeMillis());

//            mapper.update(people);



            //添加数据
//            people.setName("刘删除");
//            people.setQq("61212773747");
//            people.setType("java");
//            people.setEntro_time(121727127);
//            people.setSchool("西南大学");
//            people.setNumber(27373);
//            people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
//            people.setSlogan("我欲乘风");
//            people.setBrother("刘宁");
//            people.setCreate_at(System.currentTimeMillis());
//            people.setUpdate_at(System.currentTimeMillis());
//            int id=mapper.add(people);
//            if (id == 1) {
//                System.out.println("更新数据成功");
//                System.out.println("返回id：" + people.getId());
//            }
//          删除
//            int id=mapper.delete(44);
//            if (id == 1) {
//                System.out.println("删除数据成功");
//            }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

    }
}
