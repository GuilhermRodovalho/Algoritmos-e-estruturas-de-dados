
"""
Programação dinâmica / Dynamic programming
Esse algoritmo faz o cálculo da maior somar de números não adjacentes.

This algorithm calculates the maximum sum of non-adjacent values

"""


def func(memos, array, pos):
    if pos < 0:
        return 0

    if pos == 0:
        memos[0] = array[0]
        return memos[0]

    if memos[pos] != -1:
        return memos[pos]

    maior = -1

    for i in range(1, pos + 1):
        memos[i] = max(array[i] + func(memos, array, i-2),
                       array[i] + func(memos, array, i-3))
        if memos[i] > maior:
            maior = memos[i]

    return maior


casos = int(input())
caso = 1

while caso <= casos:
    monstros = int(input())
    array = input().split()
    array = [int(x) for x in array]

    memos = [-1 for _ in range(len(array))]

    res = func(memos, array, len(array) - 1)

    print(f"Caso {caso}:", res)

    caso += 1
