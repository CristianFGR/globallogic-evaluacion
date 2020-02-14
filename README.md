TEST-JAVA Postulacion GlobalLogic
====================

Proyecto construido con spring-boot 2.2.4
que almacena informacion de un usuario en una base de datos mysql

Este aplicativo corre en un docker en conjunto con su base de datos

### USO
Clonar el proyecto
en la raiz del mismo ejecutar
```
docker-compose up
```

Documentacion y uso de Swagger
```
http://localhost:8085/swagger-ui.html#/
```

Para utilizar este aplicativo enviar la siguiente peticion
```
curl --location --request POST 'localhost:8085/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Rodriguez",
    "email": "rodrigo@rodriguez.org",
    "password": "Ksdfsf12",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}'
```
