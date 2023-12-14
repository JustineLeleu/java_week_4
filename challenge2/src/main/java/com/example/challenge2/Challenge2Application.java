package com.example.challenge2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Challenge2Application {

    public static void main(String[] args) {

        System.out.println("Please enter a sentence: ");
        String[] sentences = readLine();

        ApplicationContext context = new AnnotationConfigApplicationContext(CountingSingleton.class);
        CountingSingleton counting = context.getBean(CountingSingleton.class);
        //System.out.println(counting.countWords(new String[]{"Hello this is a sentence sentence.", "This is another sentence.", "And another sentence."}));

        List<Map<String, Integer>> list = counting.countWords(sentences);
        for (int i = 0 ; i < list.size(); i++)
        {
            System.out.println(sentences[i] + ": ");
            System.out.println(list.get(i));
        }

        //Here is a sentence Sentence. Here is another! And another one sentence: Sentence ?
    }

    public static String[] readLine()
    {
        Scanner scanner = new Scanner(System.in);
        String[] test = scanner.nextLine().split("[.?!]");
        scanner.close();
        return test;
    }
}
