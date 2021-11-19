package com.snourian.example.dynquery.service.dto;

import com.snourian.example.dynquery.domain.Employee;

import java.time.LocalDate;

public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private LocalDate joinedDate;

    private Employee.Gender gender;

    private Employee.Rank rank;

    private long score;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Employee.Gender getGender() {
        return gender;
    }

    public void setGender(Employee.Gender gender) {
        this.gender = gender;
    }

    public Employee.Rank getRank() {
        return rank;
    }

    public void setRank(Employee.Rank rank) {
        this.rank = rank;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
