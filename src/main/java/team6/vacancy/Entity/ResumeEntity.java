package team6.vacancy.Entity;
import jakarta.persistence.*;
import lombok.Data;
import team6.vacancy.Enum.StatusEnum;

import java.util.List;

@Entity
@Table(name = "resume")
@Data
public class ResumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "nameResume")
    private String nameResume;

    @Column(name = "experience")
    private String experience;

    @Column(name="skills")
    private List<String> skills;

    @Column(name = "languages")
    private List<String> languages;

    @Column(name = "job_expectation")
    private String job_expectation;

    @Column(name ="education")
    private String education;

    @Column(name = "certificates")
    private String certificates;

    @Column(name = "status")
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private UserEntity user;
}
