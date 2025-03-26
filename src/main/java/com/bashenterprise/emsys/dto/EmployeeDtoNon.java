package com.bashenterprise.emsys.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDtoNon {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDtoNon(){}

    public EmployeeDtoNon(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
