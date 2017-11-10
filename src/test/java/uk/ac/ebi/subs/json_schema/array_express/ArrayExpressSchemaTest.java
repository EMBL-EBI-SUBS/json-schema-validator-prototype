package uk.ac.ebi.subs.json_schema.array_express;

import org.junit.Test;
import uk.ac.ebi.subs.json_schema.AbstractSchemaValidation;
import uk.ac.ebi.subs.json_schema.prototype.org.everit.JsonSchemaValidator;

public class ArrayExpressSchemaTest extends AbstractSchemaValidation {

    private JsonSchemaValidator validator;

    @Test
    public void contactTest() {
        validator = new JsonSchemaValidator("/schemas/array_express/contact-schema.json");
        super.validate(validator, "/objects/array_express/contact.json");
    }

}
