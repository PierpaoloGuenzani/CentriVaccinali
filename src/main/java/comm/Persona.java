package comm;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

public class Persona implements Serializable
{
    protected String nome, cognome, email, password;
    protected final String codiceFiscale;
    protected Calendar dataNascita;

    public Persona(String codiceFiscale, String password)
    {
        this.codiceFiscale = codiceFiscale;
        this.password = encrypt(password);
    }
    
    protected static String encrypt(String pas)
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
            System.err.println("Errore mentre la cryptografia password");
        }
        return s;
    }
    
    public boolean confronta(Persona p)
    {
        if(p.codiceFiscale.equals(this.codiceFiscale) && p.password.equals(this.password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Getter e Setter

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public String getCodiceFiscale()
    {
        return codiceFiscale;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String controllo,String password)
    {
        if(encrypt(controllo).equals(this.password))
        {
            this.password = encrypt(password);
        }
    }

    public Calendar getDataNascita()
    {
        return dataNascita;
    }

    public void setDataNascita(Calendar dataNascita)
    {
        this.dataNascita = dataNascita;
    }
    
    public void setDataNascita(int giorno, int mese, int anno)
    {
        this.dataNascita.set(anno, mese, giorno);
    }
    
}