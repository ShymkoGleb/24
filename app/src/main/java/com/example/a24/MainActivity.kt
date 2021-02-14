package com.example.a24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a24.a1_DataSource.Repository.impl.UserPost_Datasorce_Impl
import com.example.a24.a1_DataSource.Source.Exe.UsersPost_FromJson_Exe
/*Додаток, де можна переглядати пости, які отримуються по цьому запиту:
https://jsonplaceholder.typicode.com/posts
На UI потрібно показувати userId, title, body. Дизайн на ваш розсуд.
Повинно також бути сховище даних, де будуть зберігатись id юзерів, у яких є “попередження” або “бан”.
В додатку повинно бути захардкоджено, що userId 3 та 4 є попередження. А у userId 7— бан.

Якщо у юзера “бан”, то замість КОЖНОГО його посту на ui повинні показуватися view, де буде написано, що “Тут міг бути пост юзера $userId, але він забанений”.
Якщо у юзера “попередження”, то після id юзера на ui повинен бути текст “З попередженням”, а фон всього посту повинен відрізнятись від фону постів юзерів, у яких немає попередження.
Наприклад, у звичайних постів білий фон, а у тих, що з попередженням — червоний.
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }
}