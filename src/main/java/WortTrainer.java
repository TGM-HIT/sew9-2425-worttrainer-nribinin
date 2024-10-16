import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WortTrainer {

	private List<WortEintrag> wortListe;

	private WortEintrag wortEintrag;

	private int zaehlen;

	private int istRichtig;
	private int istFalsch;

	public WortTrainer() {
		this.wortListe = new ArrayList<>();
		wortListe.add(new WortEintrag("Superman", "https://static.wikia.nocookie.net/marvel_dc/images/a/a5/Superman_Vol_5_1_Textless.jpg/revision/latest/scale-to-width/360?cb=20180711061148"));
		wortListe.add(new WortEintrag("The Flash", "https://static.wikia.nocookie.net/the-flash/images/d/d0/FLASH-promo.jpg/revision/latest?cb=20150704154524&path-prefix=de"));
		wortListe.add(new WortEintrag("Green Arrow", "https://static.wikia.nocookie.net/marvel_dc/images/3/3e/Oliver_Queen_Arrow_005.png/revision/latest?cb=20171104055930"));
		wortListe.add(new WortEintrag("Spongebob Schwammkopf", "https://static.wikia.nocookie.net/cartoons/images/e/ed/Profile_-_SpongeBob_SquarePants.png/revision/latest?cb=20240420115914"));
		wortListe.add(new WortEintrag("Naruto", "https://static.wikia.nocookie.net/denaruto3/images/3/3d/Narutogesamt.png/revision/latest/scale-to-width/360?cb=20110705043058&path-prefix=de"));
	}

	public void setZaehlen(int zaehlen) {
		if(zaehlen < 0)
			throw new IllegalArgumentException("Negative Count is not possible");
		this.zaehlen = zaehlen;
	}

	public int getZaehlen() {
		return this.istRichtig;
	}

	public void setIstRichtig(int istRichtig) {
		if(istRichtig < 0)
			throw new IllegalArgumentException("Negative Count is not possible");
		this.istRichtig = istRichtig;
	}

	public int getIstRichtig() {
		return this.istRichtig;
	}
	public int getIstFalsch(){
		return this.istFalsch;
	}

	public void getRandomWortEintrag(){
		if (!wortListe.isEmpty()) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(wortListe.size()); // generates a random index
			wortEintrag = wortListe.get(randomIndex); // sets the randomly selected pair
		} else {
			throw new NullPointerException("Leere Liste!");
		}
	}

	public List<WortEintrag> getWortListe() {
		return this.wortListe;
	}

	public boolean rateWort(String wort){
		this.zaehlen++;
		if(wort.toLowerCase().equals(this.wortEintrag.getWort().toLowerCase())){
			this.istRichtig++;
			this.getRandomWortEintrag();
			return true;
		} else {
			this.istFalsch++;
			return false;
		}
	}


	public WortEintrag getWortEintrag() {
		return this.wortEintrag;
	}

	public String getAktuellerStand(){
		return "Stats - Gesamt: " + this.zaehlen + ", Richtig: " + this.istRichtig + ", Falsch: " + this.istFalsch;
	}
}
