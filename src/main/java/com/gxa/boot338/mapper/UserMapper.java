package com.gxa.boot338.mapper;
import com.gxa.boot338.entity.pojo.Coupon;
import com.gxa.boot338.entity.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;
@Mapper
public interface UserMapper {

    User getById(String username);

    List<User> getAll();

    User selectByName(String username);

    Integer insertUser(User user);

    Boolean deleteById(Integer id);

    User getByPhone(String phone);


}
