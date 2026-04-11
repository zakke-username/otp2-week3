package FuelCalculator;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LocalizationService {
    private Map<String, String> cache = new HashMap<>();
    private String language = "en";

    public void loadStrings(String language) {
        this.language = language.toLowerCase();
        cache.clear();
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT `key`, value FROM localization_strings WHERE language = ?");
            stmt.setString(1, language);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cache.put(rs.getString("key"), rs.getString("value"));
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    public String getString(String key) {
        return cache.get(key);
    }

    public List<String> getAllKeys() {
        return new ArrayList<>(cache.keySet());
    }

    public String getLanguage() {
        return language;
    }
}
