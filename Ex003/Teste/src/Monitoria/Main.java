package Monitoria;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> cadastro = new ArrayList<>();
        cadastro.add(new Engenheiro("Pedro", 58, "Engenherio"));
        cadastro.add(new Engenheiro("Lucas", 78, "Engenherio"));

        System.out.println(cadastro);
    }
}
