import sys
import time

def adicionar(lista, valor, pos):
    if pos <= 0:
        lista.insert(0, valor)
    elif pos >= len(lista):
        lista.append(valor)
    else:
        lista.insert(pos, valor)


def remover(lista, valor):
    if valor in lista:
        lista.remove(valor)


def imprimir(lista):
    print(" ".join(map(str, lista)))


def carregar_valores(linha):
    # remover o BOM
    return list(map(int, linha.replace("\ufeff", "").strip().split()))


def main(arquivo):
    caminho = rf"D:\PedroPC\Documents\AnDesempenho\Ex002\{arquivo}"

    with open(caminho, "r", encoding="utf-8") as f:
        linhas = f.readlines()


    lista = carregar_valores(linhas[0])

    qtd_acoes = int(linhas[1].replace("\ufeff", "").strip())

    for i in range(2, 2 + qtd_acoes):
        partes = linhas[i].replace("\ufeff", "").strip().split()
        acao = partes[0]

        if acao == "P":
            imprimir(lista)
        elif acao == "A":
            num = int(partes[1])
            pos = int(partes[2])
            adicionar(lista, num, pos)
        elif acao == "R":
            num = int(partes[1])
            remover(lista, num)


if __name__ == "__main__":
    if len(sys.argv[1]) != 11:
        print("ERRO! adicione um arquivo válido.")
    else:
        arquivo = sys.argv[1]
        main(arquivo)
    tempo = time.time()
    print(f"Tempo de execução: {tempo} segundos")
