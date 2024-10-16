import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Die Klasse WortTrainer repräsentiert einen Trainer, der eine Liste von
 * Wort-Bild-Paaren speichert und es ermöglicht, Wörter zu raten und die Statistik zu verfolgen.
 */
public class WortTrainer {

	/**
	 * Liste der verfügbaren Wort-Bild-Paare.
	 */
	private List<WortEintrag> wortListe;

	/**
	 * Aktuell ausgewähltes Wort-Bild-Paar.
	 */
	private WortEintrag wortEintrag;

	/**
	 * Zähler für die Gesamtanzahl der Versuche.
	 */
	private int zaehlen;

	/**
	 * Zähler für die Anzahl der richtigen Antworten.
	 */
	private int istRichtig;

	/**
	 * Zähler für die Anzahl der falschen Antworten.
	 */
	private int istFalsch;

	/**
	 * Konstruktor der WortTrainer-Klasse. Initialisiert die Liste der Wort-Bild-Paare.
	 */
	public WortTrainer() {
		this.wortListe = new ArrayList<>();
		// Beispielhafte Wort-Bild-Paare werden zur Liste hinzugefügt
		wortListe.add(new WortEintrag("Superman", "https://static.wikia.nocookie.net/marvel_dc/images/a/a5/Superman_Vol_5_1_Textless.jpg/revision/latest/scale-to-width/360?cb=20180711061148"));
		wortListe.add(new WortEintrag("The Flash", "https://static.wikia.nocookie.net/the-flash/images/d/d0/FLASH-promo.jpg/revision/latest?cb=20150704154524&path-prefix=de"));
		wortListe.add(new WortEintrag("Green Arrow", "https://static.wikia.nocookie.net/marvel_dc/images/3/3e/Oliver_Queen_Arrow_005.png/revision/latest?cb=20171104055930"));
		wortListe.add(new WortEintrag("Spongebob Schwammkopf", "https://static.wikia.nocookie.net/cartoons/images/e/ed/Profile_-_SpongeBob_SquarePants.png/revision/latest?cb=20240420115914"));
		wortListe.add(new WortEintrag("Naruto", "https://static.wikia.nocookie.net/denaruto3/images/3/3d/Narutogesamt.png/revision/latest/scale-to-width/360?cb=20110705043058&path-prefix=de"));
	}

	/**
	 * Setzt den Zähler für die Anzahl der Versuche.
	 *
	 * @param zaehlen Der neue Zählerwert.
	 * @throws IllegalArgumentException wenn der Zähler negativ ist.
	 */
	public void setZaehlen(int zaehlen) {
		if (zaehlen < 0)
			throw new IllegalArgumentException("Negative Count is not possible");
		this.zaehlen = zaehlen;
	}

	/**
	 * Gibt die Anzahl der Versuche zurück.
	 *
	 * @return Der Zähler für richtige Antworten.
	 */
	public int getZaehlen() {
		return this.zaehlen;
	}

	/**
	 * Setzt den Zähler für die Anzahl der richtigen Antworten.
	 *
	 * @param istRichtig Der neue Zählerwert für richtige Antworten.
	 * @throws IllegalArgumentException wenn der Zähler negativ ist.
	 */
	public void setIstRichtig(int istRichtig) {
		if (istRichtig < 0)
			throw new IllegalArgumentException("Negative Count is not possible");
		this.istRichtig = istRichtig;
	}

	/**
	 * Gibt die Anzahl der richtigen Antworten zurück.
	 *
	 * @return Anzahl der richtigen Antworten.
	 */
	public int getIstRichtig() {
		return this.istRichtig;
	}

	/**
	 * Gibt die Anzahl der falschen Antworten zurück.
	 *
	 * @return Anzahl der falschen Antworten.
	 */
	public int getIstFalsch() {
		return this.istFalsch;
	}

	/**
	 * Wählt ein zufälliges Wort-Bild-Paar aus der Liste der verfügbaren Paare aus.
	 * Wirft eine NullPointerException, wenn die Liste leer ist.
	 */
	public void getRandomWortEintrag() {
		if (!wortListe.isEmpty()) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(wortListe.size()); // Generiert einen zufälligen Index
			wortEintrag = wortListe.get(randomIndex); // Setzt das zufällig ausgewählte Paar
		} else {
			throw new NullPointerException("Leere Liste!");
		}
	}

	/**
	 * Gibt die Liste der verfügbaren Wort-Bild-Paare zurück.
	 *
	 * @return Liste der Wort-Bild-Paare.
	 */
	public List<WortEintrag> getWortListe() {
		return this.wortListe;
	}

	/**
	 * Überprüft, ob das eingegebene Wort korrekt ist. Aktualisiert die Zähler für
	 * richtige und falsche Antworten entsprechend und wählt bei einer richtigen Antwort
	 * ein neues zufälliges Wort-Bild-Paar.
	 *
	 * @param wort Das zu ratende Wort.
	 * @return true, wenn das Wort richtig ist, sonst false.
	 */
	public boolean rateWort(String wort) {
		this.zaehlen++;
		if (wort.toLowerCase().equals(this.wortEintrag.getWort().toLowerCase())) {
			this.istRichtig++;
			this.getRandomWortEintrag();
			return true;
		} else {
			this.istFalsch++;
			return false;
		}
	}

	/**
	 * Gibt das aktuell ausgewählte Wort-Bild-Paar zurück.
	 *
	 * @return Das aktuelle Wort-Bild-Paar.
	 */
	public WortEintrag getWortEintrag() {
		return this.wortEintrag;
	}

	/**
	 * Gibt den aktuellen Stand der Versuche, richtigen und falschen Antworten als String zurück.
	 *
	 * @return Eine String-Repräsentation des aktuellen Stands.
	 */
	public String getAktuellerStand() {
		return "Stats - Gesamt: " + this.zaehlen + ", Richtig: " + this.istRichtig + ", Falsch: " + this.istFalsch;
	}
}
