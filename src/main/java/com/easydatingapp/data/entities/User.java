package com.easydatingapp.data.entities;

import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User
{
	private static final long serialVersionUID = 1L;
	
	private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    public Long getId() {return id;}
    public void setId(Long id) { this.id = id; }

    // account data

    @Column(name="email", length=60, nullable=false)
    private String email;
    public String getEmail() {return email;}
    public void setEmail(String email) { this.email = email; }

    @Column(name="firstname", length=50, nullable=false)
    private String firstName;
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Column(name="lastname", length=50, nullable=false)
    private String lastName;
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Column(name="password", length=50, nullable=false)
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
    
    private SexualPreference sexualPreference;
    public SexualPreference getSexualPreference() {return sexualPreference;}
    public void setSexualPreference(SexualPreference sexualPreference) { this.sexualPreference = sexualPreference; }
    
    private Set<SexualDesire> sexualDesires;
    public Set<SexualDesire> getSexualDesires() {return sexualDesires;}
    public Boolean addSexualDesire(SexualDesire sexualDesire){return sexualDesires.add(sexualDesire);}
    public Boolean removeSexualDesires(SexualDesire sexualDesire) {return sexualDesires.remove(sexualDesire);}

    private PersonalityType personalityType;
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
