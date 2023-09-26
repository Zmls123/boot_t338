package com.gxa.boot338.controller;

import com.gxa.boot338.common.R;
import com.gxa.boot338.entity.pojo.Empl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "员工Restful")
public class EmplController {

    @ApiOperation("获取")
    @GetMapping("/empl/{id}")
    public R getById(@PathVariable("id") Integer id){
        log.info("id:{}",id);
        return R.success("获取成功");
    }

    @ApiOperation("添加")
    @PostMapping("/empl/{id}/{name}/{phone}")
    public R reg(@PathVariable("id") Integer id,
                 @PathVariable("name") String name,
                 @PathVariable("phone") String phone
                 ){
        log.info("id:{},name:{},phone:{}",id,name,phone);
        return R.success(id+"+"+name+"+"+phone);
    }

    @ApiOperation("修改")
    @PutMapping("/empl")
    public R update(@RequestBody Empl empl) {
        log.info("id:{},name:{},phone:{}",empl.getId(),empl.getName(),empl.getPhone());
        return R.success(empl.getId()+"+"+empl.getName()+"+"+empl.getPhone());
    }

    @ApiOperation("删除")
    @DeleteMapping ("/empl/{id}")
    public R delete(Integer id) {
        log.info("id:{}",id);
        return R.success("删除"+id);
    }
}
