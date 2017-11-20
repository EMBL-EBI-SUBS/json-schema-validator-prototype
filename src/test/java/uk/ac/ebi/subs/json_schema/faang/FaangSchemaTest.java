package uk.ac.ebi.subs.json_schema.faang;

import org.junit.Test;
import uk.ac.ebi.subs.json_schema.AbstractSchemaValidation;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.JsonSchemaValidator;

public class FaangSchemaTest extends AbstractSchemaValidation {

    private JsonSchemaValidator validator;

    @Test
    public void standardTest() {
        validator = new JsonSchemaValidator("/schemas/faang/standard-schema.json");
        super.validate(validator, "/objects/faang/animal.json");
    }
}
