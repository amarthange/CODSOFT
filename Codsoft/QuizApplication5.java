import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;


public class QuizApplication5 {
    private static final Scanner sc = new Scanner(System.in);
    private static final int TIMEPERQUESTION = 10; 
    private static boolean ans = false;
    private static String[] userAnswers;
    private static int score = 0;
    private static int currentQuestionIndex = 0;
   

    private static class Question 
    {
        String[] options;
        String ans;
        String question;
        

        Question(String question, String[] options, String ans) 
        {
            this.question = question;
            this.options = options;
            this.ans = ans;
        }
    }

    private static final Question[] questions = {
        new Question("What is the capital of India?", 
        new String[]{"New Delhi", "Mumbai", "Kolkata", "Chennai"}, "New Delhi"),
        new Question("Who is known as the Father of the Nation in India?", 
        new String[]{"Jawaharlal Nehru", "Mahatma Gandhi", "Subhas Chandra Bose", "B. R. Ambedkar"}, "Mahatma Gandhi"),
        new Question("What is the national animal of India?", 
        new String[]{"Lion", "Tiger", "Elephant", "Peacock"}, "Tiger"),
        new Question("In which year did India gain independence?", 
        new String[]{"1945", "1946", "1947", "1948"}, "1947"),
        new Question("Which Indian city is known as the Silicon Valley of India?", 
        new String[]{"Hyderabad", "Mumbai", "Bengaluru", "Pune"}, "Bengaluru"),
        new Question("Who wrote the Indian national anthem?", 
        new String[]{"Rabindranath Tagore", "Bankim Chandra Chatterjee", "Sarojini Naidu", "Allama Iqbal"}, "Rabindranath Tagore"),
        new Question("Which is the longest river in India?", 
        new String[]{"Ganges", "Yamuna", "Godavari", "Brahmaputra"}, "Ganges"),
        new Question("Who was the first President of India?", 
        new String[]{"Dr. Rajendra Prasad", "S. Radhakrishnan", "Zakir Husain", "V. V. Giri"}, "Dr. Rajendra Prasad"),
        new Question("Which festival is known as the Festival of Lights in India?", 
        new String[]{"Holi", "Diwali", "Eid", "Christmas"}, "Diwali"),
        new Question("Which Indian state is known as the 'Land of Five Rivers'?", 
        new String[]{"Punjab", "Rajasthan", "Gujarat", "Haryana"}, "Punjab")
    };

    public static void main(String[] args) 
    {
        userAnswers = new String[questions.length];
        startQuiz();
        displayResults();
    }

    private static void startQuiz() 
    {
        for (Question question : questions) 
        {
            askQuestion(question);
            currentQuestionIndex++;
        }
    }

    private static void askQuestion(Question question) 
    {
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + question.question);
        for (int i = 0; i < question.options.length; i++) 
        {
            System.out.println((i + 1) + ". " + question.options[i]);
        }

        ans = false;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() 
            {
                if (!ans) 
                {
                    System.out.println("\nTime is up!");
                    userAnswers[currentQuestionIndex] = "No Answer";
                }
            }
        }, TIMEPERQUESTION * 1000);

        long startTime = System.currentTimeMillis();
        String userAnswer = sc.nextLine();
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;

        if (elapsedTime < TIMEPERQUESTION) {
            timer.cancel();
            ans = true;
            checkAnswer(userAnswer, question);
        } else {
            System.out.println("Time is up!");
        }
    }

    private static void checkAnswer(String userAnswer, Question question) {
        try {
            int userAnswerIndex = Integer.parseInt(userAnswer) - 1;
            if (question.options[userAnswerIndex].equals(question.ans)) 
            {
                System.out.println("Correct!");
                score++;
                userAnswers[currentQuestionIndex] = question.options[userAnswerIndex];
            } else {
                System.out.println("Wrong!");
                userAnswers[currentQuestionIndex] = question.options[userAnswerIndex];
            }
        } catch (Exception e) 
        {
            System.out.println("Invalid input!");
            userAnswers[currentQuestionIndex] = "Invalid Answer";
        }
    }

    private static void displayResults() 
    {
        System.out.println("\nQuiz Over!");
        System.out.println("Your score: " + score + "/" + questions.length);
        for (int i = 0; i < questions.length; i++) 
        {
            System.out.println("Question " + (i + 1) + ": " + questions[i].question);
            System.out.println("Your answer: " + userAnswers[i]);
            System.out.println("Correct answer: " + questions[i].ans + "\n");
        }
    }
}
