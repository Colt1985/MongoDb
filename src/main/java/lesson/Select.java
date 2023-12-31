package lesson;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import java.util.Arrays;
import java.util.function.Consumer;

public class Select implements Sorted, PrintDB {

    public MongoCollection<Document> getTodoCollection() {
        var mongoClient = MongoClients.create();
        var database = mongoClient.getDatabase("mongo");
        return database.getCollection("todo");
    }

    @Override
    public void printAllTable() {
        var todoCollection = getTodoCollection();
        todoCollection.find().forEach((Consumer<Document>) System.out::println);
    }

    @Override
    public void printTableFirstNameLastNameHireDate() {

        var todoCollection = getTodoCollection();
        todoCollection.find().projection(Projections.fields(Projections.include("firstName", "lastName", "hireDate"), Projections.excludeId()))
                .forEach((Consumer<Document>) System.out::println);
    }

    @Override
    public void sortMaxMinSalary() {
        var todoCollection = getTodoCollection();
        todoCollection.find().sort(new Document("salary", -1))
                .forEach((Consumer<Document>) System.out::println);
    }

    @Override
    public void sortAverageSalary() {
        var todoCollection = getTodoCollection();
        todoCollection.aggregate(Arrays.asList(Aggregates.group("$null", Accumulators.avg("averageSalary", "$salary"))))
                .forEach((Consumer<Document>) System.out::println);
    }

    @Override
    public void printFirstNamePhone() {
        var todoCollection = getTodoCollection();
        todoCollection.find().projection(Projections.fields(Projections.include("firstName", "phone"), Projections.excludeId()))
                .forEach((Consumer<Document>) System.out::println);
    }

}


