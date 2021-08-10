"""
Programação dinâmica / Dynamic programming
função retorna a maior soma de uma subsequência do array

Basicaly, implements kadane's algorithm.
"""


def func(array: list):

    if len(array) == 1:
        return array[0]

    memo = [0 for _ in array]
    maior = 0
    memo[0] = max(array[0], 0)

    for i in range(1, len(array)):
        memo[i] = max(memo[i-1] + array[i], 0)

        if memo[i] > maior:
            maior = memo[i]

    return maior


entrada = int(input())
values = []
while entrada:
    while len(values) != entrada:
        tmp = input().split()
        tmp = [int(x) for x in tmp]
        for value in tmp:
            values.append(value)

    memo = [-1 for _ in values]
    maior = 0
    memo[0] = max(values[0], 0)

    res = func(values)

    if res > 0:
        print("Maior sequência ganhadora é " + str(res) + ".")

    else:
        print("Sequência perdedora.")

    entrada = int(input())
    values = []
