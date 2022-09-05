package com.easydatingapp.data.entities;

import java.util.GregorianCalendar;
import java.util.Set;

public class User
{
    // account data
    public int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private GregorianCalendar dateOfBirth;
    private Gender gender;
    
    // dating data
    private SexualPreference sexualPreference;
    private Set<SexualDesire> sexualDesires;
    private PersonalityType personalityType;
    
    public int getId() {return id;}
    public void setId(int id) { this.id = id; }

    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password; }
   
    public GregorianCalendar getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(GregorianCalendar dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Gender getGender() {return gender;}
    public void setGender(Gender gender) { this.gender = gender; }

    public SexualPreference getSexualPreference() {return sexualPreference;}
    public void setSexualPreference(SexualPreference sexualPreference) { this.sexualPreference = sexualPreference; }

    public Set<SexualDesire> getSexualDesires() {return sexualDesires;}
    public Boolean addSexualDesire(SexualDesire sexualDesire){return sexualDesires.add(sexualDesire);}
    public Boolean removeSexualDesires(SexualDesire sexualDesire) {return sexualDesires.remove(sexualDesire);}

    public PersonalityType getPersonalityType() {return personalityType;}
    public void setPersonalityType(PersonalityType personalityType) { this.personalityType = personalityType; }

    public enum SexualPreference
    {
        MALE,
        FEMALE,
        BOTH
    }
    
    public enum SexualDesire
    {
        BDSM,
        ROLEPLAY,
        IDK
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

    public User(){}
    
    public User(String email, String firstName, String lastName, String password)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
}
