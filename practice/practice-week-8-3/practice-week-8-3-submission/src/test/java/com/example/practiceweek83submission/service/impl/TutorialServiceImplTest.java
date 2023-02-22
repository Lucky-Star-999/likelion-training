package com.example.practiceweek83submission.service.impl;

import com.example.practiceweek83submission.entity.Tutorial;
import com.example.practiceweek83submission.repository.TutorialRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        when(tutorialRepository.findById(1l))
                .thenReturn(Optional.of(new Tutorial(1l, "Title 1", "Description 1", true)));
        assertThat(tutorialService.findById(1l).getId()).isEqualTo(1l);
    }

    @Test
    void deleteById() {
        tutorialService.deleteById(1l);
        verify(tutorialRepository).deleteById(1l);
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