import java.io.*;
import java.util.*;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/arq.txt"));
        List<Integer> lista = new ArrayList<>();
        while (sc.hasNextInt()) lista.add(sc.nextInt());
        sc.close();
        int[] numeros = lista.stream().mapToInt(i->i).toArray();

        System.out.println("Versão: " + System.getProperty("java.version"));
        System.out.println("SO: " + System.getProperty("os.name"));
        System.out.println("CPU(s): " + Runtime.getRuntime().availableProcessors());

        long start = System.nanoTime();
        bubbleSort(numeros);
        long end = System.nanoTime();
        long tempo = (end - start) / 1_000_000;
        long mem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;

        FileWriter fw = new FileWriter("arq-saida01.txt");
        for (int num : numeros) fw.write(num + " ");
        fw.close();

        System.out.println("Tempo: " + tempo + " ms | Memória: " + mem + " KB");
    }
}

