package kjanderson2.activeandroidexample;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import java.util.List;

/**
 * Created by kjanderson2 on 6/5/15.
 */
@Table(name="Contacts")
public class Person extends Model {

    @Column(name="Name")
    public String name;

    @Column(name="Age")
    public int age;

    @Column(name="Email")
    public List<Email> emails;

    @Column(name="Phone")
    public List<Telephone> phones;

    public Person(){
        //Default Constructor
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void addEmail(Email email){
        emails.add(email);
    }

    public Email getEmail1(){
        return this.emails.get(0);
    }

    public Email getEmail2(){
        return this.emails.get(1);
    }

    public void addPhone(Telephone phone){
        this.phones.add(phone);
    }

    public Telephone getPhone1(){
        return this.phones.get(0);
    }

    public Telephone getPhone2(){
        return this.phones.get(1);
    }



}
