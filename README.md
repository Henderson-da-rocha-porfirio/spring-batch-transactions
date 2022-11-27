# Transactions with Spring Batch

## Pensando que existem passos a serem seguidos antes da atualizacao e cauculo
> Diante da grande quantidade de dados que serão processados, eu estou fazendo uns testes com um projeto spring batch
porque ele permite um bom acompanhamento e registro de toda a execução e prevê suporte para transacoes. Este Projeto serve como demonstração do uso do Spring Batch
gerenciando transações dentro de um chunk. Ele possui um job que lê um arquivo de usuários e os insere no banco de dados.

## Vantagens:

### 1 _ Garante a atomicidade da transacao (ACID - tudo ocorre ou nada ocorre)
> - Se der certo a transacao, ele commita e faz todos os registros no database.
> - Caso contrário, não deu certo, ou seja, se um ou mais de um ou todos derem errado, ele faz o rollback de todos os itens do chunck. O commit não acontece, por tanto,
  nenhum registro é feito no database.
> - Exemplo:
  Se o primeiro chunck de tamanho 20 funcionar, e o segundo chunck de tamanho 20 der erro, teremos apenas 20 registros e assim sucessivamente.



### 2 _ Divisao em Chunks (pedaços)
> - exemplo:
> -  divisao de 100 registros em chuncks, ou seja,  5 pedaços com tamanho de 20 ( 5 chuncks x tamanho 20 = 100 registros )
> - Cada pedaço (chunck) roda numa transacão.



### 3 _ Transactions

> - job:
>- criado um processamento de um arquivo csv: pessoa.csv (dentro do csv terá um registro de 10.000 pessoas) = pessoas serão lidas
>- criado a carga desse arquivo no database: "INSERT INTO pessoa (id, nome, email, data_nascimento, idade)
  VALUES (:id, :nome, :email, :dataNascimento, :idade)") = pessoas serão escritas
>- No final haverá 10.000 registros de pessoas no database


### 4 _  Reusibilidade
> - capacidade de utilizacao de dados através de várias transacoes de dados sem precisar recriá-los.


### 5 _ Transações acontecem mesmo que haja algum tipo de impedimento.


### 6 _ Para simular o teste, é preciso:

> a. criar o banco no postgresql
> 
> b. criar as tabelas que estão no exemplo
> 
> c. Para isso verificar o arquivo scripts.sql
>
> d. Algumas modificações para o uso do PostgreSql e outras já foram feitas.
> 
> e. Caso queira verificar os arquivos originais que estão sendo usados em outro SGBD e/ou outro banco, favor,
verificar as fontes abaixo.

### 7 _ Fonte original sem alterações:

- [x] [Controle transacional com 1 banco de dados](https://github.com/giuliana-bezerra/sb-transactions/tree/v1.0)
- [x] [Transação deixa de funcionar com a adição de um novo banco para escrita](https://github.com/giuliana-bezerra/sb-transactions/tree/v2.0)
- [x] [Ajustar para utilizar transação no banco secundário](https://github.com/giuliana-bezerra/sb-transactions/tree/v3.0)

## Referências

- [Vídeo do Youtube](https://youtu.be/iZXYG7fM8jI)
- [Curso de Spring Batch](https://www.udemy.com/course/curso-para-desenvolvimento-de-jobs-com-spring-batch/?referralCode=8743E206FA9240686B20)
