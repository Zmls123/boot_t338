package com.gxa.boot338.mapper;

import com.gxa.boot338.entity.pojo.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper {


    int addCoupon(Coupon coupon);

    List<Coupon> selectCpnGetList(Integer userId);

    List<Coupon> selectCpnNotGetList(Integer userId);
}
