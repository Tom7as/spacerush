package com.jerabek.spacerush.screens.playClass;

import com.jerabek.spacerush.screens.NewGameConfig;

import java.util.HashMap;

public class ExampleGameData {


    //1)
    HashMap<String, Integer> profese1 = new HashMap<>();
    {
        profese1.put("stavitel",5);
        profese1.put("farmar",7);
    }

    void pridejStavitele1(int x) {
        profese1.replace("stavitel", profese1.get("stavitel")+ x );
    }

    //--------------
    //2) nová třída s hromadou int
    private profese2 profese;

    class profese2 {
        int stavitel = 5;
        int farmar = 7;

        void pridejStavitele(int x) {
            stavitel += x;
        }
    }

    //--------------
    // 3)
    int[] profese3 = {5, 7};

    void pridejStavitele3(int x) {
            profese3[0] += x ;
        }


}
