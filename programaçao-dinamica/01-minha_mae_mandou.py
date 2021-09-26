"""
"Minha mãe mandou" é uma das primeiras brincadeiras que crianças 
aprendem no Brasil. É uma maneira fácil de definir qual comida será 
escolhida entre as muitas alternativas colocadas no prato do almoço.

Mariazinha aprendeu uma versão diferente dessa brincadeira com sua mãe. 
Para fazer sua escolha ela deve repetir K vezes a frase 
"MI-NHA-MÃE-MAN-DOU-EU-ES-CO-LHER-ES-TE-DA-QUI-MAS-CO-MO-EU-SOU-TEI-MO-
SA-EU-ES-CO-LHO-ES-TE-DA-QUI" e para cada sílaba (são 29 sílabas) muda 
da escolha da comida de maneira circular começando no alimento 1, indo 
até o alimento N e retornando ao 1 até esgotar as sílabas das K repetições
da frase da brincadeira. No prato tem N alimentos diferentes.
"""


import math

qtdcasos = int(input())

while qtdcasos:
    qtdalimentos, qtdrepeticao = input().split()

    qtdalimentos = int(qtdalimentos)
    qtdrepeticao = int(qtdrepeticao)

    silabas = qtdrepeticao * 29

    alimento1 = silabas / qtdalimentos

    alimento1 = math.ceil(alimento1)

    alimentoescolhido = silabas % qtdalimentos

    alimentoescolhido += 1

    print(alimento1, alimentoescolhido)

    qtdcasos -= 1
