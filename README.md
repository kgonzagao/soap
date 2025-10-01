#  Proyecto SOAP: Employee Management

Este proyecto es una práctica completa de Spring Boot 3 + Spring WS, que implementa un sistema de gestión de empleados mediante servicios SOAP.

## Consta de dos aplicaciones:

1. Servidor SOAP (`soap-server`)

    - Expone un CRUD de empleados (crear, consultar, actualizar, eliminar).
    - Define su contrato a través de un archivo XSD, desde el cual se generan las clases JAXB.
    - Persiste los datos en una base de datos en memoria H2 mediante Spring Data JPA.
    - Expone el WSDL en:


```
http://localhost:8080/ws/employee.wsdl
```

2. Cliente SOAP (`soap-client`)

    - Consume el servicio SOAP publicado por el servidor.
    - Utiliza Jaxb2Marshaller y clases generadas automáticamente a partir del WSDL.
    - Contiene un cliente (EmployeeClient) con métodos para invocar cada operación del servicio.
    - A través de un CommandLineRunner se realizan llamadas de ejemplo para:
      - Listar todos los empleados.
      - Crear un nuevo empleado.
      - Consultar un empleado por ID.      
      - Actualizar un empleado existente.
      - Eliminar un empleado.


## 🚀 Tecnologías utilizadas
- Java 21
- Spring Boot 3.5.6
- Spring Web Services (Spring WS)
- Spring Data JPA + H2 Database
- Maven + JAX-WS Plugin (para generación de clases desde WSDL)

## 📂 Estructura del proyecto
```
/soap-server   -> aplicación que expone el servicio SOAP
/soap-client   -> aplicación que consume el servicio SOAP
```
