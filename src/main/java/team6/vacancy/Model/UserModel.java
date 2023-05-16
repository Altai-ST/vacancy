package team6.vacancy.Model;

import lombok.Data;
import team6.vacancy.Entity.ResumeEntity;
import team6.vacancy.Entity.UserEntity;
import team6.vacancy.Entity.VacancyEntity;
import team6.vacancy.Enum.RoleEnum;

import java.util.List;

@Data
public class UserModel {
    private Long id;
    private String username;
    private String email;
    private String numberphone;
    private RoleEnum role;
    private List<VacancyEntity> vacancyEntities;
    private List<ResumeEntity> resumeEntities;

    public static UserModel toModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setEmail(entity.getEmail());
        model.setNumberphone(entity.getNumberPhone());
        model.setRole(entity.getRole());
        if(entity.getRole().equals("employer")){
            model.setVacancyEntities(entity.getVacancyEntities());
        }else{
            model.setResumeEntities(entity.getResumeEntities());
        }
        return model;
    }
}
