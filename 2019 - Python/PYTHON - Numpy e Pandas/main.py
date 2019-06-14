from random import randint
from timeit import default_timer as timer
import numpy as np



lista = []
array = np.random.randint(10, size=1000000)

for i in range(1000000):
    lista.append(randint(1, 10))


def multiplicarListaPorDois():
    for i in range(1000000):
        lista[i] = lista[i] * 2


inicioLista = timer()
multiplicarListaPorDois()
fimLista    = timer()


inicioArr = timer()
array = array * 2
fimArr    = timer()

print('Lista: %f ' % (fimLista - inicioLista))
print('Array: %f ' % (fimArr - inicioArr))


