-- Tabla role
CREATE TABLE role (
	role_id SERIAL NOT NULL UNIQUE,
	role_name VARCHAR NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(role_id)
);

-- Tabla permission
CREATE TABLE permission (
	permission_id SERIAL NOT NULL UNIQUE,
	permission_name VARCHAR NOT NULL,
	description VARCHAR,
	PRIMARY KEY(permission_id)
);

-- Tabla intermedia role_permission (relación entre roles y permisos)
CREATE TABLE role_permission (
	role_permission_id SERIAL NOT NULL UNIQUE,
	role_id INTEGER NOT NULL,
	permission_id INTEGER NOT NULL,
	PRIMARY KEY(role_permission_id),
	FOREIGN KEY(role_id) REFERENCES role(role_id),
	FOREIGN KEY(permission_id) REFERENCES permission(permission_id)
);

-- Tabla user_information
CREATE TABLE user_information (
	user_id SERIAL NOT NULL UNIQUE,
	role_id INTEGER NOT NULL,
	name VARCHAR NOT NULL,
	password VARCHAR NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(user_id),
	FOREIGN KEY(role_id) REFERENCES role(role_id)
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

-- Tabla risk
CREATE TABLE risk (
	risk_id SERIAL NOT NULL UNIQUE,
	user_id INTEGER NOT NULL,
	risk_name VARCHAR NOT NULL,
	risk_description VARCHAR NOT NULL,
	impact VARCHAR NOT NULL,
	probability VARCHAR NOT NULL,
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(risk_id),
	FOREIGN KEY(user_id) REFERENCES user_information(user_id)
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
	active BOOLEAN NOT NULL DEFAULT TRUE,
	creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modification_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(control_id),
	FOREIGN KEY(user_id) REFERENCES user_information(user_id)
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
