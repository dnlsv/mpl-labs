package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LandArea implements Comparable<LandArea> {
    private final Planet planet;
    private final Client client;
    private final Area area;

    public LandArea() {
        this.planet = new Planet();
        this.client = new Client();
        this.area = new Area();
    }

    public LandArea(Planet planet, Client client, Area area) {
        this.planet = planet;
        this.client = client;
        this.area = area;
    }

    @Override
    public String toString() {
        return "Название: " + planet.getName() + ", Площадь планеты: " + planet.getSquare() + ", Имя: "
            + client.getName() + ", Возраст: " + client.getAge() + ", Площадь: " + area.getSquare()
            + ", Стоимость: " + area.getCost() + ", Ландшафт: " + area.getLandscape();

    }

    public String getNameOfPlanet() {
        return planet.getName();
    }

    @Override
    public int compareTo(LandArea obj) {
        int result = this.planet.getName().compareTo(obj.planet.getName());
        return result;
    }

    public double calculateFreePlace(List<LandArea> list, String name, int j) {
        double freePlace = list.get(j).planet.getSquare();
        try {
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).getNameOfPlanet().equals(name)) {
                    freePlace = freePlace - list.get(i).area.getSquare();
                    if (freePlace < 0) {
                        freePlace = 0;
                        throw new Exception("Места на планете нет!");
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return freePlace;
    }

    public void writeToFile(List<LandArea> list) {
        try {
            try (PrintWriter pw = new PrintWriter(
                new File(".\\resources\\", "LandArea.txt").getAbsoluteFile())) {
                for (int i = 0; i < list.size(); i++) {
                    pw.println(list.get(i).planet.getName() + " " + list.get(i).planet.getSquare() + " "
                        + list.get(i).client.getName() + " " + list.get(i).client.getAge() + " "
                        + list.get(i).area.getSquare() + " " + list.get(i).area.getCost() + " "
                        + list.get(i).area.getLandscape());
                }
                pw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LandArea> readFromFile() {
        List<LandArea> list = new ArrayList<>();
        String str;
        StringTokenizer stringtokenizer;
        Scanner scanner;
        try {
            scanner = new Scanner(new File(".\\resources\\", "LandArea.txt"));
            while (scanner.hasNext()) {
                LandArea landarea = new LandArea();
                str = scanner.nextLine();
                stringtokenizer = new StringTokenizer(str);
                while (stringtokenizer.hasMoreTokens()) {
                    landarea.planet.setName(stringtokenizer.nextToken());
                    landarea.planet.setSquare(Double.parseDouble(stringtokenizer.nextToken()));
                    landarea.client.setName(stringtokenizer.nextToken());
                    landarea.client.setAge(Integer.parseInt(stringtokenizer.nextToken()));
                    landarea.area.setSquare(Double.parseDouble(stringtokenizer.nextToken()));
                    landarea.area.setCost(Integer.parseInt(stringtokenizer.nextToken()));
                    landarea.area.setLandscape(stringtokenizer.nextToken());
                }
                list.add(landarea);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeToFileStream(List<LandArea> list) {
        String str;
        try {
            FileOutputStream fos = new FileOutputStream(".\\resources\\LandAreaStream.txt");
            for (int i = 0; i < list.size(); i++) {
                str = list.get(i).planet.getName() + " " + list.get(i).planet.getSquare() + " "
                    + list.get(i).client.getName() + " " + list.get(i).client.getAge() + " "
                    + list.get(i).area.getSquare() + " " + list.get(i).area.getCost() + " "
                    + list.get(i).area.getLandscape() + "\n";
                fos.write(str.getBytes());
            }
            fos.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public List<LandArea> readFromFileStream() {
        List<LandArea> list = new ArrayList<>();
        String str = "";
        StringTokenizer stringtokenizer;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(new File(".\\resources\\LandAreaStream.txt")), StandardCharsets.UTF_8));

            while ((str = in.readLine()) != null) {
                LandArea landarea = new LandArea();
                stringtokenizer = new StringTokenizer(str);
                while (stringtokenizer.hasMoreTokens()) {
                    landarea.planet.setName(stringtokenizer.nextToken());
                    landarea.planet.setSquare(Double.parseDouble(stringtokenizer.nextToken()));
                    landarea.client.setName(stringtokenizer.nextToken());
                    landarea.client.setAge(Integer.parseInt(stringtokenizer.nextToken()));
                    landarea.area.setSquare(Double.parseDouble(stringtokenizer.nextToken()));
                    landarea.area.setCost(Integer.parseInt(stringtokenizer.nextToken()));
                    landarea.area.setLandscape(stringtokenizer.nextToken());
                }
                list.add(landarea);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
