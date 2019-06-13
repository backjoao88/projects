import numpy as np

xarr = np.array([1.1, 1.2, 1.3, 1.4, 1.5])
yarr = np.array([2.1, 2.2, 2.3, 2.4, 2.5])
cond = np.array([True, False, True, True, False])

for i in range(len(xarr)):
    if(cond[i]):
        print(xarr[i])
    else:
        print(yarr[i])