import platform
import psutil
import time

def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    meio = len(arr) // 2
    esquerda = merge_sort(arr[:meio])
    direita = merge_sort(arr[meio:])
    return merge(esquerda, direita)

def merge(esq, dir):
    res = []
    i = j = 0
    while i < len(esq) and j < len(dir):
        if esq[i] < dir[j]:
            res.append(esq[i]); i += 1
        else:
            res.append(dir[j]); j += 1
    res.extend(esq[i:]); res.extend(dir[j:])
    return res

with open("arq.txt", "r") as f:
    numeros = list(map(int, f.read().split()))

print("=== Python Merge Sort ===")
print("Versão:", platform.python_version())
print("Processador:", platform.processor())
print("Sistema:", platform.system(), platform.release())

start = time.time()
res = merge_sort(numeros.copy())
end = time.time()
tempo = (end - start) * 1000
mem = psutil.Process().memory_info().rss / 1024

with open("arq-saida02.txt", "w") as f:
    f.write(" ".join(map(str, res)))

print(f"Tempo: {tempo:.2f} ms | Memória: {mem:.2f} KB")
