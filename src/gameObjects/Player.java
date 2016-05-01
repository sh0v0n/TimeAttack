package gameObjects;


import javafx.application.Platform;
import javafx.scene.input.KeyCode;

public class Player extends movableObject {
    private boolean dead;

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }

    double rightBound;
    double leftBound;
    double upperBound;
    double lowerBound;


    public Player(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius, "green");
        dead = false;
        radius = this.getRadius();
        rightBound = getCenterX() + radius;
        leftBound = getCenterX() - radius;
        upperBound = getCenterY() - radius;
        lowerBound = getCenterY() + radius;
        setSpeed(1);
        thisTherad = new Thread(this);
        thisTherad.start();
    }

    public void setSpeed(double x) {
        speed = x;
    }

    public double getSpeed() {
        return speed;
    }



    public void run() {
        while (this.isVisible()) {
            Platform.runLater(() -> {
                getScene().setOnKeyPressed(e -> {
                    //move according to key press
                    if (e.getCode().equals(KeyCode.RIGHT)) {
                        this.moveRight();
                    }

                    if (e.getCode().equals(KeyCode.LEFT)) {
                        this.moveLeft();
                    }

                    if (e.getCode().equals(KeyCode.UP)) {
                        this.moveUp();
                    }

                    if (e.getCode().equals(KeyCode.DOWN)) {
                        this.moveDown();
                    }


                });
            });

            try {
                thisTherad.sleep(1);

            } catch (Exception e) {
            }
        }
    }


}
