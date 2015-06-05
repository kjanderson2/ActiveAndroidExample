package kjanderson2.activeandroidexample;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;
import com.activeandroid.annotation.Column;

/**
 * THe Email model class.
 * Created by kjanderson2 on 6/5/15.
 */
@Table(name="Emails")
public class Email extends Model{
    @Column(name="Address")
    private String address;

    @Column(name="Active")
    private boolean active;


    public Email(){
        //Default Constructor
    }

    public Email(String address, boolean active){
        this.address=address;
        this.active=active;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public boolean getActive(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
