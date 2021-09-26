
"""
Programação dinâmica / Dynamic programming
Solves the problem of coin change, giving some value, it returns the
possibilites ammount you'll be able to have that value.

Coins asked to be used in the problem: 
(100, 50, 20, 10, 5, 2, 1, 0.5, 0.20, 0.10, 0.5)

But my algorithm runs too slow, guess I could use the same table amongst
the different cases.
"""


def calcula_troco(moedas: tuple, valor: int):

    tabela = [[0 for _ in range(valor+1)] for _ in range(len(moedas)+1)]

    for i in tabela:
        i[0] = 1

    for linha in range(1, len(moedas)+1):
        for coluna in range(1, valor+1):
            # print("coluna analisada:", coluna)
            # print("linha:", linha)

            if coluna - moedas[linha - 1] >= 0:
                tabela[linha][coluna] = tabela[linha-1][coluna] + \
                    tabela[linha][coluna-moedas[linha-1]]

            else:
                tabela[linha][coluna] = tabela[linha-1][coluna]

    return tabela[len(moedas)][valor]


# moedas = (10000, 5000, 2000, 1000, 500, 200, 100, 50, 10, 5)
moedas = (5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000)
# moedas = (100,200,500)

valor = float(input())

while valor:
    novovalor = valor * 100
    novovalor = int(novovalor)

    res = calcula_troco(moedas, novovalor)

    string = "{:>6.2f}{:>17}".format(valor, res)

    print(string)

    valor = float(input())
