"""
Estamos no ano 3210 e há muitos e muitos anos atrás descobrimos que não 
estamos sozinhos no Universo. Porém, em 2021 isso ainda era questionado.

Muitas civilizações em planetas da nossa galáxia, a Via-Láctea, já 
entraram em contato com a Terra. Alguns até mantêm diálogos em busca de 
nossos avançados algoritmos de busca de padrões em strings.

Felipe tem muito interesse pelo assunto e quer descobrir qual foi a 
civilização mais antiga que enviou um Hello Galaxy para toda a galáxia. 
Hello Galaxy é o primeiro comando do Protocolo de Ingresso (IP, em inglês)
no Protocolo de Transmissão e Comunicação (TCP) da Via-Láctea, garantindo 
o contato entre civilizações.

A mensagem Hello Galaxy traz consigo duas informações básicas: o texto 
“Hello World”, uma tradição muito antiga de origem desconhecida, e o 
nome do planeta da civilização remetente. O CCVL, Centro de Comunicação 
da Via-Láctea, instalado na Terra, recebe essas mensagens e registra o 
ano em que foi recebida a mensagem e o número de anos que a mensagem 
levou para chegar.

Felipe deve descobrir qual foi a primeira civilização a enviar o 
"Hello World".
"""


casos = int(input())

while casos:
    planetamaisvelho = ""
    maisvelho = 0

    for i in range(casos):

        planeta, ano, tempo = input().split()

        ano = int(ano)
        tempo = int(tempo)

        if ano - tempo < maisvelho or i == 0:
            maisvelho = ano - tempo
            planetamaisvelho = planeta

    print(planetamaisvelho)

    casos = int(input())
