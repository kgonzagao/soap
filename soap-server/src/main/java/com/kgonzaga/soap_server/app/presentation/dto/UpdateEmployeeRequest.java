//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.01 a las 01:21:03 PM ECT 
//


package com.kgonzaga.soap_server.app.presentation.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="employee" type="{http://kgonzaga.com/soap/employee-web-service}employee"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "employee"
})
@XmlRootElement(name = "updateEmployeeRequest")
public class UpdateEmployeeRequest {

    protected long id;
    @XmlElement(required = true)
    protected Employee employee;

    /**
     * Obtiene el valor de la propiedad id.
     *
     */
    public long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     *
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad employee.
     *
     * @return possible object is
     * {@link Employee }
     *
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Define el valor de la propiedad employee.
     *
     * @param value allowed object is
     *              {@link Employee }
     *
     */
    public void setEmployee(Employee value) {
        this.employee = value;
    }

}
