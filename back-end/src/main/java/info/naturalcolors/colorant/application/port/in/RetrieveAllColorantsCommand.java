package info.naturalcolors.colorant.application.port.in;

import info.naturalcolors.colorant.domain.Language;

import java.util.Objects;

public record RetrieveAllColorantsCommand(Language language) {

    @Override
    public Language language() {
        return Objects.requireNonNullElse(language, Language.ENGLISH);
    }

    public String languageAsIso() {
        return Objects.requireNonNullElse(language, Language.ENGLISH).getIso();
    }
}
