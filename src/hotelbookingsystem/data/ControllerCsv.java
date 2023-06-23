package hotelbookingsystem.data;

import java.io.*;

public class ControllerCsv {

    public void processFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");

            // Remueve los puntos de la cédula
            String ciWithoutDots = values[0].replace(".", "");

            // Reemplaza el valor en el array con la cédula sin puntos
            values[0] = ciWithoutDots;

            // Escribe la línea procesada al archivo temporal
            writer.write(String.join(",", values));
            writer.newLine();
        }

        reader.close();
        writer.close();

        // Borra el archivo original
        if (!inputFile.delete()) {
            throw new IOException("Failed to delete original file: " + inputFile);
        }

        // Renombra el archivo temporal para reemplazar el archivo original
        if (!tempFile.renameTo(inputFile)) {
            throw new IOException("Failed to rename temp file: " + tempFile);
        }
    }
}
