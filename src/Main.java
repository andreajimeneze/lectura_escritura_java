import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        String directorio = "carpetaNueva";
        String fichero = "fichero.txt";

        ArrayList<String> texto = new ArrayList<String>();
        texto.add("Perro");
        texto.add("Gato");
        texto.add("Juan");
        texto.add("Daniel");
        texto.add("Juan");
        texto.add("Gato");
        texto.add("Perro");
        texto.add("Camila");
        texto.add("Daniel");
        texto.add("Camila");

        crearArchivo(directorio, fichero);

        escribirArchivo(directorio, fichero, texto);

    }

    public static void crearArchivo (String nombreDirectorio, String nombreArchivo ) {

        File directorio = new File("src", nombreDirectorio);
        File fichero = new File(directorio, nombreArchivo);

        try {

            if(directorio.exists() == false) {
                directorio.mkdirs();
            } else {
                System.out.println("Directorio ya existe, continúe generando el archivo...");
            }


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

    public static void escribirArchivo (String directorio, String archivo, ArrayList<String> texto) throws IOException {

        File dir = new File("src/" + directorio);
        File fichero = new File("src/" + directorio, archivo);
        System.out.println(fichero);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fichero))) {
            for (String linea : texto) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo en el archivo: " + e.getMessage());
        }

    }
}