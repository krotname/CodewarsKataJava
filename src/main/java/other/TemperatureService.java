package other;

import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TemperatureService {

    // Задача на обработку данных о температуре в разных городах.
    // На входе - список данных о температурах (где каждая запись включает название города, дату и температуру),
    // на выходе - список средних температур для каждого города.
    //
    // Условия:
    // 1. Записи обрабатываются в порядке  увеличения даты.
    // 2. Если для города нет данных, то средняя температура равна 0.
    // 3. Данные для одного и того же города могут встречаться несколько раз.

    public List<CityAverageTemperature> calculateAverageTemperatures(List<TemperatureRecord> records) {
        Map<String, TemperatureDataAccumulator> resultMap = new HashMap<>();
        for (TemperatureRecord record : records) {
            if (resultMap.containsKey(record.getCity())) {
                TemperatureDataAccumulator temperatureDataAccumulator = resultMap.get(record.getCity());
                temperatureDataAccumulator.accumulate(record.getTemperature());
            } else {
                TemperatureDataAccumulator temperatureDataAccumulator = new TemperatureDataAccumulator(record.getTemperature());
                resultMap.put(record.getCity(), temperatureDataAccumulator);
            }
        }
        return resultMap
                .entrySet()
                .stream()
                .map(e -> new CityAverageTemperature(e.getKey(), e.getValue().getAverageTemperature()))
                .toList();
    }

    public List<CityAverageTemperature> calculateAverageTemperaturesStr(List<TemperatureRecord> records) {
        return records.stream()
                .sorted()
                .collect(Collectors.groupingBy(
                        TemperatureRecord::getCity,
                        Collectors.averagingDouble(TemperatureRecord::getTemperature)
                ))
                .entrySet()
                .stream()
                .map(entry -> new CityAverageTemperature(entry.getKey(), entry.getValue()))
                .toList();
    }

    public List<CityAverageTemperature> calculateAverageTemperaturesInc(List<TemperatureRecord> records) {
        Map<String, List<Integer>> cityTemperatures = new HashMap<>();

        for (TemperatureRecord record : records) {
            cityTemperatures
                    .computeIfAbsent(record.getCity(), k -> new ArrayList<>())
                    .add(record.getTemperature());
        }

        List<CityAverageTemperature> averages = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : cityTemperatures.entrySet()) {
            String city = entry.getKey();
            List<Integer> temperatures = entry.getValue();
            double average = temperatures.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            averages.add(new CityAverageTemperature(city, average));
        }

        return averages;
    }

    @Value
    public static class TemperatureRecord implements Comparable<TemperatureRecord> {
        String city;
        String date;
        int temperature;

        @Override
        public int compareTo(TemperatureRecord other) {
            return date.compareTo(other.date);
        }
    }

    @Value
    public static class CityAverageTemperature {
        String city;
        double averageTemperature;
    }

    public static class TemperatureDataAccumulator {
        double sumTemperature;
        double countTemperature;

        public TemperatureDataAccumulator(double sumTemperature) {
            this.sumTemperature = sumTemperature;
            countTemperature = 1;
        }

        public double getAverageTemperature() {
            return sumTemperature / countTemperature;
        }

        public void accumulate(double temperature) {
            this.countTemperature++;
            this.sumTemperature += temperature;
        }
    }
}
