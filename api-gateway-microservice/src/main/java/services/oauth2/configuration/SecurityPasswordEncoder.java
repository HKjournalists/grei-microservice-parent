package services.oauth2.configuration;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import services.oauth2.helper.ToolSecurityPbkdf2;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/**
 * 兼容老系统加密方法
 *
 * @author 刘佳兴
 */
@SuppressWarnings("deprecation")
public class SecurityPasswordEncoder implements PasswordEncoder {

    @Override
    public String encodePassword(String rawPass, Object salt) {
        if(null == salt) return rawPass;

        byte[] encryptedPassword = new byte[0];
        byte[] saltBytes = (byte[]) salt;
        try {
            encryptedPassword = ToolSecurityPbkdf2.getEncryptedPassword(rawPass, saltBytes);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return Arrays.toString(encryptedPassword);
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        byte[] rawPassBytes = encodePassword(rawPass, salt).getBytes();
        byte[] encPassBytes = encPass.getBytes();
        return Arrays.equals(rawPassBytes, encPassBytes);
    }

}
