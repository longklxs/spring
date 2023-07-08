import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(3);
        config.setMaxWaitMillis(3000);
        config.setMaxTotal(30);

        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.keys("*"));
        jedis.close();
        jedisPool.close();

    }
}
