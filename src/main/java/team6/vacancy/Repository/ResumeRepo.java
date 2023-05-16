package team6.vacancy.Repository;

import org.springframework.data.repository.CrudRepository;
import team6.vacancy.Entity.ResumeEntity;

public interface ResumeRepo extends CrudRepository<ResumeEntity, Long> {
    public ResumeEntity findByNameResume(String nameResume);
}
