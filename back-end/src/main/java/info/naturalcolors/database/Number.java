package info.naturalcolors.database;

import javax.persistence.*;
import java.util.List;

@Entity
public class Number {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    @Column(nullable = false)
    private boolean artificial;

    @OneToMany(mappedBy = "number")
    private List<NumberTranslation> numberTranslations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isArtificial() {
        return artificial;
    }

    public void setArtificial(boolean artificial) {
        this.artificial = artificial;
    }

    public List<NumberTranslation> getNumberTranslations() {
        return numberTranslations;
    }

    public void setNumberTranslations(List<NumberTranslation> numberTranslations) {
        this.numberTranslations = numberTranslations;
    }
}
