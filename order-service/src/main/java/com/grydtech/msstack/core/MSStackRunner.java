package com.grydtech.msstack.core;

public final class MSStackRunner {
    private MSStackRunner(){
    }

    public static void run(Class<? extends MSStackApplication> sendingClass) {
        try {
            sendingClass.newInstance().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
