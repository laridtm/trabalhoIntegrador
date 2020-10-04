UNISUL – Universidade do Sul de Santa Catarina
Cursos: Sistemas de Informação e Tecnólogo em Análise e Desenvolvimento de
Sistemas
Disciplina: Tópicos Avançados de Programação
Professor: Flávio Ceci, Dr.

# TRABALHO INTEGRADOR

## Cenário: Transportadora Entrega Rápida

A Transportadora Entrega Rápida está com um plano de expansão e entende que para
ter sucesso em suas atividades se faz necessário o desenvolvimento de um Sistema de
Logística.
A transportadora trabalha apenas com objetos grandes e todas as suas encomendas são
colocadas em caixas iguais, dessa forma fica mais fácil organizar as caixas dentro dos
veículos.
Quem irá acessar o sistema são os funcionários da frente de caixa da transportadora,
que devem fazer todos os cadastros necessários, ao cadastrar o objeto, deve-se encaixá-
lo em um dos veículos disponíveis em um dos dias da semana (segunda a sábado).
Todas as manhãs, o atendente solicita ao sistema a geração dos roteiros de entrega para
todo o dia (ver RF004). Para a distribuição das cargas por veiculo, deve-se
primeiramente optar pelo veiculo de maior capacidade para o de menor capacidade,
mais detalhes a seguir:

- Carreta: 10 pacotes;
- Caminhão baú: 3 pacotes; e
- Van: 1 pacote.
Pode-se considerar que o veículo só vai ser utilizado uma vez por dia e consegue ir em
todos os pontos de entrega referentes aos objetos de sua capacidade. Os objetos devem
ser distribuídos pelos veículos em ordem crescente à data de cadastro.

Todo motorista deve no início do dia receber o seu roteiro de entrega, ele deve anotar
no papel recebido, quais os objetos que foram entregues, bem como os que não foram
entregues, deixando disponível para o funcionário da frente de caixa essa informação
de modo que ele possa informar no sistema.

A seguir são apresentados os **requisitos do sistema** :

**RF001 – O sistema deve permitir o cadastro dos veículos**
_Descrição: os veículos podem ser dos seguintes tipos: van, caminhão baú ou carreta.
Deve-se armazenar os seguintes dados do veículo: marca, modelo, ano e placa._

**RF002 – O sistema deve armazenar as informações do motorista**
_Descrição: deve-se armazenar as seguintes informações: nome, data de nascimento,
endereço, tipo da CNH e número da CNH.
Regra de Negócio: RN001._


**RF003 – O sistema deve armazenar as informações relacionadas ao objeto para
entrega.**
_Descrição: deve-se armazenar as seguintes informações do objeto, nome do remetente,
endereço do remetente, nome do destinatário, endereço do destinatário, data do
deposito do objeto, peso e código localizador.
Regra de Negócio: RN002._

**RF004 – O sistema deve permitir a geração dos roteiros diários por veículo.**
_Descrição: O sistema deve a partir da frota cadastrada distribuir todas as encomendas,
ao final do processo, deve-se apresentar na tela a relação dos objetos alocados por
veículo. Deve-se dar a opção para o usuário verificar os objetos que ficaram fora do
roteiro do dia (ver: RF005).
Regra de Negócio: RN003; RN_

**RF005 – O sistema deve permitir os objetos que ficaram fora do roteiro do dia possam
ser listados**
_Descrição: Não há garantia que os objetos que foram selecionados para ser entregues
no dia sejam realmente entregues, por conta disso se faz necessário visualizar as
entregas que não foram entregues no dia presente ou num dia anterior._

**RF006 – O sistema deve permitir que os funcionários informem no roteiro do dia atual
quais objetos não foram entregues.**
_Descrição: O funcionário da frente de caixa recebe no final do dia de cada motorista um
papel com a informação, da entrega ou não, do objeto que estava na rota do motorista
em questão._

**RF00 7 – O sistema deve permitir que se vincule um motorista com um veículo**
_Descrição: Antes de fazer uma rota para um motorista, deve-se vincular um veículo para
ele, a partir dessa vinculação é conhecido a quantidade de objetos que ele deve entregar
por dia. Pode-se alterar a vinculação do motorista por veículo.
Regra de Negócio: RN_

**RF00 8 – O sistema deve permitir que sejam listados roteiros antigos a partir da sua
data**
_Descrição: Pode-se listar os roteiros antigos por data e/ou por motorista._

A seguir são apresentadas as **regras de negócio** :

**RN001 – Tipo de CNH por tipo de Veículo**
_Descrição:_

_- Somente motoristas com classe B e/ou C de CNH, podem dirigir veículos do tipo Van;
- Somente motoristas com classe C de CNH podem dirigir o veículo do tipo caminhão baú
ou carreta._


**RN002 – Código localizador do objeto**
_Descrição:_

_- o código localizador do objeto deve ser único e pode ser cadastrado pelo usuário;
- caso o usuário não digite o código localizador no cadastro, deve-se gerar um
automaticamente._

**RN003 – Distribuição de objetos por veículo**
_Descrição:_

_- os objetos devem ser distribuídos em ordem crescente a partir da sua data ou id de
inserção;
- deve-se primeiro preencher os veículos com maiores capacidades para os menores,
caso tenham objetos que não foram alocados no roteiro do dia, o mesmo ficará
disponível para o próximo roteiro._

**RN00 4 – Vinculo de motoristas por veículo**
_Descrição:_

_- um veículo só pode estar vinculado à um motorista;
- só é permitir gerar roteiro de entrega para os motoristas com veículos._

## Informações sobre o trabalho final

Espera-se com o desenvolvimento desse trabalho que o aluno desenvolva as
competências necessárias para o desenvolvimento de software. Como o cenário atual
da indústria de software é composto por vários papeis, espera-se que o trabalho seja
feito em equipe e que os alunos se organizem da melhor maneira possível para o
desenvolvimento do artefato de software.

As **equipes devem ser compostas por 5 ou 6 alunos** (sem exceção), o desenvolvimento
em equipe, bem como as tecnologias para se trabalhar com o desenvolvimento em
grupo (github, bit bucket, entre outras) fazem parte do esperado para a construção da
solução de trabalho.

O Sistema desenvolvido deve possuir uma camada de persistência utilizando um Banco
de Dados Relacional (Postgres, MySQL, ...), também se deve utiliza o Padrão de Projetos
DaoFactory (caso não seja implementado esse padrão de projeto, será decrementado 1
ponto da solução final).

**Informações sobre a Avaliação:**

- A primeira nota será obtida através da apresentação e entrega parcial do
    trabalho integrador, nesse ponto o sistema deve estar implementado com sua
    estrutura de base e persistência em arquivo (nessa entrega não é necessário ter
    interface gráfica).
       o A entrega da persistência em arquivo garante até dois pontos da Prova
          sobre Threads;
       o O aluno pode fazer a entrega utilizando apenas dados em memória e terá
          sua nota computada até 10.


- A última avaliação será resultante da entrega final do trabalho integrador, onde
    o aluno deve utilizar todos os conceitos visto nas disciplinas de algoritmos 1 e 2;
    e programação 1 e 2.
       o O código entregue deve contemplar todos os requisitos solicitados.
- O Trabalho Integrador deve ser entregue (código fonte mais trabalho escrito) e
    apresentado.
       o A apresentação do trabalho vale 2 pontos;
       o Para cada dia de atraso na entrega do trabalho final será descontado 2
          pontos;
       o O trabalho escrito deve apresentar o script de criação do banco de dados,
          bem como as interfaces criadas e as possíveis regras de negócio
          desenvolvidas (somente em formato digital);
       o Não será permitido o envio de e-mails para tirar dúvidas sobre a
          confecção do trabalho, as mesmas devem ser feitas pessoalmente
          durante as aulas;
       o A confecção da interface gráfica pode ser feita utilizando Swing, e pode-
          se utilizar IDEs para auxiliar na construção da mesma. Esse recurso em
          especial não será dado suporte para a confecção.
             § Caso a equipe prefira utilizar JavaFX ou tecnologias web de
                apresentação, não há problema, mas não será dado suporte.
