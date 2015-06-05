package kjanderson2.activeandroidexample;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;
import com.activeandroid.annotation.Column;

/**
 * The Telephone Model Class.
 * Created by kjanderson2 on 6/5/15.
 */
@Table(name="Telephone")
public class Telephone extends Model {

    @Column(name = "Number")
    private String number;

    @Column(name = "Active")
    private boolean active;

    @Column(name = "Type")
    private String type;

    public Telephone() {
        //Default Constructor
    }

    public Telephone(String number, boolean active) {
        this.number = number;
        this.active = active;
    }

    public Telephone(String number, boolean active, String type) {
        this.number = number;
        this.active = active;
        this.type = type;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }
}
