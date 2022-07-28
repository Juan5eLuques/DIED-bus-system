CREATE SCHEMA APLICACION_BUS;

CREATE TABLE APLICACION_BUS.LINEA
(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    color VARCHAR(15) NOT NULL,
    tipo VARCHAR(15 )NOT NULL,
    asientos INT NOT NULL,
    parados INT,
    wifi BOOLEAN,
    aire BOOLEAN
);

CREATE TABLE APLICACION_BUS.PARADA
(
    id INT PRIMARY KEY, 
    activa BOOLEAN NOT NULL,
    calle VARCHAR(15) NOT NULL,
    numero INT NOT NULL
);

CREATE TABLE APLICACION_BUS.CAMINO
(
    idOrigen INT NOT NULL,
    idDestino INT NOT NULL,
    distancia DECIMAL (5,1) NOT NULL,
    duracion INT NOT NULL,
    activa BOOLEAN NOT NULL,
    PRIMARY KEY (idOrigen, idDestino),
    FOREIGN KEY(idOrigen) REFERENCES APLICACION_BUS.PARADA(id),
    FOREIGN KEY(idDestino) REFERENCES APLICACION_BUS.PARADA(id)
);

CREATE TABLE APLICACION_BUS.TRAYECTO
(
id SERIAL PRIMARY KEY,
idLinea INT NOT NULL,
FOREIGN KEY(idLinea) REFERENCES APLICACION_BUS.LINEA(id)
);

CREATE TABLE APLICACION_BUS.INCIDENCIAS
(
    id INT PRIMARY KEY,
    idOrigen INT NOT NULL,
    idDestino INT NOT NULL,
    inicio DATE NOT NULL,
    fin DATE,
    descripcion VARCHAR (500), 
    resuelta BOOLEAN,
    FOREIGN KEY(idOrigen,idDestino) REFERENCES APLICACION_BUS.CAMINO(idOrigen,idDestino)
);
CREATE TABLE APLICACION_BUS.CAMINOTRAYECTO
(
    idOrigen INT NOT NULL,
	idDestino INT NOT NULL,
    idTrayecto INT NOT NULL,
    orden INT NOT NULL,
    PRIMARY KEY(idTrayecto,orden),
    FOREIGN KEY(idOrigen,idDestino) REFERENCES APLICACION_BUS.CAMINO(idOrigen,idDestino),
    FOREIGN KEY(idTrayecto) REFERENCES APLICACION_BUS.TRAYECTO(id)
);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(1,,'TRUE','CALLE 0',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(2,,'TRUE','CALLE 0',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(3,,'TRUE','CALLE 0',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(4,'TRUE','CALLE 0',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(5,'TRUE','CALLE 0',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(6,'TRUE','CALLE 0',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(7,'TRUE','CALLE 0',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(8,'TRUE','CALLE 0',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(9,'TRUE','CALLE 0',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(10,'TRUE','CALLE 0',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(11,'TRUE','CALLE 1',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(12,'TRUE','CALLE 1',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(13,'TRUE','CALLE 1',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(14,'TRUE','CALLE 1',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(15,'TRUE','CALLE 1',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(16,'TRUE','CALLE 1',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(17,'TRUE','CALLE 1',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(18,'TRUE','CALLE 1',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(19,'TRUE','CALLE 1',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(20,'TRUE','CALLE 1',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(21,'TRUE','CALLE 2',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(22,'TRUE','CALLE 2',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(23,'TRUE','CALLE 2',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(24,'TRUE','CALLE 2',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(25,'TRUE','CALLE 2',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(26,'TRUE','CALLE 2',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(27,'TRUE','CALLE 2',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(28,'TRUE','CALLE 2',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(29,'TRUE','CALLE 2',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(30,'TRUE','CALLE 2',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(31,'TRUE','CALLE 3',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(32,'TRUE','CALLE 3',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(33,'TRUE','CALLE 3',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(34,'TRUE','CALLE 3',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(35,'TRUE','CALLE 3',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(36,'TRUE','CALLE 3',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(37,'TRUE','CALLE 3',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(38,'TRUE','CALLE 3',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(39,'TRUE','CALLE 3',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(40,'TRUE','CALLE 3',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(41,'TRUE','CALLE 4',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(42,'TRUE','CALLE 4',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(43,'TRUE','CALLE 4',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(44,'TRUE','CALLE 4',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(45,'TRUE','CALLE 4',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(46,'TRUE','CALLE 4',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(47,'TRUE','CALLE 4',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(48,'TRUE','CALLE 4',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(49,'TRUE','CALLE 4',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(50,'TRUE','CALLE 4',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(51,'TRUE','CALLE 5',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(52,'TRUE','CALLE 5',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(53,'TRUE','CALLE 5',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(54,'TRUE','CALLE 5',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(55,'TRUE','CALLE 5',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(56,'TRUE','CALLE 5',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(57,'TRUE','CALLE 5',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(58,'TRUE','CALLE 5',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(59,'TRUE','CALLE 5',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(60,'TRUE','CALLE 5',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(61,'TRUE','CALLE 6',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(62,'TRUE','CALLE 6',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(63,'TRUE','CALLE 6',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(64,'TRUE','CALLE 6',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(65,'TRUE','CALLE 6',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(66,'TRUE','CALLE 6',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(67,'TRUE','CALLE 6',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(68,'TRUE','CALLE 6',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(69,'TRUE','CALLE 6',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(70,'TRUE','CALLE 6',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(71,'TRUE','CALLE 7',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(72,'TRUE','CALLE 7',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(73,'TRUE','CALLE 7',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(74,'TRUE','CALLE 7',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(75,'TRUE','CALLE 7',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(76,'TRUE','CALLE 7',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(77,'TRUE','CALLE 7',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(78,'TRUE','CALLE 7',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(79,'TRUE','CALLE 7',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(80,'TRUE','CALLE 7',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(81,'TRUE','CALLE 8',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(82,'TRUE','CALLE 8',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(83,'TRUE','CALLE 8',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(84,'TRUE','CALLE 8',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(85,'TRUE','CALLE 8',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(86,'TRUE','CALLE 8',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(87,'TRUE','CALLE 8',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(88,'TRUE','CALLE 8',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(89,'TRUE','CALLE 8',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(90,'TRUE','CALLE 8',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(91,'TRUE','CALLE 9',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(92,'TRUE','CALLE 9',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(93,'TRUE','CALLE 9',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(94,'TRUE','CALLE 9',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(95,'TRUE','CALLE 9',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(96,'TRUE','CALLE 9',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(97,'TRUE','CALLE 9',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(98,'TRUE','CALLE 9',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(99,'TRUE','CALLE 9',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(100,'TRUE','CALLE 9',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(101,'TRUE','CALLE 10',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(102,'TRUE','CALLE 10',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(103,'TRUE','CALLE 10',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(104,'TRUE','CALLE 10',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(105,'TRUE','CALLE 10',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(106,'TRUE','CALLE 10',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(107,'TRUE','CALLE 10',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(108,'TRUE','CALLE 10',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(109,'TRUE','CALLE 10',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(110,'TRUE','CALLE 10',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(111,'TRUE','CALLE 11',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(112,'TRUE','CALLE 11',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(113,'TRUE','CALLE 11',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(114,'TRUE','CALLE 11',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(115,'TRUE','CALLE 11',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(116,'TRUE','CALLE 11',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(117,'TRUE','CALLE 11',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(118,'TRUE','CALLE 11',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(119,'TRUE','CALLE 11',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(120,'TRUE','CALLE 11',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(121,'TRUE','CALLE 12',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(122,'TRUE','CALLE 12',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(123,'TRUE','CALLE 12',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(124,'TRUE','CALLE 12',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(125,'TRUE','CALLE 12',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(126,'TRUE','CALLE 12',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(127,'TRUE','CALLE 12',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(128,'TRUE','CALLE 12',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(129,'TRUE','CALLE 12',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(130,'TRUE','CALLE 12',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(131,'TRUE','CALLE 13',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(132,'TRUE','CALLE 13',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(133,'TRUE','CALLE 13',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(134,'TRUE','CALLE 13',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(135,'TRUE','CALLE 13',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(136,'TRUE','CALLE 13',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(137,'TRUE','CALLE 13',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(138,'TRUE','CALLE 13',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(139,'TRUE','CALLE 13',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(140,'TRUE','CALLE 13',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(141,'TRUE','CALLE 14',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(142,'TRUE','CALLE 14',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(143,'TRUE','CALLE 14',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(144,'TRUE','CALLE 14',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(145,'TRUE','CALLE 14',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(146,'TRUE','CALLE 14',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(147,'TRUE','CALLE 14',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(148,'TRUE','CALLE 14',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(149,'TRUE','CALLE 14',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(150,'TRUE','CALLE 14',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(151,'TRUE','CALLE 15',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(152,'TRUE','CALLE 15',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(153,'TRUE','CALLE 15',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(154,'TRUE','CALLE 15',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(155,'TRUE','CALLE 15',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(156,'TRUE','CALLE 15',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(157,'TRUE','CALLE 15',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(158,'TRUE','CALLE 15',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(159,'TRUE','CALLE 15',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(160,'TRUE','CALLE 15',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(161,'TRUE','CALLE 16',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(162,'TRUE','CALLE 16',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(163,'TRUE','CALLE 16',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(164,'TRUE','CALLE 16',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(165,'TRUE','CALLE 16',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(166,'TRUE','CALLE 16',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(167,'TRUE','CALLE 16',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(168,'TRUE','CALLE 16',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(169,'TRUE','CALLE 16',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(170,'TRUE','CALLE 16',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(171,'TRUE','CALLE 17',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(172,'TRUE','CALLE 17',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(173,'TRUE','CALLE 17',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(174,'TRUE','CALLE 17',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(175,'TRUE','CALLE 17',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(176,'TRUE','CALLE 17',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(177,'TRUE','CALLE 17',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(178,'TRUE','CALLE 17',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(179,'TRUE','CALLE 17',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(180,'TRUE','CALLE 17',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(181,'TRUE','CALLE 18',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(182,'TRUE','CALLE 18',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(183,'TRUE','CALLE 18',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(184,'TRUE','CALLE 18',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(185,'TRUE','CALLE 18',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(186,'TRUE','CALLE 18',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(187,'TRUE','CALLE 18',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(188,'TRUE','CALLE 18',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(189,'TRUE','CALLE 18',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(190,'TRUE','CALLE 18',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(191,'TRUE','CALLE 19',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(192,'TRUE','CALLE 19',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(193,'TRUE','CALLE 19',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(194,'TRUE','CALLE 19',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(195,'TRUE','CALLE 19',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(196,'TRUE','CALLE 19',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(197,'TRUE','CALLE 19',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(198,'TRUE','CALLE 19',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(199,'TRUE','CALLE 19',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(200,'TRUE','CALLE 19',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(201,'TRUE','CALLE 20',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(202,'TRUE','CALLE 20',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(203,'TRUE','CALLE 20',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(204,'TRUE','CALLE 20',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(205,'TRUE','CALLE 20',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(206,'TRUE','CALLE 20',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(207,'TRUE','CALLE 20',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(208,'TRUE','CALLE 20',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(209,'TRUE','CALLE 20',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(210,'TRUE','CALLE 20',1850);

INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(211,'TRUE','CALLE 21',50);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(212,'TRUE','CALLE 21',250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(213,'TRUE','CALLE 21',450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(214,'TRUE','CALLE 21',650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(215,'TRUE','CALLE 21',850);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(216,'TRUE','CALLE 21',1050);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(217,'TRUE','CALLE 21',1250);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(218,'TRUE','CALLE 21',1450);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(219,'TRUE','CALLE 21',1650);
INSERT INTO APLICACION_BUS.PARADA (id, activa, calle, numero) values(220,'TRUE','CALLE 21',1850);

--Calle0 -> (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (1,2,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (2,3,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (2,51,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (3,4,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (4,5,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (4,91,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (5,6,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (6,7,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (6,131,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (7,8,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (8,9,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (8,171,200,2,'true');

--Calle1 -> (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (11,12,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (12,13,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (12,41,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (13,14,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (14,15,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (14,81,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (15,16,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (16,17,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (16,121,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (17,18,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (18,19,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (18,161,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (19,20,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (20,201,200,2,'true');

--Calle2 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (29,28,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (29,172,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (28,27,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (28,151,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (27,26,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (27,132,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (26,25,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (26,111,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (25,24,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (25,92,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (24,23,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (24,71,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (23,22,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (23,52,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (22,21,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (22,31,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (21,12,200,2,'true');

--Calle3 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (40,39,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (40,181,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (39,38,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (39,162,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (38,37,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (38,141,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (37,36,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (37,122,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (36,35,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (36,101,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (35,34,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (35,82,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (34,33,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (34,61,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (33,32,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (33,42,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (32,31,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (32,21,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (31,2,200,2,'true');

--Calle4 -> (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (41,42,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (41,32,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (42,43,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (42,53,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (43,44,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (43,72,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (44,45,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (44,93,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (45,46,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (45,112,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (46,47,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (46,133,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (47,48,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (47,152,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (48,49,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (48,173,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (49,192,200,2,'true');

--Calle5 -> (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (51,52,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (51,22,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (52,53,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (52,43,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (53,54,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (53,62,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (54,55,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (54,83,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (55,56,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (55,102,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (56,57,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (56,123,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (57,58,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (57,142,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (58,59,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (58,163,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (59,60,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (59,182,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (60,203,200,2,'true');

--Calle6 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (69,68,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (69,174,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (68,67,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (68,153,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (67,66,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (67,134,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (66,65,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (66,113,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (65,64,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (65,94,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (64,63,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (64,73,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (63,62,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (63,54,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (62,61,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (62,33,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (61,14,200,2,'true');

--Calle7 <- (Completo)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (80,79,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (80,183,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (79,78,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (79,164,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (78,77,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (78,143,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (77,76,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (77,124,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (76,75,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (76,103,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (75,74,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (75,84,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (74,73,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (74,63,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (73,72,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (73,44,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (72,71,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (72,23,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (71,4,200,2,'true');

--Calle8 -> (Completo)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (81,82,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (81,34,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (82,83,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (82,55,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (83,84,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (83,74,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (84,85,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (84,95,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (85,86,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (85,114,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (86,87,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (86,135,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (87,88,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (87,154,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (88,89,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (88,175,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (89,194,200,2,'true');

--Calle9 -> (Completo)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (91,92,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (91,24,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (92,93,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (92,45,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (93,94,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (93,64,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (94,95,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (94,85,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (95,96,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (95,104,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (96,97,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (96,125,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (97,98,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (97,144,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (98,99,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (98,165,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (99,100,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (99,184,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (100,205,200,2,'true');

--Calle10 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (109,108,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (109,176,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (108,107,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (108,155,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (107,106,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (107,136,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (106,105,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (106,115,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (105,104,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (105,96,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (104,103,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (104,75,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (103,102,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (103,56,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (102,101,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (102,35,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (101,16,200,2,'true');

--Calle11 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (120,119,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (119,118,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (118,117,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (117,116,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (116,115,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (115,114,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (114,113,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (113,112,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (112,111,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (120,185,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (119,166,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (118,145,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (117,126,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (116,105,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (115,86,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (114,65,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (113,46,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (112,25,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (112,6,200,2,'true');

--Calle12 -> (Completo)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (121,122,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (122,123,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (123,124,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (124,125,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (125,126,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (126,127,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (127,128,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (128,129,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (121,36,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (122,57,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (123,76,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (124,97,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (125,116,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (126,137,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (127,156,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (128,177,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (129,196,200,2,'true');

--Calle13 -> (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (131,132,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (132,133,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (133,134,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (134,135,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (135,136,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (136,137,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (137,138,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (138,139,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (139,140,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (131,26,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (132,47,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (133,66,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (134,87,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (135,106,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (136,127,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (137,146,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (138,167,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (139,186,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (140,207,200,2,'true');

--Calle14 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (149,148,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (148,147,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (147,146,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (146,145,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (145,144,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (144,143,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (143,142,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (142,141,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (149,178,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (148,157,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (147,138,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (146,117,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (145,98,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (144,77,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (143,58,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (142,37,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (141,18,200,2,'true');

--Calle15 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (160,159,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (159,158,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (158,157,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (157,156,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (156,155,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (155,154,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (154,153,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (153,152,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (152,151,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (160,187,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (159,168,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (158,147,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (157,128,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (156,107,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (155,88,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (154,67,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (153,48,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (152,27,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (151,8,200,2,'true');

--Calle16 -> (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (161,162,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (162,163,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (163,164,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (164,165,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (165,166,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (166,167,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (167,168,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (168,169,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (161,38,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (162,59,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (163,78,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (164,99,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (165,118,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (166,139,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (167,158,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (168,179,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (169,198,200,2,'true');

--Calle17 -> (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (171,172,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (172,173,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (173,174,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (174,175,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (175,176,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (176,177,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (177,178,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (178,179,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (179,180,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (171,28,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (172,49,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (173,68,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (174,89,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (175,108,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (176,129,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (177,148,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (178,169,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (179,188,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (180,209,200,2,'true');

--Calle18 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (189,188,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (188,187,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (187,186,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (186,185,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (185,184,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (184,183,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (183,182,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (182,181,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (189,180,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (188,159,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (187,140,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (186,119,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (185,100,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (184,79,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (183,99,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (182,39,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (181,20,200,2,'true');

--Calle19 <- (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (200,199,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (199,198,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (198,197,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (197,196,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (196,195,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (195,194,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (194,193,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (193,192,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (192,191,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (200,189,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (198,149,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (196,109,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (194,69,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (192,29,200,2,'true');

--Calle 20 -> (Completa)
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (201,202,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (202,203,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (203,204,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (204,205,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (205,206,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (206,207,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (207,208,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (208,209,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (201,40,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (203,80,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (205,120,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (207,160,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (209,200,200,2,'true');

INSERT INTO APLICACION_BUS.LINEA (nombre, color, tipo, asientos, parados, wifi, aire) values ('Linea E1','Amarillo','Economico',40,30,'false','false');
INSERT INTO APLICACION_BUS.TRAYECTO (idLinea) values (1);

INSERT INTO APLICACION_BUS.LINEA (nombre, color, tipo, asientos, parados, wifi, aire) values ('Linea E2','Amarillo','Economico',40,20,'false','false');
INSERT INTO APLICACION_BUS.TRAYECTO (idLinea) values (2);

INSERT INTO APLICACION_BUS.LINEA (nombre, color, tipo, asientos, parados, wifi, aire) values ('Linea S1','Plateado','Superior',40,0,'true','false');
INSERT INTO APLICACION_BUS.TRAYECTO (idLinea) values (3);

INSERT INTO APLICACION_BUS.LINEA (nombre, color, tipo, asientos, parados, wifi, aire) values ('Linea S2','Plateado','Superior',40,0,'false','true');
INSERT INTO APLICACION_BUS.TRAYECTO (idLinea) values (4);

--LINEA E1
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (32,21,1,1);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (21,12,1,2);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (12,13,1,3);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (13,14,1,4);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (14,81,1,5);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (14,81,1,6);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (81,82,1,7);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (82,83,1,8);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (83,84,1,9);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (84,95,1,10);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (95,96,1,11);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (96,97,1,12);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (97,144,1,13);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (144,143,1,14);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (143,142,1,15);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (142,37,1,16);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (144,143,1,17);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (143,142,1,18);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (142,37,1,19);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (37,36,1,20);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (36,35,1,21);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (35,34,1,22);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (33,32,1,23);

--LINEA E2
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (171,172,2,1);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (172,173,2,2);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (173,174,2,3);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (174,175,2,4);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (175,176,2,5);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (176,177,2,6);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (177,178,2,7);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (178,179,2,8);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (179,188,2,9);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (188,187,2,10);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (187,186,2,11);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (186,185,2,12);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (185,184,2,13);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (184,183,2,14);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (183,182,2,15);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (182,39,2,16);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (39,38,2,17);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (38,37,2,18);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (37,122,2,19);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (122,123,2,20);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (123,124,2,21);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (124,125,2,22);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (125,126,2,23);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (126,127,2,24);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (127,156,2,25);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (156,155,2,26);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (155,154,2,27);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (153,152,2,28);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (152,151,2,29);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (151,8,2,30);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (8,171,2,31);

--LINEA S1
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (205,120,3,1);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (120,119,3,2);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (119,118,3,3);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (118,117,3,4);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (117,116,3,5);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (116,115,3,6);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (115,114,3,7);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (114,113,3,8);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (113,112,3,9);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (112,25,3,10);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (25,92,3,11);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (92,93,3,12);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (93,94,3,13);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (94,95,3,14);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (95,96,3,15);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (96,97,3,16);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (97,98,3,17);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (98,99,3,18);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (99,100,3,19);
INSERT INTO APLICACION_BUS.CAMINOTRAYECTO (idOrigen,idDestino,idTrayecto,orden) values (100,205,3,20);