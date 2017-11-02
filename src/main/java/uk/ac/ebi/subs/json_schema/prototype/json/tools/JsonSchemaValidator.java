package uk.ac.ebi.subs.json_schema.prototype.json.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.util.Optional;

public class JsonSchemaValidator {

    private JsonSchema schema;

    private Utils utils = new Utils();

    public JsonSchemaValidator(JsonSchema schema) {
        this.schema = schema;
    }

    public JsonSchemaValidator(String schema_path) {
        try {
            Optional<JsonNode> optional = utils.loadResource(schema_path);
            if (optional.isPresent()) {
                JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
                this.schema = factory.getJsonSchema(optional.get());
            }
        } catch (ProcessingException e) {
            e.printStackTrace();
        }
    }

    public ProcessingReport validate(JsonNode jsonNode) throws ProcessingException {
        return this.schema.validate(jsonNode);
    }

}
