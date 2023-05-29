package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileConversion {
    public static List<User> readUsersFromFile(String filename) {
        List<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine(); // Ігноруємо заголовок
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\s+");
                if (data.length == 2) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    User user = new User(name, age);
                    users.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static void writeUsersToJsonFile(List<User> users, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("[\n");
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                writer.write("    {\n");
                writer.write("        \"name\": \"" + user.getName() + "\",\n");
                writer.write("        \"age\":" + user.getAge() + "\n");
                writer.write("    }");
                if (i < users.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
