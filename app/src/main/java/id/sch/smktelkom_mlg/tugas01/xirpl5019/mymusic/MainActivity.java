package id.sch.smktelkom_mlg.tugas01.xirpl5019.mymusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements
        CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    EditText etTahun;
    RadioGroup rgJK;
    Spinner spKota;
    CheckBox cb1, cb2, cb3, cb4;
    Button bOk;
    TextView tvHasil, tvMusik;
    int nMusik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextUmur);
        rgJK = (RadioGroup) findViewById(R.id.RadioGroupJk);
        spKota = (Spinner) findViewById(R.id.spinner);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        bOk = (Button) findViewById(R.id.button);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvMusik = (TextView) findViewById(R.id.textViewMusik);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String hasil = null;
        String asal = spKota.getSelectedItem().toString();
        String musik = "\nAlat musik           : ";

        int startlen = musik.length();
        if (cb1.isChecked()) musik += cb1.getText() + ",";
        if (cb2.isChecked()) musik += cb2.getText() + ",";
        if (cb3.isChecked()) musik += cb3.getText() + ",";
        if (cb4.isChecked()) musik += cb4.getText();
        if (musik.length() == startlen) musik += "Anda belum memilih alat musik";

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
        } else {
            etNama.setError(null);
        }

        if (tahun.isEmpty()) {
            etTahun.setError("Umur Belum Diisi");
        } else if (tahun.length() > 2) {
            etTahun.setError("Format Umur Salah");
        } else {
            etTahun.setError(null);
        }

        tvHasil.setText("\n------- MY MUSIC -------" + "\n\nSelamat anda telah terdaftar dengan data sebagai berikut : " + "\n\nNama                   : " + nama
                + "\nUmur                    : " + tahun + " tahun" + "\nJenis Kelamin     : " + hasil + "\nAsal Kota            : "
                + asal + musik);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nMusik += 1;
        else nMusik -= 1;
        tvMusik.setText("Alat Musik (" + nMusik + " terpilih)");
    }
}
