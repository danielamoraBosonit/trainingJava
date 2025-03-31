
RESKILLING TRAINING JAVA
========================

## EXERCISES

- EXE-1. [API Rest / Hexagonal Arquitecture](#exe-1) (Proyecto base)
- EXE-2. [Mapeado de entidades / Lombok](#exe-2) (Implementada api-rest)
- EXE-3. [Documentación de APIs / Control errores](#exe-3) (Implementado mapeo)
- EXE-4. [Testing](#exe-4) (Implementada doc y errores)
- EXE-5. [JPA](#exe-5) (Implementados test)
- EXE-6. [Actuator / Maven Profiles / App.Properties](#exe-6) (Implementado Jpa)
- EXE-7. [Criteria JPA](#exe-7) (Implementado Actuator)
- EXE-8. [MongoDB](#exe-8) (Implementado Criteria)
- EXE-9. [Peticiones Rest Async](#exe-9) (Implementado Mongo)
- EXE-10. [Kafka Publisher](#exe-10) (Implementada petición rest async)
- EXE-11. [Kafka Consumer](#exe-11) (Implementado kafka publisher)
- EXE-12. [Postgres y Liquibase](#exe-12) (Implementado kafka consumer)
- EXE-13. [Authorization y Resource Servers](#exe-13) (Implementado postgres y liquibase)
- EXE-14. [SpringBatch](#exe-14) (Implementado Authorization y Resource Servers)
- EXE-15. [Redis](#exe-15) (Implementado Batch Job)
- EXE-16. [Aspectos](#exe-16) (Implementado Redis)


***
## EXERCISE-1 - API Rest / Hexagonal Architecture <a name="exe-1"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-1'

#### Objetivos didácticos
- Conocer y practicar la arquitectura hexagonal
- Implementar una API Restful en Springboot

#### Descripción
Se parte de un proyecto Springboot con las siguientes características:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA

Al iniciar el servicio se crea la tabla `working_calendar` e inserta varios registros a través del archivo `resources/data.sql`.
Esta tabla se utiliza para controlar el calendario de trabajo de determinados empleados.
El servicio tiene ya implementado una API Rest para los métodos ***GetById*** y ***GetAll*** de dicha tabla.

Para acceder a la consola de la base de datos: http://localhost:8080/h2-console

#### Se pide
Implementar con la estructura de arquitectura hexagonal las clases necesarias para exponer:

- API Rest para crear un registro en la tabla
- API Rest para borrar un registro de la tabla
- API Rest para edición total de un registro de la tabla
- API Rest para edición parcial de un registro de la tabla

#### Estructura de paquetes en arquitectura hexagonal
 	↳ content/domain 

	 	↳ application
	 		↳ impl 
	 			▹ [Class] UseCaseImpl.java
 			‣ [Interface] UseCase.java

	 	↳ domain
	 		↳ entity 
	 			▹ [Class] Entity.java
	 		↳ repository 
	 			‣ [Interface] EntityRepository.java

	 	↳ infrastructure
	 		↳ controller 
	 			↳ dto 
	 				▹ [Class] EntityOutputDto.java
	 			▹ [Class] Controller.java	 				
	 		↳ repository
	 			↳impl 
	 				▹ [Class] EntityRepositoryImpl.java
	 			↳jpa 
	 				↳entity 
	 					▹ [Class] EntityJpa.java
				‣ [Interface] EntityRepositoryJpa.java	 

***
## EXERCISE-2. Mapeado de entidades / Lombok <a name="exe-2"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-2'

#### Objetivos didácticos
- Manejar el uso de dependencias y plugins en ***Maven***
- Implementar el mapeado de entidades con ***Mapstruct***
- Incorporar la librería ***lombok*** al proyecto

#### Descripción
Se parte de un proyecto Springboot con las siguientes características:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA

Al iniciar el servicio se crea la tabla `working_calendar` e inserta varios registros a través del archivo `resources/data.sql`.
Esta tabla se utiliza para controlar el calendario de trabajo de determinados empleados.

Para acceder a la consola de la base de datos: http://localhost:8080/h2-console

#### Se pide
- Sustituir el mapeado actual del servicio usando la librería ***MAPSTRUCT***. Para ello acudir a ***Maven Repository*** y añadir la dependencia en el archivo ***pom.xml***.
  Esta librería realiza el mapeado de entidades mediante interfaces.
  La implementación del interface se realiza de manera automática durante la compilación del proyecto.
- Modificar la entidad WorkingCalendarOutputDto para incluir un campo calculado que muestre los días que hay entre el start_date y el end_date.
- Utilizar las anotaciones de lombok cuando sea posible

***
## EXERCISE-3. Documentación de APIs / Control errores <a name="exe-3"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-3'

#### Objetivos didácticos
- Conocer el correcto manejo de los errores en Springboot
- Incluir SWAGGER en un proyecto Springboot
- Documentar correctamente una API Rest mediante la especificación OpenApi v.3

#### Descripción
Se parte de un proyecto Springboot con las siguientes características:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok

Al iniciar el servicio se crea la tabla `working_calendar` e inserta varios registros a través del archivo `resources/data.sql`.
Esta tabla se utiliza para controlar el calendario de trabajo de determinados empleados.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console

#### Se pide
- Crear una clase de error personalizada.
- Crear una clase manejadora de los errores capturados por la aplicación ***Controller Advice***
- Incluir en el ***pom.xml*** la dependencia de Springdoc que permita la generación de la documentación de la API
- Documentar en el controller los endpoints de la API con:
  - Paraḿetros de entrada
  - Posibles respuestas del endpoint
  - Descripción de las operaciones
  - Ejemplos de uso

***
## EXERCISE-4. Testing <a name="exe-4"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-4'

#### Objetivos didácticos
- Realizar test unitarios en aplicaciones Springboot con jUnit y Mockito

#### Descripción
Se parte de un proyecto Springboot con las siguientes características:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger

Al iniciar el servicio se crea la tabla `working_calendar` e inserta varios registros a través del archivo `resources/data.sql`.
Esta tabla se utiliza para controlar el calendario de trabajo de determinados empleados.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html

#### Se pide
- Añadir al proyecto la librería Jacoco para la generación de porcentaje de cobertura de testing.
- Crear clases unitarias utilizando jUnit y Mockito para conseguir en el proyecto una cobertura mínima del 80%.

***
## EXERCISE-5. JPA <a name="exe-5"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-5'

#### Objetivos didácticos
- Utilizar las relaciones de entidades y queries de Jpa 

#### Descripción
Se parte de un proyecto Springboot con las siguientes características:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger
- jUnit, Mockito

Al iniciar el servicio se crea la tabla `working_calendar` e inserta varios registros a través del archivo `resources/data.sql`.
Esta tabla se utiliza para controlar el calendario de trabajo de determinados empleados.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html` 

#### Se pide
- Modificar el script `data.sql` para añadir una nueva tabla con las siguientes características:
  - Nombre: `employee` con los siguientes campos:
  - `id`: ***Primary key*** con valor controlado por una secuencia
  - `name`: varchar(100)
  - `surnames`: varchar(100)
  - `birth_date`: timestamp
  - `deparment`: varchar(50)
  - `category`: varchar(50)

- Modificar la tabla `working_calendar` para que el campo `employee_id` referencie como ***foreign key*** al `id` de la tabla `employee`
- Modificar las entidades JPA para que la relación entre `employee` y `working_calendar` sea de uno a muchos.
- Crear la estructura y un endpoint para recuperar un 'employee' por 'id'.
- Crear la estructura y un endpoint para recuperar todos los empleados por `deparment` y `category` siendo obligagorio el envío de ambos parametros.
- El objeto `WorkingCalendar` devuelto tambien debera tener una representacion del objeto `Employee`

***
## EXERCISE-6. Actuator / App.Properties / Maven Profiles <a name="exe-6"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-6'

#### Objetivos didácticos
- Exponer actuator endpoints
- Crear maven profiles
- Usar el application properties

#### Descripción
Se parte de un proyecto Springboot con las siguientes características:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger
- jUnit, Mockito

Al iniciar el servicio se crean varias tablas y registros a través del script `resources/data.sql`.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html` 

#### Se pide

- Todos los endpoints actuator usarán el puerto 8081
- Completar el `actuator/info`para mostrar la información la información de la aplicación: 
  - Nombre, versión de java, artefacto, groupId
- Crear 3 profiles en la aplicación: `local`, `pre`y `pro`
- Extender el endpoint `health` para dar información sobre `ping`y `diskspace`
- El proflie `local` no tendrá ninguna restricción de exposición de actuators
- El profile `pre`sólo expondrá el `health` extendido y el `ìnfo`.
- El profile `pro` solo expondrá el `health` sin extender y el `ìnfo`.

***
## EXERCISE-7. Criteria JPA <a name="exe-7"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-7'

#### Objetivos didácticos
- Practicar el uso de las Specifications de JPA para hacer queries complejas.

#### Descripción
Se parte de un proyecto Springboot con las siguientes características:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`
Al iniciar el servicio se crean varias tablas y registros a través del script `resources/data.sql`.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html` 
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

#### Se pide
- En el endpoint existente de `working_calendar`para obtener todos los elementos, incorporar un objeto en el endpoint de entrada que permita filtrar por cualquiera de los campos de la entidad (excepto los de fecha). Si se envía en ese objeto algún valor, la query a realizar filtraría por ese elemento y los que se envíen.
- Para esta implementación se utilizarán las clases Specifications de JPA.


***
## EXERCISE-8. MongoDB <a name="exe-8"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-8'

#### Objetivos didácticos
Integrar MongoDB en el Micro2.

#### Descripción
Se parte de un proyecto con 2 módulos:

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`
Al iniciar el servicio se crean varias tablas y registros a través del script `resources/data.sql`.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html` 
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Se facilita el esqueleto del proyecto.

#### Preparación
Para la base de datos ***Mongo*** se utilizará una imagen dockerizada de la aplicación. Se requiere tener instalado ***docker-engine*** y se recomienda ***MongoDB Compass*** para la visualización de los datos. Los comandos a ejecutar en un terminal son:

`docker pull mongo:latest`

`docker run -d -p 28017:27017 mongo`

#### Se pide
- Integrar MongoDb en el Micro 2.
- El micro2 arrancará en el puerto 8085.
- Implementar la estructura para una colección de Mongo de la entidad `time_clock` con los siguientes atributos:
   - `id`: String
   - `employeeId`: Integer
   - `time`: Date
   - `type`: String
- Implementar un endpoint para recuperar todas los `time_clock` y como parámetro opcional el `employeeId`

   
***
## EXERCISE-9. Peticiones Rest Async <a name="exe-9"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-9'

#### Objetivos didácticos
Practicar peticiones rest async con webclient.

#### Descripción
Se parte de un proyecto con 2 módulos:

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`
Al iniciar el servicio se crean varias tablas y registros a través del script `resources/data.sql`.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html` 
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos MongoDB, ***necesario arrancar imagen con***: `docker pull mongo:latest` y `docker run -d -p 28017:27017 mongo`
- Mapstruct, Lombok, Swagger

Al iniciar el servicio se popula la colección `sale` con los valores del archivo `data.json`
- Para acceder a la documentación via swagger: http://localhost:8085/swagger-ui/index.html

#### Se pide
- Implementar en el micro2 un endpoint que devuelva las un reporte de fichajes para un empleado concreto. Devolverá un objeto con el código del empleado, las ventas totales y el importe total de las ventas.
- Implementar en el micro1 un endpoint para recuperar las estadísticas por producto. Este endpoint aceptará como parámetros un array de ints para pedir las estadísticas de varios productos en la misma llamadas.
- El micro1 realizará una llamada para cada producto al micro2 para obtener las estadísticas de ventas. El micro1 retornará un listado de todas las ventas solicitadas incluyendo en cada una todos los atributos del producto.
- Esta llamada desde el micro1 al micro2 se realizará mediante webclient y se paralelizará.


***
## EXERCISE-10. Kafka Publisher <a name="exe-10"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-10'

#### Objetivos didácticos
Integrar kafka en un proyecto Springboot y crear un publisher

#### Descripción
Se parte de un proyecto con 2 módulos:

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs, WebClient
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`
Al iniciar el servicio se crean varias tablas y registros a través del script `resources/data.sql`.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html` 
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos MongoDB, ***necesario arrancar imagen con***: `docker pull mongo:latest` y `docker run -d -p 28017:27017 mongo`
- Mapstruct, Lombok, Swagger

Al iniciar el servicio se popula la colección `sale` con los valores del archivo `data.json`
- Para acceder a la documentación via swagger: http://localhost:8085/swagger-ui/index.html

#### Preparación
Para levantar el broker ***Kafka*** se ejecutará el `docker-compose`que se encuentra en la ruta: `micro2/kafka`. Para ello desde un terminal en la carpeta donde esta el archivo ejecuta:
`docker-compose up -d`
Esto levantara un contenedor de ***kafka*** y otro de ***zookeeper*** necesarios para correr la aplicación.


#### Se pide
- Incorporar Kafka al micro2.
- Implementar un publisher en este micro para que publique en la cola "statistics-topic" cuando se llame al endpoint `/api/sales/{productId}/statistics`es decir, publicará en el topic el mismo objeto que devuelve el endpoint cuando recibe una petición.

***
## EXERCISE-11. Kafka Consumer <a name="exe-11"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-11'

#### Objetivos didácticos
Consumir mensajes de kafka.

#### Descripción
Se parte de un proyecto con 2 módulos:

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs, WebClient
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`
Al iniciar el servicio se crean varias tablas y registros a través del script `resources/data.sql`.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html` 
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos MongoDB, ***necesario arrancar imagen con***: `docker pull mongo:latest` y `docker run -d -p 28017:27017 mongo`
- Mapstruct, Lombok, Swagger
- Kafka, ***necesario arrancar imagen con***: `docker-compose up -d` de la carpeta `/kafka`

Al iniciar el servicio se popula la colección `sale` con los valores del archivo `data.json`
- Para acceder a la documentación via swagger: http://localhost:8085/swagger-ui/index.html


#### Se pide
- Crear la estructura para añadir un objeto de tipo `sale`mediante apiRest en el micro2 siguiendo la arquitectura hegaxonal.
- Cuando se añada un `sale`, el servicio recalculará las statistics y publicará en el topic `statistics-topic`.
- Crear en el micro1 la tabla SQL y estructura para persistir una entidad `statistics` que almacenará las estadísticas por producto.
- Incorporar Kafka al micro1.
- Implementar un consumer del topic `statistics-topic` en el micro1 que al recibir un mensaje cree un objeto `statistics` para un producto.
- Implementar la siguiente lógica descrita en el diagrama: https://gitlab.bosonit.com/-/ide/project/santiago.ferreira/training-java/tree/main/-/training-java-index/assets/training-java-exe-11.jpg
  - Cuando se llama al endpoint del micro1 `GetProducts` antes de hacer una llamada Rest al micro2, el servicio revisará si existe en la base de datos H2 un registro para la estadísticas de ese producto.
  - Si existen, las cargará directamente, en caso de que no existan, las recuperará con la petición Rest al micro2.
  - El micro2, siempre que reciba una petición al endpoint `GetStatistics` devolverá las estadísticas y también publicará el mismo objeto en el topi `statistics-topi`, de esta manera el micro1, posteriormente consumirá el mensaje y añadirá las nuevas estadísticas.
  - Sólo exisistirá como máximo un regitro de estadísticas para cada producto.
  - Incorporar logs mediante @Slf4j a los procesos principales.


***
## EXERCISE-12. Postgres y Liquibase <a name="exe-12"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-12'

#### Objetivos didácticos
- Integrar la librería liquibase de gestión de scripts de base de datos.
- Postgres

#### Descripción
Se parte de un proyecto con 2 módulos:

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos H2 embebida
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs, WebClient
- jUnit, Mockito
- Kafka, ***necesario arrancar imagen con***: `docker-compose up -d` de la carpeta `/kafka`

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`
Al iniciar el servicio se crean varias tablas y registros a través del script `resources/data.sql`.

- Para acceder a la consola de la base de datos: http://localhost:8080/h2-console
- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html`
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos MongoDB, ***necesario arrancar imagen con***: `docker pull mongo:latest` y `docker run -d -p 28017:27017 mongo`
- Mapstruct, Lombok, Swagger
- Kafka, ***necesario arrancar imagen con***: `docker-compose up -d` de la carpeta `/kafka`

Al iniciar el servicio se popula la colección `sale` con los valores del archivo `data.json`
- Para acceder a la documentación via swagger: http://localhost:8085/swagger-ui/index.html


#### Se pide
- Sustituir en el micro1 la base de datos en memoria H2 por una base de datos ***Postgres*** que se ejecute en un contenedor Docker.
- Incorporar al micro1 la librería ***liquibase*** para gestionar los scripts de base de datos.


***
## EXERCISE-13. Authorization y Resource Servers <a name="exe-13"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-13'

#### Objetivos didácticos
- Implementar un authorization y un resource server con token JWT

#### Descripción
Se parte de un proyecto con 2 módulos (microservicios independientes). Es necesario levantar los siguientes contenedores:

- Kafka / Zookeeper : Ejecutar `docker-compose up -d` en la carpeta `/kafka` del proyecto.
- Base de datos MongoDB: `docker pull mongo:latest` y `docker run -d -p 28017:27017 mongo`
- Base de datos Posgres: `docker pull postgres:latest` y `docker run -d -e POSTGRES_USER=training -e POSTGRES_PASSWORD=training -p 5432:5432 postgres`

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos Postgres
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs, WebClient, Kafka, Liquibase
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`

- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html`
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos MongoDB
- Mapstruct, Lombok, Swagger, Kafka

Al iniciar el servicio se popula la colección `sale` con los valores del archivo `data.json`
- Para acceder a la documentación via swagger: http://localhost:8085/swagger-ui/index.html


#### Se pide
- Crear un nuevo micro que sirva tokens de autorización en base a una tabla `Users` de base de datos (que hay que crear).
- Securizar el endpoint POST addSale del micro2 para recibir un token JWT y permitir o no el acceso.
- Seguir la arquitectura del diagrama: https://gitlab.bosonit.com/-/ide/project/santiago.ferreira/training-java/tree/main/-/training-java-index/assets/training-java-exe-13.jpg


***
## EXERCISE-14. Springbatch <a name="exe-14"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-14'

#### Objetivos didácticos
- Implementar un job de springbatch

#### Descripción
Se parte de un proyecto con 3 módulos (microservicios independientes). Es necesario levantar los siguientes contenedores:

- Kafka / Zookeeper : Ejecutar `docker-compose up -d` en la carpeta `/kafka` del proyecto.
- Base de datos MongoDB: `docker pull mongo:latest` y `docker run -d -p 28017:27017 mongo`
- Base de datos Posgres: `docker pull postgres:latest` y `docker run -d -e POSTGRES_USER=training -e POSTGRES_PASSWORD=training -p 5432:5432 postgres`

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos Postgres
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs, WebClient, Kafka, Liquibase
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`

- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html`
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos MongoDB
- Mapstruct, Lombok, Swagger, Kafka

Al iniciar el servicio se popula la colección `sale` con los valores del archivo `data.json`
- Para acceder a la documentación via swagger: http://localhost:8085/swagger-ui/index.html


##### Micro Auth
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos Postgres
- Mapstruct, Lombok, Swagger

Este micro implementa un Authentication Server para autenticarse y obtener un token. Con este token se puede acceder al endpoint
delo micro2 `addSale`.

Endpoint con pk: `http://localhost:9000/oauth2/jwks`

#### Se pide
- En el micro1 crear una nueva tabla statistics_historic que almacenara las statistics de un momento dado. Además de los valores tendrá que almacenar la fecha.
- Crear un proceso batch que lea todos los registros de la tabla statistics y los añada con la fecha de la operación a la tabla statistics_historic
- Crear un endpoint que arranque el proceso.

  
***
## EXERCISE-15. Redis <a name="exe-15"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-15'

#### Objetivos didácticos
- Implementar una memoria cache.

#### Descripción
Se parte de un proyecto con 3 módulos (microservicios independientes). Es necesario levantar los siguientes contenedores:

- Kafka / Zookeeper : Ejecutar `docker-compose up -d` en la carpeta `/kafka` del proyecto.
- Base de datos MongoDB: `docker pull mongo:latest` y `docker run -d -p 28017:27017 mongo`
- Base de datos Posgres: `docker pull postgres:latest` y `docker run -d -e POSTGRES_USER=training -e POSTGRES_PASSWORD=training -p 5432:5432 postgres`

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos Postgres
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs, WebClient, Kafka, Liquibase
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`

- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html`
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos MongoDB
- Mapstruct, Lombok, Swagger, Kafka

Al iniciar el servicio se popula la colección `sale` con los valores del archivo `data.json`
- Para acceder a la documentación via swagger: http://localhost:8085/swagger-ui/index.html


##### Micro Auth
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos Postgres
- Mapstruct, Lombok, Swagger

Este micro implementa un Authentication Server para autenticarse y obtener un token. Con este token se puede acceder al endpoint
delo micro2 `addSale`.

Endpoint con pk: `http://localhost:9000/oauth2/jwks`

#### Se pide
- Incorporar las librerías REDIS al proyecto y conectarlo con una instancia REDIS de un contenedor docker.
- Cachear las peticiones al endpoint getProduct del micro1


***
## EXERCISE-16. Aspectos <a name="exe-16"></a>

#### Proyecto de partida
Github URL: `https://gitlab.bosonit.com/santiago.ferreira/training-java/-/tree/main/training-java-exe-16'

#### Objetivos didácticos
- Utlizar la programación orientada a aspectos de Springboot.

#### Descripción
Se parte de un proyecto con 3 módulos (microservicios independientes). Es necesario levantar los siguientes contenedores:

- Kafka / Zookeeper : Ejecutar `docker-compose up -d` en la carpeta `/kafka` del proyecto.
- Base de datos MongoDB: `docker pull mongo:latest` y `docker run -d -p 28017:27017 mongo`
- Base de datos Posgres: `docker pull postgres:latest` y `docker run -d -e POSTGRES_USER=training -e POSTGRES_PASSWORD=training -p 5432:5432 postgres`
- Memoria cache `docker pull redis:latest` y `docker run -p 6379:6379 -d redis`

##### Micro 1
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos Postgres, Redis
- JPA, Mapstruct, Lombok, Swagger, Criteria Specs, WebClient, Kafka, Liquibase
- jUnit, Mockito

Es necesario indicar un profile para arrancar la aplicación. P.e.: `spring.profiles.active=local`

- Para acceder a la documentación via swagger: http://localhost:8080/swagger-ui/index.html
- Para acceder al reporte de Jacoco: `target/site/jacoco/index.html`
- Actuator Endpoints:
  - /actuator/health
  - /actuator/info
  - /actuator/health/custom

##### Micro 2
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos MongoDB
- Mapstruct, Lombok, Swagger, Kafka

Al iniciar el servicio se popula la colección `sale` con los valores del archivo `data.json`
- Para acceder a la documentación via swagger: http://localhost:8085/swagger-ui/index.html


##### Micro Auth
Proyecto Springboot:

- Maven
- Springboot v3
- Java v17
- Base de datos Postgres
- Mapstruct, Lombok, Swagger

Este micro implementa un Authentication Server para autenticarse y obtener un token. Con este token se puede acceder al endpoint
delo micro2 `addSale`.

Endpoint con pk: `http://localhost:9000/oauth2/jwks`

#### Se pide
- Incorporar las librerias de la programación orientada a aspectos de springboot.
- Implementar un `pointcut`para setear en las entidades `ProductPriceJpa`, `StatisticsHistoricJpa`y `StatisticsJpa` el atributo CreationDate (LocalDateTime) con la fecha en el que se crea el recurso. Para ello hay que modificar las tablas de estas entidades de base de datos en un script de liquibase y añadir las propiedades a las entidades.
