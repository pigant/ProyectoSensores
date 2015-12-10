BEGIN;

DROP TABLE IF EXISTS historial;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS protocolo;
DROP TABLE IF EXISTS log;
DROP TABLE IF EXISTS advertencia;
DROP TABLE IF EXISTS sensor;
DROP TABLE IF EXISTS t_unidad;
DROP TABLE IF EXISTS t_sensor;
DROP TABLE IF EXISTS maquina;
DROP TABLE IF EXISTS lugar;

CREATE TABLE IF NOT EXISTS t_unidad (id_t_unidad SERIAL, nombre VARCHAR(50), 
                                     PRIMARY KEY(id_t_unidad));

CREATE TABLE IF NOT EXISTS t_sensor (id_t_sensor SERIAL, nombre VARCHAR(50),
                                     PRIMARY KEY(id_t_sensor));

CREATE TABLE IF NOT EXISTS lugar (id_lugar SERIAL, nombre VARCHAR(50), 
                                  PRIMARY KEY(id_lugar));

CREATE TABLE IF NOT EXISTS maquina (id_maquina SERIAL, nombre VARCHAR(50), 
                                    id_lugar INTEGER, detalle VARCHAR(200),
                                    PRIMARY KEY(id_maquina));

CREATE TABLE IF NOT EXISTS sensor (id_sensor SERIAL, nombre VARCHAR(50), 
                                   escala VARCHAR(50), detalle VARCHAR(200), 
                                   p_escala BOOLEAN, id_t_unidad INTEGER,
                                   id_t_sensor INTEGER, id_maquina INTEGER, 
                                   PRIMARY KEY(id_sensor));

CREATE TABLE IF NOT EXISTS protocolo (id_protocolo SERIAL, nombre VARCHAR(50), 
                                      PRIMARY KEY(id_protocolo));

CREATE TABLE IF NOT EXISTS tag (id_tag SERIAL, nombre VARCHAR(50), 
                                url VARCHAR(50), segundos INTEGER,
                                detalle VARCHAR(200),
                                id_sensor INTEGER, id_protocolo INTEGER, 
                                PRIMARY KEY(id_tag));

CREATE TABLE IF NOT EXISTS historial (id_historial SERIAL, fecha TIMESTAMP, 
                                      valor DECIMAL(10,5), id_tag INTEGER, 
                                      PRIMARY KEY(id_historial));

CREATE TABLE IF NOT EXISTS advertencia (id_advertencia SERIAL, 
                                        detalle VARCHAR(200), max DECIMAL(10,5),
                                        min DECIMAL(10,5), id_sensor INTEGER,
                                        PRIMARY KEY(id_advertencia));

CREATE TABLE IF NOT EXISTS log (id_log SERIAL, mensaje VARCHAR(200), 
                                fecha TIMESTAMP, activo BOOLEAN,
                                id_sensor INTEGER, PRIMARY KEY(id_log));

ALTER TABLE sensor ADD CONSTRAINT fk_sensor_t_unidad 
    FOREIGN KEY (id_t_unidad)  REFERENCES t_unidad(id_t_unidad);

ALTER TABLE sensor ADD CONSTRAINT fk_sensor_t_sensor 
    FOREIGN KEY (id_t_sensor)  REFERENCES t_sensor(id_t_sensor);

ALTER TABLE sensor ADD CONSTRAINT fk_sensor_maquina 
    FOREIGN KEY (id_maquina)  REFERENCES maquina(id_maquina);

ALTER TABLE maquina ADD constraint fk_maquina_lugar 
    FOREIGN KEY (id_lugar)  REFERENCES lugar(id_lugar);

ALTER TABLE tag ADD CONSTRAINT fk_tag_sensor 
    FOREIGN KEY (id_sensor) REFERENCES sensor(id_sensor);

ALTER TABLE tag ADD CONSTRAINT fk_tag_protocolo 
    FOREIGN KEY (id_protocolo) REFERENCES protocolo(id_protocolo);

ALTER TABLE historial ADD CONSTRAINT fk_historial_tag 
    FOREIGN KEY (id_tag) REFERENCES tag(id_tag);

ALTER TABLE tag ADD CONSTRAINT fk_advertencia_sensor 
    FOREIGN KEY (id_sensor) REFERENCES sensor(id_sensor);

ALTER TABLE log ADD CONSTRAINT fk_log_sensor 
    FOREIGN KEY (id_sensor) REFERENCES sensor(id_sensor);

ALTER TABLE advertencia ADD CONSTRAINT fk_advertencia_sensor
    FOREIGN KEY (id_sensor) REFERENCES sensor(id_sensor);

-- Se insertan datos basicos, para pruebas y funcionamiento

INSERT INTO t_unidad (nombre) values ('Celcius'), ('Bar'), ('Metros');

INSERT INTO t_sensor (nombre) values ('PT-100'), ('Presostato linea'), 
    ('encoder zona corte');

INSERT INTO lugar (nombre) values ('Hornos'), ('Estanques'), ('Extrusion');

INSERT INTO maquina (nombre, detalle, id_lugar) 
    values ('Horno 1', 'Marca chaleco', 1), ('Estanque salmuera', 'Grande', 2),
    ('Extrusora 20', '', 3);

INSERT INTO sensor (nombre, escala, detalle, p_escala, 
                    id_t_unidad, id_t_sensor, id_maquina) 
    values ('Sensor de nucleo', '1x', '', true, 1, 1, 1),
    ('Indicador profundida', '3x', '', true, 2, 2, 2),
    ('Contador metros pasados', '3.53x', '', true, 3, 3, 3);

INSERT INTO protocolo (nombre) values ('Modbus'), ('S7'), ('Ethercat');

INSERT INTO tag (nombre, url, detalle, id_protocolo, id_sensor) 
    values ('', '4001', '', 1, 1),
    ('', '4001', '', 1, 2),
    ('', '4001', '', 1, 3);

INSERT INTO advertencia (detalle, max, min, id_sensor) 
    values ('', -99, 95, 1), ('', 0.1, 2.0, 2);

INSERT INTO historial (valor, id_tag)
    values (10.5, 1);

COMMIT;
