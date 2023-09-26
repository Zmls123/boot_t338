import com.gxa.boot338.MainApp;
import com.gxa.boot338.entity.pojo.Coupon;
import com.gxa.boot338.entity.pojo.User;
import com.gxa.boot338.mapper.CouponMapper;
import com.gxa.boot338.service.CouponService;
import com.gxa.boot338.service.UserService;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest(classes = MainApp.class)
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    private UserService userService;

    @Autowired
    private CouponService couponService;

    @Test
    public void test1(){
        Date date=new Date();

    }

    @Test
    public void test2(){
        User user=userService.getByPhone("15520378886");
        System.out.println(user);
    }

    /*
    * useGeneratedKeys="true" keyProperty="cpId"
    * */

    @Test
    public void test3(){
        Coupon coupon = new Coupon();
        coupon.setCpTitle("冬日优惠券");
        coupon.setCpDesc("满200减30");
        coupon.setCpRole("role");
        LocalDateTime of1 = LocalDateTime.of(2022, 10, 20, 23, 59, 59);
        LocalDateTime of2 = LocalDateTime.of(2022, 12, 30, 23, 59, 59);
        coupon.setCpCollectExpire(of1);
        coupon.setCpUseExpire(of2);
        coupon.setCpImg("/uploadImg/spu/96e4ac0cbd2a4ecf8cc99bbce7501be8.jpg");

        couponService.addCoupon(coupon);

        System.out.println(coupon);

    }
}
