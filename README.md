# Proyecto de Inscripción de Alumnos

## Descripción del Proyecto

Este proyecto permite gestionar las inscripciones de alumnos en materias utilizando Jakarta EE y JSF. 
A continuación, se detallan las instrucciones para configurar la base de datos y levantar el proyecto.

## Configuración de la Base de Datos

El proyecto utiliza una base de datos en la nube en CoackroachDB. Para configurar el datasource y el pool de conexiones, siga los pasos descritos a continuación.

### Credenciales de la Base de Datos

- **Tipo de Base de Datos:** PostgreSQL 
- **Hostname:** `parcial-test-cluster-15007.7tt.aws-us-east-1.cockroachlabs.cloud`
- **Database:** `db_parcial`
- **Username:** `fernando`
- **Password:** `XEUkzO8WEKnLbd3oSleD2A`

### Configuración para CockroachDB

1. **Crear Datasource:**
   - En el archivo `persistence.xml` del proyecto, asegúrese de configurar el datasource con las credenciales de la base de datos en la nube.

   ```xml
	<?xml version="1.0" encoding="UTF-8"?>
	<persistence version="3.0"
		xmlns="https://jakarta.ee/xml/ns/persistence"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd">
		<!-- Define Persistence Unit -->
		<persistence-unit name="db_parcial" transaction-type="JTA">
			<jta-data-source>parcial_db</jta-data-source>
			<shared-cache-mode>NONE</shared-cache-mode>
			<properties></properties>
		</persistence-unit>
	</persistence>
    ```

2. Configurar el Pool de Conexiones:

    Configure el pool de conexiones en el archivo de configuración del servidor.

...

3. Instrucciones para levantar el proyecto

    - Clonar el repositorio del proyecto.
    - Configurar la base de datos utilizando las credenciales proporcionadas.
    - Importar el proyecto en el IDE de tu preferencia.
    - Configurar el servidor de aplicaciones para usar el datasource configurado (jdbc/InscripcionDB).
    - Desplegar el proyecto en el servidor de aplicaciones.
    - Acceder a la aplicación a través de la URL proporcionada por el servidor.


Este archivo README proporciona una guía clara y detallada para que el ingeniero pueda configurar la base de datos, crear el datasource y el pool de conexiones, y levantar el proyecto utilizando CockroachDB en la nube. 

## :busts_in_silhouette:Autores del proyecto:
- Fernando José Barraza Álvarez  
  **BA22025**
- Carlos Guillermo Ortiz Abarca  
  **OA21013**
- David Salomón Martínez Valladares  
  **MV12013**

  
| [<img src="https://avatars.githubusercontent.com/u/61745150?v=4" width=115><br><sub>Fernando José Barraza Álvarez</sub>](https://github.com/MinunGR) | [<img src="https://avatars.githubusercontent.com/u/57274941?v=4" width=115><br><sub>David Salomón Martínez Valladares</sub>](https://github.com/DavidSalomonDev) | [<img src="https://avatars.githubusercontent.com/u/145523801?v=4" width=115><br><sub>Carlos Guillermo Ortiz Abarca</sub>](https://github.com/Carlos-Otz) 
| :---: | :---: | :---: 
