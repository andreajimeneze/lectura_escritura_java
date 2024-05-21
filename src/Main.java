import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

        buscarTexto(directorio, fichero, texto);

    }

    public static void crearArchivo (String nombreDirectorio, String nombreArchivo ) {

        File directorio = new File("src", nombreDirectorio);
        File fichero = new File(directorio, nombreArchivo);

        try {
            if(directorio.exists() == false) {
                directorio.mkdirs();
            } else {
                System.out.println("Directorio ya existe, continúe generando el fichero...");
            }

            if (fichero.exists() == false) {
                fichero.createNewFile();
                System.out.println("Archivo creado correctamente");
            } else {
                System.out.println("Fichero ya existe");
            }
        } catch (IOException e) {
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

    public static void buscarTexto (String directorio, String nombreFichero, ArrayList<String> texto) {

        File dir = new File("src/" + directorio);
        File fichero = new File("src/" + directorio, nombreFichero);

        if(!fichero.exists()) {
            System.out.println("El fichero ingresado no existe");
        } else {
            try (FileReader fr = new FileReader(fichero);
                 BufferedReader bufferedReader = new BufferedReader(fr);
                 Scanner sc = new Scanner(System.in);
            ) {

                String linea;
                int contador = 0;

                System.out.println("Ingrese una palabra para verificar si existe en el fichero: ");
                String palabraBuscada = formatWord(sc.nextLine());
                Boolean palabraEncontrada = false;

                while((linea = bufferedReader.readLine()) != null) {
                    if(linea.contains(palabraBuscada)) {
                       palabraEncontrada = true;
                       contador++;
                    }
                }

                if(palabraEncontrada)  {
                    System.out.println("La palabra " + palabraBuscada + " está en el fichero " + contador + " veces");

                } else {
                    System.out.println("La palabra " + palabraBuscada + " NO ESTÁ en el fichero");
                }

            } catch (FileNotFoundException e) {
                System.err.println("El fichero no fue encontrado: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Ocurrió un error al leer el fichero: " + e.getMessage());
            }

        }
    }

    private static String formatWord(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}