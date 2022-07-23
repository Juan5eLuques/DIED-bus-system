CREATE DATABASE APLICACION;

CREATE TABLE APLICACION.LINEA
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
CREATE TABLE APLICACION.TRAYECTO
(
id INT PRIMARY KEY,
idLinea INT NOT NULL,
idOrigen INT NOT NULL,
idDestino INT NOT NULL,
FOREING KEY(idLinea) REFERENCES APLICACION.LINEA(id),
FOREING KEY(idOrigen) REFERENCES APLICACION.PARADA(id),
FOREING KEY(idDestino) REFERENCES APLICACION.PARADA(id)
);

CREATE TABLE APLICACION.CAMINO
(
    id INT PRIMARY KEY,
    idOrigen INT NOT NULL,
    idDestino INT NOT NULL,
    double distancia DECIMAL (3,1) NOT NULL,
    double duracion INT NOT NULL,
    estado BOOLEAN NOT NULL,
    FOREING KEY(idOrigen) REFERENCES APLICACION.PARADA(id),
    FOREING KEY(idDestino) REFERENCES APLICACION.PARADA(id)
);
CREATE TABLE APLICACION.PARADA
(
    id INT PRIMARY KEY,
    estado BOOLEAN NOT NULL,
    calle VARCHAR(15) NOT NULL,
    numero INT NOT NULL
);

CREATE TABLE APLICACION.INCIDENCIAS
(
    id INT PRIMARY KEY,
    idCamino INT NOT NULL,
    inicio DATE NOT NULL,
    fin DATE,
    descripcion VARCHAR (500), 
    bool resuelta BOOLEAN,
    FOREING KEY(idCamino) REFERENCES APLICACION.CAMINO(id)
);
CREATE TABLE APLICACION.Camino-Trayectos
(
    idCamino INT NOT NULL,
    idTrayecto INT NOT NULL,
    orden INT NOT NULL,
    PRIMARY KEY(idCamino, idTrayecto),
    FOREING KEY(idCamino) REFERENCES APLICACION.CAMINO(id),
    FOREING KEY(idTrayecto) REFERENCES APLICACION.TRAYECTO(id)
);
