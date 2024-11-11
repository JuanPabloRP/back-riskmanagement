
--INSERT INTO table_name (column1, column2, column3, ...)
--VALUES (value1, value2, value3, ...);

-- User status
INSERT INTO status (status_name) VALUES ( 'Pendiente');
INSERT INTO status (status_name) VALUES ( 'Aceptado');
INSERT INTO status (status_name) VALUES ( 'Rechazado');
INSERT INTO status (status_name) VALUES ( 'Creado');
INSERT INTO status (status_name) VALUES ( 'En progreso');
INSERT INTO status (status_name) VALUES ( 'Terminado');

-- User role
INSERT INTO role (role_name) VALUES ('Super Administrador');
INSERT INTO role (role_name) VALUES ('Administrador');
INSERT INTO role (role_name) VALUES ('Gestor de riesgo');
INSERT INTO role (role_name) VALUES ('Propietario del riesgo');
INSERT INTO role (role_name) VALUES ('Gestor de activos');
INSERT INTO role (role_name) VALUES ('Analista de seguridad');
INSERT INTO role (role_name) VALUES ('Auditor');


-- Impact level
INSERT INTO impact_level (impact_value) VALUES ('Bajo');
INSERT INTO impact_level (impact_value) VALUES ('Medio');
INSERT INTO impact_level (impact_value) VALUES ('Alto');


