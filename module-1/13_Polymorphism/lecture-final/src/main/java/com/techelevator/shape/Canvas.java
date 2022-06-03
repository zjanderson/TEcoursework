package com.techelevator.shape;

public class Canvas {

    public void render(Drawable[] drawables) {
        for(Drawable item : drawables) {
            item.draw();
        }
    }

    public void renderStuff(){
        Dog myDog = new Dog();
        Circle myCircle = new Circle();

        Drawable[] array = new Drawable[] { myDog, myCircle };
        render(array);
    }
}
