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
    
    return list(map(int, linha.strip().split()))


def main():
    
    caminho = r"D:\PedroPC\Documents\AnDesempenho\Ex002\teste.txt"

    try:
        with open(caminho, "r", encoding="utf-8") as f:
            linhas = f.readlines()

        # Para primeira linha de valores
        lista = carregar_valores(linhas[0])

        # Para a quantidade de ações
        qtd_acoes = int(linhas[1].strip())

        # Execução 
        for i in range(2, 2 + qtd_acoes):
            partes = linhas[i].strip().split()
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

    except FileNotFoundError:
        print("Arquivo não encontrado!")
    except Exception as e:
        print("Erro:", e)

if __name__ == "__main__":
    main()
