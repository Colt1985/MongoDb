package lesson;

import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Map;
import java.util.function.Consumer;

public class Select {

    public void printAllTable() {
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

            todoCollection.find()      //Поиск всего
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


            System.out.println(todoCollection.find(Filters.eq("firstName")));         //Поиск определенных значений

            todoCollection.find(Filters.eq("lastName"))         //Поиск определенных значений
                    .forEach((Consumer<Document>) System.out::println);
        }
    }

}
