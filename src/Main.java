import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {

        String directorio = "carpetaNueva";
        String fichero = "fichero.txt";
        crearArchivo(directorio, fichero);

    }

    public static void crearArchivo (String nombreDirectorio, String nombreArchivo ) {

        File directorio = new File("src/" + nombreDirectorio);
        File fichero = new File("src/" + nombreDirectorio, nombreArchivo);


            if(directorio.exists() == false) {
                directorio.mkdirs();
            } else {
                System.out.println("Directorio ya existe, continúe generando el archivo...");
            }

        try {
            if (fichero.exists() == false) {
                fichero.createNewFile();
                System.out.println("Archivo creado correctamente");
            } else {
                System.out.println("Fichero ya existe");
            }
        } catch (IOException e) {
            // Manejar la excepción aquí
            System.out.println("Error creando archivo: " + e.getMessage());
        }
    }
}