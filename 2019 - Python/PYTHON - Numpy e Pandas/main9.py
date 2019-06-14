import pandas as pd
import requests
import json
url = 'https://api.github.com/repos/pandas-dev/pandas/issues'
resp = requests.get(url)
responsedata = resp.text
jsondata = json.loads(responsedata)
data = pd.DataFrame(jsondata)
print(data)