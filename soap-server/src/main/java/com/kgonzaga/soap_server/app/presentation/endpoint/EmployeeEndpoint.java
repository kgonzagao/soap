package com.kgonzaga.soap_server.app.presentation.endpoint;

import com.kgonzaga.soap_server.app.presentation.dto.*;
import com.kgonzaga.soap_server.app.service.IEmployeeService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.kgonzaga.soap_server.app.config.WebServiceConfig.NAMESPACE_URI;

@Endpoint
public class EmployeeEndpoint {

    private final IEmployeeService service;

    public EmployeeEndpoint(IEmployeeService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeesRequest")
    @ResponsePayload
    public GetAllEmployeesResponse getAllEmployees(@RequestPayload GetAllEmployeesRequest request) {
        GetAllEmployeesResponse response = new GetAllEmployeesResponse();
        response.getEmployees().addAll(this.service.getAllEmployees());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEmployeeRequest")
    @ResponsePayload
    public CreateEmployeeResponse createEmployee(@RequestPayload CreateEmployeeRequest request) {
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setEmployee(this.service.saveEmployee(request.getEmployee()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(this.service.getEmployeeById(request.getId()).orElse(null));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setEmployee(this.service.updateEmployee(request.getId(), request.getEmployee()).orElse(null));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        response.setSuccess(this.service.deleteEmployee(request.getId()));
        return response;
    }

}
