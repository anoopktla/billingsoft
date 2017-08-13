package billing.controller;

import billing.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import billing.service.ItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anoop on 11/8/17.
 */

@RestController
public class BillingController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value ="/item", method = RequestMethod.GET)
    public @ResponseBody List<Item> getItem(ModelMap model) {

        return itemService.getItems();

    }

    @RequestMapping(value ="/item", method = RequestMethod.POST)
    public @ResponseBody List<Item> saveItem(@RequestBody Item item) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemService.saveItem(itemList);
        return  itemService.getItems();

    }

    @RequestMapping(value ="/item", method = RequestMethod.PUT)
    public @ResponseBody List<Item>  updateItem(@RequestBody Item item) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemService.updateItem(itemList);
        return  itemService.getItems();

    }

    @DeleteMapping("/item/{id}")
    public @ResponseBody List<Item>  deleteItem(@PathVariable("id")String id ) {
        itemService.deleteItems(id);
        return  itemService.getItems();

    }
}
