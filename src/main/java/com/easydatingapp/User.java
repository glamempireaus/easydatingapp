package com.easydatingapp;

import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User
{
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    public Long getId() {return id;}
    public void setId(Long id) { this.id = id; }

    // account data

    private String email;
    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email; }

    private String firstName;
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) { this.firstName = firstName; }

    private String lastName;
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) { this.lastName = lastName; }

    private String password;
    public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password; }

    private GregorianCalendar dateOfBirth;
    public GregorianCalendar getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(GregorianCalendar dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    private Gender gender;
    public Gender getGender() {return gender;}
    public void setGender(Gender gender) { this.gender = gender; }

    // dating data

    private Set<SexualPreference> sexualPreferences;
    public Set<SexualPreference> getSexualPreferences() {return sexualPreferences;}
    public Boolean addSexualPreference(SexualPreference sexualPreference){return sexualPreferences.add(sexualPreference);}
    public Boolean removeSexualPreference(SexualPreference sexualPreference) {return sexualPreferences.remove(sexualPreference);}

    private PersonalityType personalityType;
    public PersonalityType getPersonalityType() {return personalityType;}
    public void setDateOfBirth(PersonalityType personalityType) { this.personalityType = personalityType; }

    public enum SexualPreference
    {
        MALE,
        FEMALE,
        BOTH
    }

    public enum PersonalityType
    {
        ARCHITECT,
        LOGICIAN,
        COMMANDER,
        DEBATER,
        ADVOCATE,
        MEDIATOR,
        PROTAGONIST,
        CAMPAIGNER,
        LOGISTICIAN,
        DEFENDER,
        EXECUTIVE,
        CONSUL,
        VIRTUOSO,
        ADVENTURER,
        ENTREPRENEUR,
        ENTERTAINER
    }

    public enum Gender
    {
        MALE,
        FEMALE,
        OTHER
    }

    public User(String email, String firstName, String lastName, String password, GregorianCalendar dateOfBirth, Gender gender)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public int hashCode() 
    {
        return Objects.hash(this.id, this.firstName, this.password);
    }
}
