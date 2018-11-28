package io.klesogor.Lab03.Controllers;

import io.klesogor.Lab03.DTOs.ReviewDTO;
import io.klesogor.Lab03.Entities.Place;
import io.klesogor.Lab03.Entities.Review;
import io.klesogor.Lab03.Repositories.PlaceRepository;
import io.klesogor.Lab03.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ReviewController
{
    @Autowired
    private ReviewRepository _repository;

    @Autowired
    private PlaceRepository _placeRepo;

    @RequestMapping(method = GET, value = "/api/review")
    public Iterable<Review> getAll() {
        return _repository.findAll();
    }

    @RequestMapping(method = GET, value = "/api/review/{id}")
    public Review get(@PathVariable("id") Integer id)
    {
        return _repository.findById(id).get();
    }

    @RequestMapping(method = POST, value = "/api/review")
    public void create(
           @RequestBody ReviewDTO reviewDTO
    )
    {
        Review review = new Review(
                reviewDTO.getUser_name(),
                reviewDTO.getText(),
                _placeRepo.findById(reviewDTO.getPlace_id()).get()
        );
        _repository.save(review);
    }

    @RequestMapping(method = PUT, value = "/api/review/{id}")
    public void update(
            @PathVariable("id") Integer id,
            @RequestBody ReviewDTO reviewDTO
    )
    {
        Review review = new Review(
                reviewDTO.getUser_name(),
                reviewDTO.getText(),
                _placeRepo.findById(reviewDTO.getPlace_id()).get()
        );
        review.setId(id);
        _repository.save(review);
    }

    @RequestMapping(method = DELETE, value = "/api/review/{id}")
    public void delete(@PathVariable("id") Integer id)
    {
        _repository.deleteById(id);
    }
}
