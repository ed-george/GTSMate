package uk.co.edgeorgedev.gtsmate.gts;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import uk.co.edgeorgedev.gtsmate.utils.Logger;

public class GTSUser {

	private String user_id;
	private String account_id;
	private String savedata_id;

	public GTSUser(String user_id, String account_id, String savedata_id) {
		this.user_id = user_id;
		this.account_id = account_id;
		this.savedata_id = savedata_id;
	}

	public GTSUser(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getSavedata_id() {
		return savedata_id;
	}
	public void setSavedata_id(String savedata_id) {
		this.savedata_id = savedata_id;
	}

	public boolean isValid(){
		return user_id != null && account_id != null && savedata_id != null; 
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


	public boolean getSecretCredentials(String result) {
		String[] vars = StringUtils.substringsBetween(result, "var", ";");
		if(vars != null){
			for(String var : vars){
				String value = StringUtils.substringBetween(var, "'");
				if(var.contains("USERS_ACCOUNT_ID")){
					account_id = value;
				}else if(var.contains("USERS_SAVEDATA_ID")){
					savedata_id = value;
				}else{
					Logger.w(getClass(), "Found unused var "+ var);
				}
			}
			return isValid();
		}else{
			return false;
		}

	}

}
