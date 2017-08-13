package billing.model;

import billing.enums.ItemStatus;
import billing.enums.MeasureUnit;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by anoop on 11/8/17.
 */
@Document(collection="items")
public class Item {
    private String name;
    @Id
    private String id;
    private String description;
    private String supplier;
    private String unit_rate;
    private  String hsn;
    private MeasureUnit unit_of_measure;
    private ItemStatus item_status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getUnit_rate() {
        return unit_rate;
    }

    public void setUnit_rate(String unit_rate) {
        this.unit_rate = unit_rate;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public MeasureUnit getUnit_of_measure() {
        return unit_of_measure;
    }

    public void setUnit_of_measure(MeasureUnit unit_of_measure) {
        this.unit_of_measure = unit_of_measure;
    }

    public ItemStatus getItem_status() {
        return item_status;
    }

    public void setItem_status(ItemStatus item_status) {
        this.item_status = item_status;
    }
//    /
}//

// Name, ID, description, supplier, unit rate, HSN, Unit of Measure, item status
