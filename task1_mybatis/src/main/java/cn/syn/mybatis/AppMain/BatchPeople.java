package cn.syn.mybatis.AppMain;

import cn.syn.mybatis.mapper.PeopleMapper;
import cn.syn.mybatis.Pojo.People;
import cn.syn.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class BatchPeople {
    public static void main(String[] args) {
        SqlSession session = DBTools.getSession();
        PeopleMapper mapper = session.getMapper(PeopleMapper.class);
        List<People> peopleList = new ArrayList<People>();

        try {
            //批量插入数据方法1——使用for循环
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
            //批量插入数据方法2——使用mybatis batch模式
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
            //批量插入数据方法3——foreach方式插入
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

//            批量更新
//            for (int i = 0; i < 10; i++) {
//                People people=new People();
//                people.setId(231+i);
//                people.setName("林更新"+i);
//                people.setType("运营");
//                peopleList.add(people);
//            }
//            mapper.batchUpdate(peopleList);
//            批量删除
//            int[] arr={1015,1016};
//            mapper.batchDelete(arr);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
}
