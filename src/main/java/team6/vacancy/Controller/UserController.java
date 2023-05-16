package team6.vacancy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team6.vacancy.Entity.UserEntity;
import team6.vacancy.Exception.UserAlreadyExistException;
import team6.vacancy.Exception.UserNotFoundException;
import team6.vacancy.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getOneClient(@RequestParam Long id){
        try{
            return ResponseEntity.ok(userService.getOne(id));
        }catch (Exception | UserNotFoundException e){
            return ResponseEntity.badRequest().body("Произошла ошибка 2");
        }
    }

    @PostMapping("/registration")
    public ResponseEntity createUser(@RequestBody UserEntity userEntity){
        try {
            userService.createUser(userEntity);
            return ResponseEntity.ok("Сохранил");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка3");
        }
    }

    @DeleteMapping("/deleteVacancy/{id}")
    public ResponseEntity deleteResume(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка 4");
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
