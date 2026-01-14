package in.ankitsaahariya.retailhub_pos.service.serviceImp;

import in.ankitsaahariya.retailhub_pos.entity.CategoryEntity;
import in.ankitsaahariya.retailhub_pos.entity.ItemEntity;
import in.ankitsaahariya.retailhub_pos.io.ItemRequest;
import in.ankitsaahariya.retailhub_pos.io.ItemResponse;
import in.ankitsaahariya.retailhub_pos.repository.CategoryRepository;
import in.ankitsaahariya.retailhub_pos.repository.ItemsRepository;
import in.ankitsaahariya.retailhub_pos.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService {

    private final CategoryRepository categoryRepository;
    private final ItemsRepository itemsRepository;



    @Override
    public ItemResponse add(ItemRequest request) {
        ItemEntity newItem = convertToEntity(request);
        CategoryEntity existingCategory = categoryRepository.findByCategoryId(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found : "+ request.getCategoryId()));
        newItem.setCategory(existingCategory);
        newItem = itemsRepository.save(newItem);
        return convertToResponse(newItem);
    }

    private ItemResponse convertToResponse(ItemEntity newItem) {
        return  ItemResponse.builder()
                .itemId(newItem.getItemId())
                .name(newItem.getName())
                .description(newItem.getDescription())
                .price(newItem.getPrice())
                .imgUrl(newItem.getImgUrl())
                .categoryName(newItem.getCategory().getName())
                .categoryId(newItem.getCategory().getCategoryId())
                .createdAt(newItem.getCreatedAt())
                .updatedAt(newItem.getUpdatedAt())
                .build();
    }

    private ItemEntity convertToEntity(ItemRequest request) {

        return  ItemEntity.builder()
                .itemId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }


    @Override
    public List<ItemResponse> fetchItems() {
        return  itemsRepository.findAll()
                .stream()
                .map(itemEntity -> convertToResponse(itemEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteItem(String itemId) {
        ItemEntity existItem = itemsRepository.findByItemId(itemId)
                .orElseThrow(()-> new RuntimeException("Item not found:"+ itemId));
        itemsRepository.delete(existItem);
    }
}
