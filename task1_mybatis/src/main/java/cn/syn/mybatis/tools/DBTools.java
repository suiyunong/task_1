package cn.syn.mybatis.tools;

import cn.syn.mybatis.Pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBTools {
    public static SqlSessionFactory sessionFactory;

    static{
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //构建sqlSession的工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //创建能执行映射文件中sql的sqlSession
    public static SqlSession getSession(){
        return sessionFactory.openSession(ExecutorType.SIMPLE,false);
//        return sessionFactory.openSession(false);
    }
    /**
     * 打印people对象
     * @param people
     */

    public static void printPeople(People people) {
        if (people != null) {
            System.out.println("id："+people.getId());
            System.out.println("姓名："+people.getName());
            System.out.println("qq："+people.getQq());
            System.out.println("修真类型："+people.getType());
            System.out.println("入学时间："+longToDate(people.getEntro_time(),"yyyy年-MM月dd日"));
            System.out.println("毕业学校："+people.getSchool());
            System.out.println("学号："+people.getNumber());
            System.out.println("日报链接："+people.getDiary_link());
            System.out.println("口号："+people.getSlogan());
            System.out.println("师兄："+people.getBrother());
            System.out.println("创建于："+longToDate(people.getCreate_at(),"yyyy年-MM月dd日-HH时mm分ss秒"));
            System.out.println("更新于："+longToDate(people.getUpdate_at(),"yyyy年-MM月dd日-HH时mm分ss秒"));

        } else {
            System.out.println("空对象！！");
        }
    }
    public static String longToDate(long timeStamp,String formatType){
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        long stamp = timeStamp;

        Date date = new Date(stamp);
        String str = formatter.format(date);
        return str;
    }

}
