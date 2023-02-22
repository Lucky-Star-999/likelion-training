package com.example.practiceweek83submission.repository;

import com.example.practiceweek83submission.entity.Tutorial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DataJpaTest
class TutorialRepositoryTest {

    @Autowired
    private TutorialRepository tutorialRepository;

    @BeforeEach
    void setUp() {
        tutorialRepository.save(new Tutorial(null, "Title 1", "First Tutorial", true));
        tutorialRepository.save(new Tutorial(null, "Title 2", "Description 2", true));
        tutorialRepository.save(new Tutorial(null, "Title 3", "Secret", false));
        tutorialRepository.save(new Tutorial(null, "Title 4", "No published", false));
    }

    @AfterEach
    void tearDown() {
        tutorialRepository.deleteAll();
    }

    @Test
    void findAll() {
        assertThat(tutorialRepository.findAll()).isNotNull();
    }


    @Test
    void findById() {
        assertThat(tutorialRepository.findById(1l)).isNotNull();
    }


    @Test
    void deleteById() {
        tutorialRepository.deleteById(4l);
        assertFalse(tutorialRepository.existsById(4l));
    }

    @Test
    void deleteAll() {
        tutorialRepository.deleteAll();
        assertFalse(tutorialRepository.existsById(1l));
        assertFalse(tutorialRepository.existsById(2l));
        assertFalse(tutorialRepository.existsById(3l));
        assertFalse(tutorialRepository.existsById(4l));
    }


    @Test
    void save() {
        assertThat(tutorialRepository.save(new Tutorial(null, "Title 5", "Description 5", true))).isNotNull();
    }

    @Test
    void findByPublished() {
        List<Tutorial> tutorialList = new ArrayList<>();
        tutorialList.add(new Tutorial(1l, "Title 1", "First Tutorial", true));
        tutorialList.add(new Tutorial(2l, "Title 2", "Description 2", true));
        assertThat(tutorialRepository.findByPublished(true).get(0).toString())
                .isEqualTo(tutorialList.get(0).toString());
        assertThat(tutorialRepository.findByPublished(true).get(1).toString())
                .isEqualTo(tutorialList.get(1).toString());
    }

    @Test
    void findByTitleContainingIgnoreCase() {
        Tutorial tutorial = new Tutorial(1l, "Title 1", "First Tutorial", true);
        assertThat(tutorialRepository.findByTitleContainingIgnoreCase("title").get(0).toString())
                .isEqualTo(tutorial.toString());
    }
}