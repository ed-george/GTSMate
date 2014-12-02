/**
 * PokeballHelper.java
 * GTSMate
 *
 * Created by Ed George on 1 Dec 2014
 *
 */
package uk.co.edgeorgedev.gtsmate.utils;

import java.util.Locale;

import uk.co.edgeorgedev.gtsmate.R;
import android.content.Context;

/**
 * @author edgeorge
 *
 */
public enum Pokeball {

	MASTER_BALL(1), ULTRA_BALL(2), GREAT_BALL(3), POKE_BALL(4), SAFARI_BALL(5), NET_BALL(6), DIVE_BALL(7), NEST_BALL(8), REPEAT_BALL(9),
	TIMER_BALL(10), LUXUARY_BALL(11), PREMIER_BALL(12), DUSK_BALL(13), HEAL_BALL(14), QUICK_BALL(15), 
	LOVE_BALL(496), HEAVY_BALL(495), MOON_BALL(498), DREAM_BALL(576), UNKNOWN_BALL(-1);

	private final int value;

	private Pokeball(int value) {
		this.value = value;
	}

	public int getBallNumber(){
		return value;
	}

	public static Pokeball getBallFromNumber(int value){
		for(Pokeball ball : values()){
			if(ball.value == value){
				return ball;
			}
		}	
		return UNKNOWN_BALL;
	}

	@Override
	public String toString() {
		return "ball_" + super.toString().split("_")[0].toLowerCase(Locale.getDefault());
	}

	public int getImage(Context ctx){
		switch(this){

		case UNKNOWN_BALL:
			return R.drawable.logo;

		default:
			int res_id = ctx.getResources().getIdentifier(toString(), "drawable", ctx.getPackageName());
			return res_id == 0 ? R.drawable.logo : res_id;
		}
	}


}
