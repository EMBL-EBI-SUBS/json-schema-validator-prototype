package uk.ac.ebi.subs.json_schema.org.everit;

import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.JsonSchemaValidator;

public class EmptySchemaValidatorTest {

    private JsonSchemaValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new JsonSchemaValidator(SchemaLoader.load(new JSONObject("{}")));
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
