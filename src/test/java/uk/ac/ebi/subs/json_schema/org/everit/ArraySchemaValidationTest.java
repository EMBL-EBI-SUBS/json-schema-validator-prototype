package uk.ac.ebi.subs.json_schema.org.everit;

import org.everit.json.schema.ValidationException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.JsonSchemaValidator;

import java.io.IOException;
import java.io.InputStream;

public class ArraySchemaValidationTest {

    private JsonSchemaValidator validator;

    private final String ARRAY_PATH = "/objects/array.json";

    @Before
    public void setUp() throws Exception {
        validator = new JsonSchemaValidator("/schemas/array-schema.json");
    }

    @Test
    public void test() {
        try (InputStream inputStream = getClass().getResourceAsStream(ARRAY_PATH)) {
            JSONObject sample = new JSONObject(new JSONTokener(inputStream));

            try {
                validator.validate(sample);
            } catch (ValidationException exception) {
                exception.getAllMessages().forEach(System.out::println);
                Assert.fail();
            }

        } catch (IOException e) {
            Assert.fail();
        }
    }

}
