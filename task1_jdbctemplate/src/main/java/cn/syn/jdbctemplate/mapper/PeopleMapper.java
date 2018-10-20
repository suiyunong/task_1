package cn.syn.jdbctemplate.mapper;
import cn.syn.jdbctemplate.Pojo.People;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleMapper implements RowMapper<People>{
    @Override
    public People mapRow(ResultSet rs, int rownum) throws SQLException {
        People people = new People();
        people.setId(rs.getInt("id"));
        people.setName(rs.getString("name"));
        people.setQq(rs.getString("qq"));
        people.setType(rs.getString("type"));
        people.setEntro_time((Long)rs.getLong("entro_time"));
        people.setSchool(rs.getString("school"));
        people.setNumber(rs.getInt("number"));
        people.setDiary_link(rs.getString("diary_link"));
        people.setSlogan(rs.getString("slogan"));
        people.setBrother(rs.getString("brother"));
        people.setCreate_at(rs.getLong("create_at"));
        people.setUpdate_at(rs.getLong("update_at"));

        return people;
    }
}
