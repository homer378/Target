import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        List<Integer> dias = new ArrayList<>();
        List<Double> valor = new ArrayList<>();
        double media;

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/helpfiles/dados.json")) {
            JSONArray valores = (JSONArray) jsonParser.parse(reader);
            for (int i = 0; i < valores.size(); i++) {
                JSONObject dado = (JSONObject) valores.get(i);
                dias.add(Integer.parseInt(dado.get("dia").toString()));
                valor.add(Double.parseDouble(dado.get("valor").toString()));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        media = calculoTotal(valor) / 30;
        System.out.printf("A media das vendas foi de: R$ %.2f%n",media);
        maiorDia(valor, dias);
        menorDia(valor,dias);
        maiorMedia(valor,media);
    }
    private static Double calculoTotal(List<Double> lista) {
        return lista.stream().mapToDouble(Double::doubleValue).sum();
    }
    private static void maiorDia(List<Double> valores, List<Integer> dias) {
        double max = valores.get(0);
        int index = 0;
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i) > max) {
                max = valores.get(i);
                index = i;
            }
        }
        System.out.printf("Maior faturamento foi: R$ %.2f no dia %s%n",max,dias.get(index));
    }
    private static void menorDia(List<Double> valores, List<Integer> dias) {
        double min = valores.get(0);
        int index = 0;
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i) != 0 && valores.get(i) < min) {
                min = valores.get(i);
                index = i;
            }
        }
        System.out.printf("Menor faturamento foi: R$ %.2f no dia %s%n",min,dias.get(index));
    }
    private static void maiorMedia(List<Double> valores,Double media){
        int diaSuperior = 0;
        for (int i = 0; i < valores.size() ; i++) {
            if (valores.get(i) > media){
                diaSuperior++;
            }
        }
        System.out.println("A quantidade de dias em que o faturamento foi maior que a média é: "+diaSuperior);
    }
}
