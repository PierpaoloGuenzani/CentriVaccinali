package cittadini;

import comm.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Cittadini
{

    public final String pathData = "data" + File.separator;
    public final String pathCentriDati = pathData + "CentriVaccinali.dati.txt";
    public final String pathVacinati = pathData + "Vaccinati";
    public final String pathCittadiniDati = pathData + "CittadiniRegistrati.dati.txt";
    protected File cittadini, centri, vaccinati;

    /*protected final FileInputStream inputFileCit, inputFileCentri, inputFileVac;
    protected final FileOutputStream outputFileCit, outputFileCentri, outputFileVac;*/
    public static void main(String[] args) throws IOException
    {
        new Cittadini().visualizzaCentri();
    }

    public Cittadini() throws IOException
    {
        cittadini = new File(pathCittadiniDati);
        if(!cittadini.exists())
        {
            cittadini.createNewFile();
        }
        //outputFileCit = new FileOutputStream(cittadini);

        centri = new File(pathCentriDati);
        if(!centri.exists())
        {
            centri.createNewFile();
        }
        //inputFileCentri = new FileInputStream(centri);
        //outputFileCentri = new FileOutputStream(centri);

        vaccinati = new File(pathVacinati);
        if(!vaccinati.isDirectory())
        {
            vaccinati.mkdir();
        }
        /*inputStreamObj = new ObjectInputStream(inputFileCit);
        outputStreamObj = new ObjectOutputStream(outputFileCit);*/
    }

    private void exec()
    {
        new LogIn(this).setVisible(true);
    }

    public boolean registraCittadino(Persona p) throws IOException
    {
        FileOutputStream outputFileCit = null;
        ObjectOutputStream outputStreamObj = null;
        boolean flag = false;
        try
        {
            outputFileCit = new FileOutputStream(cittadini);
            outputStreamObj = new ObjectOutputStream(outputFileCit);
            outputStreamObj.writeObject(p);
            outputStreamObj.flush();
            flag = true;
        }
        catch(FileNotFoundException ex)
        {
        } //impossibile il file viene creato nel costruttore
        finally
        {
            try
            {
                outputStreamObj.close();
            }
            catch(IOException ex)
            {
            }
            try
            {
                outputFileCit.close();
            }
            catch(IOException ex)
            {
            }
        }
        return flag;
    }

    public boolean accedi(String cFiscale, String password) throws IOException
    {
        FileInputStream inputFileCit = new FileInputStream(cittadini);
        ObjectInputStream inputStreamObj = new ObjectInputStream(inputFileCit);
        boolean flag = false;
        Persona p1, p2;
        p1 = null;
        p2 = new Persona(cFiscale, password);
        while(inputFileCit.available() > 0) // >= o >?
        {
            try
            {
                p1 = (Persona) inputStreamObj.readObject();
            }
            catch(ClassNotFoundException ex)
            {
            }
            if(p1.confronta(p2))
            {
                flag = true;
                break;
            }
        }
        try
        {
            inputStreamObj.close();
        }
        catch(IOException ex){}
        try
        {
            inputFileCit.close();
        }
        catch(IOException ex){}
        return flag;
    }

    public LinkedList<Centro> cercaCentroCap(int cap) throws IOException
    {
        LinkedList<Centro> lcentri = new LinkedList<Centro>();
        FileInputStream inputFileCentri = new FileInputStream(centri);
        ObjectInputStream inputStreamObj = new ObjectInputStream(inputFileCentri);
        while(inputFileCentri.available() > 0)
        {
            try
            {
                Centro c = (Centro) inputStreamObj.readObject();
                if(c.getCap() == cap)
                {
                    lcentri.add(c);
                }
            }
            catch(ClassNotFoundException ex)
            {
            }
        }
        try
        {
            inputStreamObj.close();
            inputFileCentri.close();
        }
        catch(IOException ex)
        {
        } // vuol dire che è gia chiuso
        return lcentri;
    }

    public void visualizzaCentroCap(int cap)
    {
        FileInputStream inputFileCentri = null;
        ObjectInputStream inputStreamObj = null;
        try
        {
            inputFileCentri = new FileInputStream(centri);
            inputStreamObj = new ObjectInputStream(inputFileCentri);
            while(inputFileCentri.available() > 0)
            {
                Centro c = (Centro) inputStreamObj.readObject();
                if(c.getCap() == cap)
                {
                    System.out.println(c.toString());
                }
            }
        }
        catch(FileNotFoundException ex)
        {
        }
        catch(IOException ex)
        {
            System.out.println("nessun centro disponibile");
        }
        catch(ClassNotFoundException ex)
        {
        }
        finally
        {
            try
            {
                inputStreamObj.close();
                inputFileCentri.close();
            }
            catch(IOException ex)
            {
            } // vuol dire che è gia chiuso
        }
    }

    public LinkedList<Centro> cercaCentroCitta(String citta) throws IOException
    {
        LinkedList<Centro> lcentri = new LinkedList<Centro>();
        FileInputStream inputFileCentri = new FileInputStream(centri);
        ObjectInputStream inputStreamObj = new ObjectInputStream(inputFileCentri);
        while(inputFileCentri.available() > 0)
        {
            try
            {
                Centro c = (Centro) inputStreamObj.readObject();
                if(c.getComune().equals(citta))
                {
                    lcentri.add(c);
                }
            }
            catch(ClassNotFoundException ex)
            {
            }
        }
        try
        {
            inputStreamObj.close();
            inputFileCentri.close();
        }
        catch(IOException ex)
        {
        } // vuol dire che è gia chiuso
        return lcentri;
    }

    public void visualizzaCentroCitta(String citta)
    {
        FileInputStream inputFileCentri = null;
        ObjectInputStream inputStreamObj = null;
        try
        {
            inputFileCentri = new FileInputStream(centri);
            inputStreamObj = new ObjectInputStream(inputFileCentri);
            while(inputFileCentri.available() > 0)
            {
                Centro c = (Centro) inputStreamObj.readObject();
                if(c.getComune().equals(citta))
                {
                    System.out.println(c.toString());
                }
            }
        }
        catch(FileNotFoundException ex)
        {
        }
        catch(IOException ex)
        {
            System.out.println("nessun centro disponibile");
        }
        catch(ClassNotFoundException ex)
        {
        }
        finally
        {
            try
            {
                inputStreamObj.close();
                inputFileCentri.close();
            }
            catch(IOException ex)
            {
            } // vuol dire che è gia chiuso
        }
    }

    public LinkedList<Centro> listaCentri() throws IOException
    {
        LinkedList<Centro> lcentri = new LinkedList<Centro>();
        FileInputStream inputFileCentri = new FileInputStream(centri);
        ObjectInputStream inputStreamObj = new ObjectInputStream(inputFileCentri);
        do
        {
            try
            {
                lcentri.add((Centro) inputStreamObj.readObject());
            }
            catch(ClassNotFoundException ex)
            {
            }
        }
        while(inputFileCentri.available() > 0);
        try
        {
            inputStreamObj.close();
            inputFileCentri.close();
        }
        catch(IOException ex)
        {
        } // vuol dire che è gia chiuso
        return lcentri;
    }

    public void visualizzaCentri()
    {
        FileInputStream inputFileCentri = null;
        ObjectInputStream inputStreamObj = null;
        try
        {
            inputFileCentri = new FileInputStream(centri);
            inputStreamObj = new ObjectInputStream(inputFileCentri);
            while(inputFileCentri.available() > 0)
            {
                Centro c = (Centro) inputStreamObj.readObject();
                System.out.println(c.toString());
            }
        }
        catch(FileNotFoundException ex)
        {
        }
        catch(IOException ex)
        {
            System.out.println("nessun centro disponibile");
        }
        catch(ClassNotFoundException ex)
        {
        }
        finally
        {
            try
            {
                inputStreamObj.close();
                inputFileCentri.close();
            }
            catch(IOException ex)
            {
            } // vuol dire che è gia chiuso
        }
    }
}
//System.out.println("debug");
