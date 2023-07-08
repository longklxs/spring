import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5HashTest {
    public static void main(String[] args) {
        String rawPassword = "1234";
        Md5Hash md5Hash = new Md5Hash(rawPassword,"com",5);
        String password = md5Hash.toBase64();
        System.out.println(password);
    }
}
