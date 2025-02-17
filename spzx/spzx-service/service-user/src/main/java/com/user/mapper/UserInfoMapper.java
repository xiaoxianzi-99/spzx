package com.user.mapper;

import com.model.entity.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/14
 **/
@Mapper
public interface UserInfoMapper {
    UserInfo getByUsername(String username);

    void save(UserInfo userInfo);

    void updateById(UserInfo userInfo);
}
