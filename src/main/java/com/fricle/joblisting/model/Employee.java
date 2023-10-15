package com.fricle.joblisting.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "Employee")
public class Employee {
    //field annotation specify field name in db
    //_id field map with field marked with @Id annotation

    @Id
    @Field(name = "employeeId")
    public  String id;

    @Field(name = "employeeName")
    public String name;

    @Field(name = "mail")
    public  String email;
    public String designation;

    @Field(name = "pastExperiences")
    public  List<Experience> experiences;

}
