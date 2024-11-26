package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.CategoryChoice;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryChoiceConverter {

    public static List<CategoryChoice> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        CategoryChoice.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}