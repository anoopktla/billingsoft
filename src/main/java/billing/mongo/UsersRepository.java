package billing.mongo;

/**
 * Created by anoop on 6/8/17.
 */
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface UsersRepository extends MongoRepository<Users, String>{

}