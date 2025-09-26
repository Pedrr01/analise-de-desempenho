import java.io.*;
import java.util.*;

public class MergeSort {
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i=0; i<n1; i++) L[i] = arr[l+i];
        for (int j=0; j<n2; j++) R[j] = arr[m+1+j];

        int i=0, j=0, k=l;
        while (i<n1 && j<n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i<n1) arr[k++] = L[i++];
        while (j<n2) arr[k++] = R[j++];
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
        mergeSort(numeros, 0, numeros.length-1);
        long end = System.nanoTime();
        long tempo = (end - start) / 1_000_000;
        long mem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;

        FileWriter fw = new FileWriter("arq-saida02.txt");
        for (int num : numeros) fw.write(num + " ");
        fw.close();

        System.out.println("Tempo: " + tempo + " ms | Memória: " + mem + " KB");
    }
}
