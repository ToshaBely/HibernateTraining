package entity;

import javax.persistence.*;

@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainingID", unique = true, nullable = false)
    private long trainingID;

    @Column(name = "name", length = 500, nullable = false)
    private String name;

    @Column(name = "trainerID", unique = true)
    private int trainerID;

    @Column(name = "date", length = 20)
    private String date;

    @Column(name = "time", length = 20)
    private String time;

    @Column(name = "audience",length = 500)
    private String audience;

    @Column(name = "place", length = 50)
    private String place;

    @Column(name = "teacher", length = 50)
    private String teacher;

    @Column(name = "duration", length = 45)
    private String duration;

    public Training() {}
    public Training(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDate (String date){
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getAudience() {
        return audience;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public long getTrainingID() {
        return trainingID;
    }
}
