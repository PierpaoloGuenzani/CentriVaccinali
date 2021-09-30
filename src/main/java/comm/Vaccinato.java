package comm;

import java.io.Serializable;
import java.util.Calendar;

public class Vaccinato implements Serializable
{
    private String cFiscale;
    protected Calendar dataVacinazione;
    protected Vacino tipo;
    
    public Vaccinato(String cF)
    {
        cFiscale = cF;
    }
    
}
