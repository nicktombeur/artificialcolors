package info.artificialcolors.features.number;

public class Number {

    private final String code;
    private final boolean artificial;
    private final String name;

    public Number(String code, boolean artificial, String name) {
        this.code = code;
        this.artificial = artificial;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public boolean isArtificial() {
        return artificial;
    }

    public String getName() {
        return name;
    }
}
