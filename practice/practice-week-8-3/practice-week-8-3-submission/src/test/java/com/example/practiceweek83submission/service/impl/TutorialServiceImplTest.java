package com.example.practiceweek83submission.service.impl;

import com.example.practiceweek83submission.repository.TutorialRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TutorialServiceImplTest {

    @Mock
    private TutorialRepository tutorialRepository;

    @InjectMocks
    private TutorialServiceImpl tutorialService;

    @BeforeEach
    void setUp() {    }

    @AfterEach
    void tearDown() {   }

    @Test
    void findAll() {

    }

    @Test
    void findByTitleContaining() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void findByPublished() {
    }

    @Test
    void saveTutorial() {
    }
}