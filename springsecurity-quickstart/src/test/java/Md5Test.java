import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Test {

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        定义原始密码
        String rowPasswrod = "123456";
//        1.对原始密码加密
        MessageDigest md5 = MessageDigest.getInstance("md5");
//        2.转成字符串输出 直接输出不行：因为有不可见字符
        byte[] digest = md5.digest(rowPasswrod.getBytes());
//        3.定义编码对象
        BASE64Encoder encoder = new BASE64Encoder();
//        4.编辑密码
        String encoding = encoder.encode(digest);
//        5.输出
        System.out.println(encoding);
    }
}
