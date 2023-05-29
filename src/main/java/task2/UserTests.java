package task2;

import java.io.Serializable;
import java.util.List;

import static task2.FileConversion.readUsersFromFile;
import static task2.FileConversion.writeUsersToJsonFile;

public class UserTests  {
    public static void main(String[] args) {

        List<User> users = readUsersFromFile("C:\\Users\\serhi\\Documents\\java\\homeWorks\\hw-module-10\\src\\main\\java\\files\\fileTask2.txt");
        writeUsersToJsonFile(users, "user.json");
    }
}
