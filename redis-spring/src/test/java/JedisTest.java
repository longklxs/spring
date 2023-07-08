import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("k1","v1");
        String k1 = jedis.get("k1");
        System.out.println(k1);
        jedis.set("k2","呵呵呵");
        String k2 = jedis.get("k2");
        System.out.println(k2);
    }
}
