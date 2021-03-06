package com.hibernate.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Author author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Set<BookReviewer> bookReviewerSet;


}
