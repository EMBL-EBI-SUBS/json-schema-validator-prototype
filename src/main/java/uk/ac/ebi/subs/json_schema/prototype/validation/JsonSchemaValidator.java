package uk.ac.ebi.subs.json_schema.prototype.validation;

import org.everit.json.schema.FormatValidator;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

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

    public JsonSchemaValidator(String schema_path, FormatValidator customFormatValidator) {
        try (InputStream inputStream = getClass().getResourceAsStream(schema_path)) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));

            SchemaLoader schemaLoader = SchemaLoader.builder()
                    .schemaJson(rawSchema)
                    .addFormatValidator(customFormatValidator)
                    .build();

            this.schema = schemaLoader.load().build();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validate(String jsonObjectString) {
        this.schema.validate(new JSONObject(jsonObjectString));
    }

    public void validate(JSONObject jsonObject) {
        this.schema.validate(jsonObject);
    }
}
