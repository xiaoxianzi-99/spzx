package com.user.service.impl;

import com.model.entity.user.UserAddress;
import com.user.mapper.UserAddressMapper;
import com.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    /**
     * @return
     */
    @Override
    public List<UserAddress> findUserAddressList() {
        return null;
    }
}
