package info.naturalcolors.colorant.adapter.out.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Colorant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    @Column(nullable = false)
    private boolean artificial;

    @OneToMany(mappedBy = "colorant")
    private List<ColorantTranslation> colorantTranslations;

}
