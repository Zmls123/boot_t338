package com.gxa.boot338.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.gxa.boot338.common.BizException;
import com.gxa.boot338.common.R;
import com.gxa.boot338.entity.dto.RegUserDTO;
import com.gxa.boot338.entity.dto.UserDTO;
import com.gxa.boot338.entity.pojo.Coupon;
import com.gxa.boot338.entity.pojo.User;
import com.gxa.boot338.mapper.CouponMapper;
import com.gxa.boot338.mapper.UserMapper;
import com.gxa.boot338.service.UserService;

import com.gxa.boot338.util.SMSUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Autowired
    private CouponMapper couponMapper;

    public User getById(String username) {
        System.out.println("getById");
        User user=userMapper.getById(username);
        return user;
    }



    public Boolean reg(RegUserDTO regUserDTO) throws BizException {

        //验证码是否正确
        String user_code=regUserDTO.getCode();
        //redis获取验证码
        Object sys_code=redisTemplate.opsForValue().get("code:"+regUserDTO.getPhone());

        //比较系统和注册填写验证码是否一样
        if (!user_code.equals(sys_code)){
           throw new BizException("验证码输入不正确或者验证码已过期");
        }
        //1、判断用户名是否存在，不存在才能注册

        //2、不存在，把用户信息写入数据库，完成注册
        User user=new User();
        Date date=new Date();
        regUserDTO.setRegTime(date);
        System.out.println(date);
        BeanUtils.copyProperties(regUserDTO,user);
        Integer insert=userMapper.insertUser(user);
        return insert>0;
    }

    @Override
    public User login(UserDTO userDTO) {
        return null;
    }

//    public User login(UserDTO userDTO) {
//        //通过username查询
//        User user=userMapper.getById(userDTO.getUsername());
//        System.out.println("1:"+user);
//        //查询到数据若不为空，登录成功，否则失败
//        if (user!=null){
//            System.out.println(" null:"+user);
//            if (user.getPassword().equals(userDTO.getPassword())){
//                System.out.println(user);
//                return user;
//            }else {
//                return null;
//            }
//        }
//        return null;
//    }

    @Override
    public Boolean deleteById(Integer id) {
       Boolean res = userMapper.deleteById(id);
       return res;
    }

    @Override
    public R cpnGetList(Integer id) {
        List<Coupon> get = couponMapper.selectCpnGetList(id);
        List<Coupon> notGet = couponMapper.selectCpnNotGetList(id);
        Map<String,Object> result=new HashMap<>();
        result.put("get",get);
        result.put("notGet",notGet);

        return R.success(result);
    }

    @Override
    public User getByPhone(String phone) {
        User user=userMapper.getByPhone(phone);
        return user;
    }

    @Override
    public Boolean send(String phone) throws ClientException {

        String code=SMSUtil.getMsgCode();

        //验证码存redis
        redisTemplate.opsForValue().set("code:"+phone,code,15, TimeUnit.MINUTES);


//        SendSmsResponse response=SMSUtil.sendSms(phone,"SMS_204986028","{\"code\":\""+code+"\"}");
//
//        String result=response.getCode();
//
//        return "ok".equals(result);
        return true;
    }
}
