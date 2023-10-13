package com.fricle.joblisting.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "JobPost")//to make sure model map to collection JobPost in db
public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String [] techs;
}
