package com.esrx.student.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@XmlRootElement(name = "StudentResponse")
//@XmlAccessorType(XmlAccessType.FIELD)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class StudentResponse {
    //@XmlElement
    private int id;
    private String name;
    private String phone;
    private String email;
    private double fee;
    private String course;
    private String transactionId;
}