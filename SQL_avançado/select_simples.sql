use SUCOS_VENDAS;

-- CONSULTAS SIMPLES

-- atributos dos clientes
select * from TABELA_DE_CLIENTES;

-- cpf e nome dos clientes
select cpf, nome from TABELA_DE_CLIENTES;

-- cpf e nome dos cliente usando alias
select cpf as ID , nome as Cliente from TABELA_DE_CLIENTES;

-- atributos dos produtos
select * from TABELA_DE_PRODUTOS;

-- atributos dos produtos com codigo = 1000889
select * from TABELA_DE_PRODUTOS where CODIGO_DO_PRODUTO = '1000889';

-- atributos dos produtos com sabor limão
select * from TABELA_DE_PRODUTOS where sabor = 'Laranja';

-- atributos dos produtos com embalagem pet
select * from TABELA_DE_PRODUTOS where EMBALAGEM = 'pet';

-- atributos dos produtos com preco de 19.51
select * from TABELA_DE_PRODUTOS where PRECO_DE_LISTA between 19.51 and 19.52;


