package com.esrx.student.controller;


import com.esrx.student.service.StudentServiceClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentServiceClass studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


//    @Test
//    void getStudentById(){
//        int id = 1;
//        StudentResponse mockresponse = StudentResponse.builder()
//                .id(1).fee(200).email("sai@gmail.com")
//                .name("sai").phone("9889764312").course("ece")
//                .transactionId("23443443").build();
//        when(studentService.findStudentById(id)).thenReturn(mockresponse);
//        ResponseEntity<StudentResponse> response = studentController.get(id);
//
//        // Assert
//        assertNotNull(response);
//        assertEquals(200, response.getStatusCodeValue());
//        assertNotNull(response.getBody());
//        assertEquals(id, response.getBody().getId());
//        assertEquals("sai", response.getBody().getName());
//        verify(studentService, times(1)).findStudentById(id);
//
//    }
//
//    @Test
//    void getById_InvalidId_ShouldThrowIdInValidException() {
//        // Arrange
//        int invalidId = 99;
//        when(studentService.findStudentById(invalidId)).thenThrow(new IdInValidException("Id is invalid " + invalidId));
//        System.out.println(studentService.findStudentById(1));
//        // Act & Assert
//        IdInValidException exception = assertThrows(IdInValidException.class, () -> studentController.get(invalidId));
//        assertEquals("Id is invalid 99", exception.getMessage());
//        verify(studentService, times(1)).findStudentById(invalidId);
//    }

    @Test
    void addData() {
    }

    @Test
    void get() {
    }

    @Test
    void getStudentRequest() {
    }

    @Test
    void fetchAll() {
    }

    @Test
    void deleteStudentById() {
    }
}