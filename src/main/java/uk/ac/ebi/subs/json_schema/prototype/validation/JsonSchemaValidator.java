package uk.ac.ebi.subs.json_schema.prototype.validation;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class JsonSchemaValidator {

    private Schema schema;

    public JsonSchemaValidator(Schema schema) {
        this.schema = schema;
    }

    public JsonSchemaValidator(String schema_path) {
        try (InputStream inputStream = getClass().getResourceAsStream(schema_path)) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            this.schema = SchemaLoader.load(rawSchema);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<ValidationException> validate(String jsonObjectString) {
        ValidationException exception = null;
        try {
            this.schema.validate(new JSONObject(jsonObjectString));
        } catch (ValidationException e) {
            exception = e;
            return Optional.of(exception);
        }
        return Optional.ofNullable(exception);
    }

    public Optional<ValidationException> validate(JSONObject jsonObject) {
        try {
            this.schema.validate(jsonObject);
        } catch (ValidationException e) {
            return Optional.of(e);
        }
        return Optional.ofNullable(null);
    }
}
