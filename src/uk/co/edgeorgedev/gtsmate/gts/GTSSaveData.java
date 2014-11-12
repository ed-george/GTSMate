package uk.co.edgeorgedev.gtsmate.gts;

import com.google.gson.annotations.Expose;

public class GTSSaveData {

	@Expose
	private String accountId;
	@Expose
	private String trainerName;
	@Expose
	private String savedataId;
	@Expose
	private String trainerNameRuby;
	@Expose
	private String memberSavedataIdCode;
	@Expose
	private String countryCode;
	@Expose
	private String address;
	@Expose
	private String country;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getSavedataId() {
		return savedataId;
	}
	public void setSavedataId(String savedataId) {
		this.savedataId = savedataId;
	}
	public String getTrainerNameRuby() {
		return trainerNameRuby;
	}
	public void setTrainerNameRuby(String trainerNameRuby) {
		this.trainerNameRuby = trainerNameRuby;
	}
	public String getMemberSavedataIdCode() {
		return memberSavedataIdCode;
	}
	public void setMemberSavedataIdCode(String memberSavedataIdCode) {
		this.memberSavedataIdCode = memberSavedataIdCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
