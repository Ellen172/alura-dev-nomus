use sucos;

alter table tb_cliente 
	add primary key (cpf);
    
alter table tb_cliente
	add column (data_nascimento date);
    
insert into tb_cliente 
	(cpf, nome, endereco1, endereco2, bairro, cidade, estado, cep, 
    idade, sexo, limite_credito, volume_compra, primeira_compra, data_nascimento) 
values 
	('00388934505', 'João da Silva', 'Rua Projetada A, nro 10', '', 'Vila Rosa', 
    'Caratinga', 'Amazonas', '2222222', 30, 'M', 10000.00, 2000, 0, '1992-07-23');

select * from tb_cliente;
