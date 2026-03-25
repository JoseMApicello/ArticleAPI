# Article API

## API REST de ejercicio que simula:

Una empresa requiere implementar un servicio web que facilite a diversas aplicaciones tanto
consultar información sobre el detalle de un artículo disponible de su catálogo, así como
actualizar ciertos datos de algún artículo en específico, donde la consulta y actualización de la
información se debe realizar mediante el id del artículo.

## Evidencias invocacion servicio con POSTMAN y despliegue GCP

Ver carpeta /evidencias_gcp_postman

## Recursos

database.sql: Creacion de la base de datos

schema.sql: Creacion de la tabla article

data.sql:  Conjunto de Datos de muestra

Ubicacion de Ambos scripts : src/main/resources

## Instrucciones ambiente local

-----------------------------------------------------------------
NOTA IMPORTANTE: 
EJECUTAR SCRIPTS DE BD ANTES DE DESPLEGAR EL SERVICIO
LA BD Y TABLA DEBE EXISTIR AL MOMENTO DEL DESPLIEGUE DEL API
-----------------------------------------------------------------

### Ejecutar Scripts de BD
Ejecuta los scrips de BD en el siguiente orden:
- database.sql
- schema.sql
- data.sql

### Construir la imagen docker
docker build -t article-api .

### Verificar que se creó
docker images article-api

### Ejecutar servicio en ambiente local
docker run --rm \
  -p 8090:8080 \
  -e DB_URL=jdbc:postgresql://host.docker.internal:5433/article_bd \
  -e DB_USER=tu_usuario \
  -e DB_PASSWORD=tu_contraseña \
  article-api

## Esquema de despliegue en GCP

┌─────────────────────┐
│   Spring Boot App   │
└──────────┬──────────┘
           │
           │ Docker Image
           ▼
┌─────────────────────┐
│  Artifact Registry  │
└──────────┬──────────┘
           │
           │ Deploy
           ▼
┌─────────────────────┐        ┌──────────────────────────┐
│      Cloud Run      │───────►│  Cloud SQL (PostgreSQL)  │
└─────────────────────┘        └──────────────────────────┘
                               
