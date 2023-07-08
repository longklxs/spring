import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class SpringJedisTest {

    @Autowired
    JedisPool jedisPool;

    @Test
    public void test01(){
        Jedis jedis = jedisPool.getResource();
        String k1 = jedis.get("k1");
        System.out.println(k1);
    }

}
