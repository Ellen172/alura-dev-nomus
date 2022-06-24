/* RELATORIO DE VENDAS : qtd de litros vendidos para cada sabor, 
por ano, e um percentual de participação */

select * from ITENS_NOTAS_FISCAIS; -- qtd vendida
select * from TABELA_DE_PRODUTOS; -- sabor
select * from NOTAS_FISCAIS; -- ano da venda

-- informações necessarias das tabelas
select TP.SABOR, NF.DATA_VENDA, INF.QUANTIDADE
from TABELA_DE_PRODUTOS TP 
inner join ITENS_NOTAS_FISCAIS INF on TP.CODIGO_DO_PRODUTO = INF.CODIGO_DO_PRODUTO
inner join NOTAS_FISCAIS NF on INF.NUMERO = NF.NUMERO;

-- agrupados por ano, ordenados pelo que mais vendeu
select TP.SABOR, year(NF.DATA_VENDA) as ANO, sum(INF.QUANTIDADE) as QTD_TOTAL
from TABELA_DE_PRODUTOS TP 
inner join ITENS_NOTAS_FISCAIS INF on TP.CODIGO_DO_PRODUTO = INF.CODIGO_DO_PRODUTO
inner join NOTAS_FISCAIS NF on INF.NUMERO = NF.NUMERO
group by year(NF.DATA_VENDA), TP.SABOR
order by sum(INF.QUANTIDADE) desc;

-- qtd total vendida por sabor a cada ano 
select year(DATA_VENDA), sum(QUANTIDADE)
from NOTAS_FISCAIS NF inner join ITENS_NOTAS_FISCAIS INF
on NF.NUMERO = INF.NUMERO
group by year(DATA_VENDA)
order by sum(QUANTIDADE) desc; 

-- unindo tabelas 
select * from
(select TP.SABOR, year(NF.DATA_VENDA) as ANO, sum(INF.QUANTIDADE) as QTD_ANUAL
from TABELA_DE_PRODUTOS TP 
inner join ITENS_NOTAS_FISCAIS INF on TP.CODIGO_DO_PRODUTO = INF.CODIGO_DO_PRODUTO
inner join NOTAS_FISCAIS NF on INF.NUMERO = NF.NUMERO
group by year(NF.DATA_VENDA), TP.SABOR) as VENDAS_SABOR
inner join 
(select year(DATA_VENDA) as ANO, sum(QUANTIDADE) as QTD_TOTAL
from NOTAS_FISCAIS NF inner join ITENS_NOTAS_FISCAIS INF
on NF.NUMERO = INF.NUMERO
group by year(DATA_VENDA)
order by sum(QUANTIDADE) desc) as VENDAS_TOTAL
on VENDAS_SABOR.ANO = VENDAS_TOTAL.ANO;

-- inserindo percentual 
select VENDAS_SABOR.SABOR, VENDAS_SABOR.ANO, VENDAS_SABOR.QTD_ANUAL, VENDAS_SABOR.ANO,
	(VENDAS_SABOR.QTD_ANUAL / VENDAS_TOTAL.QTD_TOTAL)*100 as PERCENTUAL from
(select TP.SABOR, year(NF.DATA_VENDA) as ANO, sum(INF.QUANTIDADE) as QTD_ANUAL
from TABELA_DE_PRODUTOS TP 
inner join ITENS_NOTAS_FISCAIS INF on TP.CODIGO_DO_PRODUTO = INF.CODIGO_DO_PRODUTO
inner join NOTAS_FISCAIS NF on INF.NUMERO = NF.NUMERO
group by year(NF.DATA_VENDA), TP.SABOR) as VENDAS_SABOR
inner join 
(select year(DATA_VENDA) as ANO, sum(QUANTIDADE) as QTD_TOTAL
from NOTAS_FISCAIS NF inner join ITENS_NOTAS_FISCAIS INF
on NF.NUMERO = INF.NUMERO
group by year(DATA_VENDA)
order by sum(QUANTIDADE) desc) as VENDAS_TOTAL
on VENDAS_SABOR.ANO = VENDAS_TOTAL.ANO;

-- EXERCICIO: Modifique o relatório mas agora para ver o ranking das vendas por tamanho.

select TP.TAMANHO, year(NF.DATA_VENDA) as ANO, sum(INF.QUANTIDADE) as TOTAL
from NOTAS_FISCAIS NF inner join ITENS_NOTAS_FISCAIS INF on NF.NUMERO = INF.NUMERO
inner join TABELA_DE_PRODUTOS TP on TP.CODIGO_DO_PRODUTO = INF.CODIGO_DO_PRODUTO
group by TP.TAMANHO, year(NF.DATA_VENDA)
order by TP.TAMANHO;