package in.ankitsaahariya.retailhub_pos.service.serviceImp;

import in.ankitsaahariya.retailhub_pos.entity.CategoryEntity;
import in.ankitsaahariya.retailhub_pos.io.CategoryRequest;
import in.ankitsaahariya.retailhub_pos.io.CategoryResponse;
import in.ankitsaahariya.retailhub_pos.repository.CategoryRepository;
import in.ankitsaahariya.retailhub_pos.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        CategoryEntity newCategory = convertToEntity(categoryRequest);
        newCategory = categoryRepository.save(newCategory);
        return  convertToResponse(newCategory);
    }

    @Override
    public List<CategoryResponse> readCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> convertToResponse(categoryEntity))
                .collect(Collectors.toList());
    }

    //    helper Methods
    private CategoryEntity convertToEntity(CategoryRequest categoryRequest){
        return  CategoryEntity.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .bgColor(categoryRequest.getBgColor())
                .categoryId(UUID.randomUUID().toString())
                .build();
    }


    private CategoryResponse convertToResponse(CategoryEntity categoryEntity){
        return  CategoryResponse.builder()
                .categoryId(categoryEntity.getCategoryId())
                .name(categoryEntity.getName())
                .description(categoryEntity.getDescription())
                .bgColor(categoryEntity.getBgColor())
                .imgUrl(categoryEntity.getImgUrl())
                .createdAt(categoryEntity.getCreatedAt())
                .updatedAt(categoryEntity.getUpdatedAt())
                .build();
    }
}
