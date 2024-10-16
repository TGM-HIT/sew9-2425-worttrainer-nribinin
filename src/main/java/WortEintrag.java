import java.net.URL;
import java.net.MalformedURLException;

/**
 * Wörter mit URL werden gespeichert und auf Gültigkeit geprüft
 * @author Nathaniel Ribinin
 * @version 19-09-2022
 * */
public class WortEintrag {
	private String wort;
	private String url;

	public WortEintrag(){
		this.setWort("Batman");
		this.setUrl("https://images.desenio.com/zoom/wb0125-8batman-portrait50x70-55544-10774.jpg");
	}

	public WortEintrag(String wort, String url) {
		if (wort != null) {
			this.wort = wort;
		} else{
			throw new NullPointerException("Bitte gültiges Wort eingeben!");
		}
		if (this.checkUrl(url)){
			this.url = url;
		} else{
			throw new IllegalArgumentException("Bitte gib einen gültigen Link ein!");
		}
	}

	/**
	 * Ein Wort wird erstellt und darf nicht null bzw. muss min. 2 Buchstaben haben
	 * @param wort nimmt ein Wort als Parameter
	 */
	public void setWort(String wort){
		if(wort != null && wort.length() > 2) {
			this.wort = wort;
		}
		else{
			throw new IllegalArgumentException("Eingabe ist ungültig");
		}
	}

	/**
	 * Wort wird für andere Klassen zurückgegeben
	 * @return das Wort
	 */
	public String getWort(){
		return this.wort;
	}

	/**
	 * Wenn URL nicht gültig oder null ist dann wird eine Exception
	 * geworfen, ansonsten wird URL returnt
	 * @param url nimmt ein URl als Parameter
	 */
	public void setUrl(String url){
		if(url==null){
			throw new IllegalArgumentException("URL darf nicht leer sein!");
		}
		else if(checkUrl(url) == false){
			throw new IllegalArgumentException("Die URL ist leider nicht gueltig!");
		}
		else{
			this.url = url;
		}
	}

	/**
	 * URL wird geprüft
	 * @param url nimmt ei URL als Parameter
	 * @return true wenn der Check erfolgreich war, false wenn nicht
	 */
	public static boolean checkUrl(String url){
		try {
			new URL(url);
			return true;
		}
		catch (MalformedURLException e) {
			return false;
		}
	}
	public String getUrl(){
		return this.url;
	}
	/**
	 * Die Endausgabe soll jedes Wort mit einem ";" getrennt werden
	 * @return die Endausgabe
	 */
	@Override
	public String toString() {
		return this.wort + "\n" + this.url;
	}
}

