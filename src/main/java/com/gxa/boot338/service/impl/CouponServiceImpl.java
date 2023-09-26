package com.gxa.boot338.service.impl;

import com.gxa.boot338.entity.pojo.Coupon;
import com.gxa.boot338.mapper.CouponMapper;
import com.gxa.boot338.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public Coupon addCoupon(Coupon coupon) {
        int add=couponMapper.addCoupon(coupon);
        return coupon;
    }
}
