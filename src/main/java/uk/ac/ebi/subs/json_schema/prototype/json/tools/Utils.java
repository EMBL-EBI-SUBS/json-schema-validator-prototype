package uk.ac.ebi.subs.json_schema.prototype.json.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Utils {

    public Optional<JsonNode> loadResource(String schema_path) {
        JsonNode jsonNode = null;
        try (InputStreamReader reader =  new InputStreamReader(getClass().getResourceAsStream(schema_path))) {
            jsonNode = JsonLoader.fromReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(jsonNode);
    }

}
