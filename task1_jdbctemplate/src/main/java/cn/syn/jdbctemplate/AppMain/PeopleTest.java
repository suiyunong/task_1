package cn.syn.jdbctemplate.AppMain;
import cn.syn.jdbctemplate.DaoImpl.PeopleJdbcTemplate;
import cn.syn.jdbctemplate.Pojo.People;
import cn.syn.jdbctemplate.Utils.JdbcUtils;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeopleTest {
    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/applicationContext.xml");
        PeopleJdbcTemplate peopleJdbcTemplate = (PeopleJdbcTemplate) context.getBean("peopleJdbcTemplate");
        People people = new People();
        List<People> peopleList = new ArrayList<People>();
        //写一个选择增删查改的逻辑
        System.out.println("您好，请输入数字选择操作命令：");
        System.out.println("1：查询 2：添加 3：更新 4：删除 5:批量添加");
        Scanner scanner = new Scanner(System.in);
        int input=scanner.nextInt();

        switch (input) {
            case 1:
                System.out.println("输入以下数字选择查询方式：");
                System.out.println("1：查询id 2：查询姓名 3：查询学号");
                int queryInput = scanner.nextInt();
                if (queryInput == 1) {
                    System.out.println("请输入id：");
                    peopleList = peopleJdbcTemplate.findById(scanner.nextInt());
                } else if (queryInput == 2) {
                    System.out.println("请输入姓名：");
                    peopleList = peopleJdbcTemplate.findByName(scanner.next());
                } else if (queryInput == 3) {
                    System.out.println("请输入学号：");
                    peopleList = peopleJdbcTemplate.findByNumber(scanner.nextInt());
                } else {
                    System.out.println("查询出错，请检查输入是否正确");
                    //提前结束程序
                    return;
                }
                break;
            case 2:
                System.out.println("请输入姓名：");
                people.setName(scanner.next());
                System.out.println("请输入QQ号：");
                people.setQq(scanner.next());
                System.out.println("请输入修真类型：");
                people.setType(scanner.next());
                System.out.println("请输入入学时间：");
                people.setEntro_time(scanner.nextLong());
                System.out.println("请输入毕业学校：");
                people.setSchool(scanner.next());
                System.out.println("请输入学号：");
                people.setNumber(scanner.nextInt());
                System.out.println("请输入日报链接：");
                people.setDiary_link(scanner.next());
                System.out.println("请输入修真口号：");
                people.setSlogan(scanner.next());
                System.out.println("请输入师兄：");
                people.setBrother(scanner.next());
                people.setCreate_at(System.currentTimeMillis());
                int returnId = peopleJdbcTemplate.add(people);
                System.out.println("添加的数据id：" + returnId);
                break;
            case 3:
                System.out.println("请输入欲更改数据的id：");
                peopleList = peopleJdbcTemplate.findById(scanner.nextInt());
                people = peopleList.get(0);

                boolean endInput=true;
                while (endInput) {
                    System.out.println("请输入欲更改数据的字段1:姓名 2:QQ号 3:修真类型 4:入学时间 5:毕业学校 6:学号 7:日报链接 8:口号 9:师兄，输入0结束更新操作.......");
                    int field = scanner.nextInt();
                    if (field == 0) {
                        people.setUpdate_at(System.currentTimeMillis());
                        endInput = false;
                    } else if (field >= 1 && field <= 9) {
                        switch(field){
                            case 1:
                                System.out.println("请输入姓名：");
                                people.setName(scanner.next());
                                break;
                            case 2:
                                System.out.println("请输入QQ号：");
                                people.setQq(scanner.next());
                                break;
                            case 3:
                                System.out.println("请输入修真类型：");
                                people.setType(scanner.next());
                                break;
                            case 4:
                                System.out.println("请输入入学时间：");
                                people.setEntro_time(scanner.nextLong());
                                break;
                            case 5:
                                System.out.println("请输入毕业学校：");
                                people.setSchool(scanner.next());
                                break;
                            case 6:
                                System.out.println("请输入学号：");
                                people.setNumber(scanner.nextInt());
                                break;
                            case 7:
                                System.out.println("请输入日报链接：");
                                people.setDiary_link(scanner.next());
                                break;
                            case 8:
                                System.out.println("请输入修真口号：");
                                people.setSlogan(scanner.next());
                                break;
                            case 9:
                                System.out.println("请输入师兄：");
                                people.setBrother(scanner.next());
                                break;
                            default:
                                break;
                        }

                    }else {
                        System.out.println("请检查输入字段编号（0-9）.......");
                    }
                }
                boolean updateResult =peopleJdbcTemplate.update(people);
                System.out.println("更新数据结果:"+updateResult);
                    break;
            case 4:
                System.out.println("输入删除数据的id：");
                boolean deleteResult=peopleJdbcTemplate.delete(scanner.nextInt());
                System.out.println("删除数据结果:"+deleteResult);
                break;
            case 5:
                break;
            default:
                break;
        }


        for (People people2 : peopleList
                ) {
            JdbcUtils.printPeople(people2);
        }
    }
}
