package team6.vacancy.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team6.vacancy.Entity.ResumeEntity;
import team6.vacancy.Entity.VacancyEntity;
import team6.vacancy.Enum.StatusEnum;
import team6.vacancy.Exception.ResumeAlreadyExistException;
import team6.vacancy.Exception.UserNotFoundException;
import team6.vacancy.Repository.ResumeRepo;

@Service
public class ResumeService {
    @Autowired
    ResumeRepo resumeRepo;

    public ResumeEntity createResume(ResumeEntity resumeEntity) throws ResumeAlreadyExistException{
        if(resumeRepo.findByNameResume(resumeEntity.getNameResume()) != null){
            throw new ResumeAlreadyExistException("Резюме с таким именем уже есть");
        }
        resumeEntity.setStatus(StatusEnum.available);
        return resumeRepo.save(resumeEntity);
    }

    public ResumeEntity updateResume(ResumeEntity resume, Long id){
        ResumeEntity resume1 = resumeRepo.findById(id).get();
        if(resume1.equals(resume) && !(resume1.getStatus().equals(StatusEnum.deleted))){
            return resume;
        }
        resume1.setNameResume(resume.getNameResume());
        resume1.setEducation(resume.getEducation());
        resume1.setCertificates(resume.getCertificates());
        resume1.setExperience(resume.getExperience());
        resume1.setSkills(resume.getSkills());
        resume1.setLanguages(resume.getLanguages());
        resume1.setJob_expectation(resume.getJob_expectation());
        return resumeRepo.save(resume1);
    }


    public Long delete(Long id) throws UserNotFoundException {
        if(resumeRepo.findById(id)!=null) {
            ResumeEntity resume = resumeRepo.findById(id).get();
            resume.setStatus(StatusEnum.deleted);
            resumeRepo.save(resume);
            return id;
        }else throw new UserNotFoundException("Can not update laptop list. It doesn't exist");
    }
}
