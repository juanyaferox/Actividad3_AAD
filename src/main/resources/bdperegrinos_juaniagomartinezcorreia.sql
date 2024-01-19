drop database if exists bdperegrinos_JuanIagoMartinezCorreia;
create database bdperegrinos_JuanIagoMartinezCorreia character set utf8mb4;
use bdperegrinos_JuanIagoMartinezCorreia;

create table TParada (
	pkid int unsigned auto_increment primary key not null,
    cnombre varchar(255) not null,
    cregion char(1) not null
);

create table TCarnet(
	pkid int unsigned auto_increment primary key,
    fkid_parada int unsigned not null,
    fechaexp date not null,
    distancia double unsigned not null default 0.0,
    nvips int unsigned not null default 0,
    foreign key (fkid_parada) references TParada(pkid)
);

create table TPeregrino(
	pkfkid int unsigned primary key,
    cnombre varchar(255) not null,
    cnacionalidad varchar(255) not null,
    foreign key (pkfkid) references TCarnet(pkid)
);

create table TEstancia(
	pkid int unsigned auto_increment primary key,
    fkid_parada int unsigned not null,
    fkid_peregrino int unsigned not null,
    fecha date not null,
    vip boolean not null default false,
	foreign key (fkid_parada) references TParada(pkid),
    foreign key (fkid_peregrino) references TPeregrino(pkfkid)
);

create table TPeregrino_Parada(
	pkfkid_parada int unsigned not null,
    pkfkid_peregrino int unsigned not null,
    primary key (pkfkid_parada, pkfkid_peregrino),
    foreign key (pkfkid_parada) references TParada(pkid),
    foreign key (pkfkid_peregrino) references TPeregrino(pkfkid)
);

create table TPerfil( 
	pkid_usuario varchar(255) primary key,
    cpassword varchar(255) not null,
    fkid_peregrino int unsigned default null,
    fkid_parada int unsigned default null,
    foreign key (fkid_peregrino) references TPeregrino(pkfkid),
    foreign key (fkid_parada) references TParada(pkid)
);

INSERT INTO `tparada` (`pkid`, `cnombre`, `cregion`) VALUES
(1, 'Parada1', 'J'),
(2, 'Parada2', 'T'),
(3, 'Parada3', 'U'),
(4, 'Parada4', 'N'),
(5, 'Parada5', 'E');

INSERT INTO `tcarnet` (`pkid`, `fkid_parada`, `fechaexp`, `distancia`, `nvips`) VALUES
(1, 1, '2016-12-22', 0, 0),
(2, 3, '2020-11-27', 0, 0),
(3, 4, '2017-05-16', 0, 0),
(4, 2, '2019-01-24', 0, 0),
(5, 4, '2010-02-16', 0, 0);

INSERT INTO `tperegrino` (`pkfkid`, `cnombre`, `cnacionalidad`) VALUES
(1, 'Juan', 'España'),
(2, 'Jennifer', 'Colombia'),
(3, 'Mario', 'Italia'),
(4, 'Luigi', 'Italia'),
(5, 'Zelda', 'Emiratos Árabes Unidos');

INSERT INTO `testancia` (`pkid`, `fkid_parada`, `fkid_peregrino`, `fecha`, `vip`) VALUES
(1, 1, 1, '2023-06-01', 0),
(2, 2, 1, '2023-06-02', 0),
(3, 3, 1, '2023-11-03', 0),
(4, 4, 1, '2023-11-04', 0),
(5, 5, 1, '2023-11-05', 0);

INSERT INTO `tperfil` (`pkid_usuario`,`cpassword`,`fkid_peregrino`,`fkid_parada`) VALUES
("juan","123",1,null),
("adminp1","123",null,1);

