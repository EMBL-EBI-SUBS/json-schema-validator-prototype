package uk.ac.ebi.subs.json_schema.json.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.subs.json_schema.prototype.json.tools.JsonSchemaValidator;

import java.io.IOException;

public class EmptySchemaValidatorTest {

    private JsonSchemaValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new JsonSchemaValidator("/schemas/empty-schema.json");
    }

    @Test
    public void test() throws IOException, ProcessingException {
        JsonNode jsonNode = JsonLoader.fromString("{\"hello\" : \"world\"}");
        ProcessingReport report = validator.validate(jsonNode);

        Assert.assertTrue(report.isSuccess());
    }
}
