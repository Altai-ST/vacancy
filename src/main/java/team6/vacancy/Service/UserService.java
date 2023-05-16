package team6.vacancy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team6.vacancy.Entity.UserEntity;
import team6.vacancy.Enum.StatusEnum;
import team6.vacancy.Exception.UserAlreadyExistException;
import team6.vacancy.Exception.UserNotFoundException;
import team6.vacancy.Model.UserModel;
import team6.vacancy.Repository.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public UserModel getOne(Long id) throws UserNotFoundException{
        UserEntity user = userRepo.findById(id).get();
        if(user == null && user.getStatus().equals(StatusEnum.deleted)) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserModel.toModel(user);
    }

    public UserEntity createUser(UserEntity user) throws UserAlreadyExistException {

        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Такой пользователь уже есть");
        }

        else if(userRepo.findByEmail(user.getEmail())!=null){
            throw new UserAlreadyExistException("Такой email уже занят");
        }

        else if(userRepo.findByNumberphone(user.getNumberPhone())!=null){
            throw new UserAlreadyExistException("Такой номер уже занят");
        }
        user.setStatus(StatusEnum.available);
        return userRepo.save(user);
    }

    public Long delete(Long id) throws UserNotFoundException {
        if(userRepo.findById(id)!=null) {
            UserEntity user = userRepo.findById(id).get();
            user.setStatus(StatusEnum.deleted);
            userRepo.save(user);
            return id;
        }else throw new UserNotFoundException("Can not update laptop list. It doesn't exist");
    }
}
