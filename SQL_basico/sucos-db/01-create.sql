create database sucos;

/* 
CADASTRO DE CLIENTE

- cpf do cliente 
- nome completo 
- endereço (rua, bairro, cidade, estado e cep)
- data de nascimento 
- idade 
- sexo 
- limite de credito para comprar produtos 
- volume minimo de sucos que ele pode comprar 
- se ja realizou a primeira compra
*/

create table tb_cliente
(cpf varchar(11), 
nome varchar(200), 
endereco1 varchar(150), 
endereco2 varchar(150), 
bairro varchar(50), 
cidade varchar(50), 
estado varchar(50), 
cep varchar(8),
idade smallint, 
sexo varchar(1), 
limite_credito float, /* float(10,2) */ 
volume_compra float, 
primeira_compra bit /* 1 ou 0 */ );

/* 
CADATRO DE VENDEDORES 

Nome da tabela deve ser TABELA_DE_VENDEDORES 
Vendedor tem o número interno da matrícula, onde será armazenado no campo MATRICULA, 
que deve ser um string de 5 posições. O nome do vendedor deverá ser armazenado no campo NOME, 
e deve ser um string de 100 posições. Criar o campo PERCENTUAL_COMISSAO que representa 
quantos % de comissão o vendedor ganha sobre cada venda 
*/

create table tb_vendedores 
( matricula varchar(5), 
nome varchar(100), 
percentual_comissao float);

/* 
CADASTRO DE PRODUTO 
- codigo do produto 
- nome do produto 
- embalagem 
- tamanho 
- sabor 
- preço de lista 
*/
-- gerado a partir do workbench
CREATE TABLE `sucos`.`tb_produto` (
  `produto` VARCHAR(20) NULL,
  `nome` VARCHAR(150) NULL,
  `embalagem` VARCHAR(50) NULL,
  `tamanho` VARCHAR(50) NULL,
  `sabor` VARCHAR(50) NULL,
  `preco_lista` FLOAT NULL);
  
  /* apagar uma tabela */
  drop table tb_cliente2;