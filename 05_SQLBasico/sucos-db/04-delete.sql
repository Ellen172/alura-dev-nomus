use sucos ;

select * from tb_produto where produto = '1078680';

delete from tb_produto where produto = '1078680';

/* O vendedor João Geraldo Fonseca Junior matrícula (00233) foi demitido.  */
delete from tb_vendedores where matricula = '00233';
