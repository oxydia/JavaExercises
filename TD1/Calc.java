import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le premier entier.");
		int value1 = scanner.nextInt();
        System.out.println("Entrez le deuxième entier.");
		int value2 = scanner.nextInt();
        System.out.println("Addition : " + ( value1+value2));
        System.out.println("Multiplication : " + (value1*value2));
        System.out.println("Soustraction : " + (value1-value2));
        System.out.println("Quotien : " + (value1/value2));
        System.out.println("Reste : " + (value1%value2));
	}
}
