/*
// criar novo esquema
CREATE {DATABASE | SCHEMA} [IF NOT EXISTS] db_name 
	[DEFAULT] CHARACTER SET = charset_name
    [DEFAULT] COLLATE = collation_name
    DEFAULT ENCRYPTION = {'Y'|'N'}
*/

create database sucos;

create database sucos2 
	default character set utf8;

/*
// apagar esquema
DROP {DATABASE | SCHEMA} [IF EXISTS] db_name;
*/

drop database sucos;

drop database sucos2;