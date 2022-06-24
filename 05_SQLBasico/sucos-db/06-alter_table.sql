use sucos;

alter table tb_produto 
	add primary key (produto); 
    
select * from tb_produto where produto='1002334';

insert into tb_produto values 
('1002334', 'Linha Light - 1 Litro - Morango', 'PET', '1 Litro', 'Morango', 5.65);