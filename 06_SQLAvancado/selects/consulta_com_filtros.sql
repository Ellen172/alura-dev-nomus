-- CONSULTAS CONDICIONAIS

-- EXERCICIO: (NOT ((3 > 2) OR (4 >= 5)) AND (5 > 4) ) OR (9 > 0)
-- (NOT ((V) OR (F)) AND (V) ) OR (V)
-- (NOT (V) AND (V) ) OR (V)
-- (F AND (V) ) OR (V)
-- (F) OR (V)
-- V

-- produtos com sabor de manga OU tamanho de 470 ml 
select * from TABELA_DE_PRODUTOS 
where sabor = 'Manga'
or tamanho = '470 ml';


-- produtos com sabor de manga E tamanho de 470 ml 
select * from TABELA_DE_PRODUTOS 
where sabor = 'Manga'
and tamanho = '470 ml';

-- produtos exceto os que tiverem sabor de manga e tamanho de 470 ml 
select * from TABELA_DE_PRODUTOS 
where not(sabor = 'Manga'
and tamanho = '470 ml');

-- produtos com sabor de manga que não tenham tamanho de 470 ml
select * from TABELA_DE_PRODUTOS 
where sabor = 'Manga'
and not (tamanho = '470 ml');

-- produtos com sabor laranja e manga
select * from TABELA_DE_PRODUTOS
where sabor in ('Laranja', 'Manga');

-- clientes que moram em RJ e SP com idade maior que 20 
select * from TABELA_DE_CLIENTES
where cidade in ('Rio de Janeiro', 'São Paulo') 
and idade > 20;

-- clientes que moram no RJ e SP com idade entre 20 e 25
select * from TABELA_DE_CLIENTES
where cidade in ('Rio de Janeiro', 'São Paulo') 
and (idade between 20 and 25);

-- clientes com nome Silva 
select nome from TABELA_DE_CLIENTES
where nome like '%Silva%';

-- produtos com sabor Maça e embalagem pet 
select * from TABELA_DE_PRODUTOS
where sabor like '%Maça%'
and EMBALAGEM = 'pet';

-- EXERCICIO : quantos clientes possuem o ultimo sobrenome Mattos
select nome from TABELA_DE_CLIENTES
where nome like '%Mattos';

-- diferentes tipos de embalagens e tamanhos registrados para o sabor laranja
select distinct embalagem,tamanho from TABELA_DE_PRODUTOS
where sabor = 'Laranja';

-- EXERCICIO: Quais são os bairros da cidade do Rio de Janeiro que possuem clientes?
select distinct bairro from TABELA_DE_CLIENTES
where cidade = 'Rio de Janeiro';

-- os primeiros 5 produtos da tabela
select * from TABELA_DE_PRODUTOS limit 5;

-- tres produtos, começando com o da posição 2 
select * from TABELA_DE_PRODUTOS limit 2, 3;

-- EXERCICIO: Queremos obter as 10 primeiras vendas do dia 01/01/2015. 
-- Qual seria o comando SQL para obter este resultado?
select * from NOTAS_FISCAIS
where DATA_VENDA = '2015-01-01'
limit 10;

-- produtos ordenados de acordo com o preço 
select * from TABELA_DE_PRODUTOS
order by PRECO_DE_LISTA;

-- produtos ordenados decrescentemente pelo nome
select * from TABELA_DE_PRODUTOS
order by NOME_DO_PRODUTO desc;

-- ordenação decrescente pela embalagem e crescente pelo nome
select * from TABELA_DE_PRODUTOS
order by EMBALAGEM desc, NOME_DO_PRODUTO asc;


-- EXERCICIO: Qual (ou quais) foi (foram) a(s) maior(es) venda(s) do produto 
-- “Linha Refrescante - 1 Litro - Morango/Limão”, em quantidade? 
-- (Obtenha este resultado usando 2 SQLs).

-- encontrar o codigo do produto
select CODIGO_DO_PRODUTO from TABELA_DE_PRODUTOS
where NOME_DO_PRODUTO = 'Linha Refrescante - 1 Litro - Morango/Limão';

-- vendas realizadas do produto
select * from ITENS_NOTAS_FISCAIS
where CODIGO_DO_PRODUTO in (
	select CODIGO_DO_PRODUTO from TABELA_DE_PRODUTOS
	where NOME_DO_PRODUTO = 'Linha Refrescante - 1 Litro - Morango/Limão')
order by QUANTIDADE desc;


-- total de limite de credito para cada estado 
select ESTADO, sum(LIMITE_DE_CREDITO) as LIMITE_TOTAL 
from TABELA_DE_CLIENTES
group by ESTADO;

-- maior preco para cada embalagem
select EMBALAGEM, max(PRECO_DE_LISTA) as MAIOR_PRECO 
from TABELA_DE_PRODUTOS
group by embalagem;

-- conta a qtd de produtos de cada embalagem
SELECT EMBALAGEM , COUNT(*) AS CONTADOR
FROM TABELA_DE_PRODUTOS
GROUP BY EMBALAGEM;

-- soma dos limites de credito para cada bairro do Rio de Janeiro 
SELECT BAIRRO, SUM(LIMITE_DE_CREDITO)
FROM TABELA_DE_CLIENTES
WHERE CIDADE = 'Rio de Janeiro'
GROUP BY BAIRRO ;

-- EXERCICIO: Aproveitando o exercício do vídeo anterior quantos itens de venda 
-- existem com a maior quantidade do produto '1101035'?
SELECT MAX(QUANTIDADE) FROM ITENS_NOTAS_FISCAIS
WHERE CODIGO_DO_PRODUTO = '1101035';

-- soma limite para cada estado (desde que seja maior que 900.000
SELECT ESTADO , SUM(LIMITE_DE_CREDITO) AS SOMA_LIMITE 
FROM TABELA_DE_CLIENTES
GROUP BY ESTADO
HAVING SUM(LIMITE_DE_CREDITO) > 900000;

-- maximo e minimo para cada embalagem cuja soma total de preços é menor ou igual a 80
SELECT EMBALAGEM , MAX(PRECO_DE_LISTA) as MAIOR_PRECO, MIN(PRECO_DE_LISTA) as MENOR_PRECO
FROM TABELA_DE_PRODUTOS
GROUP BY EMBALAGEM
HAVING SUM(PRECO_DE_LISTA) <= 80;

-- EXERCICIO: Quais foram os clientes que fizeram mais de 500 compras em 2015?
SELECT CPF, COUNT(*) FROM NOTAS_FISCAIS
WHERE YEAR(DATA_VENDA) = 2015
GROUP BY CPF
HAVING COUNT(*) > 500;
  
-- nome, preco e status (definido a partir do preco) para cada produto
SELECT NOME_DO_PRODUTO, PRECO_DE_LISTA,
CASE 
	WHEN PRECO_DE_LISTA >= 12 THEN 'PRODUTO CARO'
    WHEN PRECO_DE_LISTA BETWEEN 7 AND 11 THEN 'PRODUTO EM CONTA'
    WHEN PRECO_DE_LISTA < 7 THEN 'PRODUTO BARATO'
END AS STATUS_PRECO
FROM TABELA_DE_PRODUTOS;

-- preço medio do status de preco de acordo com cada embalagem
SELECT EMBALAGEM,
CASE 
	WHEN PRECO_DE_LISTA > 11 THEN 'PRODUTO CARO'
    WHEN PRECO_DE_LISTA BETWEEN 7 AND 11 THEN 'PRODUTO EM CONTA'
    WHEN PRECO_DE_LISTA < 7 THEN 'PRODUTO BARATO'
END AS STATUS_PRECO, AVG (PRECO_DE_LISTA) AS PRECO_MEDIO
FROM TABELA_DE_PRODUTOS
GROUP BY EMBALAGEM,
CASE 
	WHEN PRECO_DE_LISTA > 11 THEN 'PRODUTO CARO'
    WHEN PRECO_DE_LISTA BETWEEN 7 AND 11 THEN 'PRODUTO EM CONTA'
    WHEN PRECO_DE_LISTA < 7 THEN 'PRODUTO BARATO'
END 
ORDER BY EMBALAGEM;

-- EXERCICIO: Veja o ano de nascimento dos clientes e classifique-os como: 
-- Nascidos antes de 1990 são velhos, nascidos entre 1990 e 1995 são jovens 
-- e nascidos depois de 1995 são crianças. Liste o nome do cliente e esta classificação.
SELECT NOME, 
CASE
	WHEN YEAR(DATA_DE_NASCIMENTO) < 1990 THEN 'VELHO'
    WHEN YEAR(DATA_DE_NASCIMENTO) BETWEEN 1990 AND 1995 THEN 'JOVENS'
    ELSE 'CRIANÇAS'
END AS GRUPO_IDADE
FROM TABELA_DE_CLIENTES;