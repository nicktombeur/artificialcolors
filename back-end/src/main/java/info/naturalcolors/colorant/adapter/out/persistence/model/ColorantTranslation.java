package info.naturalcolors.colorant.adapter.out.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ColorantTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String language;

    private String name;

    @ManyToOne
    @JoinColumn(name = "colorant_id")
    private Colorant colorant;

}
