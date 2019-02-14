import time
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

sns.set()


def group_sum(start, vol, target):  #T(n) = 2(n-1) + c
    if start == len(vol):   #c1
        return target == 0  #c2

    return group_sum(start + 1, vol, target) or \
           group_sum(start + 1, vol, target - vol[start])   #2(n-1) + c3


data = []

for num_items in range(10, 31):
    print("Num Items: {}".format(num_items))
    start = time.time()
    group_sum(0, list(range(num_items)), 12)
    end = time.time()

    data.append([num_items, end - start])

df = pd.DataFrame(data, columns=['num_items', 'elap_time'])
df.plot(x='num_items', y='elap_time')
plt.show()
