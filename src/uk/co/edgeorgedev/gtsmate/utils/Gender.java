/**
 * Gender.java
 * GTSMate
 *
 * Created by Ed George on 1 Dec 2014
 *
 */
package uk.co.edgeorgedev.gtsmate.utils;

import uk.co.edgeorgedev.gtsmate.R;

/**
 * @author edgeorge
 *
 */
public enum Gender {
	MALE(0), FEMALE(1), GENDERLESS(2);
	
	private final int value;

	private Gender(int value) {
		this.value = value;
	}

	public static Gender getGenderFromNumber(int value){
		for(Gender gender : values()){
			if(gender.value == value){
				return gender;
			}
		}	
		return GENDERLESS;
		
	}

	public int getImage(){
		switch(this){
	
		case MALE:
			return R.drawable.male;
		
		case FEMALE:
			return R.drawable.female;

		default:
			return R.drawable.logo;
		}
	}

	
}
