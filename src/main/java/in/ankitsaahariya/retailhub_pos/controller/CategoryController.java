package in.ankitsaahariya.retailhub_pos.controller;

import in.ankitsaahariya.retailhub_pos.io.CategoryRequest;
import in.ankitsaahariya.retailhub_pos.io.CategoryResponse;
import in.ankitsaahariya.retailhub_pos.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest){
        return  categoryService.addCategory(categoryRequest);
    }

    @GetMapping
    public List<CategoryResponse> readCategories(){
        return categoryService.readCategories();
    }
}
