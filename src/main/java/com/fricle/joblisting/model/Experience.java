package com.fricle.joblisting.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Experience {
    //no @Document annotation on sub-document
    // above annotation is used only over class that represent a collection
    private String account;
    private String role;
}
