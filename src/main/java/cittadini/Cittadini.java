package cittadini;

import comm.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Cittadini implements directory
{
    protected File cit, centri;
    
    public static void main(String[] args)
    {
        new Cittadini().exec();
    }
    
    public Cittadini()
    {
        cit = new File(pathCittadiniDati);
        centri = new File(pathCentriDati);
    }
    
    private void exec()
    {
        new LogIn(this).setVisible(true);
    }
    
    public boolean registraCittadino(Persona p) throws Exception
    {
        FileInputStream i = new FileInputStream(cit);
        ObjectInputStream io = new ObjectInputStream(i);
        /*FileOutputStream o = new FileOutputStream(cit);
        ObjectOutputStream oo = new ObjectOutputStream(o);*/
        return false;
    }
    
    public boolean accedi(String cFiscale, String password) throws Exception
    {
        boolean flag = false;
        Persona p1, p2;
        p2 = new Persona(cFiscale, password);
        FileInputStream input = new FileInputStream(cit);
        ObjectInputStream inputObject = new ObjectInputStream(input);
        do
        {
            p1 = (Persona)inputObject.readObject();
            if(p1.confronta(p2))
            {
                flag = true;
            }
        }
        while(p1 != null || flag == false);
        return flag;
    }
}
