package com.example.oleg.slovo2;

/*
Activity — это та часть приложения, с которой взаимодействует пользователь.
Можно назвать ее «окном» в терминологии десктопных ОС (хотя фактически это не окно, Window в андроиде тоже есть, но с ним мало кто из разработчиков сталкивался).
Внутри Activity расположены дочерние элементы интерфейса.

 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;




public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout bt1;
    RelativeLayout bt2;
    RelativeLayout bt3;
    RelativeLayout bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // Изменяет заголовок окна
        setTitle("Выберите тему");

        // findViewById - возвращает элемент типа View
        // Этот тип явл. основным для всех GUI-элементов
        // Инициализируем кнопки
        bt1 = (RelativeLayout) findViewById(R.id.bt1);
        bt2 = (RelativeLayout) findViewById(R.id.bt2);
        bt3 = (RelativeLayout) findViewById(R.id.bt3);
        bt4 = (RelativeLayout) findViewById(R.id.bt4);

        // Добавляем обработчик на нажатие кнопки
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

    }

    // Метод, который будет вызываться тогда, когда произошла нажатие на кнопку
    @Override
    public void onClick(View view) {
        // Получаем id элемента, на который нажали
        int viewId = view.getId();

        // Определяем, какая кнопка была нажата
        switch (viewId) {
            case R.id.bt1:
                Data.num = 0;
                break;
            case R.id.bt2:
                Data.num = 1;
                break;
            case R.id.bt3:
                Data.num = 2;
                break;
            case R.id.bt4:
                Data.num = 3;
                break;
        }

        // Создаём намерение на запуск другого Activity
        Intent intent = new Intent(this, DictionaryActivity.class);

        // Запускаем другое Activity
        startActivity(intent);
    }
}


