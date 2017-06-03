package com.common.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.huawei.ormlite.sample.db.dao.StudentProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneToOneTest();
    }

    public void oneToOneTest(){
        String names[]={"李小龙","王宝强","李连杰","习近平","李克强","马云","赵刚"};
        String lovers[]={"苍老师","机器人","范冰冰","李冰冰","小冰冰","大冰冰","水冰冰"};
        StudentProvider dao = new StudentProvider(this);

        Random rnd = new Random();
        List<Student> studentList = new ArrayList<Student>();
        List<Student> loverList = new ArrayList<Student>();
        for(int i =0; i<5; i++){

            Student lover = new Student();
            lover.setAddr("深圳市龙华新区宝能科技园<"+3*i+">楼.");
            lover.setAge(15+rnd.nextInt(20));
            lover.setName(lovers[i]);

            Student student = new Student();
            student.setAddr("深圳市龙华新区宝能科技园<"+i+">楼.");
            student.setAge(15+rnd.nextInt(20));
            student.setName(names[i]);

            student.setLovers(lover);
            lover.setLovers(student);

            studentList.add(student);
            loverList.add(lover);
        }

        //List<Student> exist= dao.queryForAll();
        //boolean result = dao.delete(exist);
        //System.out.println("delete all exist items:"+result);

        //只插入所有的学生数据，然后再查询看看学生的伴侣数据，是否也插入到数据库了.
        dao.insert(studentList);
        dao.insert(loverList);

        //查出所有学生的数据;
        List<Student> listStudent= dao.queryForAll();
        for(Student stu: listStudent){
            System.out.println(stu.getName()+"->学生:"+stu.getId()+",姓名:"+stu.getAddr());
            Student lover = stu.getLovers();
            if(lover != null){
                int count = dao.refresh(lover);
                System.out.println(stu.getName()+"的情侣是:"+" ID:"+lover.getId()+lover.getName());
            }
        }
    }
}
