package cittadini;

import comm.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;;

public class Cittadini implements directory
{
    protected File cittadini, centri, vaccinati;
    protected FileInputStream inputFileCit, inputFileCentri, inputFileVac;
    protected FileOutputStream outputFileCit, outputFileCentri, outputFileVac;
    protected ObjectInputStream inputStreamObj;
    protected ObjectOutputStream outputStreamObj;

    public static void main(String[] args) throws IOException
    {
        new Cittadini().exec();
    }

    public Cittadini() throws IOException
    {
        cittadini = new File(pathCittadiniDati);
        centri = new File(pathCentriDati);
        if(!cittadini.exists())
        {
            cittadini.createNewFile();
        }
        inputFileCit = new FileInputStream(cittadini);
        outputFileCit = new FileOutputStream(cittadini);
        if(!centri.exists())
        {
            centri.createNewFile();
        }
        /*inputStreamObj = new ObjectInputStream(inputFileCit);
        outputStreamObj = new ObjectOutputStream(outputFileCit);*/
    }

    private void exec()
    {
        new LogIn(this).setVisible(true);
    }

    public boolean registraCittadino(Persona p) throws Exception
    {
        return false;
    }

    public boolean accedi(String cFiscale, String password) throws Exception
    {
        boolean flag = false;
        Persona p1, p2;
        p2 = new Persona(cFiscale, password);
        do
        {
            p1 = (Persona) inputStreamObj.readObject();
            if(p1.confronta(p2))
            {
                flag = true;
            }
        }
        while(p1 != null || flag == false);
        return flag;
    }
}
