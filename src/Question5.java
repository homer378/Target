import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com a palavra");
        String nome = sc.nextLine();
        String reverso = "";

        for (int i = nome.length() - 1; i >= 0; i--) {
            reverso = reverso + nome.charAt(i);
        }
        System.out.println(reverso);
    }
}
