package uk.co.edgeorgedev.gtsmate.gts;

import uk.co.edgeorgedev.gtsmate.R;
import android.content.Context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

	@Expose
	@SerializedName("waza1")
	private Move move1;
	@Expose
	@SerializedName("waza2")
	private Move move2;
	@Expose
	@SerializedName("waza3")
	private Move move3;
	@Expose
	@SerializedName("waza4")
	private Move move4;
	@Expose
	@SerializedName("tokusei")
	private String nature;
	@Expose
	@SerializedName("monsno")
	private int dex;
	@Expose
	private String formNo;
	@Expose
	private int itemId;
	@Expose
	private String itemName;
	@Expose
	private int typeId1;
	@Expose
	private int typeId2;
	@Expose
	private int gender;
	@Expose
	private String typeName1;
	@Expose
	private String typeName2;
	@Expose
	private int ball;
	@Expose
	private String name;
	@Expose
	private int level;
	public Move getMove1() {
		return move1;
	}
	public void setMove1(Move move1) {
		this.move1 = move1;
	}
	public Move getMove2() {
		return move2;
	}
	public void setMove2(Move move2) {
		this.move2 = move2;
	}
	public Move getMove3() {
		return move3;
	}
	public void setMove3(Move move3) {
		this.move3 = move3;
	}
	public Move getMove4() {
		return move4;
	}
	public void setMove4(Move move4) {
		this.move4 = move4;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public String getFormNo() {
		return formNo;
	}
	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getTypeId1() {
		return typeId1;
	}
	public void setTypeId1(int typeId1) {
		this.typeId1 = typeId1;
	}
	public int getTypeId2() {
		return typeId2;
	}
	public void setTypeId2(int typeId2) {
		this.typeId2 = typeId2;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getTypeName1() {
		return typeName1;
	}
	public void setTypeName1(String typeName1) {
		this.typeName1 = typeName1;
	}
	public String getTypeName2() {
		return typeName2;
	}
	public void setTypeName2(String typeName2) {
		this.typeName2 = typeName2;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public int getImage(Context ctx){
		int img = ctx.getResources().getIdentifier("poke_" + dex, "drawable", ctx.getPackageName());
		return img == 0 ? R.drawable.logo : img;
	}
	
	@Override
	public String toString() {
		return name + " " + "Lv. " + Integer.toString(level);
	}
	
	

}