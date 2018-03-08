package ru.job4j.Inheritance;

/**
 * Class Diagnose -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */

public class Diagnose {
    private Doctor doctor;
    private Patient patient;

    public Diagnose(Doctor doctor,Patient patient){
        this.doctor = doctor;
        this.patient = patient;
    }

    private String buildDiagnosis() {
        StringBuilder sb = new StringBuilder();
        sb.append("Diagnosis:");
        sb.append(System.lineSeparator());
        sb.append(patient);
        sb.append(" is ");
        if ((patient.getDisease().equals("none"))) {
            sb.append("healthy");
        } else {
            sb.append("diseased by : " + patient.getDisease());
        }
        sb.append(System.lineSeparator());
        sb.append("Examined by:");
        sb.append(System.lineSeparator());
        sb.append(doctor);
        return sb.toString();
    }

    @Override
    public String toString() {
        return buildDiagnosis();
    }
}
