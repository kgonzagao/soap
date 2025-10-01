package com.kgonzaga.soap_client.app.presentation.client;

import com.kgonzaga.soap_client.app.persistence.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import static com.kgonzaga.soap_client.app.config.EmployeeConfig.URI;


public class EmployeeClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(EmployeeClient.class);
    private final String URI_SEND = URI.concat("/employee");
    private final String NAME_SPACE = "http://kgonzaga.com/soap/employee-web-service";

    public GetAllEmployeesResponse getAllEmployeesResponse() {
        GetAllEmployeesRequest request = new GetAllEmployeesRequest();
        log.info("getAllEmployeesResponse() -> ");
        return (GetAllEmployeesResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI_SEND, request,
                        new SoapActionCallback(NAME_SPACE.concat("/getAllEmployeesRequest")));
    }

    public CreateEmployeeResponse createEmployeeResponse(Employee employee) {
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setEmployee(employee);
        log.info("createEmployeeResponse() -> Employee ({},{},{},{})",
                employee.getId(), employee.getName(), employee.getJob(), employee.getSalary());
        return (CreateEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI_SEND, request,
                        new SoapActionCallback(NAME_SPACE.concat("/createEmployeeRequest")));
    }

    public GetEmployeeResponse getEmployeeResponse(Long id) {
        GetEmployeeRequest request = new GetEmployeeRequest();
        request.setId(id);
        log.info("getEmployeeResponse() -> Id ({})", id);
        return (GetEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI_SEND, request,
                        new SoapActionCallback(NAME_SPACE.concat("/getEmployeeRequest")));
    }

    public UpdateEmployeeResponse updateEmployeeResponse(Long id, Employee employee) {
        UpdateEmployeeRequest request = new UpdateEmployeeRequest();
        request.setId(id);
        request.setEmployee(employee);
        log.info("updateEmployeeResponse() -> Id ({})/ Employee ({},{},{},{})",
                id, employee.getId(), employee.getName(), employee.getJob(), employee.getSalary());
        return (UpdateEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI_SEND, request,
                        new SoapActionCallback(NAME_SPACE.concat("/updateEmployeeRequest")));
    }

    public DeleteEmployeeResponse deleteEmployeeResponse(Long id) {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest();
        request.setId(id);
        log.info("deleteEmployeeResponse() -> Id ({})", id);
        return (DeleteEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI_SEND, request,
                        new SoapActionCallback(NAME_SPACE.concat("/deleteEmployeeRequest")));
    }
}
