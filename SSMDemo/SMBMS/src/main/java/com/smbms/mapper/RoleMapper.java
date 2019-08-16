package com.smbms.mapper;

import com.smbms.pojo.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    Role queryWithUser(@Param("id") long id);
}
