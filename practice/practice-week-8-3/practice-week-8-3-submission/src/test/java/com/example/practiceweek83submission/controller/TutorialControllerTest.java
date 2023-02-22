package com.example.practiceweek83submission.controller;

import com.example.practiceweek83submission.entity.Tutorial;
import com.example.practiceweek83submission.service.TutorialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TutorialController.class)
class TutorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TutorialService tutorialService;

    @Test
    void getAllTutorials() throws Exception {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1L, "Title 1", "Description 1", true));
        tutorials.add(new Tutorial(2L, "Title 2", "Description 2", false));

        when(tutorialService.findAll()).thenReturn(tutorials);

        mockMvc.perform(get("/api/tutorials"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,title:\"Title 1\",description:\"Description 1\",published:true},"
                        + "{id:2,title:\"Title 2\",description:\"Description 2\",published:false}]"));
    }

    @Test
    void getTutorialsById() throws Exception {
        Tutorial tutorial = new Tutorial(1L, "Title 1", "Description 1", true);
        when(tutorialService.findById(1L)).thenReturn(tutorial);

        mockMvc.perform(get("/api/tutorials/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,title:\"Title 1\",description:\"Description 1\",published:true}"));
    }

    @Test
    void createTutorial() throws Exception {
    }

    @Test
    void updateTutorial() throws Exception {
    }

    @Test
    void deleteTutorial() throws Exception {
    }

    @Test
    void deleteAllTutorials() throws Exception {
    }

    @Test
    void findByPublished() throws Exception {
    }
}