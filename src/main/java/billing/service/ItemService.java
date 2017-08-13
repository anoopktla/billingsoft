package billing.service;

import billing.mongo.ItemRepository;
import billing.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by anoop on 11/8/17.
 *
 */
@Component
public class ItemService {

    @Autowired
    private ItemRepository itemRepo;

    public List<Item> getItems(){
        return  itemRepo.findAll();

    }

    public boolean saveItem(List<Item> items){
         itemRepo.insert(items);
        return true;
    }

    public boolean updateItem(List<Item> items){
        itemRepo.save(items);//insert(items);
        return true;
    }
    public boolean deleteItems(String id){
        itemRepo.delete(id);

        return true;
    }
}
