use sucos;

select * from tb_produto
where produto = '544931'
or produto = '1078680';

update tb_produto set embalagem = 'PET', preco_lista = 3.20
where produto = '544931';

update tb_produto set embalagem = 'Lata'
where produto = '1078680';

/* Cláudia Morais (00236) recebeu aumento e sua comissão 
passou a ser de 11%. José Geraldo da Fonseca (00233) reclamou 
que seu nome real é José Geraldo da Fonseca Junior. */

select * from tb_vendedores;

update tb_vendedores set percentual_comissao = 11 where matricula = '00236';
update tb_vendedores set nome = 'José Geraldo da Fonseca Junior' where matricula = '00233';