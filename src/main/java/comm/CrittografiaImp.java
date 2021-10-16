
package comm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrittografiaImp implements Crittografia
{
    @Override
    public String encrypt(String pas)
    {
        String s;
        s = null;
        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pas.getBytes());
            s = String.valueOf(m.digest()); 
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println("Errore nella cryptografia password");
        }
        return s;
    }
}
