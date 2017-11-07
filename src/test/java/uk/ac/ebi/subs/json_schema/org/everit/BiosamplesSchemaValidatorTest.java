package uk.ac.ebi.subs.json_schema.org.everit;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.subs.json_schema.AbstractSchemaValidation;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.JsonSchemaValidator;

public class BiosamplesSchemaValidatorTest extends AbstractSchemaValidation {

    private JsonSchemaValidator validator;

    private final String SAMPLE_PATH = "/objects/sample.json";

    @Before
    public void setUp() throws Exception {
        validator = new JsonSchemaValidator("/schemas/biosamples-schema.json");
    }

    @Test
    public void test() {
        super.validate(validator, SAMPLE_PATH);
    }
}
