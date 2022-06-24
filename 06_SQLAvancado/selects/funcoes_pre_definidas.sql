-- FUNÇÕES COM STRING

-- remove espaços da esquerda
SELECT LTRIM('    OLA') AS RESULTADO;

-- remove espaços da direita
SELECT RTRIM('OLA      ') AS RESULTADO;

-- remove espaços antes e depois 
SELECT TRIM('    OLA      ') AS RESULTADO;

-- concatenar strings 
SELECT CONCAT('OLA', ', ' , 'TUDO BEM?') AS RESULTADO;

-- torna maiusculo
SELECT UPPER('ola') AS RESULTADO;

-- substring 
SELECT SUBSTRING('OLA, TUDO BEM?', 6) AS RESULTADO; -- a partir da posição 5
SELECT SUBSTRING('OLA, TUDO BEM?', 6, 8) AS RESULTADO; -- a partir da posição 5, com 8 carcteres

-- usando com bando de dados
SELECT concat(NOME, ' (' , CPF, ') ' ) AS RESULTADO 
FROM TABELA_DE_CLIENTES;

-- EXERCICIO: Faça uma consulta listando o nome do cliente e o 
-- endereço completo (Com rua, bairro, cidade e estado).
SELECT NOME,CONCAT(ENDERECO_1, ' ', ENDERECO_2, ', Bairro ' , BAIRRO, 
	', ', CIDADE, ' - ', ESTADO) AS ENDERECO 
FROM TABELA_DE_CLIENTES;

-- FUNÇÕES COM DATAS 

-- data atual
SELECT CURDATE();

-- hora atual
SELECT CURRENT_TIME();

-- data e hora atual
SELECT CURRENT_TIMESTAMP();

-- ano da data atual
SELECT year(CURRENT_TIMESTAMP());

-- dia da semana da data atual
SELECT DAYNAME(CURRENT_TIMESTAMP());

-- nome do mes atual
SELECT MONTHNAME(CURRENT_TIMESTAMP());

-- total de dias de vida desde 01/07/2002
SELECT DATEDIFF(CURDATE(), "2002-07-01");  

-- subtrair data
SELECT DATE_SUB(CURRENT_TIMESTAMP(), INTERVAL 5 DAY) AS CINCO_DIAS_ATRAS;

-- usando no banco de dados
SELECT dayname(DATA_VENDA) AS DIA, monthname(DATA_VENDA) AS MES, year(DATA_VENDA) AS ANO 
FROM NOTAS_FISCAIS;

-- EXERCICIO: Crie uma consulta que mostre o nome e a idade atual dos clientes.
SELECT NOME, TIMESTAMPDIFF(YEAR, DATA_DE_NASCIMENTO, CURDATE()) AS IDADE
FROM TABELA_DE_CLIENTES;

-- FUNÇÕES NUMERICAS

SELECT (23+((25-2)/2)*45) AS RESULTADO;

-- arredonda como proximo inteiro acima do declarado 
SELECT CEILING(12.333323332) AS RESULTADO;

-- arredonda de acordo com as casas decimais
SELECT ROUND(12.333323332) AS RESULTADO;
SELECT ROUND(12.333323332, 3) AS RESULTADO; -- pode ser definido qtd de casas decimais

-- arredonda como se não houve decimais
SELECT FLOOR(12.333323332) AS RESULTADO;

-- retorna um nro aleatorio
SELECT RAND() AS ALEATORIO;

-- faturamento arredondado
SELECT NUMERO, QUANTIDADE, PRECO, ROUND(QUANTIDADE * PRECO, 2) AS FATURAMENTO
FROM ITENS_NOTAS_FISCAIS;	

-- EXERCICIO: Na tabela de notas fiscais temos o valor do imposto. Já na tabela 
-- de itens temos a quantidade e o faturamento. Calcule o valor do imposto pago no 
-- ano de 2015 arredondando para o menor inteiro.

SELECT YEAR(DATA_VENDA), ROUND(SUM(IMPOSTO*(QUANTIDADE*PRECO)), 2) AS VALOR_IMPOSTO
FROM NOTAS_FISCAIS NF INNER JOIN ITENS_NOTAS_FISCAIS I
ON NF.NUMERO = I.NUMERO
WHERE YEAR(DATA_VENDA) = 2015
GROUP BY YEAR(DATA_VENDA);

-- CONVERSAO DE DADOS

SELECT CONCAT('HOJE É DIA: ', 
	DATE_FORMAT(CURRENT_TIMESTAMP(), '%W, %d/%m/%y - semana %u do ano')) AS RESULTADO;
    
SELECT convert(23.3, CHAR) AS RESULTADO;
SELECT SUBSTRING(convert(23.3, CHAR), 1,1) AS RESULTADO;

SELECT SUBSTRING(23.3, 1,1) AS RESULTADO;

-- EXERCICIO: Queremos construir um SQL cujo resultado seja, para cada cliente:
-- “O cliente João da Silva faturou 120000 no ano de 2015”.
-- Somente para o ano de 2016.

SELECT CONCAT('O cliente ', TC.NOME, ' faturou ', 
	round(SUM(INF.QUANTIDADE * INF.preco), 2)
	, ' no ano ', convert(YEAR(NF.DATA_VENDA), char(20))) 
    AS SENTENCA 
FROM NOTAS_FISCAIS NF
INNER JOIN ITENS_NOTAS_FISCAIS INF 	
	ON NF.NUMERO = INF.NUMERO
INNER JOIN TABELA_DE_CLIENTES TC 
	ON NF.CPF = TC.CPF
WHERE YEAR(DATA_VENDA) = 2015
GROUP BY YEAR(NF.DATA_VENDA), NF.CPF;
