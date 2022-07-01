package com.research.voting_system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Candidate {

    @Id
    private String id;
    private String name;
    private String party;
    private String symbol;
    private Long no_of_votes_ele_vol;
    private Long no_of_votes_ele_dist;
    private Long total_votes;

    public Candidate() {
    }
}
