package com.smbms.mapper;

import com.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countUser();

    List<User> queryAll();

    List<User> queryByUserNameUserRole(User u);

    List<User> queryWithRole();

    void insert(User user);

    void update(User user);

    void update2(@Param("id") Long id, @Param("password") String password);

    void deleteById(@Param("id")Long id);

    User queryByIdWithRole(@Param("id") Long id);

    // 测试 动态SQL
    List<User> queryByIdUserName(@Param("id") Long id, @Param("userName") String userName);

    User selectById(@Param("id") Long id);
    void update3(User user);


    List<User> queryByIds(List<Long> ids);

    List<User> queryByRole(@Param("userRole") Long id);
}
