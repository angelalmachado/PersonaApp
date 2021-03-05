package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// represents an account containing a person's personal information,
// their personality scores and similar personalities list
public class Account implements Writable {
    private String name;
    private String username;
    private List<Integer> personalityScore;
    private List<Personality> similarPersonalities;

    // constructor
    // EFFECTS: constructs an account, setting the name to accName
    // and the username to accUsername
    public Account(String accName, String accUsername) {
        name = accName;
        username = accUsername;
        personalityScore = new ArrayList<>();
        similarPersonalities = new ArrayList<>();
    }

    // add similar personality
    // MODIFIES: this, similarPersonalities
    // EFFECTS: adds the given person to the list of similar personalities if person is not in the list yet
    public void addPersonality(Personality p) {
        boolean add = true;
        for (int i = 0; i <= similarPersonalities.size() - 1; i++) {
            if (similarPersonalities.get(i).getName() == p.getName()) {
                add = false;
            }
        }

        if (add) {
            similarPersonalities.add(p);
        } else {
            System.out.println("Person already in list! Try again.");
        }
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public List<Integer> getPersonalityScore() {
        return personalityScore;
    }

    public List<Personality> getSimilarPersonalities() {
        return similarPersonalities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("username", username);
        json.put("personality scores", scoreToJson());
        json.put("similar personalities", similarPersonalitiesToJson());
        return json;
    }

    // EFFECTS: adds the scores to json
    private JSONArray scoreToJson() {
        JSONArray json = new JSONArray();

        for (Integer score : personalityScore) {
            json.put(score);
        }
        return json;
    }

    // EFFECTS: adds the personalities to json
    private JSONArray similarPersonalitiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Personality p : similarPersonalities) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}
