package com.example.practiceweek83submission.service.impl;

import com.example.practiceweek83submission.entity.Tutorial;
import com.example.practiceweek83submission.repository.TutorialRepository;
import com.example.practiceweek83submission.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Override
    public List<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return tutorialRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public Tutorial findById(long id) {
        return tutorialRepository.findById(id).orElse(null);
    }

    @Override
    public int deleteById(long id) {
        try {
            tutorialRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int deleteAll() {
        try {
            tutorialRepository.deleteAll();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Tutorial> findByPublished(boolean b) {
        return tutorialRepository.findByPublished(b);
    }

    @Override
    public Tutorial saveTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }
}
