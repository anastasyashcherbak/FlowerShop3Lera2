package com.lera.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
@Entity
@Table(name = "holidays")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;
    private String description;

    @ElementCollection(fetch=FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "holiday")
    private List<Bouquet> bouquets;

    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "usercalendar_id", referencedColumnName = "id")
    private UserCalendar userCalendar;

}
