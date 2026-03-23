package com.example.lab1_fx;

import java.util.HashMap;
import java.util.Map;

public class ConverterModel {

    private final Map<String, Double> coefficients = new HashMap<>();

    public ConverterModel() {
        coefficients.put("Граненый стакан (250 мл)", 250.0);
        coefficients.put("Чайный стакан (200 мл)", 200.0);
        coefficients.put("Столовая ложка (15 мл)", 15.0);
        coefficients.put("Чайная ложка (5 мл)", 5.0);
        coefficients.put("Миллилитры", 1.0);
    }

    public double convert(double value, String from, String to) {

        if (!coefficients.containsKey(from) || !coefficients.containsKey(to)) {
            throw new IllegalArgumentException("Неизвестная единица измерения!");
        }

        double valueInMl = value * coefficients.get(from);
        return valueInMl / coefficients.get(to);
    }

    public Map<String, Double> getUnits() {
        return coefficients;
    }
}