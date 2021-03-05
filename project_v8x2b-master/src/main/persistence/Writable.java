// Code modeled after the JsonSerializationDemo uploaded by Paul Carter on the CPSC 210 repository

package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}