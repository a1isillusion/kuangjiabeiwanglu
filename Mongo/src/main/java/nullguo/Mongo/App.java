package nullguo.Mongo;

import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    	Mongaodao dao=new Mongaodao();
    	MongoClient mongoClient = dao.getMongoClient();
        MongoDatabase mongoDataBase = dao.getMongoDataBase(mongoClient);
        MongoCollection<Document> collection = mongoDataBase.getCollection("col");
        List<Document> members = new ArrayList<Document>();  
        members.add(new Document("id","12553"));
        members.add(new Document("id","12345"));
   /*     Document document = new Document("title", "MongoDB").  
                append("description", "database").  
                append("likes", 100).  
                append("by", "Fly").
                append("coder",members);  
                List<Document> documents = new ArrayList<Document>();  
                documents.add(document);  
                collection.insertMany(documents); 
    */
    /*    FindIterable<Document> findIterable = collection.find(new Document("likes",new Document("$gt",100)).append("title", "MongoDB"));  
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
           System.out.println(mongoCursor.next());  
        }  
    */
  //   collection.updateMany(new Document("url",new Document("$regex","runoob")), new Document("$set",new Document("url","nullguo")));
  //   collection.deleteMany(new Document("description",new Document("$regex","Nosql")));
     FindIterable<Document> findIterable = collection.find();  
     MongoCursor<Document> mongoCursor = findIterable.iterator();  
     while(mongoCursor.hasNext()){   
    	Object object=mongoCursor.next().get("coder");
        if( object instanceof List<?>) {
        	List<Document> list=(List<Document>)object;
        	for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).get("id"));
			}
        }
    }
}}
