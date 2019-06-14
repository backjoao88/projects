import numpy as np

arr = np.random.randint(10, size=10)

np.savetxt('teste.txt', arr)

teste = np.loadtxt('teste.txt', dtype=int)

print(teste)