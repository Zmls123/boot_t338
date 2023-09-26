package com.gxa.boot338.redis;

import com.gxa.boot338.MainApp;
import io.swagger.annotations.ApiOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = MainApp.class)
@RunWith(SpringRunner.class)
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    private ValueOperations<String, Object> valueOper;
    @Before
    public void init(){
// 生成一个操作字符串的对象
        valueOper = redisTemplate.opsForValue();
    }

    @Test
    public void testWrite(){
        valueOper.set("code:"+"18623356760","2345",1, TimeUnit.MINUTES);
    }

    @Test
    public void testRead(){
        Object bl_code = valueOper.get("code:18623356760");
        System.out.println(bl_code);
    }
}
