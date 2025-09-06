#include <iostream>
#include <vector>
#include <cmath>
#include <limits>
#include <string>

using namespace std;

vector<int> verificar(int num) {
    vector<int> primos;

    for (int n = 2; n <= num; n++) {
        bool primo = true;

        for (int i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                primo = false;
                break;
            }
        }

        if (primo) {
            primos.push_back(n);
        }
    }

    return primos;
}

int main() {
    string entrada;

    while (true) {
        cout << "Digite um numero inteiro maior que 1: ";
        cin >> entrada;

        if (entrada == "00") {
            cout << "Saindo do programa..." << endl;
            break;
        }

        int numero;
        try {
            numero = stoi(entrada);
        } catch (...) {
            cout << "ERRO! Digite um valor inteiro valido." << endl;
            continue;
        }

        if (numero < 2) {
            cout << "ERRO! Digite um numero maior que 1." << endl;
            continue;
        }

        vector<int> primos = verificar(numero);

        cout << "\n--------- Resultados ---------" << endl;
        cout << "Numero informado: " << numero << endl;
        cout << "Numeros primos ate " << numero << ": ";
        for (int p : primos) {
            cout << p << " ";
        }
        cout << endl;
        cout << "Quantidade de numeros primos: " << primos.size() << endl;
        cout << "----------------------------\n" << endl;
    }

    return 0;
}
