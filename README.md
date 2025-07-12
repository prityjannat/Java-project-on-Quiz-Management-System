# Java-project-on-Quiz-Management-System
### 👩‍💻 Author: Afrina Jannat Prity
### 🧩 Project Description
The Quiz Management System is a simple Java-based console application that simulates a quiz platform with role-based user access. It supports two types of users:
- Admin – Responsible for creating and managing quiz questions (MCQs).
- Student – Can participate in quizzes and receive performance scores.
This system uses JSON files for storing user credentials and quiz data, eliminating the need for any external database. It is especially useful as an educational tool for practicing MCQs, particularly in Software Quality Assurance (SQA) topics.

### 🔐 Role-Based Login Flow
- Admin Login:
    The admin logs in using predefined credentials and can add questions to the question bank. After entering a question and four options, the admin specifies the correct answer using an answer key (1 to 4). Admin can continuously add questions until pressing 'q' to quit.
- Student Login:
    After logging in, the student is presented with a quiz containing 10 randomly selected MCQs from the question bank. Students earn 1 mark per correct answer, with no negative marking. After the quiz, the system displays the student’s score and performance feedback.

### 🗃️ Data Persistence

- users.json - 
    Stores user credentials and their roles (admin or student).

    [
          { "username": "admin", "password": "1234", "role": "admin" },
          { "username": "salman", "password": "1234", "role": "student" }
    ]

- quiz.json - 
Stores the multiple-choice questions with options and answer key.

  [
        {
          "question": "Which is not part of system testing?",
          "option 1": "Regression Testing",
          "option 2": "Sanity Testing",
          "option 3": "Load Testing",
          "option 4": "Unit Testing",
        "answerkey": 4
        }
  ]

### 🧾 Quiz Scoring Criteria
At the end of each quiz, the system evaluates the student’s performance:
Score Range	Feedback Message - 
- 8–10 -->	Excellent!
- 5–7	 -->  Good
- 3–4	 -->  Very Poor
- 0–2	 -->  Very sorry, you are failed.

### 🛠️ Admin Features
    * Secure login using JSON-based credentials
    * Add multiple MCQs with four options and answer key
    * Add questions continuously until 'q' is pressed
    * Questions saved in real-time to quiz.json

### 🧑‍🎓 Student Features
    * Login using a predefined student account
    * Quiz contains 10 randomly selected MCQs
    * One mark per correct answer
    * Feedback displayed based on final score
    * Option to restart quiz or quit

### 🧠 Technologies Used
    Java (Console-based)
    Gradle (for build automation)
    JSON (data persistence)
    Console I/O (Scanner for input/output)

### 🎥 Demo Video
https://drive.google.com/file/d/1pyYq6TWV_wqrMlrDjlBK6WWIKy7Lq0bi/view?usp=sharing 





