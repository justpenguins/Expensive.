package persistence;

import org.json.JSONObject;

// Creates a JSON object
public interface Writeable {

    JSONObject toJson();
}
