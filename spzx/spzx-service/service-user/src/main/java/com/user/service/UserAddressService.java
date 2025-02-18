package com.user.service;

import com.model.entity.user.UserAddress;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
public interface UserAddressService {
    List<UserAddress> findUserAddressList();

    UserAddress getById(Long id);
}
