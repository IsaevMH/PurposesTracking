package org.purposetracking.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purposes", schema = "public")
public class Purpose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purpose_id", columnDefinition = "serial")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "creation_date")
    private LocalDateTime dateOfCreation;

    @Column(name = "days_tally")
    private int daysTally;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Purpose() {}

    public Purpose(long id, String title, LocalDateTime dateOfCreation, int daysTally) {
        this.id = id;
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.daysTally = daysTally;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }
    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getDaysTally() {
        return daysTally;
    }
    public void setDaysTally(int daysTally) {
        this.daysTally = daysTally;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
