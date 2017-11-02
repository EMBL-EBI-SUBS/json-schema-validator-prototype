package uk.ac.ebi.subs.json_schema.json.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.ac.ebi.subs.json_schema.prototype.json.tools.JsonSchemaValidator;
import uk.ac.ebi.subs.json_schema.prototype.json.tools.Utils;

import java.util.Optional;

public class SampleSchemaValidatorTest {

    private JsonSchemaValidator validator;

    private Utils utils;

    private final String SAMPLE_PATH = "/objects/sample.json";

    @Before
    public void setUp() throws Exception {
        utils = new Utils();
        validator = new JsonSchemaValidator("/schemas/sample-schema.json");
    }

    @Test
    public void test() throws ProcessingException {
        Optional<JsonNode> optional = utils.loadResource(SAMPLE_PATH);
        Assert.assertTrue(optional.isPresent());

        ProcessingReport report = validator.validate(optional.get());
        Assert.assertTrue(report.isSuccess());
    }
}
