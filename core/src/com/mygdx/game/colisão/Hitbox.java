package com.mygdx.game.colisão;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.player.Player;

public class Hitbox {

   public static boolean Hitbox(Rectangle rec1,Rectangle rec2){
      if(rec1.overlaps(rec2)){
         return true;
      }
      else
         return false;
   }
}
