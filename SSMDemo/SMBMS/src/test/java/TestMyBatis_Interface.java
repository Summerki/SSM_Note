import com.smbms.mapper.UserMapper;
import com.smbms.pojo.User;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis_Interface {

    private SqlSession session;

    @Before
    public void pre(){
        session = MyBatisUtil.createSqlSession();
    }

//    @Test
//    public void testQueryByUserName(){
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        List<User> users = mapper.queryByUserNameUserRole("%孙%", 3);
//        System.out.println(users);
//    }

//    @Test
//    public void testQueryByUserName(){
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        User u = new User();
//        u.setUserName("%孙%");
//        u.setUserRole(3L);
//        List<User> users = mapper.queryByUserNameUserRole(u);
//        System.out.println(users);
//    }

    @Test
    public void test(){
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> users = mapper.queryByRole(2L);

        System.out.println(users);
    }

//    @Test
//    public void testQueryAll(){
//        UserMapper mapper = session.getMapper(UserMapper.class);
//        List<User> users = mapper.queryAll();
//        System.out.println(users);
//    }



    @After
    public void after(){
        session.commit();
        session.close();
    }
}
