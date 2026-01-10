package in.ankitsaahariya.retailhub_pos.service;

import in.ankitsaahariya.retailhub_pos.io.CategoryRequest;
import in.ankitsaahariya.retailhub_pos.io.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse addCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> readCategories();


    void deleteCategory(String categoryId);
}
