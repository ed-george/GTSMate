package uk.co.edgeorgedev.gtsmate.http;

import uk.co.edgeorgedev.gtsmate.utils.Logger;


public enum Response {
	NETWORK_ERROR(-1), OK(200), CREATED(201), NO_CONTENT(204),
	BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), NOT_FOUND(404), METHOD_NOT_ALLOWED(405), IM_A_TEAPOT(418),
	INTERNAL_SERVER_ERROR(500), BAD_GATEWAY(502), SERVICE_UNAVAILABLE(503), UNKNOWN(999);

	private int code;
	private Response(int value) {
		this.code = value;
	}

	public int getCode(){ return code; }

	public static Response responseFromCode(int code){
		for(Response response : Response.values()){
			if(response.getCode() == code){
				return response;
			}
		}
		return UNKNOWN;
	}

	public boolean isSuccess(){
		switch(this){
		case OK:
		case CREATED:
		case NO_CONTENT:
			return true;
		default:
			return false;
		}
	}

	public boolean isError(){
		//Lol
		return !isSuccess();
	}

	public boolean isClientError(){
		switch(this){
		case BAD_REQUEST:
		case UNAUTHORIZED:
		case FORBIDDEN:
		case NOT_FOUND:
		case METHOD_NOT_ALLOWED:
		case IM_A_TEAPOT:
			return true;
		default:
			return false;
		}
	}

	public boolean isServerError(){
		switch(this){
		case INTERNAL_SERVER_ERROR:
		case BAD_GATEWAY:
		case SERVICE_UNAVAILABLE:
			return true;
		default:
			return false;
		}
	}

	@Override
	public String toString() {
		return super.toString().replaceAll("_", " ");
	}

	public void toLog(String msg) {

		if(msg == null)
			return;

		String log = msg + " " + toString();
		
		if(isError()){
			Logger.e(getClass(), log);
		}else{
			Logger.i(getClass(), log);
		}
	}
}
