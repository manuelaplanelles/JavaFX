CREATE DATABASE instituto;

CREATE TABLE estudiante(
	nia INTEGER,
	nombre VARCHAR(30),
	fecha_nacimiento DATE,
CONSTRAINT pk_estudiante PRIMARY KEY (nia));

SELECT * FROM estudiante;
INSERT INTO estudiantes(nia, nombre, fecha_nacimiento) VALUE (00000001, 'Patri', '1995-05-04');
INSERT INTO estudiantes(nia, nombre, fecha_nacimiento) VALUE (00000002, 'Manuela', '1990-08-07');
INSERT INTO estudiantes(nia, nombre, fecha_nacimiento) VALUE (00000003, 'Ivan', '2001-05-02');
INSERT INTO estudiantes(nia, nombre, fecha_nacimiento) VALUE (00000004, 'Jose Luis', '2007-11-26');
INSERT INTO estudiantes(nia, nombre, fecha_nacimiento) VALUE (00000005, 'Ismael', '2006-09-14');
INSERT INTO estudiantes(nia, nombre, fecha_nacimiento) VALUE (00000006, 'Izan', '2003-07-20');
INSERT INTO estudiantes(nia, nombre, fecha_nacimiento) VALUE (00000007, 'Jose Ramon', '2006-10-27');
INSERT INTO estudiantes(nia, nombre, fecha_nacimiento) VALUE (00000008, 'Alejandro', '2002-01-16');