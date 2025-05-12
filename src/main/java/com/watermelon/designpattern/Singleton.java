package com.watermelon.designpattern;

/**
 * <h1>Singleton</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/7
 */
public class Singleton {

    private static volatile Singleton instance;

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}