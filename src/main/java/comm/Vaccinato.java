package comm;

import java.io.Serializable;
import java.util.Calendar;

public class Vaccinato implements Serializable
{
    protected String cFiscale;
    protected Calendar dataVaccinazione;
    protected Vaccino tipo;
    
    public Vaccinato(String cF, Vaccino t)
    {
        cFiscale = cF;
        tipo = t;
        dataVaccinazione = Calendar.getInstance();
    }

    public String getcFiscale()
    {
        return cFiscale;
    }

    public void setcFiscale(String cFiscale)
    {
        this.cFiscale = cFiscale;
    }

    public Calendar getDataVaccinazione()
    {
        return dataVaccinazione;
    }

    public void setDataVaccinazione(Calendar dataVaccinazione)
    {
        this.dataVaccinazione = dataVaccinazione;
    }

    public Vaccino getTipo()
    {
        return tipo;
    }

    public void setTipo(Vaccino tipo)
    {
        this.tipo = tipo;
    }
}