package com.kgonzaga.soap_client.app.config;

import com.kgonzaga.soap_client.app.presentation.client.EmployeeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class EmployeeConfig {

    private static final String PACKAGE_NAME = "com.kgonzaga.soap_client.app.persistence.wsdl";
    public static final String URI = "http://localhost:8080/ws";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(PACKAGE_NAME);
        return marshaller;
    }

    @Bean
    public EmployeeClient client(Jaxb2Marshaller marshaller) {
        EmployeeClient client = new EmployeeClient();
        client.setDefaultUri(URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
