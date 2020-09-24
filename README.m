### trabalhoIntegrador

Cenário: Transportadora Entrega Rápida
A Transportadora Entrega Rápida está com um plano de expansão e entende que para
ter sucesso em suas atividades se faz necessário o desenvolvimento de um Sistema de
Logística.
A transportadora trabalha apenas com objetos grandes e todas as suas encomendassão
colocadas em caixas iguais, dessa forma fica mais fácil organizar as caixas dentro dos
veículos.
Quem irá acessar o sistema são os funcionários da frente de caixa da transportadora,
que devem fazer todos os cadastros necessários, ao cadastrar o objeto, deve-se encaixálo em um dos veículos disponíveis em um dos dias da semana (segunda a sábado).
Todas as manhãs, o atendente solicita ao sistema a geração dos roteiros de entrega para
todo o dia (ver RF004). Para a distribuição das cargas por veiculo, deve-se
primeiramente optar pelo veiculo de maior capacidade para o de menor capacidade,
mais detalhes a seguir:
• Carreta: 10 pacotes;
• Caminhão baú: 3 pacotes; e
• Van: 1 pacote.
Pode-se considerar que o veículo só vai ser utilizado uma vez por dia e consegue ir em
todos os pontos de entrega referentes aos objetos de sua capacidade. Os objetos devem
ser distribuídos pelos veículos em ordem crescente à data de cadastro.
Todo motorista deve no início do dia receber o seu roteiro de entrega, ele deve anotar
no papel recebido, quais os objetos que foram entregues, bem como os que não foram
entregues, deixando disponível para o funcionário da frente de caixa essa informação
de modo que ele possa informar no sistema.
A seguir são apresentados os requisitos do sistema:
RF001 – O sistema deve permitir o cadastro dos veículos
Descrição: os veículos podem ser dos seguintes tipos: van, caminhão baú ou carreta.
Deve-se armazenar os seguintes dados do veículo: marca, modelo, ano e placa.
RF002 – O sistema deve armazenar as informações do motorista
Descrição: deve-se armazenar as seguintes informações: nome, data de nascimento,
endereço, tipo da CNH e número da CNH.
Regra de Negócio: RN001.
RF003 – O sistema deve armazenar as informações relacionadas ao objeto para
entrega.
Descrição: deve-se armazenar as seguintes informações do objeto, nome do remetente,
endereço do remetente, nome do destinatário, endereço do destinatário, data do
deposito do objeto, peso e código localizador.
Regra de Negócio: RN002.
RF004 – O sistema deve permitir a geração dos roteiros diários por veículo.
Descrição: O sistema deve a partir da frota cadastrada distribuir todas as encomendas,
ao final do processo, deve-se apresentar na tela a relação dos objetos alocados por
veículo. Deve-se dar a opção para o usuário verificar os objetos que ficaram fora do
roteiro do dia (ver: RF005).
Regra de Negócio: RN003; RN004
RF005 – O sistema deve permitir os objetos que ficaram fora do roteiro do dia possam
ser listados
Descrição: Não há garantia que os objetos que foram selecionados para ser entregues
no dia sejam realmente entregues, por conta disso se faz necessário visualizar as
entregas que não foram entregues no dia presente ou num dia anterior.
RF006 – O sistema deve permitir que os funcionários informem no roteiro do dia atual
quais objetos não foram entregues.
Descrição: O funcionário da frente de caixa recebe no final do dia de cada motorista um
papel com a informação, da entrega ou não, do objeto que estava na rota do motorista
em questão.
RF007 – O sistema deve permitir que se vincule um motorista com um veículo
Descrição: Antes de fazer uma rota para um motorista, deve-se vincular um veículo para
ele, a partir dessa vinculação é conhecido a quantidade de objetos que ele deve entregar
por dia. Pode-se alterar a vinculação do motorista por veículo.
Regra de Negócio: RN004
RF008 – O sistema deve permitir que sejam listados roteiros antigos a partir da sua
data
Descrição: Pode-se listar os roteiros antigos por data e/ou por motorista.
A seguir são apresentadas as regras de negócio:
RN001 – Tipo de CNH por tipo de Veículo
Descrição:
- Somente motoristas com classe B e/ou C de CNH, podem dirigir veículos do tipo Van;
- Somente motoristas com classe C de CNH podem dirigir o veículo do tipo caminhão baú
ou carreta.
RN002 – Código localizador do objeto
Descrição:
- o código localizador do objeto deve ser único e pode ser cadastrado pelo usuário;
- caso o usuário não digite o código localizador no cadastro, deve-se gerar um
automaticamente.
RN003 – Distribuição de objetos por veículo
Descrição:
- os objetos devem ser distribuídos em ordem crescente a partir da sua data ou id de
inserção;
- deve-se primeiro preencher os veículos com maiores capacidades para os menores,
caso tenham objetos que não foram alocados no roteiro do dia, o mesmo ficará
disponível para o próximo roteiro.
RN004 – Vinculo de motoristas por veículo
Descrição:
- um veículo só pode estar vinculado à um motorista;
- só é permitir gerar roteiro de entrega para os motoristas com veículos.
