CREATE SCHEMA APLICACION_BUS;

CREATE TABLE APLICACION_BUS.LINEA
(
    id INT PRIMARY KEY,
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
    id SERIAL PRIMARY KEY, 
    activa BOOLEAN NOT NULL,
    calle VARCHAR(15) NOT NULL,
    numero INT NOT NULL
);

CREATE TABLE APLICACION_BUS.CAMINO
(
    idOrigen INT NOT NULL,
    idDestino INT NOT NULL,
    distancia DECIMAL (3,1) NOT NULL,
    duracion INT NOT NULL,
    activa BOOLEAN NOT NULL,
    PRIMARY KEY (idOrigen, idDestino),
    FOREIGN KEY(idOrigen) REFERENCES APLICACION_BUS.PARADA(id),
    FOREIGN KEY(idDestino) REFERENCES APLICACION_BUS.PARADA(id)
);

CREATE TABLE APLICACION_BUS.TRAYECTO
(
id INT PRIMARY KEY,
idLinea INT NOT NULL,
idOrigen INT NOT NULL,
idDestino INT NOT NULL,
FOREIGN KEY(idLinea) REFERENCES APLICACION_BUS.LINEA(id),
FOREIGN KEY(idOrigen) REFERENCES APLICACION_BUS.PARADA(id),
FOREIGN KEY(idDestino) REFERENCES APLICACION_BUS.PARADA(id)
);

CREATE TABLE APLICACION_BUS.INCIDENCIAS
(
    id INT PRIMARY KEY,
    idCamino INT NOT NULL,
    inicio DATE NOT NULL,
    fin DATE,
    descripcion VARCHAR (500), 
    resuelta BOOLEAN,
    FOREIGN KEY(idCamino) REFERENCES APLICACION_BUS.CAMINO(id)
);
CREATE TABLE APLICACION_BUS.CAMINO.TRAYECTO
(
    idCamino INT NOT NULL,
    idTrayecto INT NOT NULL,
    orden INT NOT NULL,
    PRIMARY KEY(idCamino, idTrayecto),
    FOREIGN KEY(idCamino) REFERENCES APLICACION_BUS.CAMINO(id),
    FOREIGN KEY(idTrayecto) REFERENCES APLICACION_BUS.TRAYECTO(id)
);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 0',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 1',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 2',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 3',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 4',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 5',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 6',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 7',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 8',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 9',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 10',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 11',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 12',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 13',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 14',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 15',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 16',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 17',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 18',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 19',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',1850);

INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',50);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',850);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',1050);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',1250);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',1450);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',1650);
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 21',1850);

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
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (207,260,200,2,'true');
INSERT INTO APLICACION_BUS.CAMINO (idOrigen, idDestino, distancia, duracion, activa) values (209,200,200,2,'true');



