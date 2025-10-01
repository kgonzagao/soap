//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2025.10.01 a las 01:21:03 PM ECT 
//


package com.kgonzaga.soap_server.app.presentation.dto;

import java.math.BigDecimal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para employee complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="employee"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="job" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="salary" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employee", propOrder = {
        "id",
        "name",
        "job",
        "salary"
})
public class Employee {

    protected long id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String job;
    @XmlElement(required = true)
    protected BigDecimal salary;

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
     * Obtiene el valor de la propiedad name.
     *
     * @return possible object is
     * {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     *
     * @param value allowed object is
     *              {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad job.
     *
     * @return possible object is
     * {@link String }
     *
     */
    public String getJob() {
        return job;
    }

    /**
     * Define el valor de la propiedad job.
     *
     * @param value allowed object is
     *              {@link String }
     *
     */
    public void setJob(String value) {
        this.job = value;
    }

    /**
     * Obtiene el valor de la propiedad salary.
     *
     * @return possible object is
     * {@link BigDecimal }
     *
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Define el valor de la propiedad salary.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     *
     */
    public void setSalary(BigDecimal value) {
        this.salary = value;
    }

}
