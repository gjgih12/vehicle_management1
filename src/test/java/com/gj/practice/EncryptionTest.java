package com.gj.practice;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 加密
 * @author ：gengjian
 * @date ：2020/6/28
 */
public class EncryptionTest {

    @Test
    public void testEncrypt() throws Exception {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");          // 加密的算法，这个算法是默认的
        config.setPassword("Uy&75loRd%mDssx");                        // 加密的密钥，随便自己填写，很重要千万不要告诉别人
        standardPBEStringEncryptor.setConfig(config);
        String plainText = "123";         //自己的密码
        String encryptedText = standardPBEStringEncryptor.encrypt(plainText);
        System.out.println(encryptedText);
    }

    @Test
    public void testDe() throws Exception {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("Uy&75loRd%mDssx");
        standardPBEStringEncryptor.setConfig(config);
        String encryptedText = "viDKjiz4PpRtkOJp06GhSw==";   //加密后的密码
        String plainText = standardPBEStringEncryptor.decrypt(encryptedText);
        System.out.println(plainText);
    }



    @Test
    public void baseTest() throws UnsupportedEncodingException {

        String str = "123abc";

        byte[] sa = str.getBytes("UTF-8");

        System.out.println("前===  "+sa);

        Base64.Encoder encoder = Base64.getEncoder();
        String sb = encoder.encodeToString(sa);

        System.out.println("后===  "+sb);

        byte[] sb2 = sb.getBytes("UTF-8");

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] sa2 = decoder.decode(sb2);

        String str2 = new String(sa2,"UTF-8");

        System.out.println("===  "+str2);

    }


}
