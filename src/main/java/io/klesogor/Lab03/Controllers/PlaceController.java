package io.klesogor.Lab03.Controllers;

import io.klesogor.Lab03.DTOs.PlaceDTO;
import io.klesogor.Lab03.Entities.Place;
import io.klesogor.Lab03.Repositories.CategoryRepository;
import io.klesogor.Lab03.Repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.SAAJResult;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class PlaceController
{
    @Autowired
    private PlaceRepository _repository;

    @Autowired
    private CategoryRepository _categoryRepo;

    @RequestMapping(method = GET, value = "/api/place")
    public Iterable<Place> getAll() {
        return _repository.findAll();
    }

    @RequestMapping(method = GET, value = "/api/place/{id}")
    public Place get(@PathVariable("id") Integer id) {
        return _repository.findById(id).get();
    }

    @RequestMapping(method = POST, value = "/api/place")
    public void create(
            @RequestBody PlaceDTO placeDTO
    )
    {
        Place place = new Place(
                placeDTO.getName(),
                placeDTO.getAddress(),
                _categoryRepo.findById(placeDTO.getCategory_id()).get(),
                placeDTO.getRating());
        _repository.save(place);
    }

    @RequestMapping(method = PUT, value = "/api/place/{id}")
    public void update(
            @PathVariable("id") Integer id,
            @RequestBody PlaceDTO placeDTO
    )
    {
        Place place = new Place(
                placeDTO.getName(),
                placeDTO.getAddress(),
                _categoryRepo.findById(placeDTO.getCategory_id()).get(),
                placeDTO.getRating());
        place.setId(id);
        _repository.save(place);
    }

    @RequestMapping(method = DELETE, value = "/api/place/{id}")
    public void delete(@PathVariable("id") Integer id) {
        _repository.deleteById(id);
    }
}
