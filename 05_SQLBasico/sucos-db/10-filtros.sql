-- FILTROS

-- usando where
select * from tb_produto where produto = '544931';

-- retorna clientes do RJ 
select * from tb_cliente where cidade = 'Rio de Janeiro'; 


-- alterando sabor limão para citrus

select * from tb_produto where sabor = 'Limão';

update tb_produto set sabor = 'Citrus' where sabor = 'Limão';

select * from tb_produto where sabor = 'Citrus';


-- EXERCICIO: Verifique os dados cadastrais da vendedora Claudia Morais.

select * from tb_vendedores where nome = 'Claúdia Morais';


-- retorna todos os clientes com 22 anos
select * from tb_cliente where idade = 22;

-- retorna todos os clientes com mais de 22 anos
select * from tb_cliente where idade > 22;

-- retorna todos os clientes com menos de 22 anos
select * from tb_cliente where idade < 22;

-- retorna todos os clientes com idade diferente de 22 
select * from tb_cliente where idade <> 22;

-- verifica alfabeticamente, os nomes que vem depois de Fernando Cavalcante. 
select * from tb_cliente where nome > 'Fernando Cavalcante';

-- igualando com float
select * from tb_produto where preco_lista = 16.008; -- não funciona, float é ponto flutuante
select * from tb_produto where preco_lista > 16;

select * from tb_produto where preco_lista between 16.007 and 16.009; -- localiza 16.008 

-- EXERCICIO: Veja quais são os vendedores que possuem comissão maior que 10%.
select * from tb_vendedores where percentual_comissao > 10;


-- DATAS 

-- nascimento em 13 de janeiro de 1995
select  * from tb_cliente where DATA_NASCIMENTO = '1995-01-13';

-- nascimento apos 13 de janeiro de 1995
select  * from tb_cliente where DATA_NASCIMENTO > '1995-01-13';


-- FUNÇÕES COM DATAS

-- busca pelo ano 
select * from tb_cliente where year(DATA_NASCIMENTO) = '1995'; 

-- busca pelo mes
select * from tb_cliente where month(data_nascimento) = '10';

-- EXERCICIO: Veja quais são os vendedores que foram admitidos da empresa a partir de 2016.
select * from tb_vendedores where year(data_admissao) > '2016';