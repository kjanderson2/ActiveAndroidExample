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

    @Column(name="Identification")
    public long id;

    @Column(name="Name")
    public String name;

    @Column(name="Age")
    public int age;

    @Column(name="Email1")
    public Email email1;

    @Column(name="Email2")
    public Email email2;

    @Column(name="Phone1")
    public Telephone phone1;

    @Column(name="Phone2")
    public Telephone phone2;



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

    public void setEmail1(Email email){
        this.email1 = email;
    }

    public void setEmail2(Email email){
        this.email2 = email;
    }

    public Email getEmail1(){
        return this.email1;
    }

    public Email getEmail2(){
        return this.email2;
    }

    public void setPhone1(Telephone phone){
        this.phone1 = phone;
    }

    public void setPhone2(Telephone phone){
        this.phone2 = phone;
    }

    public Telephone getPhone1(){
        return this.phone1;
    }

    public Telephone getPhone2(){
        return this.phone2;
    }



}
