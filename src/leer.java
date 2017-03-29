
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class leer {

    public static void main(String[] args) {

        String escuderia;
        String piloto;
        int numGrandesPremios;
        boolean activo;

        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream("premios.dat");
            dis = new DataInputStream(fis);

            System.out.println("Escuderia: \tPiloto: \tNumero de grandes premios: \tActivo: ");
            System.out.println("------------------------------------------------------------------------");

            while (true) {
                escuderia = dis.readUTF();
                piloto = dis.readUTF();
                numGrandesPremios = dis.readInt();
                activo = dis.readBoolean();

                System.out.println(escuderia + "  \t" + piloto + "\t\t\t" + numGrandesPremios + "\t\t\t" + activo);
            }
        } catch (EOFException ex) {
            System.out.println("_________________");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(leer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(leer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dis.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(leer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
