package org.example.SpringBootPathfinderWorkshop.service.impl;

import org.example.SpringBootPathfinderWorkshop.model.entity.Category;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;
import org.example.SpringBootPathfinderWorkshop.repository.CategoryRepository;
import org.example.SpringBootPathfinderWorkshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category selectByName(CategoryNameEnum categoryNameEnum) {

         return this.categoryRepository.findByName(categoryNameEnum);

    }
}
