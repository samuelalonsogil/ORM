package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Futbolistas")
public class Futbolista {
    @Id
    @Column(name = "fu")
}
