package uk.ac.ebi.subs.json_schema.org.everit;

import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.subs.json_schema.AbstractSchemaValidation;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.JsonSchemaValidator;

public class ArraySchemaValidationTest extends AbstractSchemaValidation {

    private JsonSchemaValidator validator;

    private final String ARRAY_PATH = "/objects/array.json";

    @Before
    public void setUp() throws Exception {
        validator = new JsonSchemaValidator("/schemas/array-schema.json");
    }

    @Test
    public void testAtLeastOneElementWithNickName() {
        super.validate(validator, ARRAY_PATH);
    }

}
