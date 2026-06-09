package other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class TemperatureServiceTest {

    private final TemperatureService service = new TemperatureService();

    @Test
    void shouldCalculateAveragesForRepeatedCities() {
        Map<String, Double> averages = toMap(service.calculateAverageTemperatures(records()));

        assertEquals(0.0, averages.get("Moscow"));
        assertEquals(18.0, averages.get("Berlin"));
        assertEquals(30.0, averages.get("Dubai"));
    }

    @Test
    void streamAndIncrementalImplementationsShouldMatchBaseline() {
        Map<String, Double> baseline = toMap(service.calculateAverageTemperatures(records()));

        assertEquals(baseline, toMap(service.calculateAverageTemperaturesStr(records())));
        assertEquals(baseline, toMap(service.calculateAverageTemperaturesInc(records())));
    }

    @Test
    void shouldReturnEmptyResultForEmptyInput() {
        assertTrue(service.calculateAverageTemperatures(List.of()).isEmpty());
        assertTrue(service.calculateAverageTemperaturesStr(List.of()).isEmpty());
        assertTrue(service.calculateAverageTemperaturesInc(List.of()).isEmpty());
    }

    private static List<TemperatureService.TemperatureRecord> records() {
        return List.of(
                new TemperatureService.TemperatureRecord("Moscow", "2026-01-01", -5),
                new TemperatureService.TemperatureRecord("Berlin", "2026-01-03", 20),
                new TemperatureService.TemperatureRecord("Moscow", "2026-01-02", 5),
                new TemperatureService.TemperatureRecord("Dubai", "2026-01-01", 30),
                new TemperatureService.TemperatureRecord("Berlin", "2026-01-01", 16)
        );
    }

    private static Map<String, Double> toMap(List<TemperatureService.CityAverageTemperature> temperatures) {
        return temperatures.stream()
                .collect(Collectors.toMap(
                        TemperatureService.CityAverageTemperature::getCity,
                        TemperatureService.CityAverageTemperature::getAverageTemperature
                ));
    }
}
