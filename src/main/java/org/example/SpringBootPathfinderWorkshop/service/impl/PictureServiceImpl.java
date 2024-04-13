package org.example.SpringBootPathfinderWorkshop.service.impl;

import org.example.SpringBootPathfinderWorkshop.repository.PictureRepository;
import org.example.SpringBootPathfinderWorkshop.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> selectAllUrls() {
        return this.pictureRepository.findAllUrls();
    }
}
