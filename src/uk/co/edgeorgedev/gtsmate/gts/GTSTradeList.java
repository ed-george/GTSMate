package uk.co.edgeorgedev.gtsmate.gts;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GTSTradeList {

	@SerializedName("status_code")
	@Expose
	private String statusCode;
	@Expose
	private Integer totalCount;
	@Expose
	private List<GTSTrade> tradeList = new ArrayList<GTSTrade>();
	@Expose
	private GTSError error;
	/**
	 * 
	 * @return
	 * The statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * 
	 * @param statusCode
	 * The status_code
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public GTSTradeList withStatusCode(String statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	/**
	 * 
	 * @return
	 * The totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 
	 * @param totalCount
	 * The totalCount
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public GTSTradeList withTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		return this;
	}

	/**
	 * 
	 * @return
	 * The tradeList
	 */
	public List<GTSTrade> getTradeList() {
		return tradeList;
	}

	/**
	 * 
	 * @param tradeList
	 * The tradeList
	 */
	public void setTradeList(List<GTSTrade> tradeList) {
		this.tradeList = tradeList;
	}

	public GTSTradeList withTradeList(List<GTSTrade> tradeList) {
		this.tradeList = tradeList;
		return this;
	}

	public GTSError getError() {
		return error;
	}

	public boolean isError() {
		return !statusCode.equals("0000");
	}	

}