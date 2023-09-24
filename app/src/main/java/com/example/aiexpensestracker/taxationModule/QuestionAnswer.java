package com.example.aiexpensestracker.taxationModule;

public class QuestionAnswer {

    public static String question[] ={
            "What is the deadline for submitting your Income Tax Return Form (ITRF) in Malaysia?",
            "What is the deadline for payment of income tax in Malaysia?",
            "Which of the following income sources are taxable in Malaysia?",
            "Which tax form is used to file income tax returns in Malaysia?",
            "Who is required to file income tax returns in Malaysia?"
    };

    public static String choices[][] = {
            {"January 31st","February 28th","April 30th","July 31st"},
            {"April 30th","May 31st","June 30th","July 31st"},
            {"Employment income","Rental income","Business income","All of the above"},
            {"Form E","Form P","Form M","Form B"},
            {"Only employees", "Only business owners", "All individuals earning income", "Only retirees"}
    };

    public static String correctAnswers[] = {
            "April 30th",
            "June 30th",
            "All of the above",
            "Form B",
            "All individuals earning income"
    };

}