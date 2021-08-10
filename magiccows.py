# Programação dinâmica / Dynamic programming

import math

MAX_DAYS = 50


def soma_linha(tabela, day, max_cows):
    res = 0
    for i in range(max_cows+1):
        res += tabela[day][i]

    return res


max_cows, number_farms, ndays = input().split()
max_cows = int(max_cows)
number_farms = int(number_farms)
ndays = int(ndays)

tabela = [[0 for _ in range(max_cows + 1)] for _ in range(MAX_DAYS + 1)]

cows = []

for i in range(1, number_farms+1):
    var = int(input())
    tabela[0][var] += 1

days = []
for i in range(ndays):
    var = int(input())
    days.append(var)

for day in range(MAX_DAYS):
    for i in range(1, max_cows + 1):
        if i <= max_cows / 2:
            tabela[day + 1][i * 2] += tabela[day][i]
        else:
            tabela[day + 1][i] += tabela[day][i] * 2

for day in days:
    res = soma_linha(tabela, day, max_cows)
    print(res)
