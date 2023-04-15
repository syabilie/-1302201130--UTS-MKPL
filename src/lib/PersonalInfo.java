package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PersonalInfo {
    public enum Gender {
        MALE,
        FEMALE
    }
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private LocalDate dateJoined;
    private boolean isForeigner;
    private Gender gender;

    public PersonalInfo(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public Gender getGender() {
        return gender;
    }
}
