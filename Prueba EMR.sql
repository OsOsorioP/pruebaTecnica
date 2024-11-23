CREATE TABLE granjero(
	gra_id INT PRIMARY KEY,
	gra_nombres VARCHAR(60) NOT NULL,
	gra_telefono VARCHAR(20) NOT NULL,
	gra_correo VARCHAR(30) NOT NULL UNIQUE
);

CREATE TYPE estados AS ENUM ('Inicial','en progreso','finalizada')

CREATE TABLE granja(
	gran_id SERIAL PRIMARY KEY,
	gran_estado estados DEFAULT 'Inicial',
	gran_catastral INT NOT NULL,
	gran_ubicacion VARCHAR(10) NOT NULL,
	gran_latitud NUMERIC(10,8) NOT NULL,
	gran_longitud NUMERIC(10,8) NOT NULL,
	gra_id INT UNIQUE,
	CONSTRAINT  fk_gra_id FOREIGN KEY (gra_id) REFERENCES granjero(gra_id),
	par_id INT UNIQUE,
	CONSTRAINT fk_par_id FOREIGN KEY (par_id) REFERENCES parcela(par_id)
);

CREATE TABLE parcela(
	par_id SERIAL PRIMARY KEY,
	par_fechaInicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	par_fechaFin TIMESTAMP,
	par_estado estados DEFAULT 'Inicial',
	prod_id INT UNIQUE,
	CONSTRAINT fk_prod_id FOREIGN KEY (prod_id) REFERENCES producto(prod_id)
);

CREATE TABLE producto(
	prod_id SERIAL PRIMARY KEY,
	prod_nombre VARCHAR(50) NOT NULL,
	prod_tiempo TIME DEFAULT CURRENT_TIME,	
	prod_precioCompra DECIMAL(10,2) DEFAULT 0.0,
	prod_precioVenta DECIMAL(10,2) DEFAULT 0.0,
	prod_especie VARCHAR(40) NOT NULL,
	prod_descripcion TEXT DEFAULT ''
);

CREATE TABLE actividad(
	act_id SERIAL PRIMARY KEY,
	act_fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	act_estado estados DEFAULT 'Inicial',
	gra_id INT UNIQUE,
	CONSTRAINT  fk_gra_id FOREIGN KEY (gra_id) REFERENCES granjero(gra_id)
);

CREATE TABLE animal(
	ani_id SERIAL PRIMARY KEY,
	ani_nombre VARCHAR(50) NOT NULL,
	ani_tipo VARCHAR(50) NOT NULL,
	ani_precioCompra DECIMAL(10,2) DEFAULT 0.0,
	ani_precioVenta DECIMAL(10,2) DEFAULT 0.0,
	ani_raza VARCHAR(50) NOT NULL,
	gran_id INT UNIQUE,
	CONSTRAINT  fk_gran_id FOREIGN KEY (gran_id) REFERENCES granja(gran_id)
);

CREATE TABLE elemento(
	ele_id SERIAL PRIMARY KEY,
	ele_nombre VARCHAR(50),
	ele_precioCompra DECIMAL(10,2) DEFAULT 0.0,
	ele_precioVenta DECIMAL(10,2) DEFAULT 0.0,
	ele_tipo VARCHAR(60),
	ele_fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	gran_id INT UNIQUE,
	CONSTRAINT  fk_gran_id FOREIGN KEY (gran_id) REFERENCES granja(gran_id)
);
