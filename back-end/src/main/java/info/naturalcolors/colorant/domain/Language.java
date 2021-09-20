package info.naturalcolors.colorant.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Language {

    ENGLISH("en-GB"),
    DUTCH("nl-BE");

    @Getter
    private final String iso;

    public static String toIso(final Language language) {
        return Objects.requireNonNullElse(language, Language.ENGLISH).getIso();
    }
}
