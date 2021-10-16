package comm;
import java.io.File;
public interface directory
{
    public final String pathData = "data" + File.separator;
    public final String pathCentriDati = pathData + "CentriVaccinali.dati.txt";
    public final String pathVacinati = pathData + "Vaccinati" + File.separator;
    public final String pathCittadiniDati = pathData + "CittadiniRegistrati.dati.txt";
}
