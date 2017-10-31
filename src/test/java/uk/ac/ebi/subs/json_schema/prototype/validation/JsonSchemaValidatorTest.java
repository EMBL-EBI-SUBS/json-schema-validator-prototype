package uk.ac.ebi.subs.json_schema.prototype.validation;

import org.everit.json.schema.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class JsonSchemaValidatorTest {

    private JsonSchemaValidator validator;

    @Before
    public void setUp() throws Exception {
        this.validator = new JsonSchemaValidator("/schemas/person-schema.json");
    }

    @Test
    public void test() {
        Optional<ValidationException> exception = validator.validate("{\"hello\" : \"world\"}");

        if (exception.isPresent()) {
            Assert.assertFalse(exception.get().getCausingExceptions().isEmpty());
            Assert.assertTrue(exception.get().getCausingExceptions().size() == 2);
        } else {
            Assert.fail();
        }

    }
}
