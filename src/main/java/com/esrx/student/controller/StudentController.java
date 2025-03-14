package com.esrx.student.controller;

import com.esrx.student.ExceptionHandling.InValidIdException;
import com.esrx.student.annotations.CustomAnnotation;
import com.esrx.student.customResponseEntity.ServiceResponseEntity;
import com.esrx.student.dto.StudentRequest;
import com.esrx.student.dto.StudentResponse;
import com.esrx.student.entity.StudentEntity;
import com.esrx.student.service.StudentServiceClass;
import com.esrx.student.utils.StudentMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
//port: 9000
public class StudentController {
    @Autowired
    StudentServiceClass service;
    Logger log= LogManager.getLogger(StudentController.class);


    @PostMapping("/add")
    @CustomAnnotation
    public ServiceResponseEntity<StudentResponse> addData(@Valid @RequestBody  StudentRequest request){
       StudentResponse response= service.saveStudent(request);
        log.info("StudentController :: adding data Successfully added to the db {}",StudentMapper.JasonMapper(response));
        ServiceResponseEntity<StudentResponse> serviceResponseEntity = new ServiceResponseEntity<>();
        serviceResponseEntity.setStatus(HttpStatus.CREATED.toString());
        serviceResponseEntity.setResponse(response);
        return serviceResponseEntity;
    }

    @CustomAnnotation
    @GetMapping(path = "/get/{id}",produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "fetch the Student by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "student found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = StudentEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "invalid id")
    })
    public ResponseEntity<?> get(@PathVariable int id) throws InValidIdException {
        StudentResponse studentResponse=service.findStudentById(id);
        if(studentResponse!=null){
            return ResponseEntity.ok(studentResponse);
        }
       else{
           return new ResponseEntity<>("The entered id is invalid",HttpStatus.BAD_REQUEST);
        }
    }


    @CustomAnnotation
    @GetMapping(path ="/getStudentById",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentRequest(@RequestParam(required = false) Integer studentId){
        ServiceResponseEntity<StudentResponse> serviceResponseEntity = new ServiceResponseEntity<>();
        if(studentId!=null){
            serviceResponseEntity.setResponse(service.findStudentById(studentId));
            serviceResponseEntity.setStatus(HttpStatus.FOUND.toString());
            return ResponseEntity.status(HttpStatus.FOUND).body(serviceResponseEntity);
        }
        else{
            serviceResponseEntity.setStatus(HttpStatus.BAD_REQUEST.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serviceResponseEntity);

        }
    }


    @CustomAnnotation
    @GetMapping(value = "/getAll",produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<StudentResponse>> fetchAll(){
        List<StudentResponse> studentResponseList=service.studentList();
        return ResponseEntity.ok(studentResponseList);
    }


    @DeleteMapping("/delete/{id}")
    public ServiceResponseEntity<?> deleteStudentById(@PathVariable int id){
        ServiceResponseEntity<StudentResponse> serviceResponseEntity = new ServiceResponseEntity<>();
       service.deleteStudentById(id);
       log.debug("StudentController :: deleted the student record successfully by id {}",id);
        serviceResponseEntity.setStatus(HttpStatus.OK.toString());
        return serviceResponseEntity;
    }
}
