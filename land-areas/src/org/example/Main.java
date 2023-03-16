package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LandArea landarea = new LandArea();
        List<LandArea> list = new ArrayList<>();

        list = landarea.readFromFile();
        if (list.isEmpty()) {
            list = landarea.readFromFileStream();
        }
        if (list.isEmpty()) {
            list.add(new LandArea(new Planet("Земля", 1000), new Client("Денис", 19), 
                new Area(100, 50000, "Равнина")));
            list.add(new LandArea(new Planet("Марс", 2000), new Client("Кирилл", 29),
                new Area(200, 10000, "Лес")));
            list.add(new LandArea(new Planet("Юпитер", 3000), new Client("Вадим", 22),
                new Area(50, 40000, "Поле")));
            list.add(new LandArea(new Planet("Венера", 4000), new Client("Дмитрий", 23),
                new Area(300, 60000, "Степь")));
            list.add(new LandArea(new Planet("Сатурн", 5000), new Client("Антон", 25),
                new Area(130, 30000, "Джунгли")));
        }

        Schedule schedule = new Schedule();
        List<Schedule> scheduleList = new ArrayList<>();

        scheduleList = schedule.readFromFile();
        if (scheduleList.isEmpty()) {
            scheduleList = schedule.readFromFileStream();
        }
        if (scheduleList.isEmpty()) {
            scheduleList.add(new Schedule("Земля", "Марс", "12:25", "13:45", 30));
            scheduleList.add(new Schedule("Марс", "Земля", "17:00", "18:20", 30));
            scheduleList.add(new Schedule("Марс", "Юпитер", "15:00", "17:55", 60));
            scheduleList.add(new Schedule("Земля", "Сатурн", "14:00", "15:20", 30));
        }

        Collections.sort(list);
        Collections.sort(scheduleList);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println(
                "Остаток свободного места: " + landarea.calculateFreePlace(list, list.get(i).getNameOfPlanet(), i));
        }

        System.out.println();

        for (int i = 0; i < scheduleList.size(); i++)
            System.out.println(scheduleList.get(i));

        schedule.scheduleTwoPlanets(scheduleList, "Марс", "Земля");
    }

}
