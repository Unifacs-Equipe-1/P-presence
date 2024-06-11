
# A3 Programção e Soluções Computacionais

Este trabalho foi realizado para a última avaliação do semestre (conhecida como A3). Tivemos a ideia de criar uma lista de chamada para uma turma, pois alguns professores não a fazem devido ao tamanho da turma.

Este texto servirá como auxílio para a utilização do nosso sistema.

Ao rodar o programa principal, aparecerão três (3) opções de login: aluno, professor e administrador. O login como professor e aluno é feito pelo Registro de Professor (RP) e Registro de Aluno (RA) e pela senha. Para logar como administrador, deve-se inserir o login e a senha (admin e admin).

O RP e o RA são conjuntos de números diferentes que mudam toda vez que o programa para de rodar, podendo ter até 11 dígitos. (Explicação de como foi feito na parte de comandos)

Para saber o RA e RP, você deve entrar como administrador. No caso do RA, deve-se selecionar a opção "Gerenciar Aluno" e, em seguida, "Ver alunos", onde aparecerão todos os alunos com suas informações e RAs. Para ver os dos professores, deve-se ir em "Gerenciar Professores" e depois em "Ver Professores".

Para que o aluno marque a presença na aula, o professor deve configurar a sala que ele irá utilizar. Para isso, deve-se logar como professor com o RP e a senha - que já deixamos predefinida; para a professora Eliane, a senha é "profeliane". Na primeira opção, o professor informará a sala que vai utilizar ("Configurar sala"). Logo após informar, ele vai gerar o código que os alunos usarão para confirmar a presença na opção "Gerar código da sala".

Para marcar presença, o aluno deve logar-se com o RA e a senha e selecionar a opção "Entrar na sala e marcar presença".

Para o professor visualizar a presença dos alunos, ele deve ir na opção "Ver todos os alunos", que mostrará os dados dos alunos e se marcaram presença ou não.

## Todas as opções de Aluno

1 - Mostrar sala disponível

Aqui serão mostradas as salas disponíveis, criadas pelos professores.

2 - Entrar na sala e marcar presença

Aqui o aluno deve inserir o código da sala que o professor disponibilizar para marcar a presença.

3 - Ver meus dados

Aqui será exibida uma tabela com os dados do aluno (nome, gênero, curso, turno e UC).

4 - Sair da conta

Aqui o aluno sairá da conta e voltará para a seção de login.

## Todas as opções de professor

1 - Configurar sala

Nesta opção, o professor irá programar a sala que quer utilizar, devendo inserir o número da sala.

2 - Gerar código da sala

Nesta opção, será gerado um código que o professor deve enviar para os alunos para que marquem presença na aula.

3 - Ver todos os alunos

Nesta opção, será exibida uma lista dos alunos com seus nomes, cursos, turnos e se marcaram presença.

4 - Sair da conta

Aqui o professor sairá da conta e voltará para a seção de login.

## Todas as opções como Administrador

1 - Gerenciar alunos

1.1 Cadastrar alunos

Nesta opção, o administrador pode adicionar um novo aluno à sala, inserindo os dados necessários (nome, gênero, turno, curso e senha).

1.2 Atualizar aluno

Nesta opção, o administrador poderá alterar o turno ou o curso do aluno, inserindo o RA para identificá-lo.

1.3 Excluir aluno

Nesta opção, o administrador poderá excluir o aluno através do RA dele.

1.4 Ver alunos

Nesta opção, será exibida uma lista dos alunos com seus RAs, nomes, cursos e turnos.

1.5 Filtrar alunos

Nesta opção, o administrador poderá filtrar os alunos por algum atributo (nome, RA, curso, turno, gênero). Por exemplo, se existirem dois alunos com o mesmo nome, ambos serão mostrados.

1.6 Voltar

Esta opção apenas voltará para as opções anteriores.

2 - Gerenciar professores

2.1 Cadastrar professores

Nesta opção, o administrador irá cadastrar um novo professor, inserindo os dados necessários (nome, turno, curso, Unidade Curricular (UC) e senha).

2.2 Atualizar professores

Nesta opção, o administrador poderá atualizar os dados de um professor através do seu RP.

2.3 Excluir professor

Nesta opção, o administrador irá excluir um professor através do seu RP.

2.4 Ver professores

Nesta opção, será exibida uma lista de professores com seus dados (RPs, nome, curso, turno).

2.5 Voltar para a página anterior

Esta opção apenas voltará para as opções anteriores.

## Comandos extras

+ Limpeza de terminal
Para limpar o terminal, utilizamos um método para criar 1000 quebras de linha.

+ RA e RP
Na pasta "extras" e na classe "Util" foi criado um método para gerar os números; na classe Programa, esse número é atribuído ao aluno e ao professor.

+ Código da sala
É gerado um código aleatório contendo letras e números.

+ Ordenação
Foi utilizado um método com a importação "Colection" para ordenar por ordem alfabética

## Requisitos funcionais e não funcionais

## Atributos Funcionais

Login e autenticação:

RF01 - Login como aluno, professor ou administrador.

RF02 - Uso de Registro de Professor (RP) e Registro de Aluno (RA) para login.

Gerenciamento de usuários:

RF03 - Cadastro, atualização e exclusão de alunos.

RF04 - Visualização de listas de alunos.

RF05 - Filtragem de alunos por atributos (nome, RA, curso, turno, gênero).

RF06 - Cadastro, atualização e exclusão de professores.

RF07 - Visualização de listas de professores.

Gerenciamento de presença:

RF08 - Configuração de salas por professores.

RF09 - Geração de código de sala para marcação de presença.

RF10 - Marcação de presença por alunos.

RF11 - Visualização de presença dos alunos pelos professores.

Visualização de dados:

RF12 - Alunos podem ver suas salas disponíveis e seus dados pessoais.

RF13 - Professores podem ver listas de alunos com informações detalhadas.

## Atributos Não Funcionais

Usabilidade:

NRF01 - Clareza na interface de login e nas opções apresentadas para cada tipo de usuário.

NRF02 - Navegação intuitiva para gerenciar alunos, professores e salas.

Segurança:

NRF03 - Autenticação de usuários com login e senha.

NRF04 - Senhas predefinidas e possibilidade de alterar senhas.

Manutenibilidade:

NRF05 - Explicações claras sobre como adicionar, atualizar e excluir alunos e professores.

NRF06 - Estrutura clara para geração e gestão de RA e RP.

Eficiência:

NRF07 - Geração e uso de códigos únicos para salas.

NRF08 - Limpeza do terminal para melhor visualização.

Confiabilidade:

NRF09 - Geração automática de RA e RP com até 11 dígitos, garantindo unicidade.

NRF10 - Métodos definidos para garantir a integridade dos dados de presença e de usuários.