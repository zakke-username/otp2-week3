import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LocalizationServiceTest {
    private LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationService();
        localizationService.loadStrings("en");
    }

    @Test
    void getString_test() {
        String distanceLabel = localizationService.getString("distance.label");
        assertNotNull(distanceLabel);

        String priceLabel = localizationService.getString("price.label");
        assertNotNull(priceLabel);
    }

    @Test
    void getAllKeys_test() {
        List<String> keys = localizationService.getAllKeys();
        assertNotNull(keys);
    }

    @Test
    void getLanguage_test() {
        String language = localizationService.getLanguage();
        assertEquals("en", language);
    }
}
