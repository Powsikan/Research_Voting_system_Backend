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
public class Candidate {

    @Id
    private String id;
    private String name;
    private String party;
    private String symbol;
    private Long no_of_votes_ele_vol;
    private Long no_of_votes_ele_dist;
    private Long total_votes;

}
