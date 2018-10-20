package cn.syn.jdbctemplate.DAO;

import cn.syn.jdbctemplate.DaoImpl.PeopleJdbcTemplate;
import cn.syn.jdbctemplate.Pojo.People;
import cn.syn.jdbctemplate.Utils.JdbcUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class PeopleDaoTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/applicationContext.xml");
    PeopleJdbcTemplate peopleJdbcTemplate = (PeopleJdbcTemplate) context.getBean("peopleJdbcTemplate");
    People people = new People();
    List<People> peopleList = new ArrayList<People>();

    @Test
    public void add() {
        try {
            people.setName("王添加");
            people.setQq("61212773747");
            people.setType("java");
            people.setEntro_time(121727127);
            people.setSchool("西南大学");
            people.setNumber(27390);
            people.setDiary_link("https://www.cnblogs.com/xingyunblog/p/6243179.html");
            people.setSlogan("我欲乘风");
            people.setBrother("刘宁");
            people.setCreate_at(System.currentTimeMillis());
            people.setUpdate_at(System.currentTimeMillis());
            int id = peopleJdbcTemplate.add(people);
            System.out.println("返回id：" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void batchAdd() {
        try {
            for (int i = 0; i < 4; i++) {
                people = new People();
                people.setName("赵添加" + (i + 1));
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
            int[] AddCounts = peopleJdbcTemplate.batchAdd(peopleList);
            for (int i : AddCounts
                    ) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void batchAddReturnId() {
        try {
            for (int i = 0; i < 4; i++) {
                people = new People();
                people.setName("zhou添加" + (i + 1));
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
//返回id的逻辑写在batchAddReturnId方法里
            peopleJdbcTemplate.batchAddReturnId(peopleList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void update() {
        try {
            peopleList = peopleJdbcTemplate.findById(42);
            people = peopleList.get(0);
            people.setName("武器");
            people.setType("PM");
            boolean updateResult = peopleJdbcTemplate.update(people);
            System.out.println("更新数据结果:" + updateResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void batchUpdate() {
        try {
            //        批量更新id为27、28、29、30的数据
            List<People> batch = new ArrayList<People>();
            int[] updateCounts = null;
            int id = 27;
            for (int i = 0; i < 4; i++) {
                peopleList = peopleJdbcTemplate.findById(id + i);
                people = peopleList.get(0);
                people.setType("运营2");
                people.setUpdate_at(System.currentTimeMillis());
                batch.add(people);
            }
            updateCounts = peopleJdbcTemplate.batchUpdate(batch);
            for (int i : updateCounts
                    ) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void delete() {
        try {
            boolean deleteResult = peopleJdbcTemplate.delete(49);
            System.out.println("删除数据结果:" + deleteResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void batchDelete() {
        try {
            int[] batchDeLete = new int[10];
            for (int i = 61; i < 71; i++) {
                batchDeLete[(i - 61)] = i;
            }
            int[] updateCounts = peopleJdbcTemplate.batchDelete(batchDeLete);
            for (int i : updateCounts
                    ) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findById() {
        peopleList = peopleJdbcTemplate.findById(2);
        for (People p : peopleList
                ) {
            JdbcUtils.printPeople(p);
        }
    }

    @Test
    public void findByName() {
        peopleList = peopleJdbcTemplate.findByName("魏强");
        for (People p : peopleList
                ) {
            JdbcUtils.printPeople(p);
        }
    }

    @Test
    public void findByNumber() {
        peopleList = peopleJdbcTemplate.findByNumber(1083);
        for (People p : peopleList
                ) {
            JdbcUtils.printPeople(p);
        }
    }

}