package com.gxa.boot338.config;
//通过类的形式完成配置 , 放在和Main的主类平级的位置, 方便被扫描
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
@Configuration
public class RedisConfig {
    // 使用Bean注解的原因: 为了给RedisTemplate 提供属性值
// 其中一个重要项: 声明序列化方式
    @Bean
    @SuppressWarnings("all") // spring提供的一个注解, 忽略所有的警告
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
// 创建一个template对象
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
// 通过factory得到连接
        template.setConnectionFactory(factory);
// 声明序列化器
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new
                Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
// key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
// hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
// value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
// hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}