package io.klesogor.Lab03.Repositories;
import io.klesogor.Lab03.Entities.Category;
import io.klesogor.Lab03.Entities.Place;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
