package comm;

import java.util.Calendar;

public class Vacinato extends Persona
{
    protected Calendar dataVacinazione;
    protected Vacino tipo;

    public Vacinato(String codiceFiscale, String password)
    {
        super(codiceFiscale, password);
    }

}
