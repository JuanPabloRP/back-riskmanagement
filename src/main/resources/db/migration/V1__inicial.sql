-- Versión 1 de la Base de Datos sin la tabla permissions y sus relaciones

-- Tabla role
CREATE TABLE role (
	role_id SERIAL NOT NULL UNIQUE,
	role_name VARCHAR NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(role_id)
);

-- Tabla status (Estado de aprobación de usuario)
CREATE TABLE status (
	status_id SERIAL NOT NULL PRIMARY KEY,
	status_name VARCHAR(50) NOT NULL UNIQUE,
	active BOOLEAN NOT NULL DEFAULT TRUE,
  creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tabla user_information
CREATE TABLE user_information (
    user_id SERIAL NOT NULL UNIQUE,
    role_id INTEGER NOT NULL,
    identification VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    birth_date DATE,
    name VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    status_id INTEGER NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(user_id),
    FOREIGN KEY(role_id) REFERENCES role(role_id),
    FOREIGN KEY(status_id) REFERENCES status(status_id)
);

-- Tabla user_information_history para auditoría de cambios
CREATE TABLE user_information_history (
	history_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	role_id INTEGER,
	name VARCHAR,
	status_id INTEGER,
	active BOOLEAN,
	action VARCHAR(50) NOT NULL,  -- "INSERT", "UPDATE", "DELETE"
	action_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modified_by INTEGER,
	FOREIGN KEY(user_id) REFERENCES user_information(user_id),
	FOREIGN KEY(modified_by) REFERENCES user_information(user_id)
);

-- Tabla asset
CREATE TABLE asset (
	asset_id SERIAL NOT NULL UNIQUE,
	user_id INTEGER NOT NULL,
	asset_name VARCHAR NOT NULL,
	asset_type VARCHAR NOT NULL,
	location VARCHAR NOT NULL,
	asset_value BIGINT NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(asset_id),
	FOREIGN KEY(user_id) REFERENCES user_information(user_id)
);

-- Tabla impact_level (Para niveles de impacto en risk)
CREATE TABLE impact_level (
	impact_id SERIAL PRIMARY KEY,
	impact_value VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla risk
CREATE TABLE risk (
	risk_id SERIAL NOT NULL UNIQUE,
	user_id INTEGER NOT NULL,
	risk_name VARCHAR NOT NULL,
	risk_description VARCHAR NOT NULL,
	impact_id INTEGER,
	probability VARCHAR NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(risk_id),
	FOREIGN KEY(user_id) REFERENCES user_information(user_id),
	FOREIGN KEY(impact_id) REFERENCES impact_level(impact_id)
);

-- Tabla vulnerability
CREATE TABLE vulnerability (
	vulnerability_id SERIAL NOT NULL UNIQUE,
	user_id INTEGER NOT NULL,
	vulnerability_name VARCHAR NOT NULL,
	vulnerability_description VARCHAR NOT NULL,
	severity VARCHAR NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(vulnerability_id),
	FOREIGN KEY(user_id) REFERENCES user_information(user_id)
);

-- Tabla threat
CREATE TABLE threat (
	threat_id SERIAL NOT NULL UNIQUE,
	user_id INTEGER NOT NULL,
	threat_name VARCHAR NOT NULL,
	threat_description VARCHAR NOT NULL,
	threat_type VARCHAR NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(threat_id),
	FOREIGN KEY(user_id) REFERENCES user_information(user_id)
);

-- Tabla control
CREATE TABLE control (
	control_id SERIAL NOT NULL UNIQUE,
	user_id INTEGER NOT NULL,
	control_name VARCHAR NOT NULL,
	control_type VARCHAR NOT NULL,
	control_description VARCHAR NOT NULL,
	status_id INTEGER,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(control_id),
	FOREIGN KEY(user_id) REFERENCES user_information(user_id),
	FOREIGN KEY(status_id) REFERENCES status(status_id)
);


-- Tabla treatment_plan
CREATE TABLE treatment_plan (
	plan_id SERIAL NOT NULL UNIQUE,
	user_id INTEGER NOT NULL,
	description VARCHAR NOT NULL,
	status VARCHAR NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(plan_id),
	FOREIGN KEY(user_id) REFERENCES user_information(user_id)
);

-- Tabla risk_asset
CREATE TABLE risk_asset (
	risk_asset_id SERIAL NOT NULL UNIQUE,
	risk_id INTEGER NOT NULL,
	asset_id INTEGER NOT NULL,
	PRIMARY KEY(risk_asset_id),
	FOREIGN KEY(risk_id) REFERENCES risk(risk_id),
	FOREIGN KEY(asset_id) REFERENCES asset(asset_id)
);

-- Tabla risk_vulnerability
CREATE TABLE risk_vulnerability (
	risk_vulnerability_id SERIAL NOT NULL UNIQUE,
	risk_id INTEGER NOT NULL,
	vulnerability_id INTEGER NOT NULL,
	PRIMARY KEY(risk_vulnerability_id),
	FOREIGN KEY(risk_id) REFERENCES risk(risk_id),
	FOREIGN KEY(vulnerability_id) REFERENCES vulnerability(vulnerability_id)
);

-- Tabla risk_threat
CREATE TABLE risk_threat (
	risk_threat_id SERIAL NOT NULL UNIQUE,
	risk_id INTEGER NOT NULL,
	threat_id INTEGER NOT NULL,
	PRIMARY KEY(risk_threat_id),
	FOREIGN KEY(risk_id) REFERENCES risk(risk_id),
	FOREIGN KEY(threat_id) REFERENCES threat(threat_id)
);

-- Tabla risk_control
CREATE TABLE risk_control (
	risk_control_id SERIAL NOT NULL UNIQUE,
	risk_id INTEGER NOT NULL,
	control_id INTEGER NOT NULL,
	PRIMARY KEY(risk_control_id),
	FOREIGN KEY(risk_id) REFERENCES risk(risk_id),
	FOREIGN KEY(control_id) REFERENCES control(control_id)
);

-- Tabla risk_plan
CREATE TABLE risk_plan (
	risk_plan_id SERIAL NOT NULL UNIQUE,
	risk_id INTEGER NOT NULL,
	plan_id INTEGER NOT NULL,
	PRIMARY KEY(risk_plan_id),
	FOREIGN KEY(risk_id) REFERENCES risk(risk_id),
	FOREIGN KEY(plan_id) REFERENCES treatment_plan(plan_id)
);

-- Tabla settings para configuraciones globales
CREATE TABLE settings (
	setting_id SERIAL PRIMARY KEY,
	setting_key VARCHAR(100) UNIQUE NOT NULL,
	setting_value VARCHAR(255) NOT NULL
);

-- Índices adicionales
CREATE INDEX idx_user_status ON user_information(status_id);
CREATE INDEX idx_asset_user ON asset(user_id);
CREATE INDEX idx_risk_user ON risk(user_id);

-- Trigger para actualizar modification_date en user_information
CREATE OR REPLACE FUNCTION update_modification_date()
RETURNS TRIGGER AS $$
BEGIN
    NEW.modification_date = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_modification_date
BEFORE UPDATE ON user_information
FOR EACH ROW
EXECUTE FUNCTION update_modification_date();
