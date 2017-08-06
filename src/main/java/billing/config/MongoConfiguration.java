package billing.config;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import java.net.UnknownHostException;

import static com.mongodb.MongoClientOptions.builder;
import static com.mongodb.WriteConcern.ACKNOWLEDGED;
import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
@EnableMongoRepositories(basePackages = "billing.mongo")
public class MongoConfiguration extends AbstractMongoConfiguration {

    //@Value("${mongo.uri}")
    String mongoUri="mongodb://localhost:27017";

   /* @Autowired
    Mongo mongo;*/

    @Override
    protected String getDatabaseName() {
        return "users";
    }

    @Override
    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new MongoClient(new MongoClientURI(mongoUri, builder()
                .connectTimeout((int) SECONDS.toMillis(5))
                .socketTimeout((int) SECONDS.toMillis(10))
                .connectionsPerHost(100)
                .threadsAllowedToBlockForConnectionMultiplier(50)
                .readPreference(ReadPreference.primaryPreferred())
                .writeConcern(ACKNOWLEDGED)
        ));
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "users");
    }

    @Override
    protected String getMappingBasePackage() {
        return "billing.mongo";
    }


}

