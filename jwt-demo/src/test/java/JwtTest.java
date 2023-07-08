import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testCreateJwt(){
        JwtBuilder builder = Jwts.builder();

        builder.setId("111");
        builder.setSubject("老王");
        builder.setIssuedAt(new Date());

        builder.signWith(SignatureAlgorithm.HS256,"longklxs");

        String token = builder.compact();
        System.out.println(token);
    }

    @Test
    public void testParseJwt(){
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiLogIHnjosiLCJpYXQiOjE2ODgwOTE3MTl9.-MpXtHw9r6hUz1mAQexorzLuFwur6plNPkGe9x9sc-s";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJzdWIiOiLogIHnjosiLCJpYXQiOjE2ODgwOTI0MTAsInJvbGUiOiJhZG1pbjEiLCJ0ZXN0IjoidGVzdCJ9.kZMyrmbYKBR8ZfvqACAfDcbm9D1bC72dPfDsD-k6K_Y";
        JwtParser jwtParser = Jwts.parser();
        jwtParser.setSigningKey("longklxs");
        Jws<Claims> jwsClaims = jwtParser.parseClaimsJws(token);
        Claims claims = jwsClaims.getBody();
        System.out.println(claims);

    }

    @Test
    public void testExpireDateJwt(){
        long mills = 1*60*1000;
        long current = System.currentTimeMillis();
        Date date = new Date(current + mills);

        JwtBuilder builder = Jwts.builder();

        builder.setId("111");
        builder.setSubject("老王");
        builder.setIssuedAt(new Date());
        builder.setExpiration(date);

        builder.signWith(SignatureAlgorithm.HS256,"longklxs");
        String token = builder.compact();
        System.out.println(token);
    }

    @Test
    public void testClaims(){
        Map<String, Object> map = new HashMap<>();
        map.put("role","admin1");
        map.put("test","test");
        JwtBuilder builder = Jwts.builder();
        builder.setId("111");
        builder.setSubject("老王");
        builder.setIssuedAt(new Date());
//        builder.setClaims(map);
        builder.addClaims(map);

        builder.signWith(SignatureAlgorithm.HS256,"longklxs");
        String token = builder.compact();
        System.out.println(token);
    }
}
