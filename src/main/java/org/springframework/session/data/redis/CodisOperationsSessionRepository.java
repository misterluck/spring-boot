package org.springframework.session.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;

/**
 * Created by zhaol on 2018/10/10.
 */
public class CodisOperationsSessionRepository extends RedisOperationsSessionRepository {

    @Autowired
    public CodisOperationsSessionRepository(RedisConnectionFactory redisConnectionFactory) {
        super(redisConnectionFactory);
    }

    @Autowired
    public CodisOperationsSessionRepository(RedisOperations redisOperations) {
        super(redisOperations);
    }

    @Override
    public void save(RedisSession session) {
        session.setNew(false);
        super.save(session);
    }
}
