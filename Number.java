class Number{
  private int value, x, y;
  private final int w;

  Number(int w){
    this.w = w;
    //constructer is used to create a pointer from the WIDTH to w.
  }
  
  public void display(){
    System.out.print(value);
    //displays the number
  }
  
  public void fall(){
    y = y+1;
    //makes the numbers fall
  }
  
  public void reset(Number[] numbers){
    do {
      reset();
    } while (isColliding(numbers));
    //Makes sure that the numbers are not colliding, if they are a number object resets.
  }

  private boolean isColliding(Number[] numbers) {
    for(int i = 0; i < numbers.length; i++) {
      if (numbers[i] != this && this.x == numbers[i].getX() && this.y == numbers[i].getY()) {
        return true;
      }
    }  
    return false;
  }
  //colliding logic
  
  private void reset() {
    x = (int)(w * Math.random()); 
    y = 1 + (int)(-5 * Math.random()); 
    value = (int)(3 * Math.random());
  }
  //resets variables randomly
  
  public int getX(){
    return(x);
  }
  
  public int getY(){
    return(y);
  }
  
  public int getValue(){
    return(value);
  }

  //getter methods

  @Override
  public String toString() {
    return "Number(x=" + x + "; y=" + y + "; value=" + value;
  }
  //used for troubleshooting
}