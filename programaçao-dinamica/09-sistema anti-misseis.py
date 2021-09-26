"""
Programação dinâmica / Dynamic programming
Resumo:
Esse algoritmo calcula a maior soma de elementos em que o próximo seja 
menor que o anterior.
Não funciona em alguns casos.

This alorithm get the max sum of tha values in a array, in which 
arr[n] < next_value_to_be_added.
It doesn't work in a few cases.

Descrição:
O projetista do Sistema de Defesa Área Linear (SDAL) está desenvolvendo 
um importante escudo anti-mísseis e precisa da sua ajuda!

No SDAL, um míssil de defesa consegue atingir múltiplos mísseis que 
estão atacando. A única restrição para a atuação do míssil de defesa é 
que ele só pode acertar mísseis consecutivos que estão cada vez mais 
altos, nunca diminuindo a altitude.

Por exemplo, se os mísseis estão vindo nas alturas de 1 km, 6 km, 2 km e 
5 km, chegando nessa ordem, o míssil de defesa pode acertar os mísseis 
vindo em 1 km e 6 km, mas depois não pode mudar de rota para acertar os 
mísseis restantes, pois 2 km e 5 km estarão em altitudes mais baixas que 
o último míssil acertado em 6 km.

O trabalho do projetista é programar os mísseis de defesas para 
acertaram o maior número possível de alvos.

Ajude o projetista e escreva um código que encontra a melhor sequência 
de alvos que os mísseis SDAL podem acertar. É seguro assumir que os 
mísseis de ataque sempre chegarão em sequência que resultam em apenas 
uma solução.

As primeira linha da entrada conterá a quantidade de casos testes.
As próximas linhas terão os valores das distâncias. 
Os casos testes são separados por uma linha vazia, e o último caso é 
até EOF.



"""

from sys import stdin


def sdal(array):
    if len(array) == 1:
        return 1

    temp = maior = 0
    memo[0] = 1

    tmparray = []
    finalarray = []

    for i in range(1, len(array)):
        memo[i] = 1
        tmparray = []
        for j in range(i):
            if array[j] < array[i]:
                temp = memo[j] + 1
                tmparray.append(array[j])

            if temp > memo[i]:
                memo[i] = temp
                if temp > maior:
                    tmparray.append(array[i])
                    finalarray = tmparray
                    maior = temp

    return maior, finalarray


cteste = int(input())

lixo = input()

while cteste:
    altitudes = []
    while True:
        try:
            var = int(stdin.readline())
            altitudes.append(var)
        except ValueError:
            break

    novoarray = []
    memo = [0 for _ in range(len(altitudes)+1)]

    res, novoarray = sdal(altitudes)

    print("Acertos:", str(res))

    for val in range(res):
        print(novoarray[val])

    cteste -= 1
