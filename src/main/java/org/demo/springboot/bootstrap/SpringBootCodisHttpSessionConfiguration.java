package org.demo.springboot.bootstrap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.session.data.redis.CodisOperationsSessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

import java.util.Arrays;

/**
 * Codis实现Http Session共享配置类
 * Created by zhaol on 2018/7/13.
 */
@Configuration
public class SpringBootCodisHttpSessionConfiguration extends RedisHttpSessionConfiguration {
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    @Override
    public RedisOperationsSessionRepository sessionRepository(RedisOperations<Object, Object> sessionRedisTemplate, ApplicationEventPublisher applicationEventPublisher) {
        RedisOperationsSessionRepository sessionRepository = new CodisOperationsSessionRepository(jedisConnectionFactory);

        return sessionRepository;
    }

    @Bean
    @Override
    public InitializingBean enableRedisKeyspaceNotificationsInitializer(RedisConnectionFactory connectionFactory) {
        return null;
    }

    @Bean
    @Override
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory, RedisOperationsSessionRepository messageListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        return container;
    }
}
