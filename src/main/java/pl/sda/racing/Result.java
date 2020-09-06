package pl.sda.racing;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.datatype.Duration;
@Entity
@Data
public class Result {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Pigeon pigeon;
    @ManyToOne
    private Race race;
    private Duration time;
}
