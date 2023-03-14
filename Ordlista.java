import java.util.Random;

public class Ordlista {
    private static final String[] arrayOrd = {    //simplare array, bla för enklare överblick och tillägg + bort
            "Kalle",
            "Pelle",
            "Mjölkchoklad",
            "Batteri",
            "Skruvdragare",
            "Ännumeramjölkchoklad",
            "Schweizernötchoklad",
            "Påsemedmackori",
            "Cocacola",
            "Lokaburkmedjordgubbar&granatäpple",
            "Okejnågraenklaordocksådå",
            "Hund",
            "Bil",
            "Katt",
            "Tupp",
            "Höna",
            "Kyckling",
            "Maraboupapperpåmjölkchokladen",
            "Chokladkaka",
            "Visitkort"
    };

    public String getRandomWord() {          //hämtar ett random ord ifrån vanliga Arrayen ovan, mha imp java.util.Random;
        Random random = new Random();
        return arrayOrd[random.nextInt(arrayOrd.length)];      //och returnerar den, till arrayen igen
    }
}
