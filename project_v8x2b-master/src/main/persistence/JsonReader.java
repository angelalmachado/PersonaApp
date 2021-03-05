// Code modeled after the JsonSerializationDemo uploaded by Paul Carter on the CPSC 210 repository

package persistence;

import model.Account;
import model.Personality;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads account from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads account from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Account read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData.trim());
        return parseAccount(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses account from JSON object and returns it
    private Account parseAccount(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String username = jsonObject.getString("username");
        Account acc = new Account(name, username);
        addScores(acc, jsonObject);
        addPersonalities(acc, jsonObject);
        return acc;
    }

    // EFFECTS: adds the scores to the json object
    private void addScores(Account acc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("personality scores");
        for (Object json : jsonArray) {
            Integer nextScore = (Integer) json;
            acc.getPersonalityScore().add(nextScore);
        }
    }

    // EFFECTS: adds the personalities to the json object
    private void addPersonalities(Account acc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("similar personalities");
        for (Object json : jsonArray) {
            JSONObject nextPersonality = (JSONObject) json;
            addPersonality(acc, nextPersonality);
        }
    }

    // EFFECTS: adds a single personality to the nextPersonality json object
    private void addPersonality(Account acc, JSONObject nextPersonality) {
        String name = nextPersonality.getString("name");
        String trait = nextPersonality.getString("trait");
        Personality personality = new Personality(name, trait);
        acc.addPersonality(personality);
    }

}
