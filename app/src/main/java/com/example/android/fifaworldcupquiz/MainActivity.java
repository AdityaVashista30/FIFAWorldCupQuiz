package com.example.android.fifaworldcupquiz;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int score=0;
    String name="",message="";
    public void submit(View view){
        score=0;
        message="";
        EditText getName=(EditText) findViewById(R.id.name_edit_text);
        TextView showResult=(TextView) findViewById(R.id.result_text);
        name=getName.getText().toString();
        if(name.replaceAll("\\s","").equals("")){message="Enter name and press again!";
        showResult.setText(message);
        message="";}
        else{
            //ANSWER ONE
            answer_one();
            //ANSWER TWO
            answer_two();
            //ANSWER THREE
            answer_three();
            //ANSWER FOUR
            answer_four();
            //ANSWER FIVE
            answer_five();
            //ANSWER SIX
            answer_six();
            //ANSWER SEVEN
            answer_seven();
            //ANSWER EIGHT
            answer_eight();
            //ANSWER NINE
            answer_nine();
            //ANSWER TEN
            answer_ten();
            message="Hello "+name+"\n";
            if(score==10){message+="CONGRATULATIONS!! \nYou have answered all questions correctly \n";}
            message+="Your Score: "+score+"/10";
            showResult.setText(message);
            Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();} }
    private void answer_one(){
        EditText answer1=(EditText) findViewById(R.id.answer_one);
        ImageView image1=(ImageView) findViewById(R.id.image1);
        if(answer1.getText().toString().equals("1930")){image1.setImageResource(R.drawable.right);
        score+=1;}
        else{image1.setImageResource(R.drawable.wrong);}
    }
    private void answer_two(){
        ImageView image2=(ImageView) findViewById(R.id.image2);
        RadioButton answer2=(RadioButton) findViewById(R.id.answer_two_germany_radio_button);
        if(answer2.isChecked()){score+=1;
        image2.setImageResource(R.drawable.right);}
        else{image2.setImageResource(R.drawable.wrong);}
    }
    private void answer_three(){
        EditText answer3=(EditText) findViewById(R.id.answer_three);
        ImageView image3=(ImageView) findViewById(R.id.image3);
        if(answer3.getText().toString().replaceAll("\\s","").equals("URUGUAY")){score+=1;
        image3.setImageResource(R.drawable.right);}
        else{image3.setImageResource(R.drawable.wrong);}
    }
    private void answer_four(){
        ImageView image4=(ImageView) findViewById(R.id.image4);
        CheckBox answer4_1=(CheckBox) findViewById(R.id.answer_four_SignOfAVictory_checkbox);
        CheckBox answer4_2=(CheckBox) findViewById(R.id.answer_four_WakaWaka_checkbox);
        CheckBox answer4_3=(CheckBox) findViewById(R.id.answer_four_WavinFlag_checkbox);
        CheckBox answerWrong=(CheckBox) findViewById(R.id.answer_four_WeAreOne_checkbox);
        if (answer4_1.isChecked()&&answer4_2.isChecked()&&answer4_3.isChecked()&&!answerWrong.isChecked()){score+=1;
        image4.setImageResource(R.drawable.right);}
        else{image4.setImageResource(R.drawable.wrong);}
    }
    private void answer_five(){
        ImageView image5=(ImageView) findViewById(R.id.image5);
        RadioButton answer5=(RadioButton) findViewById(R.id.answer_five_2026_radio_button);
        if(answer5.isChecked()){score+=1;
            image5.setImageResource(R.drawable.right);}
        else{image5.setImageResource(R.drawable.wrong);}
    }
    private void answer_six(){
        ImageView image6=(ImageView) findViewById(R.id.image6);
        CheckBox answer6_1=(CheckBox) findViewById(R.id.answer_six_Iniesta_checkbox);
        CheckBox answer6_2=(CheckBox) findViewById(R.id.answer_six_Zidane_checkbox);
        CheckBox answerWrong6_1=(CheckBox) findViewById(R.id.answer_six_Lahm_checkbox);
        CheckBox answerWrong6_2=(CheckBox) findViewById(R.id.answer_six_Buffon_checkbox);
        if (answer6_1.isChecked()&&answer6_2.isChecked()&&!answerWrong6_1.isChecked()&&!answerWrong6_2.isChecked()){score+=1;
            image6.setImageResource(R.drawable.right);}
        else{image6.setImageResource(R.drawable.wrong);}
    }
    private void answer_seven(){
        ImageView image7=(ImageView) findViewById(R.id.image7);
        RadioButton answer7=(RadioButton) findViewById(R.id.answer_seven_3_radio_button);
        if(answer7.isChecked()){score+=1;
        image7.setImageResource(R.drawable.right);}
        else {image7.setImageResource(R.drawable.wrong);}
    }
    private void answer_eight(){
        ImageView image8=(ImageView) findViewById(R.id.image8);
        EditText answer8=(EditText) findViewById(R.id.answer_eight_edit_text);
        if(answer8.getText().toString().replaceAll("\\s","").equals("11")){score+=1;
        image8.setImageResource(R.drawable.right);}
        else{image8.setImageResource(R.drawable.wrong);}
    }
    private void answer_nine(){
        ImageView image9=(ImageView) findViewById(R.id.image9);
        RadioButton answer9=(RadioButton) findViewById(R.id.answer_nine_Senegal_radio_button);
        if(answer9.isChecked()){score+=1;
        image9.setImageResource(R.drawable.right); }
        else{image9.setImageResource(R.drawable.wrong);}
    }
    private void answer_ten(){
        ImageView image10=(ImageView) findViewById(R.id.image10);
        EditText answer10=(EditText) findViewById(R.id.answer_ten);
        if(answer10.getText().toString().equals("16")){score+=1;
            image10.setImageResource(R.drawable.right);}
        else{image10.setImageResource(R.drawable.wrong);}
    }
    public void sendEmail(View view){
        if(message.equals("")){TextView showResult=(TextView) findViewById(R.id.result_text);
        showResult.setText("Press SUBMIT and try again");}
        else{
            //EMAIL LINKING WITH GMAIL OR OTHER EMAIL APP
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT,"FIFA World Cup Quiz Result of "+name);//subject line
            intent.putExtra(Intent.EXTRA_TEXT,""+message);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
    }
    public void reset(View view){
        message="";
        name="";
        score=0;

        EditText eText=(EditText) findViewById(R.id.name_edit_text);
        eText.setText("");
        EditText eText2=(EditText) findViewById(R.id.answer_one);
        eText2.setText("");
        EditText eText3=(EditText) findViewById(R.id.answer_three);
        eText3.setText("");
        EditText eText4=(EditText) findViewById(R.id.answer_eight_edit_text);
        eText4.setText("");
        EditText eText5=(EditText) findViewById(R.id.answer_ten);
        eText5.setText("");

        ImageView image1=(ImageView) findViewById(R.id.image1);
        image1.setImageDrawable(null);
        ImageView image2=(ImageView) findViewById(R.id.image2);
        image2.setImageDrawable(null);
        ImageView image3=(ImageView) findViewById(R.id.image3);
        image3.setImageDrawable(null);
        ImageView image4=(ImageView) findViewById(R.id.image4);
        image4.setImageDrawable(null);
        ImageView image5=(ImageView) findViewById(R.id.image5);
        image5.setImageDrawable(null);
        ImageView image6=(ImageView) findViewById(R.id.image6);
        image6.setImageDrawable(null);
        ImageView image7=(ImageView) findViewById(R.id.image7);
        image7.setImageDrawable(null);
        ImageView image8=(ImageView) findViewById(R.id.image8);
        image8.setImageDrawable(null);
        ImageView image9=(ImageView) findViewById(R.id.image9);
        image9.setImageDrawable(null);
        ImageView image10=(ImageView) findViewById(R.id.image10);
        image10.setImageDrawable(null);

        TextView tText=(TextView) findViewById(R.id.result_text);
        tText.setText("");

        RadioGroup rGroup1=(RadioGroup) findViewById(R.id.radio_group1);
        rGroup1.clearCheck();
        RadioGroup rGroup2=(RadioGroup) findViewById(R.id.radio_group2);
        rGroup2.clearCheck();
        RadioGroup rGroup3=(RadioGroup) findViewById(R.id.radio_group3);
        rGroup3.clearCheck();
        RadioGroup rGroup4=(RadioGroup) findViewById(R.id.radio_group4);
        rGroup4.clearCheck();

        CheckBox cBox1=(CheckBox) findViewById(R.id.answer_six_Buffon_checkbox);
        cBox1.setChecked(false);
        CheckBox cBox2=(CheckBox) findViewById(R.id.answer_six_Iniesta_checkbox);
        cBox2.setChecked(false);
        CheckBox cBox3=(CheckBox) findViewById(R.id.answer_six_Lahm_checkbox);
        cBox3.setChecked(false);
        CheckBox cBox4=(CheckBox) findViewById(R.id.answer_six_Zidane_checkbox);
        cBox4.setChecked(false);
        CheckBox cBox5=(CheckBox) findViewById(R.id.answer_four_WakaWaka_checkbox);
        cBox5.setChecked(false);
        CheckBox cBox6=(CheckBox) findViewById(R.id.answer_four_WavinFlag_checkbox);
        cBox6.setChecked(false);
        CheckBox cBox7=(CheckBox) findViewById(R.id.answer_four_WeAreOne_checkbox);
        cBox7.setChecked(false);
        CheckBox cBox8=(CheckBox) findViewById(R.id.answer_four_SignOfAVictory_checkbox);
        cBox8.setChecked(false);    }

}
