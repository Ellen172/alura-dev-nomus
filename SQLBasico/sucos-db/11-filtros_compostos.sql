use sucos;

-- localiza produtos com valores entre 16.007 e 16.009 
select * from tb_produto
where preco_lista >= 16.007 
and PRECO_LISTA <= 16.009;

-- cliente com idade maior que 18, sexo masculino
select nome, idade, sexo from tb_cliente 
where idade >= 18
and sexo = 'M';

-- cliente da cidade do RJ ou do bairro Jardins
select * from tb_cliente
where cidade = 'Rio de Janeiro'
or bairro = 'Jardins';

-- concatenando varias condições
select nome, idade, sexo, cidade, bairro from tb_cliente 
where (idade >= 18 and sexo = 'F') 
or (cidade = 'Rio de Janeiro' or bairro = 'Jardins');

-- EXERCICIO: Veja quais são os vendedores que estão de férias e que foram admitidos antes de 2016.
select * from tb_vendedores 
where de_ferias = 1 
and year(data_admissao) < '2016';