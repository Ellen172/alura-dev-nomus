/* RELATORIO DE VENDAS: Comparar o volume_de_compra dos clientes 
com o volume real de compra mensal */

-- retorna cpf, data_venda e qtd para cada venda
select NF.CPF, date_format(NF.DATA_VENDA, '%Y-%m') as ANO_MES, INF.QUANTIDADE  
from NOTAS_FISCAIS NF inner join ITENS_NOTAS_FISCAIS INF 
	on NF.NUMERO = INF.NUMERO;
    
-- agrupa a venda pelo cpf, qtd será a soma total
select NF.CPF, date_format(NF.DATA_VENDA, '%Y-%m') as ANO_MES, sum(INF.QUANTIDADE) as QTD_VENDAS
from NOTAS_FISCAIS NF inner join ITENS_NOTAS_FISCAIS INF 
	on NF.NUMERO = INF.NUMERO
group by NF.CPF, date_format(NF.DATA_VENDA, '%Y-%m');

-- consulta do limite de compra por cliente
select TC.CPF, TC.NOME, TC.VOLUME_DE_COMPRA AS LIMITE
from TABELA_DE_CLIENTES TC;

-- comparando tabelas
select NF.CPF, TC.NOME, date_format(NF.DATA_VENDA, '%Y-%m') as ANO_MES, 
	sum(INF.QUANTIDADE) as QTD_VENDAS, max(TC.VOLUME_DE_COMPRA) AS QTD_LIMITE
from NOTAS_FISCAIS NF 
inner join ITENS_NOTAS_FISCAIS INF 
	on NF.NUMERO = INF.NUMERO
inner join TABELA_DE_CLIENTES TC
	on TC.CPF = NF.CPF
group by NF.CPF, TC.NOME, date_format(NF.DATA_VENDA, '%Y-%m');

-- finalizando 
select X.CPF, X.NOME, X.ANO_MES, X.QTD_VENDAS, X.QTD_LIMITE, 
    CASE 
		WHEN (X.QTD_LIMITE - X.QTD_VENDAS) < 0 THEN 'INVALIDO'
        ELSE 'VALIDO'
	END AS STATUS_VENDA
from (select NF.CPF, TC.NOME, date_format(NF.DATA_VENDA, '%Y-%m') as ANO_MES, 
			sum(INF.QUANTIDADE) as QTD_VENDAS, max(TC.VOLUME_DE_COMPRA) AS QTD_LIMITE
		from NOTAS_FISCAIS NF 
		inner join ITENS_NOTAS_FISCAIS INF 
			on NF.NUMERO = INF.NUMERO
		inner join TABELA_DE_CLIENTES TC
			on TC.CPF = NF.CPF
		group by NF.CPF, TC.NOME, date_format(NF.DATA_VENDA, '%Y-%m')) X;


/* EXERCICIO: Nesta aula construímos um relatório que apresentou os clientes 
que tiveram vendas inválidas. Complemente este relatório listando somente os que 
tiveram vendas inválidas e calculando a diferença entre o limite de venda máximo e 
o realizado, em percentuais. */
select X.CPF, X.NOME, X.ANO_MES, X.QTD_VENDAS, X.QTD_LIMITE, 
	ROUND((X.QTD_VENDAS / X.QTD_LIMITE)*100, 2) AS PERCENTUAL,
    CASE 
		WHEN (X.QTD_LIMITE - X.QTD_VENDAS) < 0 THEN 'INVALIDO'
        ELSE 'VALIDO'
	END AS STATUS_VENDA
from (select NF.CPF, TC.NOME, date_format(NF.DATA_VENDA, '%Y-%m') as ANO_MES, 
			sum(INF.QUANTIDADE) as QTD_VENDAS, max(TC.VOLUME_DE_COMPRA) AS QTD_LIMITE
		from NOTAS_FISCAIS NF 
		inner join ITENS_NOTAS_FISCAIS INF 
			on NF.NUMERO = INF.NUMERO
		inner join TABELA_DE_CLIENTES TC
			on TC.CPF = NF.CPF
		group by NF.CPF, TC.NOME, date_format(NF.DATA_VENDA, '%Y-%m')) X;