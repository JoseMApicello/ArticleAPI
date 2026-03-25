# Article API

## API REST de ejercicio que simula:

Una empresa requiere implementar un servicio web que facilite a diversas aplicaciones tanto
consultar información sobre el detalle de un artículo disponible de su catálogo, así como
actualizar ciertos datos de algún artículo en específico, donde la consulta y actualización de la
información se debe realizar mediante el id del artículo.

## Recursos

database.sql: Creacion de la base de datos

schema.sql: Creacion de la tabla article

data.sql:  Conjunto de Datos de muestra

Ubicacion de Ambos scripts : src/main/resources

## Instrucciones ambiente local

### Scripts de BD
Ejecuta los scrips de BD en el siguiente orden:
- database.sql
- schema.sql
- data.sql

### Construir la imagen docker
docker build -t article-api .

### Verificar que se creó
docker images article-api

### Ejecución en ambiente local
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
                               
