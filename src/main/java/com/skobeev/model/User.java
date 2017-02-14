package com.skobeev.model;

import net.sf.oval.constraint.*;
import com.skobeev.util.CheckUserMail;

import java.util.Date;

public class User {

    private Long id;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Length(min = 2 ,max = 15 , message = "Name length must between 2 and 20 characters")
    private String firstName;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Length(min = 3 ,max = 15 , message = "Last Name length must between 3 and 20 characters")
    private String lastName;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @CheckWith(value= CheckUserMail.class , message = "mail already exists")
    private String mail;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @DateRange(format = "yyyy-MM-dd",min = "1950-01-01",max="2000-01-01",message = "Birthday must be in a range of 1950-2000")
    private Date birthDay;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 1000,message = "Invalid value,minimum salary must be 1000")
    private Long salary;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    private Long depId;

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
