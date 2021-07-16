package com.gj.modules.oauth.jwt;

import com.gj.common.exception.BaseTwoException;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

/**
 * @author: baron
 * @date: 2020-01-13 23:12
 **/
public class JWTHS256 {

    /**
     * 创建秘钥
     */
    private static final byte[] SECRET = "6MNSobBRCHGIO0fS6MNSobBRCHGIO0fS".getBytes();

    /**
     * 过期时间5秒
     */
    private static final long EXPIRE_TIME = 1000 * 500;


    public static void main(String[] args) {
        //String gengjian = buildJWT("gengjian");
        //System.out.println(gengjian);

        String s = vaildToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkb2kiLCJBQ0NPVU5UIjoiZ2VuZ2ppYW4iLCJpc3MiOiJodHRwOlwvXC93d3cuZG9pZHVveWkuY29tIiwiZXhwIjoxNTk5NTQ2NTg0fQ.32omCmLdkLA6PgmVsHqGW6jN_cTSBh0CSLQ70vxcsks\n");
        System.out.println(s);
    }

    /**
     * 生成Token
     * @param account
     * @return
     */
    public static String buildJWT(String account) {
        try {
            /**
             * 1.创建一个32-byte的密匙
             */
            MACSigner macSigner = new MACSigner(SECRET);
            /**
             * 2. 建立payload 载体
             */
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject("doi")
                    .issuer("http://www.doiduoyi.com")
                    .expirationTime(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                    .claim("ACCOUNT",account)
                    .build();

            /**
             * 3. 建立签名
             */
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(macSigner);

            /**
             * 4. 生成token
             */
            String token = signedJWT.serialize();
            return token;
        } catch (KeyLengthException e) {
            e.printStackTrace();
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static String vaildToken(String token ) {
        try {
            SignedJWT jwt = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET);
            //校验是否有效
            if (!jwt.verify(verifier)) {
                throw new BaseTwoException("Token 无效");
            }

            //校验超时
            Date expirationTime = jwt.getJWTClaimsSet().getExpirationTime();
            if (new Date().after(expirationTime)) {
                throw new BaseTwoException("Token 已过期");
            }

            //获取载体中的数据
            Object account = jwt.getJWTClaimsSet().getClaim("ACCOUNT");
            //是否有openUid
            if (Objects.isNull(account)){
                throw new BaseTwoException("账号为空");
            }
            return account.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JOSEException e) {
            e.printStackTrace();
        }
        return null;
    }


}