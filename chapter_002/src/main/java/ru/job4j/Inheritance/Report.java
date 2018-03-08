package ru.job4j.Inheritance;

/**
 * Class Report -  solution of task:
 * 1. Реализация профессий в коде [#6837]
 *
 * @author Viathceslav Bugakov
 * @version %Id%
 * @since 0.1
 */


public class Report {
    private Engineer engineer;
    private House house;

    public Report(Engineer engineer, House house){
        this.engineer = engineer;
        this.house = house;
    }

    private String buildStageReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Building report:");
        sb.append(System.lineSeparator());
        sb.append(house);
        sb.append(" in condition: ");
        if ((house.getStage().equals("project"))) {
            sb.append("building not started");
        } else {
            sb.append("Building " + house.getStage());
        }
        sb.append(System.lineSeparator());
        sb.append("Responsible:");
        sb.append(System.lineSeparator());
        sb.append(engineer);
        return sb.toString();
    }

    @Override
    public String toString() {
        return buildStageReport();
    }

}
