"""
Programação dinâmica / Dynamic programming
Seu Zé está preparando as mais deliciosas e docinhas rapaduras feitas 
a partir da exploração de seu lindo canavial crescido naturalmente sem 
agrotóxicos. Primeiro ele prepara uma barra de rapadura de 20 cm de 
largura e 7 cm de espessura, depois ele a corta em blocos de comprimentos 
variados. O preço da rapadura (do bloco cortado e embalado) no mercado 
depende do seu comprimento em polegadas. Dados o comprimento total da 
barra de rapadura e os preços no mercado de cada tamanho de rapadura 
(comprimento em polegadas), ajude o seu Zé a cortar a sua barra da 
maneira mais rentável possível.

entries: 
1
10
1 5 8 9 10 17 17 20 24 30

returns: 
30
"""

import math


def rapadura(valores, tamanho, memo):
    if memo[tamanho] >= 0:
        return memo[tamanho]

    if tamanho == 0:
        var = 0
    else:
        var = -math.inf
        for i, value in enumerate(valores, start=1):
            if tamanho - i >= 0:
                var = max(var, value + rapadura(valores, tamanho-i, memo))

        memo[tamanho] = var

    return var


casosteste = int(input())

while casosteste:

    comprimento = int(input())
    var = input().split()

    valores = []

    for i in var:
        valores.append(int(i))

    memo = [-1 for i in range(len(valores)+1)]

    res = rapadura(valores, comprimento, memo)
    print(res)

    casosteste -= 1
