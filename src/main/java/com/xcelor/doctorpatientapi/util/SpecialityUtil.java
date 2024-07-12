package com.xcelor.util;

import java.util.HashMap;
import java.util.Map;

public class SpecialityUtil {

    private static final Map<String, String> SYMPTOM_SPECIALITY_MAP = new HashMap<>();

    static {
        SYMPTOM_SPECIALITY_MAP.put("Arthritis", "Orthopedic");
        SYMPTOM_SPECIALITY_MAP.put("Back Pain", "Orthopedic");
        SYMPTOM_SPECIALITY_MAP.put("Tissue injuries", "Orthopedic");
        SYMPTOM_SPECIALITY_MAP.put("Dysmenorrhea", "Gynecology");
        SYMPTOM_SPECIALITY_MAP.put("Skin infection", "Dermatology");
        SYMPTOM_SPECIALITY_MAP.put("Skin burn", "Dermatology");
        SYMPTOM_SPECIALITY_MAP.put("Ear pain", "ENT specialist");
    }

    public static String getSpecialityBySymptom(String symptom) {
        return SYMPTOM_SPECIALITY_MAP.get(symptom);
    }

    public static boolean isValidSpeciality(String speciality) {
        return SYMPTOM_SPECIALITY_MAP.containsValue(speciality);
    }
}