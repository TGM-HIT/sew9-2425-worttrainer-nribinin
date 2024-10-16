/**
 * Speicherstrategie-Interface für das Speichern und Laden von WortTrainer
 * @author Nathaniel Ribinin
 * @version 2024-10-16
 */
interface Speichern {
    /**
     * Speichern von einer WortTrainer Liste
     * @param trainer Der Trainer
     */
    void save(WortTrainer trainer);

    /**
     * Laden eines WortTrainers basiert auf einer Liste
     * @return den Trainer
     */
    WortTrainer load();
}