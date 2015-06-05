package kjanderson2.activeandroidexample;

        import com.activeandroid.query.Select;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.TextView;


public class MainActivity extends ActionBarActivity{

    private TextView idView;
    private EditText nameBox, ageBox, email1Box, email2Box, phone1Box, phone2Box;
    private CheckBox email1Checkbox, email2Checkbox, phone1Checkbox, phone2Checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idView = (TextView) findViewById(R.id.productID);
        nameBox = (EditText) findViewById(R.id.productName);
        ageBox = (EditText) findViewById(R.id.productQuantity);

        //Initialize EditTexts... These will be accessed for email and phone values
        email1Box = (EditText) findViewById(R.id.email1);
        email2Box = (EditText) findViewById(R.id.email2);
        phone1Box = (EditText) findViewById(R.id.phone1);
        phone2Box = (EditText) findViewById(R.id.phone2);

        //Initialize Checkboxes and boolean values for activity
        email1Checkbox = (CheckBox) findViewById(R.id.email1_activity_box);
        email2Checkbox = (CheckBox) findViewById(R.id.email2_activity_box);
        phone1Checkbox = (CheckBox) findViewById(R.id.phone1_activity_box);
        phone2Checkbox = (CheckBox) findViewById(R.id.phone2_activity_box);


    }

    public void newProduct(View view){

        int age = Integer.parseInt(ageBox.getText().toString());
        Person person = new Person(nameBox.getText().toString(), age);

        if(email1Box.getText() != null) {
            boolean email1Active = email1Checkbox.isChecked();
            Email email1 = new Email(email1Box.getText().toString(), email1Active);
            email1.save();
            person.setEmail1(email1);
            person.email1.save();
        }
        if(email2Box.getText() != null) {
            boolean email2Active = email2Checkbox.isChecked();
            Email email2 = new Email(email2Box.getText().toString(), email2Active);
            email2.save();
            person.setEmail2(email2);
            person.email2.save();
        }
        if(phone1Box.getText() != null) {
            boolean phone1Active = phone1Checkbox.isChecked();
            Telephone phone1 = new Telephone(phone1Box.getText().toString(), phone1Active);
            phone1.save();
            person.setPhone1(phone1);
            person.phone1.save();
        }
        if(phone2Box.getText() != null) {
            boolean phone2Active = phone2Checkbox.isChecked();
            Telephone phone2 = new Telephone (phone2Box.getText().toString(), phone2Active);
            phone2.save();
            person.setPhone2(phone2);
            person.phone2.save();
        }

        person.save();

        idView.setText("Record " + person.getId().toString() + " Added");
        clearBoxes();

    }

    private Person queryPerson(String name){
        return new Select().from(Person.class).where("Name = name").executeSingle();
    }

    public void lookupProduct (View view) {
        Person person = queryPerson(nameBox.getText().toString());
        if(person != null){
            idView.setText("ID = " + person.getId().toString());
            fillBoxes(person);
        } else {
            idView.setText("No Match Found");
        }
    }

    public void removeProduct(View view) {


        Person person = queryPerson(nameBox.getText().toString());
        if(person !=null){
            idView.setText("Record " + person.getId().toString() +" Deleted");
            person.delete();
            clearBoxes();
        } else {
            idView.setText("No Match Found");
        }
    }

    private void clearBoxes(){
        nameBox.setText("");
        ageBox.setText("");
        email1Box.setText("");
        email2Box.setText("");
        phone1Box.setText("");
        phone2Box.setText("");
        email1Checkbox.setChecked(false);
        email2Checkbox.setChecked(false);
        phone1Checkbox.setChecked(false);
        phone2Checkbox.setChecked(false);
    }

    private void fillBoxes(Person person){
        ageBox.setText(String.valueOf(person.getAge()));
        email1Box.setText(String.valueOf(person.getEmail1().getAddress()));
        email1Checkbox.setChecked(person.getEmail1().getActive());
        email2Box.setText(String.valueOf(person.getEmail2().getAddress()));
        email2Checkbox.setChecked(person.getEmail2().getActive());
        phone1Box.setText(String.valueOf(person.getPhone1().getNumber()));
        phone2Checkbox.setChecked(person.getPhone1().getActive());
        phone2Box.setText(String.valueOf(person.getPhone2().getNumber()));
        phone2Checkbox.setChecked(person.getPhone2().getActive());
    }


}