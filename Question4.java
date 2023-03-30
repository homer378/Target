public class Question4 {
    public static void main(String[] args) {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double ou = 19849.53;
        double soma = sp + rj + mg + es + ou;

        System.out.println("Porcentagem de São Paulo: " + calporcentagem(sp, soma));
        System.out.println("Porcentagem de Rio de Janeiro: " + calporcentagem(rj, soma));
        System.out.println("Porcentagem de Minas Gerais: " + calporcentagem(mg, soma));
        System.out.println("Porcentagem de Espirito Santo: " + calporcentagem(es, soma));
        System.out.println("Porcentagem de outros estados: " + calporcentagem(ou, soma));
    }
    public static String calporcentagem(double p, double soma) {
        return Math.round((p * 100) / soma) + "%";
    }
}
