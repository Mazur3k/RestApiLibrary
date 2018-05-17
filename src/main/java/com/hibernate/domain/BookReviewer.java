package com.hibernate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookReviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Reviewer reviewer;
}
