# SOAP Employee Service - Spring Boot 3

Este proyecto es una práctica de **SOAP Web Services** usando **Spring Boot 3**, **Spring WS** y **JPA (H2)**.  
Implementa un CRUD completo de empleados (`Employee`) expuesto como servicio SOAP, basado en un contrato XSD.

---

## 🚀 Tecnologías usadas

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Web Services**
- **Spring Data JPA**
- **H2 Database** (en memoria)
- **JAXB / jaxb2-maven-plugin** (para generar DTOs desde el XSD)
- **WSDL4J** (soporte WSDL)

---

## 📂 Estructura del proyecto

```
src/main/java/com/kgonzaga/soap_server/app
│── config/ # Configuración de SOAP y WSDL
│── mapper/ # Mapper DTO ↔ Entity
│── persistence/
│ ├── entity/ # Entidades JPA
│ ├── repository/ # Repositorios Spring Data
│── presentation/
│ ├── dto/ # Clases generadas desde el XSD
│ ├── endpoint/ # Endpoints SOAP
│── service/ # Interfaz de servicios
│── service/impl/ # Implementación de servicios
```

---

## 📜 Contrato (XSD)

El contrato se define en:

```
src/main/resources/xsd/employee-service.xsd
```

Este XSD describe:

- `Employee` (id, name, job, salary)
- Operaciones:
    - **CreateEmployee**
    - **GetEmployee (by id)**
    - **GetAllEmployees**
    - **UpdateEmployee**
    - **DeleteEmployee**

El **WSDL** se genera automáticamente en runtime a partir del XSD.

---

## 🌐 Endpoints SOAP

El servicio SOAP se expone en:

```http
http://localhost:8080/ws
```

El **WSDL** está disponible en:

```http
http://localhost:8080/ws/employee.wsdl
```

---

## 📌 Operaciones disponibles

### 1️⃣ Crear empleado

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:emp="http://kgonzaga.com/soap/employee-web-service">
    <soapenv:Header/>
    <soapenv:Body>
        <emp:createEmployeeRequest>
            <emp:employee>
                <emp:name>John Doe</emp:name>
                <emp:job>Developer</emp:job>
                <emp:salary>1200.00</emp:salary>
            </emp:employee>
        </emp:createEmployeeRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

### 2️⃣ Obtener empleado por ID

```xml

<emp:getEmployeeRequest xmlns:emp="http://kgonzaga.com/soap/employee-web-service">
    <emp:id>1</emp:id>
</emp:getEmployeeRequest>
```

### 3️⃣ Obtener todos los empleados

```xml

<emp:getAllEmployeesRequest xmlns:emp="http://kgonzaga.com/soap/employee-web-service"/>
```

### 4️⃣ Actualizar empleado

```xml

<emp:updateEmployeeRequest xmlns:emp="http://kgonzaga.com/soap/employee-web-service">
    <emp:id>1</emp:id>
    <emp:employee>
        <emp:id>1</emp:id>
        <emp:name>Jane Doe</emp:name>
        <emp:job>Manager</emp:job>
        <emp:salary>2000.00</emp:salary>
    </emp:employee>
</emp:updateEmployeeRequest>
```

### 5️⃣ Eliminar empleado

```xml

<emp:deleteEmployeeRequest xmlns:emp="http://kgonzaga.com/soap/employee-web-service">
    <emp:id>1</emp:id>
</emp:deleteEmployeeRequest>
```

## 🛠️ Cómo ejecutar

1. Clona el repositorio:

```
git clone https://github.com/kgonzagao/soap.git
cd soap-serve
```

2. Compila y genera clases JAXB a partir del XSD: (Nota: las clases JAXB se encuentra generadas)

```
mvn clean install
```

3. Ejecuta la aplicación:

```
mvn spring-boot:run
```

4. Accede al WSDL en:

```
👉 http://localhost:8080/ws/employee.wsdl
```

## 🧪 Tests

El proyecto incluye soporte para pruebas con `spring-boot-starter-test`.
Se recomienda probar los endpoints usando SOAP UI o Postman (con body XML).

## 📖 Mejoras pendientes

- Manejo de SoapFaults personalizados para errores (ej: empleado no encontrado).
- Validaciones con Bean Validation (Jakarta Validation).
- Tests automatizados con WebServiceTemplate.

## ⚖️ Licencia

Este proyecto está bajo la Licencia Apache 2.0.