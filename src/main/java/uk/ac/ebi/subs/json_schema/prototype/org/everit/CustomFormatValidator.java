package uk.ac.ebi.subs.json_schema.prototype.org.everit;

import org.everit.json.schema.FormatValidator;

import java.util.Optional;

public class CustomFormatValidator implements FormatValidator {

    @Override
    public Optional<String> validate(String value) {
        if (value.length() % 2 == 0) {
            return Optional.empty();
        }
        return Optional.of(String.format("the length of string [%s] is odd", value));
    }

    @Override
    public String formatName() {
        return "custom-format";
    }
}
