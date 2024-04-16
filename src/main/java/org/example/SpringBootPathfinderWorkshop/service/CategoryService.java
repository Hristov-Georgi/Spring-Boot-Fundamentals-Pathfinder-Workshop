package org.example.SpringBootPathfinderWorkshop.service;

import org.example.SpringBootPathfinderWorkshop.model.entity.Category;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;



public interface CategoryService {

    Category selectByName(CategoryNameEnum categoryNameEnum);
}
