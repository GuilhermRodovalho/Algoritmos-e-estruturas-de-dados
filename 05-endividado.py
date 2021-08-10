""""
Nlogônia, a capital de NPLândia, tem N museus de ciência.
Turinho e Ada combinaram em ir à Nlogônia em N domingos diferentes. 
Eles gostam de montar uma programação para visitar um museu de ciência 
diferente a cada domingo.

Turinho é muito mesquinho, então todo domingo ele vai avisar a Ada que 
se esqueceu de trazer o dinheiro para pagar a entrada do museu, e pede a 
Ada pagar por ele.

Ada sempre paga, e por conhecer Turinho bem, sabe que também que ele 
nunca irá devolver se não cobrá-lo. Na verdade, Ada sabe que mesmo que 
ela peça a Turinho seu dinheiro de volta, ele só aceitará pagar se a 
dívida acumulada for um múltiplo de 100, porque senão ele vai dizer que 
não tem trocado para pagar a dívida inteira, e então não pagará nada.

Assim, a cada domingo, se a dívida acumulada for um múltiplo de 100 Ada 
vai até a casa de Turinho para reivindicar o seu dinheiro e, porque 
ele não vai ter nenhuma desculpa, irá pagar. É claro que Turinho não 
gosta disso, mas é consolado pela ideia de que, se a dívida acumulada 
depois de visitar os N museus não for um múltiplo de 100, Ada deve não 
cobrar essa última parte da dívida.

Ada gostaria de saber quantas vezes terá que ir cobrar Turinho. Para 
esse cálculo, ela pode fornecer uma lista de preços dos ingressos para 
os N museus de ciência em Nlogônia, na ordem em que ela e Turinho os 
visitam.
"""


museus = int(input())

while True:

    resultado = 0
    valor = 0
    controle = 1

    temp = input().split()

    for val in temp:
        valor += int(val)
        if valor % 100 == 0:
            resultado += 1

    print(resultado)

    museus = int(input())
    if museus == -1:
        break
