/**
 * Created by Java Student on 07.11.2016.
 */
import zoo.*;

public class Main {
    public static void main(String ...args) {
        //Animal animal = new Animal();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        Bear bear = new Bear();

        Animal[] animals = {tiger, lion, bear};

        for (int i = 0; i < animals.length; i++) {
            animals[i].makeNoise();
        }

        bear.eatFood(Food.MEAT);
    }
}
