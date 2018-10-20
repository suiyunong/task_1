package cn.syn.jdbctemplate.DaoImpl;

import cn.syn.jdbctemplate.CustomerJdbcTemplate.CustomerJdbcTemplate;
import cn.syn.jdbctemplate.DAO.PeopleDao;
import cn.syn.jdbctemplate.Pojo.People;
import cn.syn.jdbctemplate.mapper.PeopleMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * People接口的具体实现类
 */
public class PeopleJdbcTemplate implements PeopleDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private CustomerJdbcTemplate customerJdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.customerJdbcTemplate = new CustomerJdbcTemplate(dataSource);
    }

    /**
     * 插入并获取主键
     * @param people
     * @return
     */
    @Override
    public int add(People people) {
        final String sql = "INSERT INTO people(name,qq,type,entro_time,school,number,diary_link,slogan,brother,create_at,update_at)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final People finalPeople = people;


        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, finalPeople.getName());
                ps.setObject(2, finalPeople.getQq());
                ps.setObject(3, finalPeople.getType());
                ps.setObject(4, finalPeople.getEntro_time());
                ps.setObject(5, finalPeople.getSchool());
                ps.setObject(6, finalPeople.getNumber());
                ps.setObject(7, finalPeople.getDiary_link());
                ps.setObject(8, finalPeople.getSlogan());
                ps.setObject(9, finalPeople.getBrother());
                ps.setObject(10, finalPeople.getCreate_at());
                ps.setObject(11, finalPeople.getUpdate_at());

                return ps;
            }

        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * JDBCTemplate批量添加数据
     * @param peopleList
     * @return
     */
    @Override
    public int[] batchAdd(List<People> peopleList) {
        final String sql = "INSERT INTO people(name,qq,type,entro_time,school,number,diary_link,slogan,brother,create_at,update_at)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        final List<People> tempList = peopleList;
        List<Object[]> batch = new ArrayList<Object[]>();

        for (People people : tempList) {
            Object[] args = new Object[]{
                    people.getName(),
                    people.getQq(),
                    people.getType(),
                    people.getEntro_time(),
                    people.getSchool(),
                    people.getNumber(),
                    people.getDiary_link(),
                    people.getSlogan(),
                    people.getBrother(),
                    people.getCreate_at(),
                    people.getUpdate_at(),};
            batch.add(args);
        }
        int[] updateCounts = jdbcTemplate.batchUpdate(sql, batch);

        return updateCounts;

    }

    /**
     * 通过JDBCTemplate子类批量添加数据，并返回数据id
     * @param peopleList
     * @return
     */
    @Override
    public void batchAddReturnId(List<People> peopleList) {

        final String sql = "INSERT INTO people(name,qq,type,entro_time,school,number,diary_link,slogan,brother,create_at,update_at)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        final List<People> tempList = peopleList;
        int[] returnIds = new int[tempList.size()];

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        customerJdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                People people = tempList.get(i);
                ps.setObject(1, people.getName());
                ps.setObject(2, people.getQq());
                ps.setObject(3, people.getType());
                ps.setObject(4, people.getEntro_time());
                ps.setObject(5, people.getSchool());
                ps.setObject(6, people.getNumber());
                ps.setObject(7, people.getDiary_link());
                ps.setObject(8, people.getSlogan());
                ps.setObject(9, people.getBrother());
                ps.setObject(10, people.getCreate_at());
                ps.setObject(11, people.getUpdate_at());
            }
            @Override
            public int getBatchSize() {
                return tempList.size();
            }
        },generatedKeyHolder);
        List<Map<String, Object>> objectMap = generatedKeyHolder.getKeyList();
        for (Map<String, Object> map : objectMap) {
            System.out.println(map.get("GENERATED_KEY"));
        }
    }

    /**
     * 更新成功返回true，失败返回false
     * @param people
     * @return
     */
    @Override
    public boolean update(People people) {

        final String sql = "update people set name=?,qq=?,type=?,entro_time=?,school=?,number=?,diary_link=?,slogan=?,brother=? ,update_at=? where id=?";
        Object[] args = new Object[]{
                people.getName(),
                people.getQq(),
                people.getType(),
                people.getEntro_time(),
                people.getSchool(),
                people.getNumber(),
                people.getDiary_link(),
                people.getSlogan(),
                people.getBrother(),
                people.getUpdate_at(),
                people.getId()};
        int temp = jdbcTemplate.update(sql, args);
        if (temp > 0) {
            System.out.println("更新数据成功");
            return true;
        } else {
            System.out.println("更新数据失败");
            return false;
        }
    }

    /**
     * 批量更新数据
     * @param peopleList
     * @return
     */
    @Override
    public int[] batchUpdate(List<People> peopleList) {
        final String sql = "update people set name=?,qq=?,type=?,entro_time=?,school=?,number=?,diary_link=?,slogan=?,brother=? ,update_at=? where id=?";
        List<Object[]> batch = new ArrayList<Object[]>();
        for (People people : peopleList) {
            Object[] args = new Object[]{
                    people.getName(),
                    people.getQq(),
                    people.getType(),
                    people.getEntro_time(),
                    people.getSchool(),
                    people.getNumber(),
                    people.getDiary_link(),
                    people.getSlogan(),
                    people.getBrother(),
                    people.getUpdate_at(),
                    people.getId()};
            batch.add(args);
        }
        int[] updateCounts = jdbcTemplate.batchUpdate(sql, batch);
        boolean status = true;
        for (int i : updateCounts
                ) {
            if (i <= 0) {
                status = false;
            }
        }
        if (status) {
            System.out.println("批量更新成功");
        }else {
            System.out.println("批量更新失败");
        }
        return updateCounts;
    }

    /**
     * 删除成功返回true，否则返回false
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {

       final String sql = "delete from people where id=?";
        int temp=jdbcTemplate.update(sql, id);
        if (temp > 0) {
            System.out.println("删除数据成功");
            return true;
        } else {
            System.out.println("删除数据失败");
            return false;
        }
    }

    /**
     * 批量删除数据，返回true 或false
     * @param ids
     * @return
     */
    @Override
    public int[] batchDelete(int[] ids) {
        final int[] tempIds = ids;
        final String sql = "delete from people where id=?";
        List<Object[]> batch = new ArrayList<Object[]>();
        for (int id : tempIds) {
            Object[] args = new Object[]{id};
            batch.add(args);
        }
        int[] updateCounts = jdbcTemplate.batchUpdate(sql, batch);
        boolean status = true;
        for (int i : updateCounts
                ) {
            if (i == 0) {
                status = false;
            }
        }
        if (status) {
            System.out.println("批量删除成功");
        }else {
            System.out.println("批量删除失败");
        }
        return updateCounts;
    }


    /**
     * 根据id查询，返回people对象
     * @param id
     * @return
     */
    @Override
    public List<People> findById(int id) {
        final String sql = "select * from people where id=?";
        List<People> peopleList = new ArrayList<People>();
        Object[] params = new Object[]{id};
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, params);
        for (Map row : rows
                ) {
            People people = new People();
            people.setId((Integer) row.get("id"));
            people.setName((String) row.get("name"));
            people.setQq((String) row.get("qq"));
            people.setType((String) row.get("type"));
//            System.out.println("entro_time"+(Long) row.get("entro_time"));
            people.setEntro_time((Long) row.get("entro_time"));
            people.setSchool((String) row.get("school"));
//            System.out.println("number"+(Integer) row.get("number"));
            people.setNumber((Integer) row.get("number"));
            people.setDiary_link((String) row.get("diary_link"));
            people.setSlogan((String) row.get("slogan"));
            people.setBrother((String) row.get("brother"));
//            System.out.println("Create_at"+(Long) row.get("create_at"));
            people.setCreate_at((Long) row.get("create_at"));
//            System.out.println("Update_at"+(Long) row.get("update_at"));
            people.setUpdate_at((Long) row.get("update_at"));

            peopleList.add(people);
        }
        return peopleList;
    }

    /**
     * 根据姓名查询，返回people对象
     * @param name
     * @return
     */
    @Override
    public List<People> findByName(String name) {
        final String sql = "select * from people where name=?";
        List<People> peopleList = new ArrayList<People>();
        Object[] params = new Object[]{name};
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, params);
        for (Map row : rows
                ) {
            People people = new People();
            people.setId((Integer) row.get("id"));
            people.setName((String) row.get("name"));
            people.setQq((String) row.get("qq"));
            people.setType((String) row.get("type"));
//            System.out.println("entro_time"+(Long) row.get("entro_time"));
            people.setEntro_time((Long) row.get("entro_time"));
            people.setSchool((String) row.get("school"));
//            System.out.println("number"+(Integer) row.get("number"));
            people.setNumber((Integer) row.get("number"));
            people.setDiary_link((String) row.get("diary_link"));
            people.setSlogan((String) row.get("slogan"));
            people.setBrother((String) row.get("brother"));
//            System.out.println("Create_at"+(Long) row.get("create_at"));
            people.setCreate_at((Long) row.get("create_at"));
//            System.out.println("Update_at"+(Long) row.get("update_at"));
            people.setUpdate_at((Long) row.get("update_at"));

            peopleList.add(people);
        }
        return peopleList;
    }

    /**
     * 根据学号查询，返回people对象
     * @param number
     * @return
     */
    @Override
    public List<People> findByNumber(int number) {
        final String sql = "select * from people where number=?";
        List<People> peopleList = new ArrayList<People>();
        Object[] params = new Object[]{number};
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, params);
        for (Map row : rows
                ) {
            People people = new People();
            people.setId((Integer) row.get("id"));
            people.setName((String) row.get("name"));
            people.setQq((String) row.get("qq"));
            people.setType((String) row.get("type"));
//            System.out.println("entro_time"+(Long) row.get("entro_time"));
            people.setEntro_time((Long) row.get("entro_time"));
            people.setSchool((String) row.get("school"));
//            System.out.println("number"+(Integer) row.get("number"));
            people.setNumber((Integer) row.get("number"));
            people.setDiary_link((String) row.get("diary_link"));
            people.setSlogan((String) row.get("slogan"));
            people.setBrother((String) row.get("brother"));
//            System.out.println("Create_at"+(Long) row.get("create_at"));
            people.setCreate_at((Long) row.get("create_at"));
//            System.out.println("Update_at"+(Long) row.get("update_at"));
            people.setUpdate_at((Long) row.get("update_at"));

            peopleList.add(people);
        }
        return peopleList;
    }
    public List<People> findByNumber2(int number) {
        final String sql = "select * from people where number=?";
        List<People> peopleList = new ArrayList<People>();
        try {
            Object[] params = new Object[]{number};
            peopleList = (List<People>) jdbcTemplate.queryForObject(sql, params, new int[]{Types.INTEGER}, new PeopleMapper());
            System.out.println("查询成功！");
            return peopleList;
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 查询全部数据，返回列表对象
     * @return
     */
    @Override
    public List<People> findAll() {

        final String sql = "SELECT * FROM PEOPLE";
        List<People> peopleList = new ArrayList<People>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows
                ) {
            People people = new People();
            people.setId((Integer) row.get("id"));
            people.setName((String) row.get("name"));
            people.setQq((String) row.get("qq"));
            people.setType((String) row.get("type"));
//            System.out.println("entro_time"+(Long) row.get("entro_time"));
            people.setEntro_time((Long) row.get("entro_time"));
            people.setSchool((String) row.get("school"));
//            System.out.println("number"+(Integer) row.get("number"));
            people.setNumber((Integer) row.get("number"));
            people.setDiary_link((String) row.get("diary_link"));
            people.setSlogan((String) row.get("slogan"));
            people.setBrother((String) row.get("brother"));
//            System.out.println("Create_at"+(Long) row.get("create_at"));
            people.setCreate_at((Long) row.get("create_at"));
//            System.out.println("Update_at"+(Long) row.get("update_at"));
            people.setUpdate_at((Long) row.get("update_at"));

            peopleList.add(people);
        }
        return peopleList;
    }


}
