import java.util.Scanner;
public class Meny {
    private Scanner scanner;   //en fast scanner, då många menyval här
    public Meny(Scanner scanner) {
        this.scanner = scanner;}

    public void visaMeny() {
        while (true) {
            //-------Printar ut textvalen för menyn (i en loop) ------.
            System.out.println("Välkommen till spelet Hänga Gubbe!");
            System.out.println("----------------------------------");
            System.out.println("1. Starta Spelet");
            System.out.println("2. Avsluta");
            System.out.println("----------------------------------");
            System.out.print("Gör ditt väl här bredvid: ");

            //------Startar scanner för menyval (i villkor)-------
            int choice = scanner.nextInt();

            if (choice == 1) { playGame();}       //val 1 == starta spel, + kopplat till metod spela igen, nedan.
            else if (choice == 2) { System.out.println("Hejrå!"); System.exit(0); } //val 2 == avsluta spel
            else { System.out.println("Det är inte ett giltigt val. prova en gång till."); }     //felaktigt val == prnta text
            }
    }

    private void playGame() {                //metod för spela igen
        boolean playAgain = true;            //=sant

        while (playAgain) {
            Ordlista ordlista = new Ordlista();                           //initiera metoden med val för nytt spel/nya ord+lista igen
            Spelet game = new Spelet(scanner, ordlista.getRandomWord());  //nytt spel, ny scanner, ny ordlista.somhämtar nytt randomword
            game.play();

            System.out.print("Vill du spela igen? (j/n): ");
            String playAgainInput = scanner.next().toLowerCase();         //scanner spela igen

            if (playAgainInput.equals("j")) { playAgain = true; }    //om j, spela igen = sant
            else { System.out.println("Tack för att du spelade"); visaMeny();}  //annars tack för att du spelade, samt återvänd till första startmenyn igen.
        }
    }
}
