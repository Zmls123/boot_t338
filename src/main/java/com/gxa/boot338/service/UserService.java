package com.gxa.boot338.service;

import com.aliyuncs.exceptions.ClientException;
import com.gxa.boot338.common.BizException;
import com.gxa.boot338.common.R;
import com.gxa.boot338.entity.dto.RegUserDTO;
import com.gxa.boot338.entity.dto.UserDTO;
import com.gxa.boot338.entity.pojo.Coupon;
import com.gxa.boot338.entity.pojo.User;

import java.util.List;


public interface UserService {
    User getById(String username);

   Boolean reg(RegUserDTO regUserDTO) throws BizException;

    User login(UserDTO userDTO);


    Boolean deleteById(Integer id);


    R cpnGetList(Integer id);


    User getByPhone(String phone);

    Boolean send(String phone) throws ClientException;
}
