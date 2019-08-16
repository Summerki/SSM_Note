import com.smbms.mapper.RoleMapper;
import com.smbms.pojo.Role;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRole {
    private SqlSession session;

    @Before
    public void pre(){
        session = MyBatisUtil.createSqlSession();
    }

    @Test
    public void test(){
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        Role role = mapper.queryWithUser(3L);
        System.out.println(role);
    }


    @After
    public void after(){
        session.commit();
        session.close();
    }
}
