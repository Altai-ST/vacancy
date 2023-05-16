package team6.vacancy.Repository;

import org.springframework.data.repository.CrudRepository;
import team6.vacancy.Entity.VacancyEntity;

public interface VacancyRepo extends CrudRepository<VacancyEntity, Long> {

}
