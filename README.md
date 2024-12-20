# sew9-2425-worttrainer-nribinin

## Projektbeschreibung
Dieses Projekt ist ein Worttrainer, der Benutzern hilft, verschiedene Wörter zu lernen und zu üben. Es verwendet eine grafische Benutzeroberfläche (GUI), um die Wörter anzuzeigen und die Benutzerinteraktionen zu verwalten.

## Verwendete Technologien
- **Programmiersprache:** Java
- **Build-Tool:** Gradle

## Projektstruktur
- `src/main/java/Main.java`: Hauptklasse zum Starten der Anwendung.
- `worttrainer.json`: JSON-Datei, die die Liste der Wörter und deren zugehörige URLs enthält.

## Installation und Ausführung
1. **Projekt klonen:**
   ```sh
   git clone https://github.com/nribinin/sew9-2425-worttrainer-nribinin.git
   cd sew9-2425-worttrainer-nribinin
    ```
## Abhängigkeiten installieren:  
./gradlew build
## Anwendung starten:  
./gradlew run
## JSON-Datei worttrainer.json
Die Datei worttrainer.json enthält die Wörter, die im Worttrainer verwendet werden. Ein Beispielinhalt der Datei sieht wie folgt aus:
```json
{
  "wortListe": [
    {
      "wort": "Superman",
      "url": "https://static.wikia.nocookie.net/marvel_dc/images/a/a5/Superman_Vol_5_1_Textless.jpg/revision/latest/scale-to-width/360?cb\u003d20180711061148"
    },
    {
      "wort": "The Flash",
      "url": "https://static.wikia.nocookie.net/the-flash/images/d/d0/FLASH-promo.jpg/revision/latest?cb\u003d20150704154524\u0026path-prefix\u003dde"
    },
    {
      "wort": "Green Arrow",
      "url": "https://static.wikia.nocookie.net/marvel_dc/images/3/3e/Oliver_Queen_Arrow_005.png/revision/latest?cb\u003d20171104055930"
    },
    {
      "wort": "Spongebob Schwammkopf",
      "url": "https://static.wikia.nocookie.net/cartoons/images/e/ed/Profile_-_SpongeBob_SquarePants.png/revision/latest?cb\u003d20240420115914"
    },
    {
      "wort": "Naruto",
      "url": "https://static.wikia.nocookie.net/denaruto3/images/3/3d/Narutogesamt.png/revision/latest/scale-to-width/360?cb\u003d20110705043058\u0026path-prefix\u003dde"
    }
  ],
  "wortEintrag": {
    "wort": "The Flash",
    "url": "https://static.wikia.nocookie.net/the-flash/images/d/d0/FLASH-promo.jpg/revision/latest?cb\u003d20150704154524\u0026path-prefix\u003dde"
  },
  "zaehlen": 0,
  "istRichtig": 0,
  "istFalsch": 0
}
```
Autor
Nathaniel Ribinin
Lizenz
Dieses Projekt ist unter der MIT-Lizenz lizenziert. Weitere Informationen finden Sie in der LICENSE-Datei.