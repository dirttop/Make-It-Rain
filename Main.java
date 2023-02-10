
class Main {
  private static final int HEIGHT = 10, WIDTH = 40;
  //creates constant variables for height and width

  public static void main(String[] args) {
    //initalizes number objects and tally array
    int[] tally = new int[WIDTH];
    Number[] numbers = new Number[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = new Number(WIDTH);
    }
    //calls the constructer for every number object
    for (int i = 0; i < numbers.length; i++) {
      numbers[i].reset(numbers);
    }
    //makes sure that the number object is created properly without overlap

    while (true) { 
      for (int y = 0; y < HEIGHT; y++) {
        System.out.print("\n");
        for (int x = 0; x < WIDTH; x++) {
          boolean printed = false;
          for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].getX() == x && numbers[i].getY() == y) {
              numbers[i].display();
              printed = true;
            } 
          }
          if (!printed) {
              System.out.print(" ");
          }
        }
      }
      //creates empty grid, and checks to see if number object occupies the position of an empty space. Then displays.
      System.out.print("\n");
      for (int i = 0; i < WIDTH; i++) {
        System.out.print("-");
      }
      System.out.print("\n");
      for (int i = 0; i < WIDTH; i++) {
        System.out.print(tally[i]);
      }
      //displays the tally array

      for (int i = 0; i < numbers.length; i++) {
        //System.out.print("\n\n");
        //System.out.println(numbers[i]);
        //uncomment for number object x and y coordinates
        numbers[i].fall();
        int numx = numbers[i].getX();
        if (numbers[i].getY() > HEIGHT) {
          if (tally[numx] < 9) {
            tally[numx] = tally[numx] + numbers[i].getValue();
            if (tally[numx] > 9) {
              tally[numx] = 9;
            }
          }
          numbers[i].reset(numbers);
        }
      }
      //This for loop runs the logic for tally addition, making sure that the tally isn't over 9 as well as reseting the number once it contributes to the tally. It also is what makes the numbers fall.

      pause();
      clear();
    }
  }

  public static void testNumber() {
    for (int i = 0; i < 10000; i++) {
      Number n = new Number(WIDTH);
      if (n.getX() > (WIDTH - 1)) {
        System.err.println("Test failed: " + n);
      }
    }
  }
  //Used to troubleshoot the code

  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void pause() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
  }

};