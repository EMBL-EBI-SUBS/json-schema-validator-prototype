package uk.ac.ebi.subs.json_schema.prototype.validation;

import org.everit.json.schema.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JsonSchemaValidatorTest {

    private JsonSchemaValidator validator;

    @Before
    public void setUp() throws Exception {
        this.validator = new JsonSchemaValidator("/schemas/person-schema.json");
    }

    @Test
    public void test() {
        try {
            validator.validate("{\"hello\" : \"world\"}");
        } catch (ValidationException exception) {
            Assert.assertFalse(exception.getCausingExceptions().isEmpty());
            Assert.assertTrue(exception.getCausingExceptions().size() == 2);
        }
    }
}
