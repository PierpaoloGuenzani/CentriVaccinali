package comm;
public interface directory
{
    public final String pathData = "data" + java.io.File.pathSeparator;
    public final String pathCentriDati = pathData + "CentriVaccili.dati.txt";
    public final String pathVacinati = pathData + "Vaccinati" + java.io.File.pathSeparator;
    public final String pathCittadiniDati = pathData + "Cittadini_Registrati.dati.txt";
}
