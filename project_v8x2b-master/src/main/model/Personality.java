package model;

import org.json.JSONObject;
import persistence.Writable;

//represents the a personality to be added to the list of similar personalities
public class Personality implements Writable {
    private String name;
    private String trait;

    // constructor
    // EFFECTS: constructs a person with a name and a personality trait
    public Personality(String name, String trait) {
        this.name = name;
        this.trait = trait;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getTrait() {
        return trait;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("trait", trait);
        return json;
    }
}
