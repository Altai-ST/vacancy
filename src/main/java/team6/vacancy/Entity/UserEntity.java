package team6.vacancy.Entity;
import jakarta.persistence.*;
import lombok.Data;

import team6.vacancy.Enum.RoleEnum;
import team6.vacancy.Enum.StatusEnum;

import java.util.List;

@Entity
@Table(name="user")
@Data
public class UserEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="number_phone")
    private String numberPhone;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column(name = "status")
    private StatusEnum status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employer")
    private List<VacancyEntity> vacancyEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ResumeEntity> resumeEntities;

}
