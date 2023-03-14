import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  //minimal main som bara ha en deklarering för scanner
        Meny meny = new Meny(scanner);             //ny meny-initiering
        meny.visaMeny();                           //som därifrån tar sina vidare val, ifrån visaMeny(metod) i Meny-klass
    }
}

