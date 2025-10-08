class FizzBuzz {
    public static void main(String[] args) {

        fizzBuzz(3);
        fizzBuzz(4);
        fizzBuzz(5);
        fizzBuzz(15); 
        
    }

    // A standard FizzBuzz solution
    public static void fizzBuzz(int x){

        if ((x % 3 == 0) && (x % 5 == 0)){
            System.out.println("FizzBuzz");
        }

        else if (x % 3 == 0){
            System.out.println("Fizz");
        }

        else if (x % 5 == 0){
            System.out.println("Buzz");
        }
        else{
            System.out.println(x);
        }
    }
}