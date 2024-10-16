import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import javax.swing.*;

/**
 * Implementierung der Speicherstrategie mit Gson zur Serialisierung und
 * Deserialisierung von WortTrainer-Objekten in eine JSON-Datei.
 */
class GsonSpeichern implements Speichern {
    /**
     * Der Dateipfad, unter dem die JSON-Datei gespeichert und gelesen wird.
     */
    private static final String DATEI_PFAD = "worttrainer.json";

    /**
     * Das Gson-Objekt, das für die Serialisierung und Deserialisierung verwendet wird.
     */
    private Gson gson;

    /**
     * Konstruktor für die GsonSpeichern-Klasse. Initialisiert das Gson-Objekt mit Pretty-Printing
     * zur besseren Lesbarkeit der gespeicherten JSON-Datei.
     */
    public GsonSpeichern() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Speichert den aktuellen Zustand des WortTrainers in eine JSON-Datei.
     *
     * @param trainer Das WortTrainer-Objekt, das gespeichert werden soll.
     */
    @Override
    public void save(WortTrainer trainer) {
        try (FileWriter writer = new FileWriter(DATEI_PFAD)) {
            gson.toJson(trainer, writer);  // Konvertiert den WortTrainer in JSON und schreibt ihn in die Datei
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler beim Speichern der Daten.");  // Zeigt eine Fehlermeldung an, wenn ein Fehler auftritt
        }
    }

    /**
     * Lädt den WortTrainer aus der JSON-Datei. Falls ein Fehler beim Laden auftritt,
     * wird ein neues WortTrainer-Objekt erstellt.
     *
     * @return Das geladene WortTrainer-Objekt oder ein neues Objekt, falls das Laden fehlschlägt.
     */
    @Override
    public WortTrainer load() {
        try (FileReader reader = new FileReader(DATEI_PFAD)) {
            return gson.fromJson(reader, WortTrainer.class);  // Liest die JSON-Datei und konvertiert sie in ein WortTrainer-Objekt
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler beim Laden der Daten. Eine neue Datei wird erstellt.");  // Zeigt eine Fehlermeldung an, wenn ein Fehler auftritt
            return new WortTrainer();  // Gibt einen neuen WortTrainer zurück, falls das Laden fehlschlägt
        }
    }
}
