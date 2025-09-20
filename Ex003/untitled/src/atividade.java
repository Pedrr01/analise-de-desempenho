import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class atividade {


    public static void adicionar(List<Integer> lista, int valor, int pos) {
        if (pos <= 0) {
            lista.add(0, valor);
        } else if (pos >= lista.size()) {
            lista.add(valor);
        } else {
            lista.add(pos, valor);
        }
    }

    public static void remover(List<Integer> lista, int valor) {
        lista.remove(Integer.valueOf(valor));
    }

    public static void imprimir(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
            if (i < lista.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static List<Integer> carregarValores(String linha) {
        List<Integer> valores = new ArrayList<>();
        linha = linha.replace("\uFEFF", "").trim(); // para remove o BOM
        String[] partes = linha.split("\\s+");
        for (String parte : partes) {
            valores.add(Integer.parseInt(parte));
        }
        return valores;
    }

    public static void main(String[] args) {

        String caminho = "D:\\PedroPC\\Documents\\AnDesempenho\\Ex003\\untitled\\src\\teste02.txt";

        // Início do time
        long inicio = System.nanoTime();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            List<Integer> lista = carregarValores(linha);

            linha = br.readLine();
            int qtdAcoes = Integer.parseInt(linha.replace("\uFEFF", "").trim());

            for (int i = 0; i < qtdAcoes; i++) {
                linha = br.readLine().replace("\uFEFF", "").trim();
                String[] partes = linha.split("\\s+");
                String acao = partes[0];

                switch (acao) {
                    case "P":
                        imprimir(lista);
                        break;
                    case "A":
                        int num = Integer.parseInt(partes[1]);
                        int pos = Integer.parseInt(partes[2]);
                        adicionar(lista, num, pos);
                        break;
                    case "R":
                        num = Integer.parseInt(partes[1]);
                        remover(lista, num);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Fim do time
        long fim = System.nanoTime();
        double segundos = (fim - inicio) / 1_000_000_000.0;

        System.out.printf("Tempo de execução: %.6f segundos%n", segundos);
    }
}
