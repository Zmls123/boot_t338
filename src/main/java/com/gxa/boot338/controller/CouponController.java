package com.gxa.boot338.controller;

import com.gxa.boot338.common.R;
import com.gxa.boot338.entity.pojo.Coupon;
import com.gxa.boot338.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "优惠券操作")
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @ApiOperation("优惠券添加")
    @PostMapping("/add")
    public R addCoupon(@RequestBody Coupon coupon){
        Coupon res=couponService.addCoupon(coupon);
        return res!=null?R.success(coupon):R.failed("add failed");
    }
}
