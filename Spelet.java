import java.util.Scanner;

public class Spelet {
    private final Scanner scanner;
    private final String ord;
    private char[] hemligtOrd;

    public Spelet(Scanner scanner, String word) {
        this.scanner = scanner;                          //returnerar just .denna scanner, återkommande nedan
        this.ord = word.toLowerCase();                   //gör allt till lowercase så den ignorerar stora+små skillnader, återkommande på flera ställen i programmet
        this.hemligtOrd = new char[this.ord.length()];   //väljer nytt spel med nytt hemligt ord
        for (int i = 0; i < this.ord.length(); i++) {    //loop igenom ordet
            this.hemligtOrd[i] = '_';
        }
    }

    public void play() {         //spelet!! :D
        int gissningarKvar = 7;
        boolean gameOver = false;

        while (!gameOver) {                                                      //första huvudloop, medan spelet !ej är slut.
            System.out.print("----------------------------------");
            System.out.println(" Gissningar kvar " + gissningarKvar);
            System.out.println("Ord: " + String.valueOf(hemligtOrd));
            System.out.print("Gissa på en(1) bokstav: ");


            String Gissning = getGissning(); if (Gissning == null) continue;    //allmän String för gissning

            boolean correctGuess = getRättGissning(Gissning);                   //rätt gissning i extrh metod
            gissningarKvar = getFelGissning(gissningarKvar, correctGuess);      //fel gissning i extrh metod

            gameOver = isSpelSlut(String.valueOf(hemligtOrd).equals(ord), "Du vann! Ordet var ", gameOver);         //vinst! av spel. extrh metod
            gameOver = isSpelSlut(gissningarKvar == 0, "Du förlorade tyvärr! Ordet var ", gameOver);   //förlust, tyvärr.. extrh metod
        }
    }

    private String getGissning() {              //metod för hantera gissningarna
        String Gissning = scanner.next().toLowerCase();
        if (Gissning.length() != 1 || !Character.isLetter(Gissning.charAt(0))) {
            System.out.println("Det är inte ett korrekt val, försök igen!");
            return null;
        }
        return Gissning;
    }

    private boolean getRättGissning(String Gissning) {     //metod för rätt gissning,
        char letter = Gissning.charAt(0);

        boolean rättGissning = false;
        for (int i = 0; i < ord.length(); i++) {
            if (ord.charAt(i) == letter) { hemligtOrd[i] = letter; rättGissning = true;}
        }
        return rättGissning;             //är den rätt gör inget spec, returnera bara fortsätt samma 'rätt' loop igen
    }

    private static int getFelGissning(int gissningarKvar, boolean felGissning) {   //metod för fel gissning,
        if (!felGissning) {
            gissningarKvar--;             //Är gissning fel, minska antal gissningar kvar med -1
        }
        return gissningarKvar;            //returnera uppdatera gissningarKvar
    }

    private boolean isSpelSlut(boolean gissningarKvar, String x, boolean gameOver) {
        if (gissningarKvar) {        //kontrollerar dekl. gissningarKvar längre ovan, med om gissningar är nere 0, spelet slut tyvärr.
            System.out.println(x + ord + ".");
            gameOver = true;
        }

        return gameOver;
    }
}