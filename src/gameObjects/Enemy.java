package gameObjects;

import scenes.GameScene;

public abstract class Enemy extends MovableObject {
    protected boolean horizontalDirection;
    protected boolean verticalDirection;
    Player player;
    Coin coin;

    public Enemy(double centerX, double centerY, double radius, String color, Player player, Coin coin) {
        super(centerX, centerY, radius, color);
        this.player = player;
        this.coin = coin;
    }

    public synchronized void resume() {
        GameScene.isPaused = false;
        notify();
    }


    public void setHorizontalDirection(boolean direction){
        horizontalDirection = direction;
    }
    public void setVerticalDirection(boolean direction){
        verticalDirection = direction;
    }
}
