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
id SERIAL,
PRIMARY KEY (id),
idLinea INT NOT NULL,
FOREIGN KEY(idLinea) REFERENCES APLICACION_BUS.LINEA(id)
);

CREATE TABLE APLICACION_BUS.INCIDENCIAS
(   
    id SERIAL,
    PRIMARY KEY (id),
    idParada INT NOT NULL,
    inicio DATE NOT NULL,
    fin DATE,
    descripcion VARCHAR (500), 
    resuelta BOOLEAN,
    FOREIGN KEY(idParada) REFERENCES APLICACION_BUS.PARADA(id)
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

CREATE TABLE APLICACION_BUS.BOLETO
(
     id SERIAL PRIMARY KEY,
     idLinea INT NOT NULL,
     paradaInicial INT NOT NULL,
     paradaFinal INT NOT NULL,
     duracion DECIMAL(5,1),
     distancia DECIMAL(5,1),
     costo DECIMAL(5,1),
     FOREIGN KEY(idLinea) REFERENCES APLICACION_BUS.LINEA(id),
     FOREIGN KEY(paradaInicial) REFERENCES APLICACION_BUS.PARADA(id),
     FOREIGN KEY(paradaFinal) REFERENCES APLICACION_BUS.PARADA(id)
);