import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis_Util {


    // 测试用户表里面的数据总量
    @Test
    public void testUserCount(){
        SqlSession session = MyBatisUtil.createSqlSession();

        // 书写字符串的方式太容易出错了
        Object o = session.selectOne("com.smbms.mapper.UserMapper.countUser");
        System.out.println(o);

        session.commit();
        session.close();
    }
}
