package lesson;

import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Map;
import java.util.function.Consumer;

public class CreateDB {
    public void createTable() {
        try (var mongoClient = MongoClients.create()) {
            mongoClient.listDatabases()
                    .forEach((Consumer<Document>) System.out::println);

            mongoClient.listDatabaseNames()
                    .forEach((Consumer<String>) System.out::println);
            // test
            var database = mongoClient.getDatabase("mongo");
            // show collections
            var todoCollection = database.getCollection("todo");
            database.listCollectionNames()
                    .forEach((Consumer<String>) System.out::println);
            // todo
            database.listCollections()
                    .forEach((Consumer<Document>) System.out::println);

            var todoDocument = new Document(Map.of(
                    "_id", new ObjectId(),
                    "firstName", "Steven",
                    "lastName", "King",
                    "email", "Sking@mail.ru",
                    "phone", "89434326655",
                    "hireDate", "1987-12-25",
                    "jobId", "Ad_pres",
                    "salary", 24000));
            var todoDocument2 = new Document(Map.of(
                    "_id", new ObjectId(),
                    "firstName", "Neena",
                    "lastName", "Kochhar",
                    "email", "NKocchhar@mail.ru",
                    "phone", "89226336655",
                    "hireDate", "1988-02-15",
                    "jobId", "Ad_VP",
                    "salary", 17000));
            var todoDocument3 = new Document(Map.of(
                    "_id", new ObjectId(),
                    "firstName", "Lex",
                    "lastName", "Haan",
                    "email", "Haan@mail.ru",
                    "phone", "89116336777",
                    "hireDate", "1999-03-12",
                    "jobId", "Ad_VP",
                    "salary", 17000));
            var todoDocument4 = new Document(Map.of(
                    "_id", new ObjectId(),
                    "firstName", "Alexander",
                    "lastName", "Hunold",
                    "email", "Hunold@mail.ru",
                    "phone", "89325636777",
                    "hireDate", "1987-03-08",
                    "jobId", "IT_PROG",
                    "salary", 9000));
            var todoDocument5 = new Document(Map.of(
                    "_id", new ObjectId(),
                    "firstName", "Bruce",
                    "lastName", "Ernst",
                    "email", "Ernst@mail.ru",
                    "phone", "89216778853",
                    "hireDate", "1986-08-17",
                    "jobId", "Ad_VP",
                    "salary", 6000));

            todoCollection.insertOne(todoDocument);
            todoCollection.insertOne(todoDocument2);
            todoCollection.insertOne(todoDocument3);
            todoCollection.insertOne(todoDocument4);
            todoCollection.insertOne(todoDocument5);
        }
    }
}