/**
 * This class encapsulates the student's record. 
 *
 * @author Ranjana Rajagopalan
 * @version 10/13/21
 */
public class studentRecord
{
    String name, letterGrade; 
    double quiz1, quiz2, quiz3, midterm, finalExam; // input comes from user
    double numericScore; // calculated based on user input
    
    /**
     * Constructor for objects of class studentRecord
     */
    public studentRecord(String name, double quiz1, double quiz2, double quiz3, double midterm, double finalExam)
    {
        this.name = name;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.midterm = midterm;
        this.finalExam = finalExam;
        numericScore = 0;
        letterGrade = "";
    }
    
    /**
     * Accessor method that returns the student's name. 
     */
    public String getStudentName() {
        return name;
    }
    
    /**
     * Accessor method that returns score of quiz 1. 
     */
    public double getQuiz1Score(){
        return quiz1;
    }
    
    /**
     * Accessor method that returns score of quiz 2. 
     */
    public double getQuiz2Score(){
        return quiz2;
    }
    
    /**
     * Accessor method that returns score of quiz 3. 
     */
    public double getQuiz3Score(){
        return quiz3;
    }
    
    /**
     * Accessor method that returns score of the midterm. 
     */
    public double getMidtermScore(){
        return midterm;
    }
    
    /**
     * Accessor method that returns score of the final exam. 
     */
    public double getFinalScore(){
        return finalExam;
    }
    
    /**
     * Accessor method that returns the weighted numeric score received by the student. 
     */
    public double getNumericScore(){
        return numericScore;
    }
    
    /**
     * Accessor method that returns the letter grade received by the student. 
     */
    public String getLetterGrade(){
        return letterGrade;
    }
    
    /**
     * Mutator method calculates the overall numeric score so final letter grade can be calculated. 
     */
    public void calculateNumericScore(){
        double quizMeanPercentage = (((quiz1 + quiz2 + quiz3)/ 30) * 100);
        numericScore = (0.25*quizMeanPercentage) + (0.35*midterm) + (0.4*finalExam);
    }
    
    /**
     * Mutator method calculates the final letter grade that the student received.  
     */
    public void calculateLetterGrade() {
        if (numericScore >= 90) {
            letterGrade = "A";
        }
        else if (numericScore >= 80) {
            letterGrade = "B";
        }
        else if (numericScore >= 70) {
            letterGrade = "C";
        }
        else if (numericScore >= 60) {
            letterGrade = "D";
        }
        else {
            letterGrade = "F";
        }
    }
    
    /**
     * Equals method that compares two students' records. 
     */
    public boolean equals(studentRecord otherStudent) {
        return ((name.equals(otherStudent.getStudentName())) && (letterGrade.equals(otherStudent.getLetterGrade())) && (quiz1 == otherStudent.getQuiz1Score()) &&
               (quiz2 == otherStudent.getQuiz2Score()) && (quiz3 == otherStudent.getQuiz3Score()) && (midterm == otherStudent.getMidtermScore()) && 
               (finalExam == otherStudent.getFinalScore()));
    }
    
    /**
     * Returns a String representation of the student's record including:
     * the 3 quiz scores, 2 exam scores, 
     * the overall numeric score, 
     * and the final letter grade. 
     */
    @Override
    public String toString(){
        String quizzes = ("The three quiz scores for " + name + " are: " + quiz1 + ", " + quiz2 + ", and " + quiz3 + "\n");
        String examScores = (name + "'s midterm score is: " + midterm + ", and the final exam score is: " + finalExam + "\n");
        String overallNumericScore = (name + " received an overall numeric score of " + numericScore + ", ");
        String overallLetterGrade = ("so " + name + " received a grade of " + letterGrade + " in this course.\n");
        
        return (quizzes + examScores + overallNumericScore + overallLetterGrade);
    }
}
