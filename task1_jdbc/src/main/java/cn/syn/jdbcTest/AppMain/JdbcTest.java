package cn.syn.jdbcTest.AppMain;

import cn.syn.jdbcTest.Utils.JdbcUtils;

import java.sql.*;

public class JdbcTest {
    /**
     * 插入数据
     */
    public void addUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 获取连接
            connection = JdbcUtils.getConnection();
            // 准备sql语句
            String sql = "INSERT INTO people(name,qq,type,entro_time,school,number,diary_link,slogan,brother,create_at,update_at)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            // 获取PrepareStatement对象
            preparedStatement = connection.prepareStatement(sql);
            // 填充占位符
            preparedStatement.setString(1, "朱丽");
            preparedStatement.setString(2, "3319729010");
            preparedStatement.setString(3, "PM");
            preparedStatement.setLong(4, 152363400);
            preparedStatement.setString(5, "湖北工程学院");
            preparedStatement.setInt(6, 1084);
            preparedStatement.setString(7, "dailyType=others&total=7&page=1&uid=21830&sort=0&orderBy=3");
            preparedStatement.setString(8, "学而不思则罔，思而不学则殆");
            preparedStatement.setString(9, "刘宁");
            preparedStatement.setLong(10, System.currentTimeMillis());
            preparedStatement.setLong(11, System.currentTimeMillis());
            // 执行sql
            int num = preparedStatement.executeUpdate();// 返回影响到的行数

            System.out.println("一共影响到" + num + "行");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseDB(connection, preparedStatement, null);
        }
    }

    /**
     * 读取查询
     */
    public void findUserById() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            final String sql = "select name,qq,type,school from people where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,3);
            resultSet = preparedStatement.executeQuery();

            // 遍历结果集
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String qq = resultSet.getString(2);
                String type = resultSet.getString(3);
                String school = resultSet.getString(4);
                System.out.println(name + ":" + qq + ":" + type+":"+school);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            JdbcUtils.releaseDB(connection, preparedStatement, resultSet);
        }
    }

    /**
     * 修改更新
     */
    public void updateUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "UPDATE people SET school = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "华南理工大学");
            preparedStatement.setString(2, "3");
            int num = preparedStatement.executeUpdate();

            System.out.println("一共影响到" + num + "行");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            JdbcUtils.releaseDB(connection, preparedStatement, null);
        }
    }

    /**
     * 删除
     */
    public void deleteUserById() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "DELETE FROM people WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 59);
            int num = preparedStatement.executeUpdate();

            System.out.println("一共影响到" + num + "行");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            JdbcUtils.releaseDB(connection, preparedStatement, null);
        }

    }

}

