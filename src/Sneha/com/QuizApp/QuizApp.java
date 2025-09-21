package Sneha.com.QuizApp;

import java.util.*;

class Question
{
      String questionText;
      List<String> options;
      int correctOptionIndex;
      
      public Question(String questionText, List<String> options, int correctOptionIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctOptionIndex = correctOptionIndex;
      }
}

class Quiz {
      String topic;
      List<Question> questions;
      
      public Quiz(String topic) {
            this.topic = topic;
            this.questions = new ArrayList<>();
      }
      
      public void addQuestion(Question q) {
            questions.add(q);
      }
      
      public void takeQuiz(Scanner scanner) {
            int score = 0;
            System.out.println("\nStarting Sneha.com.QuizApp.Quiz on: " + topic);
            for (int i = 0; i < questions.size(); i++) {
                  Question q = questions.get(i);
                  System.out.println((i + 1) + ". " + q.questionText);
                  for (int j = 0; j < q.options.size(); j++) {
                        System.out.println("   " + (j + 1) + ") " + q.options.get(j));
                  }
                  System.out.print("Your answer: ");
                  int userAnswer = scanner.nextInt();
                  if (userAnswer == q.correctOptionIndex + 1) {
                        System.out.println("Correct!\n");
                        score++;
                  } else {
                        System.out.println("Wrong! Correct answer: " + q.options.get(q.correctOptionIndex) + "\n");
                  }
            }
            System.out.println("Sneha.com.QuizApp.Quiz Completed! Score: " + score + "/" + questions.size());
      }
}

public class QuizApp {
      static Map<String, Quiz> quizMap = new HashMap<>();
      static Scanner scanner = new Scanner(System.in);
      
      public static void main(String[] args) {
            System.out.println("Welcome to Sneha.com.QuizApp.Quiz Generator!");
            while (true) {
                  System.out.println("\nAvailable commands:");
                  System.out.println("Press 1 for create-quiz");
                  System.out.println("Press 2 for add-question");
                  System.out.println("Press 3 for take-quiz");
                  System.out.println("Press 4 for exit");
                  System.out.print("\nEnter command: ");
                  int command = scanner.nextInt();
                  scanner.nextLine();
                  
                  switch (command) {
                        case 1:
                              createQuiz();
                              break;
                        case 2:
                              addQuestion();
                              break;
                        case 3:
                              takeQuiz();
                              break;
                        case 4:
                              System.out.println("Goodbye!");
                              return;
                        default:
                              System.out.println("Invalid command!");
                  }
            }
      }
      
      private static void createQuiz() {
            System.out.print("Enter quiz topic name: ");
            String topic = scanner.nextLine();
            if (quizMap.containsKey(topic)) {
                  System.out.println("Sneha.com.QuizApp.Quiz already exists.");
            } else {
                  quizMap.put(topic, new Quiz(topic));
                  System.out.println("Sneha.com.QuizApp.Quiz created successfully.");
            }
      }
      
      private static void addQuestion() {
            System.out.print("Enter quiz topic name to add questions: ");
            String topic = scanner.nextLine().trim();
            
            if (!quizMap.containsKey(topic)) {
                  System.out.println("Sneha.com.QuizApp.Quiz not found.");
                  return;
            }
            
            while (true) {
                  System.out.print("Enter question (or type 'done' to stop adding questions): ");
                  String questionText = scanner.nextLine().trim();
                  
                  if (questionText.equalsIgnoreCase("done")) {
                        System.out.println("Stopped adding questions to quiz: " + topic);
                        break;
                  }
                  
                  List<String> options = new ArrayList<>();
                  int n = 0;
                  
                  // Read number of options safely
                  while (true) {
                        System.out.print("How many options you want to add = ");
                        try {
                              n = scanner.nextInt();
                              scanner.nextLine(); // Consume newline
                              if (n < 2) {
                                    System.out.println("Please enter at least 2 options.");
                                    continue;
                              }
                              break;
                        } catch (InputMismatchException e) {
                              System.out.println("Invalid number. Please enter a valid integer.");
                              scanner.nextLine(); // Clear invalid input
                        }
                  }
                  
                  // Add options
                  for (int i = 1; i <= n; i++) {
                        System.out.print("Enter option " + i + ": ");
                        String option = scanner.nextLine();
                        options.add(option);
                  }
                  
                  // Get correct option safely
                  int correctOption = -1;
                  while (true) {
                        System.out.print("Enter correct option number (1-" + n + "): ");
                        try {
                              correctOption = Integer.parseInt(scanner.nextLine().trim()) - 1;
                              if (correctOption < 0 || correctOption >= n) {
                                    System.out.println("Invalid option number. Try again.");
                                    continue;
                              }
                              break;
                        } catch (NumberFormatException e) {
                              System.out.println("Please enter a valid number.");
                        }
                  }
                  
                  quizMap.get(topic).addQuestion(new Question(questionText, options, correctOption));
                  System.out.println("Sneha.com.QuizApp.Question added to quiz.\n");
            }
      }
      
      
      
      private static void takeQuiz() {
            System.out.print("Enter quiz topic name: ");
            String topic = scanner.nextLine();
            if (!quizMap.containsKey(topic)) {
                  System.out.println("Sneha.com.QuizApp.Quiz not found.");
            } else {
                  quizMap.get(topic).takeQuiz(scanner);
            }
      }
}
