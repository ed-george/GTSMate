package uk.co.edgeorgedev.gtsmate.gts;

import com.google.gson.annotations.Expose;

public class GTSTrade {

	@Expose
	private GTSSaveData tradeSavedata;
	@Expose
	private Pokemon tradePokemon;
	@Expose
	private String tradeDate;
	@Expose
	private Pokemon postSimple;
	
	/**
	 * @return the tradeDate
	 */
	public String getTradeDate() {
		return tradeDate;
	}
	
	public String getTradeDay() {
		return tradeDate.split(" ")[0];
	}
	
	public String getTradeTime() {
		return tradeDate.split(" ")[1];
	}

	/**
	 * @param tradeDate the tradeDate to set
	 */
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public GTSSaveData getTradeSavedata() {
		return tradeSavedata;
	}

	public void setTradeSavedata(GTSSaveData tradeSavedata) {
		this.tradeSavedata = tradeSavedata;
	}

	public Pokemon getTradePokemon() {
		return tradePokemon;
	}

	public void setTradePokemon(Pokemon tradePokemon) {
		this.tradePokemon = tradePokemon;
	}

	public Pokemon getPostSimple() {
		return postSimple;
	}

	public void setPostSimple(Pokemon postSimple) {
		this.postSimple = postSimple;
	}
	
}
