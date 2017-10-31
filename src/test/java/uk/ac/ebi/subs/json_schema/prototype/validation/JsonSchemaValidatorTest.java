package uk.ac.ebi.subs.json_schema.prototype.validation;

import org.everit.json.schema.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JsonSchemaValidatorTest {

    private JsonSchemaValidator validator;

    @Before
    public void setUp() throws Exception {
        this.validator = new JsonSchemaValidator("/person-schema.json");
    }

    @Test
    public void test() {
        List<ValidationException> validationExceptions = validator.validate("{\"hello\" : \"world\"}");

        Assert.assertFalse(validationExceptions.isEmpty());
        Assert.assertTrue(validationExceptions.size() == 2);
    }
}
