-- SELECT SIMPLES

-- seleciona todos os registros de clientes
select * from tb_cliente; 

-- apenas cpf e nome dos registros 
select cpf, nome from tb_cliente;

-- cpf e nome dos primeiros 5 registros encontrados
select cpf, nome from tb_cliente limit 5;

-- alias: nome fantasia para um campo
select data_nascimento as 'Nascimento do Cliente', cpf as 'CPF do Cliente', 
	nome as 'Nome do Cliente' from tb_cliente;

-- EXERCICIO: selecione nome e matricula dos vendedores
select nome, matricula from tb_vendedores;


