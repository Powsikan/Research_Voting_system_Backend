package com.research.voting_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String fullName;
    private String address;
    private String nicNumber;
    private String ele_vol;
    private String ele_district;
    private String fingerPrint;
    private boolean hasVoted;

}
