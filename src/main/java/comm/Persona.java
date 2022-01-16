package comm;

import java.io.Serializable;
import java.util.Calendar;

public class Persona implements Serializable
{
    protected String nome, cognome, email, password; //4 byte * carattere (15 nome , 20 cognome, 50 email, 15 password) = 60 + 80 + 200 + 60 = 400 byte
    protected final String codiceFiscale; // (16 caratteri) = 64 byte
    protected Calendar dataNascita; // long = 8 byte
    //totale 472 byte per persona * 60000000 popolazione italiana = 28320000000 = 27009 MB = 26,3 GB
    private static Crittografia c;

    public Persona(String codiceFiscale, String password)
    {
        this.codiceFiscale = codiceFiscale;
        this.password = c.encrypt(password);
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

    public void setPassword(String password,String nuovaPassword)
    {
        if(c.encrypt(password).equals(this.password))
        {
            this.password = c.encrypt(nuovaPassword);
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