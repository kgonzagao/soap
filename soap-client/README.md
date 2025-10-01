# SOAP Employee Client - Spring Boot 3

Este proyecto es un **cliente SOAP** hecho con **Spring Boot 3** para consumir el servicio **Employee SOAP Service**.

---

## 🚀 Tecnologías usadas

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Web Services**
- **JAXB (clases generadas a partir del WSDL con `jaxws-maven-plugin`)**

---

## 📂 Estructura del proyecto

```
src/main/java/com/kgonzaga/soap_client/app
│── config/ # Configuración SOAP (Marshaller + URI)
│── persistence/wsdl # Clases generadas desde el WSDL del servidor
│── presentation/
│ └── client/ # EmployeeClient: llamadas SOAP
│── SoapClientApplication.java # Runner principal
```

---

## ⚙️ Cómo generar las clases desde el WSDL

El WSDL se expone en el servidor en:

```
http://localhost:8080/ws/employee.wsdl
```

Para regenerar las clases:

```bash
mvn clean compile
```

Esto ejecutará el plugin jaxws-maven-plugin y generará las clases en `com.kgonzaga.soap_client.app.persistence.wsdl`.

## 🧪 Ejecución del cliente

1. Asegúrate de que el servidor (`soap-serve`) esté corriendo en `http://localhost:8080/ws`.
2. Corre el cliente:

```
mvn spring-boot:run
```

3. El `CommandLineRunner` ejecutará automáticamente:
    - Listar empleados
    - Crear un nuevo empleado
    - Obtener un empleado por ID
    - Actualizar empleado
    - Eliminar empleado

Los resultados se verán en consola.

## 📖 Mejoras pendientes

- Manejo de errores (ej: empleado no encontrado).
- Uso de `SoapFault` para validar respuestas erróneas.
- Reemplazar `System.out.println` por `Logger`.

## ⚖️ Licencia

Este proyecto está bajo la Licencia Apache 2.0.