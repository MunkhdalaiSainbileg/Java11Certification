class Main {
  public static final String INVALID_MESSAGE = "Invalid Value";
  public static void main(String[] args) {
    boolean gameOver = true;
    int score = 800;
    int levelCompleted = 5;
    int bonus = 100;

    int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
    System.out.println("Your final score was " + highScore);

    score = 10000;
    levelCompleted = 8;
    bonus = 200;

    highScore = calculateScore(gameOver, score, levelCompleted, bonus);
    System.out.println("Your final score was " + highScore);

    // Create a method called displayHighScorePosition
    // it should a players name as a parameter, and a 2nd parameter as a position in
    // the high score table
    // You should display the players name along with a message like " managed to
    // get into position " and the
    // position they got and a further message " on the high score table".
    //
    // Create a 2nd method called calculateHighScorePosition
    // it should be sent one argument only, the player score
    // it should return an in
    // the return data should be
    // 1 if the score is >=1000
    // 2 if the score is >=500 and < 1000
    // 3 if the score is >=100 and < 500
    // 4 in all other cases
    // call both methods and display the results of the following
    // a score of 1500, 900, 400 and 50

    // displayHighScorePosition("John", calculateHighScorePosition(1500));
    // displayHighScorePosition("Daniel", calculateHighScorePosition(900));
    // displayHighScorePosition("Bat", calculateHighScorePosition(400));
    // displayHighScorePosition("George", calculateHighScorePosition(50));

    // printConversion(1.5);
    // printConversion(-2);

    // System.out.println("10.25 :" + toMilesPerHour(10.25));
    // System.out.println("-5.6 :" + toMilesPerHour(-5.6));
    // System.out.println("25.42 :" + toMilesPerHour(25.42));
    // System.out.println("75.114 :" + toMilesPerHour(75.114));

    // System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
    // System.out.println(areEqualByThreeDecimalPlaces(-3.175, -3.176));

    printSquareStar(8);
  }

  public static void displayHighScorePosition(String playerName, int position) {
    System.out.println(playerName + " managed to get into position " + position + " on the high score table");
  }

  public static int calculateHighScorePosition(int playerScore) {

    // if (playerScore >= 1000) {
    // return 1;
    // } else if (playerScore >= 500) {
    // return 2;
    // } else if (playerScore >= 100) {
    // return 3;
    // }
    // return 4;
    int position = 4;
    if (playerScore >= 1000) {
      position = 1;
    } else if (playerScore >= 500) {
      position = 2;
    } else if (playerScore >= 100) {
      position = 3;
    }
    return position;
  }

  public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

    if (gameOver) {
      int finalScore = score + (levelCompleted * bonus);
      finalScore += 2000;
      return finalScore;
    }

    return -1;

  }

  public static long toMilesPerHour(double kilometersPerHour) {
    if (kilometersPerHour < 0) {
      return -1l;
    }
    return Math.round(0.62137 * kilometersPerHour);
  }

  public static void printConversion(double kilometersPerHour) {
    long milehours = toMilesPerHour(kilometersPerHour);
    if (milehours == -1) {
      System.out.println("Invalid Value");
    }
    System.out.println(kilometersPerHour + " km/h = " + milehours + " mi/h");
  }

  public static boolean isLeapYear(int year) {
    if (year < 1 || year > 9999) {
      return false;
    }
    if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
      return true;
    }
    return false;
  }

  public static boolean areEqualByThreeDecimalPlaces(double firstParam, double secondParam) {

    long firstValue = (int)(firstParam * 1000);
    int secondValue = (int)(secondParam * 1000);

    if (firstValue == secondValue) {
      return true;
    }
    return false;
  }

  // Create a method called calcFeetAndInchesToCentimeters
  // It needs to have two parameters.
  // feet is the first parameter, inches is the 2nd parameter
  //
  // You should validate that the first parameter feet is >= 0
  // You should validate that the 2nd parameter inches is >=0 and <=12
  // return -1 from the method if either of the above is not true
  //
  // If the parameters are valid, then calculate how many centimetres
  // comprise the feet and inches passed to this method and return
  // that value.
  //
  // Create a 2nd method of the same name but with only one parameter
  // inches is the parameter
  // validate that its >=0
  // return -1 if it is not true
  // But if its valid, then calculate how many feet are in the inches
  // and then here is the tricky part
  // call the other overloaded method passing the correct feet and inches
  // calculated so that it can calculate correctly.
  // hints: Use double for your number datatypes is probably a good idea
  // 1 inch = 2.54cm  and one foot = 12 inches
  // use the link I give you to confirm your code is calculating correctly.
  // Calling another overloaded method just requires you to use the
  // right number of parameters.
  
  public static double calcFeetAndInchesToCentimeters(double feet, double inches){
    
    if(feet<0 || (inches<0 || inches>12)){
      return -1d;
    }
    double totalCentimers = (feet * 12) * 2.54 + inches*2.54;  
    
    return totalCentimers;
  }

  public static double calcFeetAndInchesToCentimeters(int inches){
    
    if(inches<0){
      return -1;
    }  
    double feet = inches/12;
    double remainingInches = inches%12;
    return calcFeetAndInchesToCentimeters(feet, remainingInches);    
  }

  public static String getDurationString (int minutes, int seconds){
    
    if(minutes <0 ||(seconds<0 || seconds>59)){
      return "Invalid value";
    }

    int hours = minutes/60;
    String hoursStr = hours+"h ";
    if(hours<10){
      hoursStr = "0"+hoursStr;
    }
    
    int remainingMinutes = minutes%60;
    String minutesStr = remainingMinutes+"m ";
    if(remainingMinutes<10){
       minutesStr = "0"+minutesStr;
    }

    String secondsStr = seconds+"s";
    if(seconds<10){
       secondsStr = "0"+secondsStr;
    }
    return hoursStr+minutesStr+secondsStr;
  }

  public static String getDurationString (int seconds){
    
    if(seconds<0){
      return INVALID_MESSAGE;
    }
    int minutes = seconds/60;
    int second = seconds%60;
    return getDurationString(minutes, second);
  }

   // write your code here
    public static int getLargestPrime(int number){
        if(number<1){
            return -1;
        }
        int counter=0;
        int largestPrimeNumber=-1;
        for(int i=1; i<=number; i++){
            if(number%i==0){
                System.out.println(" i ="+i);
                for(int k=1; k<=i; k++){
                    if(i%k==0){
                        counter++;
                    }
                }
                if(counter==2){
                    largestPrimeNumber = i;
                }
                counter=0;
                System.out.println(" largestPrimeNumber="+largestPrimeNumber);
            }
        }
        return largestPrimeNumber;
    }

    public static void printSquareStar(int number){
        if(number<5){
            System.out.println("Invalid Value");
        } else {
            for(int i=1; i<=number; i++){
                String stringstar ="";
                for(int k=1; k<=number; k++){
                    if(i==1 || i==number){
                       stringstar += "*";
                    }  else if(k==1 || k==number){
                       stringstar += "*";
                    }  else if(i==k){
                       stringstar += "*";
                    }  else if(i==(number-k)+1){
                        stringstar += "*";
                    }  else {
                       stringstar += " ";
                    }      
                }
                System.out.println(stringstar);
            }
        }
    }
  
}