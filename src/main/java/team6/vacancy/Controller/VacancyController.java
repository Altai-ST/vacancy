package team6.vacancy.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team6.vacancy.Entity.VacancyEntity;
import team6.vacancy.Exception.UserNotFoundException;
import team6.vacancy.Service.VacancyService;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
    VacancyService service;

    @PostMapping("/create")
    public ResponseEntity createVacancy(@RequestBody VacancyEntity vacancy, @RequestParam Long id){
        try{
            service.createVacancy(vacancy, id);
            return ResponseEntity.ok("Сохранил");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @PutMapping("/update")
    public ResponseEntity updateVacancy(@RequestBody VacancyEntity vacancy, @RequestParam Long id){
        try{
            service.updateVacancy(vacancy, id);
            return ResponseEntity.ok("Изменил");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("П/9роизошла ошибка");
        }
    }

    @DeleteMapping("/deleteVacancy/{id}")
    public ResponseEntity deleteResume(@PathVariable Long id){
        try{
            return ResponseEntity.ok(service.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка 4");
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
