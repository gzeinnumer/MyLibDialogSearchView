package com.gzeinnumer.mylibsearchviewdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gzeinnumer.mylibsearchviewdialog.constant.ButtonStyle;
import com.gzeinnumer.mylibsearchviewdialog.dialog.searchViewDialog.SearchViewDialogOldOld;
import com.gzeinnumer.mylibsearchviewdialog.dialog.searchViewDialogNew.SearchViewDialog;
import com.gzeinnumer.mylibsearchviewdialog.model.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listString.add("Lorem ipsum dolor");
        listString.add("sit amet, consectetur");
        listString.add("adipiscing elit, sed do");
        listString.add("eiusmod tempor");
        listString.add("incididunt ut labore et dolore");
        listString.add("magna aliqua");
        listString.add("Ut enim ad minim veniam, quis nostrud exercitation");
        listString.add("ullamco laboris nisi ut aliquip");
        listString.add("ex ea commodo consequat.");
        listString.add("Duis aute irure dolor");
        listString.add("in reprehenderit");
        listString.add("in voluptate");
        listString.add("velit esse cillum dolor");

        initOnClick();
    }

    Button btn;
    TextView tv;

    private void initOnClick() {
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv_title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //choise 1
//                initDialogSingle();
//                initDialogMulti();
//                initDialogSingleCustom();
//                initDialogMultiCustom();
//                initDialogSingleEgi10();
//                initDialogSingleGZeinNumer();
                initDialogSingleGZeinNumer2();
            }
        });
    }

    private static final String TAG = "Main_Activity";

    private void initDialogSingle() {
        new SearchViewDialogOldOld(getSupportFragmentManager(), listString)
                .setTitle("ini title")
                .setContent("ini content")
                .setButtonStyle(ButtonStyle.ButtonContained)
                .setButtonColor(R.color.amber_200)
                .onOkPressedCallBackSingle(new SearchViewDialogOldOld.OnOkPressedSingle() {
                    @Override
                    public void onOkSingle(int position, String value) {
                        String temp = "Single Select :\n\n";
                        temp = temp+"position on list => "+position+"\n";
                        temp = temp+"value on list => "+value+"\n";

                        tv.setText(temp);
                        Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialogOldOld.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void initDialogMulti() {
        new SearchViewDialogOldOld(getSupportFragmentManager(), listString)
                .enableFullScreen()
                .setTitle("ini title")
                .setContent("ini content")
                .onOkPressedCallBackMulti(new SearchViewDialogOldOld.OnOkPressedMulti(){
                    @Override
                    public void onOkMulti(List<SearchViewModel> data) {
                        String temp = "Multi Select :\n";
                        temp = temp + "Total Data => "+data.size()+"\n\n";
                        for (SearchViewModel d: data){
                            temp = temp + "position on list => "+d.getPosition()+"\n";
                            temp = temp + "value on list => "+d.getName()+"\n\n";
                        }
                        tv.setText(temp);
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialogOldOld.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void initDialogSingleCustom() {
        new SearchViewDialogOldOld(getSupportFragmentManager(), listString)
                .setCanvasWidth(1.0)
                .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_corner_2))

                .setTitle("ini title")
                .setTitleSize(21)
                .setTitleColor(getResources().getColor(R.color.colorAccent))
//                .setTitleColor(Color.parseColor("#03DAC5"))
                .setTitleAlignment(View.TEXT_ALIGNMENT_TEXT_END)

                .setContent("ini content")
                .setContentSize(21)
                .setContentColor(getResources().getColor(R.color.colorAccent))
//                .setContentColor(Color.parseColor("#03DAC5"))
                .setContentAlignment(View.TEXT_ALIGNMENT_TEXT_END)

                .setBtnCancelTitle("Batal")
                .setBtnCancelTitleColor(getResources().getColor(R.color.colorAccent))
//                .setBtnCancelTitleColor(Color.parseColor("#03DAC5"))
                .setCancelIconLeft(R.drawable.ic_baseline_add_24)
                .setCancelIconTop(R.drawable.ic_baseline_add_24)
                .setCancelIconRight(R.drawable.ic_baseline_add_24)
                .setCancelIconBottom(R.drawable.ic_baseline_add_24)

                .setBtnOkTitle("Yuhuu")
                .setBtnOkTitleColor(getResources().getColor(R.color.colorAccent))
//                .setBtnOkTitleColor(Color.parseColor("#03DAC5"))
                .setOkIconLeft(R.drawable.ic_baseline_add_24)
                .setOkIconTop(R.drawable.ic_baseline_add_24)
                .setOkIconTop(R.drawable.ic_baseline_add_24)
                .setOkIconBottom(R.drawable.ic_baseline_add_24)

                .setButtonTextSize(21)
                .setButtonStyle(ButtonStyle.ButtonOutlined)
                .setButtonGravity(Gravity.CENTER)
                .setButtonColor(R.color.amber_200)

                .setTextSearchSize(30)
                .setTextSearchColor(getResources().getColor(R.color.colorAccent))
//                .setTextSearchColor(Color.parseColor("#03DAC5"))

                .setContentListHeight(900)

                .setTextListSize(30)
                .setTextListColor(getResources().getColor(R.color.colorAccent))
//                .setTextListColor(Color.parseColor("#03DAC5"))

                .onOkPressedCallBackSingle(new SearchViewDialogOldOld.OnOkPressedSingle() {
                    @Override
                    public void onOkSingle(int position, String value) {
                        String temp = "Single Select :\n\n";
                        temp = temp+"position on list => "+position+"\n";
                        temp = temp+"value on list => "+value+"\n";

                        tv.setText(temp);
                        Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialogOldOld.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }

    private void initDialogMultiCustom() {
        new SearchViewDialogOldOld(getSupportFragmentManager(), listString)
                .setCanvasWidth(1.0)
                .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_corner_2))

                .setTitle("ini title")
                .setTitleSize(21)
                .setTitleColor(getResources().getColor(R.color.colorAccent))
//                .setTitleColor(Color.parseColor("#03DAC5"))
                .setTitleAlignment(View.TEXT_ALIGNMENT_TEXT_END)

                .setContent("ini content")
                .setContentSize(21)
                .setContentColor(getResources().getColor(R.color.colorAccent))
//                .setContentColor(Color.parseColor("#03DAC5"))
                .setContentAlignment(View.TEXT_ALIGNMENT_TEXT_END)

                .setBtnCancelTitle("Batal")
                .setBtnCancelTitleColor(getResources().getColor(R.color.colorAccent))
//                .setBtnCancelTitleColor(Color.parseColor("#03DAC5"))
                .setCancelIconLeft(R.drawable.ic_baseline_add_24)
                .setCancelIconTop(R.drawable.ic_baseline_add_24)
                .setCancelIconRight(R.drawable.ic_baseline_add_24)
                .setCancelIconBottom(R.drawable.ic_baseline_add_24)

                .setBtnOkTitle("Yuhuu")
                .setBtnOkTitleColor(getResources().getColor(R.color.colorAccent))
//                .setBtnOkTitleColor(Color.parseColor("#03DAC5"))
                .setOkIconLeft(R.drawable.ic_baseline_add_24)
                .setOkIconTop(R.drawable.ic_baseline_add_24)
                .setOkIconTop(R.drawable.ic_baseline_add_24)
                .setOkIconBottom(R.drawable.ic_baseline_add_24)

                .setButtonTextSize(21)
                .setButtonStyle(ButtonStyle.ButtonOutlined)
                .setButtonGravity(Gravity.CENTER)

                .setTextSearchSize(30)
                .setTextSearchColor(getResources().getColor(R.color.colorAccent))
//                .setTextSearchColor(Color.parseColor("#03DAC5"))

                .setContentListHeight(900)

                .setTextListSize(30)
                .setTextListColor(getResources().getColor(R.color.colorAccent))
//                .setTextListColor(Color.parseColor("#03DAC5"))

                .onOkPressedCallBackMulti(new SearchViewDialogOldOld.OnOkPressedMulti(){
                    @Override
                    public void onOkMulti(List<SearchViewModel> data) {
                        String temp = "Multi Select :\n";
                        temp = temp + "Total Data => "+data.size()+"\n\n";
                        for (SearchViewModel d: data){
                            temp = temp + "position on list => "+d.getPosition()+"\n";
                            temp = temp + "value on list => "+d.getName()+"\n\n";
                        }
                        tv.setText(temp);
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialogOldOld.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void initDialogSingleEgi10() {
        ArrayList<ExampleModel> listObject = new ArrayList<>();
        listObject.add(new ExampleModel(1, "Zein", "Balbar"));
        listObject.add(new ExampleModel(2, "Zein2", "Balbar2"));
        listObject.add(new ExampleModel(3, "Zein3", "Balbar3"));
        listObject.add(new ExampleModel(4, "Zein4", "Balbar4"));

        String[] arrayString = {"M", "Fadli", "Zein"};
        new SearchViewDialogOldOld(getSupportFragmentManager(),listString)
//                .setItems(listString)
//                .setItems(listObject)
//                .setItems(arrayString)
                .setTitle("ini title")
                .setContent("ini content")
                .setButtonStyle(ButtonStyle.ButtonContained)
                .setButtonColor(R.color.amber_200)
                .onOkPressedCallBackSingle(new SearchViewDialogOldOld.OnOkPressedSingle() {
                    @Override
                    public void onOkSingle(int position, String value) {
                        String temp = "Single Select :\n\n";
                        temp = temp+"position on list => "+position+"\n";
                        temp = temp+"value on list => "+value+"\n";

                        tv.setText(temp);
                        Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialogOldOld.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }


    private void initDialogSingleGZeinNumer() {

        String[] arrayString = {"M", "Fadli", "Zein"};
        new SearchViewDialog<String>(getSupportFragmentManager())
                .setItems(arrayString)
                .setTitle("ini title")
                .setContent("ini content")
                .setButtonStyle(ButtonStyle.ButtonContained)
                .onOkPressedCallBackSingle(new SearchViewDialog.OnOkPressedSingle<String>() {
                    @Override
                    public void onOkSingle(String data) {
                        String temp = "Single Select : \n"+data.toString();
                        tv.setText(temp);
                    }
                })
                .onOkPressedCallBackMulti(new SearchViewDialog.OnOkPressedMulti<String>() {
                    @Override
                    public void onOkMulti(List<String> data) {
                        String temp = "Multi Select :\n";
                        temp = temp + "Total Data => "+data.size()+"\n\n";
                        for (String d: data){
                            temp = temp + "Value => "+ d +"\n";
                        }
                        tv.setText(temp);
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }



    private void initDialogSingleGZeinNumer2() {
        ArrayList<ExampleModel> listObject = new ArrayList<>();
        listObject.add(new ExampleModel(1, "Zein", "Balbar"));
        listObject.add(new ExampleModel(2, "Zein2", "Balbar2"));
        listObject.add(new ExampleModel(3, "Zein3", "Balbar3"));
        listObject.add(new ExampleModel(4, "Zein4", "Balbar4"));

        new SearchViewDialog<ExampleModel>(getSupportFragmentManager())
                .setItems(listObject)
                .setTitle("ini title")
                .setContent("ini content")
                .setButtonStyle(ButtonStyle.ButtonContained)
                .onOkPressedCallBackSingle(new SearchViewDialog.OnOkPressedSingle<ExampleModel>() {
                    @Override
                    public void onOkSingle(ExampleModel data) {
                        String temp = "Single Select : \n"+data.toString();
                        tv.setText(temp);
                    }
                })
                .onOkPressedCallBackMulti(new SearchViewDialog.OnOkPressedMulti<ExampleModel>() {
                    @Override
                    public void onOkMulti(List<ExampleModel> data) {
                        String temp = "Multi Select :\n";
                        temp = temp + "Total Data => "+data.size()+"\n\n";
                        for (ExampleModel d: data){
                            temp = temp + "Value => "+d.getName()+"\n";
                            temp = temp + "Value => "+d.getAddress()+"\n";
                        }
                        tv.setText(temp);
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}