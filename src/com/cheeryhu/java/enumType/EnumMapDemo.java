package com.cheeryhu.java.enumType;

import java.util.*;

/**
 * 有一堆size大小相同而颜色不同的数据，需要统计出每种颜色的数量
 */
public class EnumMapDemo {
    public static void main(String[] args){
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(1, Color.GREEN));
        balls.add(new Ball(2, Color.RED));
        balls.add(new Ball(3, Color.GREEN));
        balls.add(new Ball(4, Color.BLUE));
        balls.add(new Ball(5, Color.GREEN));
        balls.add(new Ball(6, Color.RED));
        balls.add(new Ball(7, Color.GREEN));
        balls.add(new Ball(8, Color.RED));

        // 使用HashMap
        Map<Color, Integer> map = new HashMap<>();
        for (Ball ball: balls){
            if(map.containsKey(ball.getColor())){
                map.put(ball.getColor(), map.get(ball.getColor()) + 1);
            }else{
                map.put(ball.getColor(), 1);
            }
        }
        System.out.println(map.toString());

        //使用EnumMap
        Map<Color, Integer> enumMap = new EnumMap<>(Color.class);
        for (Ball ball : balls) {
            if (null == enumMap.get(ball.getColor())) {
                enumMap.put(ball.getColor(), 1);
            } else {
                enumMap.put(ball.getColor(), enumMap.get(ball.getColor()) + 1);
            }
        }
        System.out.println(enumMap.toString());
    }
}

enum Color{
    GREEN, RED, BLUE;
}

class Ball{
    private int num;
    private Color color;

    public Ball(int num, Color color) {
        this.num = num;
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
