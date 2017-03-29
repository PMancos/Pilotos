

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cargar {

    static Scanner tc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String escuderia;
        String piloto;
        int numGrandePremiosGanados;
        boolean activo;
        char condicion;

        try {
            FileOutputStream fos = new FileOutputStream("premios.dat", true);
            DataOutputStream dos = new DataOutputStream(fos);
        do{
            
            System.out.print("Introduce el nombre la escuderia: ");
            escuderia = tc.nextLine();

            
            
            System.out.print("Introduce el piloto: ");
            piloto = tc.nextLine();

            

            System.out.print("Introduce el numero de grandes premios ganados: ");
            numGrandePremiosGanados = tc.nextInt();

            

            System.out.print("Esta en activo? (s/n): ");
            tc.nextLine();
            condicion = tc.nextLine().charAt(0);

            if (condicion == 's') {
                activo = true;
            } else {
                activo = false;
            }

        dos.writeUTF(escuderia);
        dos.writeUTF(piloto);
        dos.writeInt(numGrandePremiosGanados);
        dos.writeBoolean(activo);

            
            
            System.out.print("¿Deseas insertar otro piloto? (s/n): ");
            condicion=tc.nextLine().charAt(0);
            
        }while(condicion=='s');

        
        
        dos.close();
        fos.close();
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(cargar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(leer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
