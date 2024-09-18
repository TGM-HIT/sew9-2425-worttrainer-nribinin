import java.util.ArrayList;
import java.util.List;

public class WortTrainer {

	private List<WortEintrag> wortListe;

	private WortEintrag eintrag;

	private int zaehlen;

	private int istRichtig;

	public void Worttrainer(List<WortEintrag> wortListe) {
		this.wortListe = new ArrayList<>();
	}

	public WortEintrag randomGenerator(){
		int generator = (int)(Math.random() * wortListe.size());
		this.eintrag = wortListe.add(generator);
		return list.indexEingabe(generator);
	}

	public void setZaehlen(int zaehlen) {

	}

	public int getZaehlen() {
		return 0;
	}

	public void setIstRichtig(int istRichtig) {

	}

	public int getIstRichtig() {
		return 0;
	}

	public List<WortEintrag> getWortListe() {
		return null;
	}

	public boolean check(String wort) {
		return false;
	}

	public boolean checkIgnore(String wort) {
		return false;
	}

	public WortEintrag getEintrag() {
		return null;
	}

	public void setEintrag(WortEintrag eintrag) {

	}

}
