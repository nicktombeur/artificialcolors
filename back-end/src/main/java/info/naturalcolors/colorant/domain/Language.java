package info.naturalcolors.colorant.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Language {

    ENGLISH("en-GB"),
    DUTCH("nl-BE");

    @Getter
    private final String iso;
}
