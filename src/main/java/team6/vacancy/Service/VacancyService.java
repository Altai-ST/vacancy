package team6.vacancy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team6.vacancy.Entity.UserEntity;
import team6.vacancy.Entity.VacancyEntity;
import team6.vacancy.Enum.StatusEnum;
import team6.vacancy.Exception.UserNotFoundException;
import team6.vacancy.Repository.UserRepo;
import team6.vacancy.Repository.VacancyRepo;

@Service
public class VacancyService {
    @Autowired
    private VacancyRepo vacancyRepo;

    @Autowired
    private UserRepo userRepo;

    public VacancyEntity createVacancy(VacancyEntity vacancy, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        vacancy.setEmployer(user);
        vacancy.setStatus(StatusEnum.available);
        return vacancyRepo.save(vacancy);
    }

    public VacancyEntity updateVacancy(VacancyEntity vacancy, Long id){
        VacancyEntity vacancy1 = vacancyRepo.findById(id).get();
        if(vacancy1.equals(vacancy) && !(vacancy1.getStatus().equals(StatusEnum.deleted))){
            return vacancy;
        }
        vacancy1.setNameVacancy(vacancy.getNameVacancy());
        vacancy1.setAddress(vacancy.getAddress());
        vacancy1.setDescription(vacancy.getDescription());
        vacancy1.setEducation(vacancy.getEducation());
        vacancy1.setRegion(vacancy.getRegion());
        vacancy1.setDateCreate(vacancy.getDateCreate());
        vacancy1.setEmploymentType(vacancy.getEmploymentType());
        vacancy1.setCompanyIndustry(vacancy.getCompanyIndustry());
        vacancy1.setFromExperience(vacancy.getFromExperience());
        vacancy1.setFromSalary(vacancy.getFromSalary());
        vacancy1.setSpecialties(vacancy.getSpecialties());
        vacancy1.setStatus(vacancy.getStatus());
        vacancy1.setUpToExperience(vacancy.getUpToExperience());
        vacancy1.setUpToSalary(vacancy.getUpToSalary());
        vacancy1.setWorkSchedule(vacancy.getWorkSchedule());
        return vacancyRepo.save(vacancy1);
    }

    public Long delete(Long id) throws UserNotFoundException {
        if(vacancyRepo.findById(id)!=null) {
            VacancyEntity vacancy = vacancyRepo.findById(id).get();
            vacancy.setStatus(StatusEnum.deleted);
            vacancyRepo.save(vacancy);
            return id;
        }else throw new UserNotFoundException("Can not update laptop list. It doesn't exist");
    }
}
