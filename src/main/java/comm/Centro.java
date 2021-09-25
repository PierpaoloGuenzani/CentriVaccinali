package comm;

import java.io.Serializable;

public class Centro implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected String nome, via, comune, provincia;
    protected int ncivico, cap;
    protected TipologiaCentro tipo;
    
    public Centro()
    {
        
    }

    public Centro(String nome, String via, String comune, String provincia, int ncivico, int cap, TipologiaCentro tipo)
    {
        this.nome = nome;
        this.via = via;
        this.comune = comune;
        this.provincia = provincia;
        this.ncivico = ncivico;
        this.cap = cap;
        this.tipo = tipo;
    }

    public Centro(String nome, int cap)
    {
        this.nome = nome;
        this.cap = cap;
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

    public String getVia()
    {
        return via;
    }

    public void setVia(String via)
    {
        this.via = via;
    }

    public String getComune()
    {
        return comune;
    }

    public void setComune(String comune)
    {
        this.comune = comune;
    }

    public String getProvincia()
    {
        return provincia;
    }

    public void setProvincia(String provincia)
    {
        this.provincia = provincia;
    }

    public int getNcivico()
    {
        return ncivico;
    }

    public void setNcivico(int ncivico)
    {
        this.ncivico = ncivico;
    }

    public int getCap()
    {
        return cap;
    }

    public void setCap(int cap)
    {
        this.cap = cap;
    }

    public TipologiaCentro getTipo()
    {
        return tipo;
    }

    public void setTipo(TipologiaCentro tipo)
    {
        this.tipo = tipo;
    }
    
}