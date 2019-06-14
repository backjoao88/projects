# Considerando a série abaixo, imprima os valores únicos na série
import pandas as pd
obj = pd.Series(['c', 'a', 'd', 'a', 'a', 'b', 'b', 'c', 'c', 'a', 'b'])
uniques = obj.unique()
print(uniques)