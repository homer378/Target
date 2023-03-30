import java.util.Scanner;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com o número a ser consultado: ");
        int num = sc.nextInt();

        int b = 1;
        int c = 0;
        boolean n = false;

        if (num == 0 || num == 1) {
            System.out.println(num + " Está na sequência");
        } else {
            for (int a = 0; c <= num; c = a + b) {
                a = b;
                b = c;
                //se quiser ver a sequência,descomente o trexo abaixo.
                //System.out.println(c);
                if (num == c) {
                    System.out.println(num + " Está na sequência");
                    n = true;
                }
            }
        }

        if (!n) {
            System.out.println(num + " Não está na sequência");
        }
    }
}
