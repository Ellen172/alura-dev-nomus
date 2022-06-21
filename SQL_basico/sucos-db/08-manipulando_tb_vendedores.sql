use sucos;

alter table tb_vendedores
	add data_admissao date, 
    add de_ferias bit;
    
alter table tb_vendedores
	add primary key (matricula);
    
insert into tb_vendedores 
	(matricula, nome, percentual_comissao, data_admissao, de_ferias) 
values 
	('00237', 'Márcio Almeida Silva', 8, '2014-08-15', 0), 
    ('00238', 'Cláudia Morais', 8, '2013-09-17', 1),
    ('00239', 'Roberta Martins', 11, '2017-03-18', 1),
    ('00240', 'Péricles Alves', 11, '2016-08-21', 0);
    
select * from tb_vendedores;