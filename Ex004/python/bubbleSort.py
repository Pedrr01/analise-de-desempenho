import platform
import psutil
import time

def bubble_sort(lista):
    n = len(lista)
    for i in range(n):
        for j in range(0, n - i - 1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
    return lista

# abre o arquivo em modo leitura (separa os números por espaço e transforma em uma lista)
with open("arq.txt", "r") as f:
    numeros = list(map(int, f.read().split()))

print("Versão:", platform.python_version()) # versão do Python
print("Processador:", platform.processor()) # processador
print("Sistema:", platform.system(), platform.release()) # SO e a versão

# Faz uma copia da lista e chama a função
start = time.time()
res = bubble_sort(numeros.copy())
end = time.time()

tempo = (end - start) * 1000  
mem = psutil.Process().memory_info().rss / 1024  

with open("arq-saida.txt", "w") as f:
    f.write(" ".join(map(str, res)))

print(f"Tempo: {tempo:.2f} ms | Memória: {mem:.2f} KB")
