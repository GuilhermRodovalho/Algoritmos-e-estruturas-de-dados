"""
Programação dinâmica / Dynamic programming
Classico problema da mochila binaria.
Nesse caso, precisa-se armazenar a memoria das consultas passadas, pra 
evitar fazer o calculo novamente


knapsack 0/1 problem.
you pass to the function the capacity of the knapsack, an array with the
prices, an array with the values, the ammount of products, and an array
that's going to be used to remember the subproblems. 

"""


def func(capacidade, pesos, valores, qtdprodutos, memo):

    if memo[qtdprodutos][capacidade] != 0:
        return memo[qtdprodutos][capacidade]

    for i in range(qtdprodutos+1):
        for j in range(31):
            if i == 0 or j == 0:
                memo[i][j] = 0

            elif pesos[i-1] <= j:
                memo[i][j] = max(valores[i-1] + memo[i-1]
                                 [j-pesos[i-1]], memo[i-1][j])

            else:
                memo[i][j] = memo[i-1][j]

    return memo[qtdprodutos][capacidade]


cteste = int(input())
precos = []
pesos = []
memo = []

it = 0

while cteste:
    qtdprodutos = int(input())
    for i in range(qtdprodutos):
        tmp = input().split()
        precos.append(int(tmp[0]))
        pesos.append(int(tmp[1]))

    membros = int(input())

    memo = [[0 for _ in range(31)] for _ in range(qtdprodutos+1)]

    res = 0

    for _ in range(membros):
        capacidade = int(input())

        res += func(capacidade, pesos, precos, qtdprodutos, memo)

    print(res)

    precos = []
    pesos = []
    cteste -= 1
