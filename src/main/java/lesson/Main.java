package lesson;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        // 1. Напишите запрос MongoDB для отображения всех данных из представленной таблицы
        // 2. Напишите запрос MongoDB для отображения ФИО и даты рождения всех лиц из представленной таблицы
        // 3. Напишите запрос MongoDB для отображения всех работников сортируя их в порядке уменьшения заработной платы
        // 4. Напишите запрос MongoDB для отображения средней зарплаты всех работников
        // 5. Напишите запрос MongoDB для отображения только имени и номера телефона сотрудников из представленной таблицы

//        CreateDB createDB = new CreateDB();   //Создание и добавление таблицы
//        createDB.createTable();

        Select select = new Select();

        //1. select.printAllTable();
        //2. select.printTableFirstNameLastNameHireDate();
        //3. select.sortMaxMinSalary();
        //4. select.sortAverageSalary();
        //5. select.printFirstNamePhone();
    }
}


