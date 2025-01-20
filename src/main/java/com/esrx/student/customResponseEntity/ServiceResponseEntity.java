package com.esrx.student.customResponseEntity;

import com.esrx.student.dto.ErrorDTo;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "ServiceResponseEntity")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null fields from JSON response
public class ServiceResponseEntity<T> {

    @XmlElement(name = "status")
    private String status; // Changed to String for XML compatibility

    @XmlElement(name = "response")
    private T response;

    @XmlElement(name = "errorList")
    private List<ErrorDTo> errorList;

}

