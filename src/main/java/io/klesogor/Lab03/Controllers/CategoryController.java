package io.klesogor.Lab03.Controllers;

import io.klesogor.Lab03.DTOs.CategoryDTO;
import io.klesogor.Lab03.Entities.Category;
import io.klesogor.Lab03.Entities.Place;
import io.klesogor.Lab03.Repositories.CategoryRepository;
import io.klesogor.Lab03.Repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository _repository;

    @RequestMapping(method = GET, value = "/api/category")
    public Iterable<Category> getAll() {
        return _repository.findAll();
    }

    @RequestMapping(method = GET, value = "/api/category/{id}")
    public Category get(@PathVariable("id") Integer id) {
        return _repository.findById(id).get();
    }

    @RequestMapping(method = POST, value = "/api/category")
    public void create(
            @RequestBody CategoryDTO category
    ) {
        _repository.save(new Category(category.getName()));
    }

    @RequestMapping(method = PUT, value = "/api/category/{id}")
    public void update(
            @PathVariable("id") Integer id,
            @RequestBody CategoryDTO categoryDTO

    ) {
        Category category = new Category(categoryDTO.getName());
        category.setId(id);
        _repository.save(category);
    }

    @RequestMapping(method = DELETE, value = "/api/category/{id}")
    public void delete(@PathVariable("id") Integer id) {
        _repository.deleteById(id);
    }
}
