package com.user.controller;

import com.model.entity.user.UserAddress;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.user.service.UserAddressService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/2/17
 **/
@RestController
@RequestMapping("api/user/userAddress")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("auth/findUserAddressList")
    public Result<List<UserAddress>> findUserAddressList() {
        List<UserAddress> list = userAddressService.findUserAddressList();
        return Result.build(list , ResultCodeEnum.SUCCESS) ;
    }
}
