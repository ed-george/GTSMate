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

	POKE_BALL(4), GREAT_BALL(3), ULTRA_BALL(2), MASTER_BALL(1),
	LOVE_BALL(496), HEAVY_BALL(495), REPEAT_BALL(9), DREAM_BALL(576),
	QUICK_BALL(15), DUSK_BALL(13), TIMER_BALL(10), PREMIER_BALL(12),
	LUXUARY_BALL(11), NEST_BALL(8), DIVE_BALL(7), MOON_BALL(498), HEAL_BALL(14), UNKNOWN(-1);

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
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return "ball_" + super.toString().split("_")[0].toLowerCase(Locale.getDefault());
	}
	
	public int getImage(Context ctx){
		switch(this){
		
		case UNKNOWN:
			return R.drawable.logo;
			
		default:
			int res_id = ctx.getResources().getIdentifier(toString(), "drawable", ctx.getPackageName());
			return res_id == 0 ? R.drawable.logo : res_id;
		}
	}
	

}
