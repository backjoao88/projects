import sqlite3
import numpy

import pandas as pd
import numpy as np 

data = numpy.random.rand(100, 4)
 
conn = sqlite3.connect('atv10.db')   

c = conn.cursor()

c.execute('SELECT * FROM LIVRO')

lista = c.fetchall()

arrayNp = np.array(lista)

dataset = pd.DataFrame({'ID':arrayNp[:,0],'Descricao':arrayNp[:,1],'Autor':arrayNp[:,2]})

print('--- DATASET FROM TABLE LIVRO ---')

print(dataset)
