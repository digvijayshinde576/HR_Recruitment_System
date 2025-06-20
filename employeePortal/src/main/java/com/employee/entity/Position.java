package com.employee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "position_seq")
    @SequenceGenerator(name = "position_seq",sequenceName = "position_seq",allocationSize = 1)
    private Long id;

    @Column(name = "positionName", length = 50, unique = true, nullable = false)
    private String positionName;

//    @ManyToMany(mappedBy = "positions")
//    List<Candidate> candidates;

//    @ManyToOne
//    @JoinColumn(name = "candidate_id")
//    private Candidate candidate;
}
