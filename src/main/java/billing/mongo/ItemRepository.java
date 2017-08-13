package billing.mongo;

import billing.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

/**
 * Created by anoop on 11/8/17.
 */
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
