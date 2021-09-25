package cittadini;
public class Cittadini
{
    public static void main(String[] args)
    {
        new Cittadini().exec();
    }
    
    private void exec()
    {
        new LogIn(this).setVisible(true);
    }
    
    public void registraCittadino()
    {
        
    }
    
    public boolean accedi(String cfiscale, String password)
    {
        return false;
    }
}
