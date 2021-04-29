package com.gamoland.rearingapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailAddress;
    @ManyToMany
    private List<Colony> colonies;

    public Owner(String emailAddress, List<Colony> colonies) {
        this.emailAddress = emailAddress;
        this.colonies = colonies;
    }

    public Owner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Colony> getColonies() {
        return colonies;
    }

    public void setColonies(List<Colony> colonies) {
        this.colonies = colonies;
    }

    public void addColony(Colony colony){
        colonies.add(colony);
    }
}
