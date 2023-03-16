package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Schedule implements Comparable<Schedule> {
    private String arrivalPlanet;
    private String departurePlanet;
    private String arrivalTime;
    private String departureTime;
    private int cost;

    public Schedule() {

    }

    public Schedule(String arrivalPlanet, String departurePlanet, String arrivalTime, String departureTime, int cost) {
        this.arrivalPlanet = arrivalPlanet;
        this.departurePlanet = departurePlanet;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Планета прибытия: " + arrivalPlanet + ", Планета отправления: " + departurePlanet
            + ", Время отправления: " + arrivalTime + ", Время прибытия: " + departureTime + ", Стоимсость билета: "
            + cost;
    }

    public String getArrivalPlanet() {
        return arrivalPlanet;
    }

    @Override
    public int compareTo(Schedule obj) {
        int result = this.getArrivalPlanet().compareTo(obj.arrivalPlanet);
        return result;
    }

    public void scheduleTwoPlanets(List<Schedule> scheduleList, String firstPlanet, String secondPlanet) {
        boolean flag = false;
        System.out.println("\n\tРасписаниие рейсов " + firstPlanet + " - " + secondPlanet);
        for (int i = 0; i < scheduleList.size(); i++) {
            if (scheduleList.get(i).arrivalPlanet.equals(firstPlanet)
                && scheduleList.get(i).departurePlanet.equals(secondPlanet)
                || scheduleList.get(i).arrivalPlanet.equals(secondPlanet)
                && scheduleList.get(i).departurePlanet.equals(firstPlanet)
            ) {
                flag = true;
                System.out.println(scheduleList.get(i));
            }
        }
        if (!flag)
            System.out.println("Рейсов нет!");
    }

    public void writeToFile(List<Schedule> scheduleList) {
        try {
            try (
                PrintWriter pw = new PrintWriter(
                    new File(".\\resources\\", "Schedule.txt").getAbsoluteFile()
                )
            ) {
                for (int i = 0; i < scheduleList.size(); i++) {
                    pw.println(scheduleList.get(i).arrivalPlanet + " " + scheduleList.get(i).departurePlanet + " "
                        + scheduleList.get(i).arrivalTime + " " + scheduleList.get(i).departureTime + " "
                        + scheduleList.get(i).cost);
                }
                pw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Schedule> readFromFile() {
        List<Schedule> scheduleList = new ArrayList<>();
        String str;
        StringTokenizer stringtokenizer;
        Scanner scanner;
        try {
            scanner = new Scanner(new File(".\\resources\\", "Schedule.txt"));
            while (scanner.hasNext()) {
                Schedule schedule = new Schedule();
                str = scanner.nextLine();
                stringtokenizer = new StringTokenizer(str);
                while (stringtokenizer.hasMoreTokens()) {
                    schedule.arrivalPlanet = stringtokenizer.nextToken();
                    schedule.departurePlanet = stringtokenizer.nextToken();
                    schedule.arrivalTime = stringtokenizer.nextToken();
                    schedule.departureTime = stringtokenizer.nextToken();
                    schedule.cost = Integer.parseInt(stringtokenizer.nextToken());
                }
                scheduleList.add(schedule);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

    public void writeToFileStream(List<Schedule> scheduleList) {
        String str;
        try {
            FileOutputStream fos = new FileOutputStream(".\\resources\\ScheduleStream.txt");

            for (int i = 0; i < scheduleList.size(); i++) {
                str = scheduleList.get(i).arrivalPlanet + " " + scheduleList.get(i).departurePlanet + " "
                    + scheduleList.get(i).arrivalTime + " " + scheduleList.get(i).departureTime + " "
                    + scheduleList.get(i).cost + "\n";
                fos.write(str.getBytes());
            }

            fos.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public List<Schedule> readFromFileStream() {
        List<Schedule> scheduleList = new ArrayList<>();
        String str = "";
        StringTokenizer stringtokenizer;

        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(new File(".\\resources\\ScheduleStream.txt")),
                    StandardCharsets.UTF_8
                )
            );

            while ((str = in.readLine()) != null) {
                Schedule schedule = new Schedule();
                stringtokenizer = new StringTokenizer(str);
                while (stringtokenizer.hasMoreTokens()) {
                    schedule.arrivalPlanet = stringtokenizer.nextToken();
                    schedule.departurePlanet = stringtokenizer.nextToken();
                    schedule.arrivalTime = stringtokenizer.nextToken();
                    schedule.departureTime = stringtokenizer.nextToken();
                    schedule.cost = Integer.parseInt(stringtokenizer.nextToken());
                }
                scheduleList.add(schedule);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }

}
