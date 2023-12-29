package lesson;

import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.function.Consumer;

public class Select {

    public void printAllTable() {
        try (var mongoClient = MongoClients.create()) {                             // Начало
            mongoClient.listDatabases()                                             // Как вывести этот код в отдельный метод, а то в следующем методе код повторяется
                    .forEach((Consumer<Document>) System.out::println);
            mongoClient.listDatabaseNames()
                    .forEach((Consumer<String>) System.out::println);
            var database = mongoClient.getDatabase("mongo");
            database.listCollectionNames()
                    .forEach((Consumer<String>) System.out::println);
            // todo
            database.listCollections()
                    .forEach((Consumer<Document>) System.out::println);

            var todoCollection = database.getCollection("todo");                // Конец

            todoCollection.find()      //Вывод всей таблицы
                    .forEach((Consumer<Document>) System.out::println);
        }
    }

    public void printTableFirstNameLastNameHireDate() {
        try (var mongoClient = MongoClients.create()) {
            mongoClient.listDatabases()
                    .forEach((Consumer<Document>) System.out::println);
            mongoClient.listDatabaseNames()
                    .forEach((Consumer<String>) System.out::println);
            var database = mongoClient.getDatabase("mongo");
            database.listCollectionNames()
                    .forEach((Consumer<String>) System.out::println);
            // todo
            database.listCollections()
                    .forEach((Consumer<Document>) System.out::println);

            var todoCollection = database.getCollection("todo");


//            todoCollection.find(Filters.eq("lastName"))         //Вот здесь нужна помощь в фильтрации
//                    .forEach((Consumer<Document>) System.out::println);
        }
    }

}
