package in.ankitsaahariya.retailhub_pos.controller;

import in.ankitsaahariya.retailhub_pos.io.CategoryRequest;
import in.ankitsaahariya.retailhub_pos.io.CategoryResponse;
import in.ankitsaahariya.retailhub_pos.repository.CategoryRepository;
import in.ankitsaahariya.retailhub_pos.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/admin/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest){
        return  categoryService.addCategory(categoryRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categories/get")
    public List<CategoryResponse> readCategories(){
        return categoryService.readCategories();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/admin/categories/{categoryId}")
    public void deleteExistingCategory(@PathVariable String categoryId){
        try{
            categoryService.deleteCategory(categoryId);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
}
