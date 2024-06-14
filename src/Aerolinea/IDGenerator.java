package Aerolinea;
import java.io.*;

//Lucas: Clase para generar ID unicos, lo usamos para generar id de reservas. Cada vez que se crea una reserva se llama al metodo
// IDGenerator y este devuelve un id.
    public class IDGenerator {
        private static final String FILE_PATH = "last_id.txt";  // Ruta del archivo donde se guarda el último ID
        private static int lastId;  // Variable estática para mantener el último ID generado

        // Bloque estático para cargar el último ID desde un archivo cuando la clase se carga
        static {
            try {
                File file = new File(FILE_PATH);
                if (file.exists()) {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    lastId = Integer.parseInt(reader.readLine());
                    reader.close();
                } else {
                    lastId = 0; // Inicializa lastId en 0 si no existe el archivo
                }
            } catch (IOException e) {
                e.printStackTrace();
                lastId = 0; // Fallback a 0 en caso de error
            }
        }

        // Método sincronizado para generar un ID único
        public static int generateID() {
            lastId++;
            saveLastId(); // Guarda el último ID en el archivo
            return lastId;
        }

        // Método privado para guardar el último ID en un archivo
        private static void saveLastId() {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
                writer.write(String.valueOf(lastId));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
