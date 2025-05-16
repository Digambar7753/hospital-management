package com.xcelore.backend.util;

import com.xcelore.backend.entity.enums.Speciality;
import com.xcelore.backend.entity.enums.Symptom;

public class SymptomMapper {
    public static Speciality mapSymptomToSpeciality(Symptom symptom) {
        return switch (symptom) {
            case ARTHRITIS, BACK_PAIN, TISSUE_INJURIES -> Speciality.ORTHOPAEDIC;
            case DYSMENORRHEA -> Speciality.GYNECOLOGY;
            case SKIN_INFECTION, SKIN_BURN -> Speciality.DERMATOLOGY;
            case EAR_PAIN -> Speciality.ENT;
        };
    }
}