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
CREATE TABLE APLICACION_BUS.CAMINO
(
    id INT PRIMARY KEY,
    idOrigen INT NOT NULL,
    idDestino INT NOT NULL,
    distancia DECIMAL (3,1) NOT NULL,
    duracion INT NOT NULL,
    estado BOOLEAN NOT NULL,
    FOREIGN KEY(idOrigen) REFERENCES APLICACION_BUS.PARADA(id),
    FOREIGN KEY(idDestino) REFERENCES APLICACION_BUS.PARADA(id)
);
CREATE TABLE APLICACION_BUS.PARADA
(
    id SERIAL PRIMARY KEY, 
    activa BOOLEAN NOT NULL,
    calle VARCHAR(15) NOT NULL,
    numero INT NOT NULL
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
INSERT INTO APLICACION_BUS.PARADA (activa, calle, numero) values('TRUE','CALLE 20',2050);
