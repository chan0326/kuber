package com.example.demo.common.component;

import com.example.demo.user.model.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
@Log4j2
@Component
public class JwtProvider {
   private String issuer;
    private  final SecretKey secretKey ;
    Instant expiredDate = Instant.now().plus(1, ChronoUnit.DAYS);


    public  JwtProvider(@Value("${jwt.secret}") String secretKey){
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }
    public  String createToken(UserDto userDto){
        String token = Jwts.builder()
                .issuer(issuer)
                .signWith(secretKey)
                .expiration(Date.from(expiredDate))
                .subject("erichgamma")
                .claim("username",userDto.getUsername())
                .claim("job",userDto.getJob())
                .claim("userId",userDto.getId())

                .compact();
        log.info("로그인 성공으로 발급된 토근: "+token);
        return token;

    }

}
