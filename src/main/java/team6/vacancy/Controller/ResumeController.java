package team6.vacancy.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team6.vacancy.Entity.ResumeEntity;
import team6.vacancy.Exception.UserNotFoundException;
import team6.vacancy.Service.ResumeService;

@RestController
@RequestMapping("/resume")
@Slf4j
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("")
    public ResponseEntity createResume(@RequestBody ResumeEntity resumeEntity){
        try {
            log.info("HEEEREERETYDFFGH-------------------");
            resumeService.createResume(resumeEntity);
            return ResponseEntity.ok("Сохранил");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateVacancy(@RequestBody ResumeEntity resume, @RequestParam Long id){
        try{
            resumeService.updateResume(resume, id);
            return ResponseEntity.ok("Изменил");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/deleteResume/{id}")
    public ResponseEntity deleteResume(@PathVariable Long id){
        try{
            return ResponseEntity.ok(resumeService.delete(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка 4");
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
