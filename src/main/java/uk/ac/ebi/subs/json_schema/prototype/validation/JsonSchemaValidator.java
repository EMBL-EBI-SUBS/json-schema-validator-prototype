package uk.ac.ebi.subs.json_schema.prototype.validation;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    public List<ValidationException> validate(String jsonObject) {
        try {
            this.schema.validate(new JSONObject(jsonObject));
        } catch (ValidationException e) {
            return e.getCausingExceptions();
        }
        return new ArrayList<>();
    }
}
