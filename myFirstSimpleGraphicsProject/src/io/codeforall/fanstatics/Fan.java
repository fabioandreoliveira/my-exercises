package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Fan implements KeyboardHandler {

    private Keyboard keyboard;
    private Picture picture;
    private Rectangle boundary;

    public Fan() {
        picture = new Picture(20, 20, "rsc/fan.jpg");
        picture.draw();

        boundary = new Rectangle(10, 10, 1000, 1000);
        initKeyboard();
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
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int currentX = picture.getX();  // Coordenada X atual da imagem
        int currentY = picture.getY();  // Coordenada Y atual da imagem
        int pictureWidth = picture.getWidth();  // Largura da imagem
        int pictureHeight = picture.getHeight();  // Altura da imagem

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT -> {
                if (currentX + pictureWidth + 100 <= boundary.getX() + boundary.getWidth()) {
                    picture.translate(100, 0);
                }}
                case KeyboardEvent.KEY_LEFT -> {
                    if (currentX - 100 >= boundary.getX()) {
                        picture.translate(-100, 0);
                    }}
                    case KeyboardEvent.KEY_UP -> {
                        if (currentY - 100 >= boundary.getY()) {
                            picture.translate(0, -100);
                        }}
                        case KeyboardEvent.KEY_DOWN -> {
                            if (currentY + pictureHeight + 100 <= boundary.getY() + boundary.getHeight()) {
                                picture.translate(0, 100);
                            }
                        }
                    }
                }

                @Override
                public void keyReleased (KeyboardEvent keyboardEvent){


                }
            }

