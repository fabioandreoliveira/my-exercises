package io.codeforall.fanSTATICS;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    int cellSize = 20;
    int PADDING = 10;

    Keyboard keyboard;

    Rectangle player;
    int playerX = 0;
    int playerY = 0;
    boolean isSpacePressed = false;

    public Player() {
        initPlayer();
    }

    private void initPlayer() {
        player = new Rectangle(PADDING, PADDING, cellSize, cellSize);
        player.setColor(Color.BLACK);
        player.fill();
        initKeyboard();
        startUpdateLoop();
    }

    private void paintCurrentCell() {
        Rectangle cell = new Rectangle(PADDING + playerX * cellSize, PADDING + playerY * cellSize, cellSize, cellSize);
        cell.setColor(Color.RED); // Defina a cor que você deseja usar para pintar
        cell.fill(); // Pinta a célula
    }

    private void initKeyboard() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveLeft);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveUp);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveDown);

        KeyboardEvent paintCell = new KeyboardEvent();
        paintCell.setKey(KeyboardEvent.KEY_SPACE);
        paintCell.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(paintCell);
    }

    private void startUpdateLoop() {
        Thread updateThread = new Thread(() -> {
            while (true) {
                if (isSpacePressed) {
                    paintCurrentCell();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        );
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (playerX < 49) {
                    player.translate(20, 0);
                    playerX++;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (playerX > 0) {
                    player.translate(-20, 0);
                    playerX--;
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (playerY > 0) {
                    player.translate(0, -20);
                    playerY--;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (playerY < 49) {
                    player.translate(0, 20);
                    playerY++;
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                isSpacePressed = true;
                paintCurrentCell();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    /*    if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            isSpacePressed = false;
        }*/
    }


}



