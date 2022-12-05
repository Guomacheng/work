package com.yq.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends BaseMapper<Users> {

    @Select("select real_name from users where account=#{account} and password=#{password}")
    String verify(@Param("account")String account,@Param("password")String password);

    @Select(("select uid from users where account=#{account}"))
    Integer queryIdByAccount(String account);
}
