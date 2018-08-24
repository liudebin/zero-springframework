package zero.test.tx;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 事务测试
 *
 * @author liuguobin
 * @date 2018/7/25
 */

public class TxTest {

    JdbcTemplate jdbcTemplate;


    public void get() {
        final List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from mydb.file ");
        System.out.println(list.size());
    }

    //如果为 save则会开启事务，但是没想到是怎么开启的。
    public void saveOne() {
//  public void aa()
        String sql = "INSERT INTO mydb.file (name, local_path, remote_path, type, product, status, create_time, update_time, complete_time, remark, version) VALUES ( '凉凉9999', null, null, null, null, null, null, null, null, null, 3);";
        jdbcTemplate.execute(sql);
        throw new RuntimeException("test");
    }

    public void noTx() {
        saveOne();
    }





    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public TxTest setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        return this;
    }
}
