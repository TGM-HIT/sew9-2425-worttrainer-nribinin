package nribinin;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Benutzeroberfläche zum Verwenden des Worttrainers
 * @autor Nathaniel Ribinin
 * @version 2024-10-16
 */
public class GUI {
    private WortTrainer wortTrainer;
    private Speichern speichern;

    private boolean firstguess;

    /**
     * Standardkonstruktor für die GUI. Trainer wird aus einer Datei geladen.
     */
    public GUI() {
        this.speichern = new GsonSpeichern();
        this.wortTrainer = this.speichern.load();
        firstguess = true;
    }

    /**
     * Worttrainer wird gestartet und zeigt ihn mittels JOptionPane an.
     */
    public void start() {
        this.wortTrainer.getRandomWortEintrag();
        boolean letzterVersuchErfolgreich = false;

        while (true) {
            String wort = zeigeStatistikUndBildUndAbfrage(letzterVersuchErfolgreich);
            firstguess = false;
            if (wort == null || wort.isEmpty()) {
                break;
            }

            letzterVersuchErfolgreich = this.wortTrainer.rateWort(wort);
        }

        // Speichern des Zustands vor dem Beenden
        this.speichern.save(wortTrainer);
        JOptionPane.showMessageDialog(null, "Programm beendet. Daten wurden gespeichert.");
    }

    /**
     * Zeigt Statistik, Bild und Abfrage in einem Panel an.
     */
    public String zeigeStatistikUndBildUndAbfrage(boolean letzterVersuchErfolgreich) {
        WortEintrag aktuellesPaar = wortTrainer.getWortEintrag();
        String bildURL = aktuellesPaar.getUrl();

        // Baut die Nachricht zusammen
        String nachricht = "<html>" + this.wortTrainer.getAktuellerStand();
        if (firstguess) {
        } else if (!letzterVersuchErfolgreich){
            nachricht += "<br>Der letzte Versuch war falsch.</html>";
        } else {
            nachricht += "<br>Der letzte Versuch war richtig!</html>";
        }

        // Erstellt das Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Fügt die Statistik als JLabel hinzu
        JLabel labelText = new JLabel(nachricht);
        panel.add(labelText);

        try {
            // Ladet und skaliere das Bild
            URL url = new URL(bildURL);
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImg);

            // Fügt das Bild als JLabel hinzu
            JLabel labelImage = new JLabel(icon);
            panel.add(labelImage);
        } catch (Exception e) {
            // Fallback, falls das Bild nicht geladen werden kann
            panel.add(new JLabel("(Bild konnte nicht geladen werden)"));
        }

        // Fügt das Eingabefeld für das Wort hinzu
        JTextField wortFeld = new JTextField(20);
        panel.add(new JLabel("Bitte das Wort eingeben:"));
        panel.add(wortFeld);

        // Zeigt das Panel in einem JOptionPane-Dialog an
        int option = JOptionPane.showConfirmDialog(null, panel, "Bild und Wortabfrage", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Gibt das eingegebene Wort zurück oder null, wenn der Nutzer abbricht
        if (option == JOptionPane.OK_OPTION) {
            return wortFeld.getText();
        } else {
            return null; // Benutzer hat abgebrochen
        }
    }

    public WortTrainer getTrainer() {
        return wortTrainer;
    }
}