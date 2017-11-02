package uk.ac.ebi.subs.json_schema.org.everit;

import org.everit.json.schema.ValidationException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.JsonSchemaValidator;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.CustomFormatValidator;

import java.io.IOException;
import java.io.InputStream;

public class CustomFormatValidatorTest {

    private JsonSchemaValidator validator;

    private final String SAMPLE_PATH = "/objects/sample.json";

    @Before
    public void setUp() throws Exception {
        validator = new JsonSchemaValidator("/schemas/sample-schema.json", new CustomFormatValidator());
    }

    @Test
    public void test() {
        try (InputStream inputStream = getClass().getResourceAsStream(SAMPLE_PATH)) {
            JSONObject sample = new JSONObject(new JSONTokener(inputStream));

            try {
                validator.validate(sample);
            } catch (ValidationException exception) {
                Assert.assertFalse(exception.getAllMessages().isEmpty());
                Assert.assertTrue(exception.getAllMessages().size() == 1);
            }
        } catch (IOException e) {
            Assert.fail();
        }
    }
}
