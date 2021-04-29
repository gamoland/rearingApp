package com.gamoland.rearingapp.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Colony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startedAt;
    private LocalDateTime feedAt;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "colonies", fetch = FetchType.EAGER)
    private List<Owner> owners;

    public Colony() {
    }

    public Colony(LocalDateTime startedAt, LocalDateTime feedAt, List<Owner> owners) {
        this.startedAt = startedAt;
        this.feedAt = feedAt;
        this.owners = owners;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getFeedAt() {
        return feedAt;
    }

    public void setFeedAt(LocalDateTime feedAt) {
        this.feedAt = feedAt;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public void addOwner(Owner owner){
        owners.add(owner);
    }
}
