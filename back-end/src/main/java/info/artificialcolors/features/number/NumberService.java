package info.artificialcolors.features.number;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberService {

    private final NumberRepository numberRepository;

    @Autowired
    public NumberService(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    public List<Number> getAll(String language) {
        return numberRepository.getAllTranslated(language);
    }

}
