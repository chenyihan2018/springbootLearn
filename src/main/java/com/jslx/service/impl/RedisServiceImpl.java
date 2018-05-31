package com.jslx.service.impl;

import com.jslx.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by xiaour.github.com on 2017/11/8.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RedisServiceImpl implements RedisService {

    private static int seconds=3600*24;

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    @Override
    public boolean set(final String key, final String value) throws Exception {
        Assert.hasText(key,"Key is not empty.");
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    public String get(final String key) throws Exception {
        Assert.hasText(key,"Key is not empty.");
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value =  connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    @Override
    public boolean expire(String key, long expire) throws Exception {
        return false;
    }

    @Override
    public <T> boolean setList(String key, List<T> list) throws Exception {
        return false;
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clz) throws Exception {
        return null;
    }

    @Override
    public long lpush(String key, Object obj) throws Exception {
        return 0;
    }

    @Override
    public long rpush(String key, Object obj) throws Exception {
        return 0;
    }

    @Override
    public void hmset(String key, Object obj) throws Exception {

    }

    @Override
    public <T> T hget(String key, Class<T> clz) throws Exception {
        return null;
    }

    public void del(final String key) throws Exception {
        Assert.hasText(key,"Key is not empty.");

        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection conn) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                return conn.del(serializer.serialize(key));
            }
        });
    }

    @Override
    public <T> List<T> hmGetAll(String key, Class<T> clz) throws Exception {
        return null;
    }

    @Override
    public String lpop(String key) throws Exception {
        return null;
    }

}
