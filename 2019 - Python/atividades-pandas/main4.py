import numpy as np 

array = np.random.rand(3,3)

print('Array')
print(array)

print('Linhas')
print(array[0])
print(array[1])
print(array[2])

print('Colunas')
print(array.transpose()[0])
print(array.transpose()[1])
print(array.transpose()[2])

