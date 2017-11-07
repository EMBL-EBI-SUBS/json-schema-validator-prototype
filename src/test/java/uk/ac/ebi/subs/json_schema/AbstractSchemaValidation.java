package uk.ac.ebi.subs.json_schema;

import org.everit.json.schema.ValidationException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.JsonSchemaValidator;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractSchemaValidation {

    public void validate(JsonSchemaValidator validator, String objectPath) {
        try (InputStream inputStream = getClass().getResourceAsStream(objectPath)) {
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
