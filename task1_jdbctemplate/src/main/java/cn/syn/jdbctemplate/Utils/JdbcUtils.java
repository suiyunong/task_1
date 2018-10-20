package cn.syn.jdbctemplate.Utils;

import cn.syn.jdbctemplate.Pojo.People;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JdbcUtils {

    public static String longToDate(long timeStamp,String formatType){
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        long stamp = timeStamp;

        java.util.Date date = new Date(stamp);
        String str = formatter.format(date);
        return str;
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
            System.out.println("入学时间："+JdbcUtils.longToDate(people.getEntro_time(),"yyyy年-MM月dd日"));
            System.out.println("毕业学校："+people.getSchool());
            System.out.println("学号："+people.getNumber());
            System.out.println("日报链接："+people.getDiary_link());
            System.out.println("口号："+people.getSlogan());
            System.out.println("师兄："+people.getBrother());
            System.out.println("创建于："+ JdbcUtils.longToDate(people.getCreate_at(),"yyyy年-MM月dd日-HH时mm分ss秒"));
            System.out.println("更新于："+JdbcUtils.longToDate(people.getUpdate_at(),"yyyy年-MM月dd日-HH时mm分ss秒"));

        } else {
            System.out.println("空对象！！");
        }
    }
}
