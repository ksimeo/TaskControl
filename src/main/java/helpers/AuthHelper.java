package helpers;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 * Created by Avega on 02.06.14.
 */
public class AuthHelper
{
    public static String String2Hash(String str) throws NoSuchProviderException, NoSuchAlgorithmException {

        Security.addProvider(new BouncyCastleProvider());

        MessageDigest mda = MessageDigest.getInstance("SHA-512", "BC");

        return Base64.encode(mda.digest(str.getBytes()));
    }
}
