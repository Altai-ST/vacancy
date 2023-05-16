package team6.vacancy.Entity;
import jakarta.persistence.*;
import lombok.Data;
import team6.vacancy.Enum.StatusEnum;

@Entity
@Table(name = "vacancy")
@Data
public class VacancyEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_vacancy")
    private String nameVacancy;

    @Column(name = "fromSalary")
    private String fromSalary;

    @Column(name = "upToSalary")
    private String upToSalary;

    @Column(name = "fromExperience")
    private String fromExperience;

    @Column(name = "upToExperience")
    private String upToExperience;

    @Column(name = "workSchedule")
    private String workSchedule;

    @Column(name = "employmentType")
    private String employmentType;

    @Column(name = "specialties")
    private String specialties;

    @Column(name = "region")
    private String region;

    @Column(name = "companyIndustry")
    private String companyIndustry;

    @Column(name = "education")
    private String education;

    @Column(name = "description")
    private String description;

    @Column(name = "dateCreate")
    private String dateCreate;

    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private UserEntity employer;
}
