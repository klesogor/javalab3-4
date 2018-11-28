package io.klesogor.Lab03.Repositories;
import io.klesogor.Lab03.Entities.Place;
import io.klesogor.Lab03.Entities.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
