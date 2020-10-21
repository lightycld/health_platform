package com.health.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;

@Component
public class JedisClient {

    @Autowired
    private JedisConnectionFactory connectionFactory;


    /**
     * @param key
     * @param value
     * @param expire unit: seconds
     */
    public void set(String key, String value, int expire) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            jedis.set(key, value);
            jedis.expire(key, expire);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * @param key
     */
    public String get(String key) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            return jedis.get(key);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


    /**
     * @param key
     * @param value
     */
    public void setNoExpire(String key, String value) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            jedis.set(key, value);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean setnx(String key, String value, int seconds) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            if (1 == jedis.setnx(key, value)) {
                jedis.expire(key, seconds);
                return true;
            } else {
                return false;
            }
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void setex(String key, String value, int seconds) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            jedis.setex(key, seconds, value);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void del(String key) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            jedis.del(key);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public long incr(String key, int expire) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            long inc = jedis.incr(key);
            if (1 == inc) {
                jedis.expire(key, expire);
            }
            return inc;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * 创建或向zset中添加元素
     *
     * @param key
     */
    public void zadd(String key, String member, double score) {
        //获取当前时间
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            jedis.zadd(key, score, member);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * 获取当前key中数量
     *
     * @param key
     * @return
     */
    public long getCount(String key) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            // 按key统计集合中的有效数量
            return jedis.zcard(key);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List<String> mget(String[] keys) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            return jedis.mget(keys);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * @param key
     * @param field
     * @param value
     * @param expire unit: seconds
     */
    public void hset(String key, String field, String value, int expire) {
        JedisConnection con = null;
        Jedis jedis;
        try {
            con = (JedisConnection) connectionFactory.getConnection();
            jedis = con.getNativeConnection();
            jedis.hset(key, field, value);

        } finally {
            if (con != null) {
                con.close();
            }
        }

    }


}
