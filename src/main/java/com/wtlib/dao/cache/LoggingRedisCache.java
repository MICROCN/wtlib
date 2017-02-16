<<<<<<< HEAD
package com.wtlib.dao.cache;

import org.apache.ibatis.cache.decorators.LoggingCache;

public class LoggingRedisCache extends LoggingCache{
 
    public LoggingRedisCache(String id) {
        super(new RedisCache(id));
    }
}
=======
package com.wtlib.dao.cache;

import org.apache.ibatis.cache.decorators.LoggingCache;

public class LoggingRedisCache extends LoggingCache{
 
    public LoggingRedisCache(String id) {
        super(new RedisCache(id));
    }
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
