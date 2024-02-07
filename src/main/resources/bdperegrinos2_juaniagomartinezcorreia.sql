drop database if exists bdperegrinos2_JuanIagoMartinezCorreia;
create database bdperegrinos2_JuanIagoMartinezCorreia character set utf8mb4;
use bdperegrinos2_JuanIagoMartinezCorreia;

create table TParada
(
    pkid    int unsigned auto_increment primary key not null,
    cnombre varchar(255)                            not null,
    cregion char(1)                                 not null
);

create table TCarnet
(
    pkid        int unsigned auto_increment primary key,
    fkid_parada int unsigned    not null,
    fechaexp    date            not null,
    distancia   double unsigned not null default 0.0,
    nvips       int unsigned    not null default 0,
    foreign key (fkid_parada) references TParada (pkid)
);

create table TPeregrino
(
    pkfkid        int unsigned primary key,
    cnombre       varchar(255) not null,
    cnacionalidad varchar(255) not null,
    foreign key (pkfkid) references TCarnet (pkid)
);

create table TEstancia
(
    pkid           int unsigned auto_increment primary key,
    fkid_parada    int unsigned not null,
    fkid_peregrino int unsigned not null,
    fecha          date         not null,
    vip            boolean      not null default false,
    foreign key (fkid_parada) references TParada (pkid),
    foreign key (fkid_peregrino) references TPeregrino (pkfkid)
);

create table TPeregrino_Parada
(
    pkfkid_parada    int unsigned not null,
    pkfkid_peregrino int unsigned not null,
    primary key (pkfkid_parada, pkfkid_peregrino),
    foreign key (pkfkid_parada) references TParada (pkid),
    foreign key (pkfkid_peregrino) references TPeregrino (pkfkid)
);

create table TPerfil
(
    pkid_usuario   varchar(255) primary key,
    cpassword      varchar(255) not null,
    fkid_peregrino int unsigned default null,
    fkid_parada    int unsigned default null,
    foreign key (fkid_peregrino) references TPeregrino (pkfkid),
    foreign key (fkid_parada) references TParada (pkid)
);

create table TDireccion
(
    pkid      int unsigned auto_increment primary key,
    direccion varchar(255) not null,
    localidad varchar(255) not null
);

create table TEnvioACasa
(
    pkid           int unsigned auto_increment primary key,
    peso           double unsigned not null,
    largo          int unsigned    not null,/*uso estos datos puesto q en mysql no hay arrays*/
    ancho          int unsigned    not null,
    alto           int unsigned    not null,
    urgente        boolean         not null default false,
    fkid_parada    int unsigned,
    fkid_direccion int unsigned,
    foreign key (fkid_parada) references TParada (pkid),
    foreign key (fkid_direccion) references TDireccion (pkid)
);

create table TConjuntoContratado
(
    pkid          int unsigned auto_increment primary key,
    precioTotal   double unsigned not null,
    metodoPago    char            not null,
    extra         varchar(255) default null,
    fkid_estancia int unsigned,
    foreign key (fkid_estancia) references TEstancia (pkid)
);

create table TServicio
(
    pkid       int unsigned auto_increment primary key,
    nombre     varchar(255) not null,
    precio     double       not null,
    fkid_envio int unsigned,
    foreign key (fkid_envio) references TConjuntoContratado (pkid)
);

create table TConjunto_Servicio
(
    pkfkid_conjunto int unsigned not null,
    pkfkid_servicio int unsigned not null,
    primary key (pkfkid_conjunto, pkfkid_servicio),
    foreign key (pkfkid_conjunto) references TConjuntoContratado (pkid),
    foreign key (pkfkid_servicio) references TServicio (pkid)
);



INSERT INTO `tparada` (`pkid`, `cnombre`, `cregion`)
VALUES (1, 'Parada1', 'J'),
       (2, 'Parada2', 'T'),
       (3, 'Parada3', 'U'),
       (4, 'Parada4', 'N'),
       (5, 'Parada5', 'E');

INSERT INTO `tcarnet` (`pkid`, `fkid_parada`, `fechaexp`, `distancia`, `nvips`)
VALUES (1, 1, '2016-12-22', 20, 0),
       (2, 3, '2020-11-27', 20, 0),
       (3, 4, '2017-05-16', 5, 0),
       (4, 2, '2019-01-24', 0, 0),
       (5, 4, '2010-02-16', 0, 0);

INSERT INTO `tperegrino` (`pkfkid`, `cnombre`, `cnacionalidad`)
VALUES (1, 'Juan', 'España'),
       (2, 'Jennifer', 'Colombia'),
       (3, 'Mario', 'Italia'),
       (4, 'Luigi', 'Italia'),
       (5, 'Zelda', 'Emiratos Árabes Unidos');

INSERT INTO `testancia` (`pkid`, `fkid_parada`, `fkid_peregrino`, `fecha`, `vip`)
VALUES (1, 1, 1, '2023-06-01', 0),/*peregrino1 hace 5 estancias*/
       (2, 2, 1, '2023-06-02', 0),
       (3, 3, 1, '2023-11-03', 0),
       (4, 4, 1, '2023-11-04', 0),
       (5, 5, 1, '2023-11-05', 0),
       (6, 1, 2, '2023-01-01', 0),/*peregrino2 hace 2 estancias*/
       (7, 2, 2, '2023-02-02', 0);

INSERT INTO `tperegrino_parada`(pkfkid_parada, pkfkid_peregrino)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),/*peregrino1 pasa por todas las paradas y se estancia en todas*/
       (1, 2),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 2),/*peregrino 2 pasa por todas las paradas solo estancia en 2*/
       (1, 3),
       (2, 3),/*peregrino 3 pasa por 2 paradas*/
       (3, 4),
       (4, 5);/*peregrino 4 y 5 solo tiene la parada inicial*/

INSERT INTO `tperfil` (`pkid_usuario`, `cpassword`, `fkid_peregrino`, `fkid_parada`)
VALUES ("juan", "123", 1, null),
       ("jennie", "123", 2, null),
       ("mario", "123", 3, null),
       ("luigi", "123", 4, null),
       ("zelda", "123", 5, null),
       ("adminp1", "123", null, 1),
       ("adminp2", "123", null, 2),
       ("adminp3", "123", null, 3),
       ("adminp4", "123", null, 4),
       ("adminp5", "123", null, 5);

