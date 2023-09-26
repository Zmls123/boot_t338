package com.gxa.boot338.controller;



import com.alibaba.druid.util.StringUtils;
import com.gxa.boot338.common.BizException;
import com.gxa.boot338.common.R;
import com.gxa.boot338.entity.dto.RegUserDTO;
import com.gxa.boot338.entity.dto.UserDTO;
import com.gxa.boot338.entity.pojo.User;
import com.gxa.boot338.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/*
* @RequestMapping 把url中的请求映射到控制器
*
* java注解中存在两个默认情况
* 1、数组是可以默认赋一个值，可以省略大括号{}
* 2、value属性名默认可以省略，多个属性不可以
*
* @Controller:把UserController
* */
@RestController
@RequestMapping(value = "/user" )
@Api(tags="用户操作接口")
public class UserController {

    /*
    * RequestMapping在默认条件下get、post都支持
    * springmvc的返回值为String,默认会请求到一个jsp的地址上
    * 如果要把String直接返回给测试工具，必须声明为json类型,需要一个注解@ResponseBody
    * 前后端分离需要返回jso给前端，于是使用@ResponseBody
    * */

    @Autowired
    UserService userService;

    @ApiOperation(value="登录",notes = "id表示用户的编号")
    @PostMapping("/login")
    //用再参数身上
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username",value = "用户名",required = true,example = "gxa"),
//            @ApiImplicitParam(name = "password",value = "密码",required = true,example = "654321")
//    })
    public R login(UserDTO userDTO){
        System.out.println(userDTO);
        User login = userService.login(userDTO);
        System.out.println(login);
        return login!=null ? R.success(login):R.failed("登录失败");
    }

    @ApiOperation(value="登录",notes = "{\n" +
            "  \"password\": \"654321\",\n" +
            "  \"username\": \"gxa\"\n" +
            "}")
    @PostMapping("/login1")
    public R login1(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        User login = userService.login(userDTO);
        System.out.println(login);
        return login!=null ? R.success(login):R.failed("登录失败");
    }


    @PostMapping("/reg")
    public R reg(@RequestBody RegUserDTO regUserDTO) throws BizException {
        String code=regUserDTO.getCode();
        if (StringUtils.isEmpty(code)){
            throw new BizException("验证码不能为空");
        }
       Boolean res= userService.reg(regUserDTO);
        return res? R.success(res):R.failed("注册失败");
    }


//    @DeleteMapping("/deleteById")
    //restful风格
    @ApiOperation("用户删除")
    @DeleteMapping("/delete/{id}")
    public R deleteById(@PathVariable("id") Integer id){
        Boolean res=userService.deleteById(id);
        return res? R.success("删除成功"):R.failed("删除失败");
    }


    @ApiOperation("短信发送")
    @PostMapping("/send")
    public R send(String phone) throws Exception {


        //判断手机号是否合法
        //非空
        if (StringUtils.isEmpty(phone)){
            //抛出异常，记录日志
            throw new BizException("手机号不能为空");
            //return R.failed("手机号不能为空");
        }
//        int i=1/0;
        //合法手机号,正则
        boolean matches = phone.matches("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$");
        if (!matches){
            throw new BizException("手机号不合法，请重新输入");
        }
        //判断手机号是否已经存在
        User user=userService.getByPhone(phone);
        if (user!=null){
            throw new BizException("手机号已经存在，请登录");
        }
        //发送（阿里云）
        //返回结果：阿里发送成功---返回状态给用户
        //测试需要把验证码发前端和测试，打印带控制台
        //实际上通过接收验证码

       Boolean send= userService.send(phone);
        return send?R.success("success"):R.failed("failed");
    }
    @ApiOperation(value = "根据用户id查询可领取优惠券的方法")
    @GetMapping("/cpnGetList")
    public R cpnGetList(Integer id){
        return userService.cpnGetList(id);
    }

}
