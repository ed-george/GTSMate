/**
 * ResetableInputStream.java
 * Boppl
 * 
 * Created by Ed George on Sep 26, 2014
 * Copyright (c) 2013-14 Boppl Ltd. All rights reserved. 
 *
 */
package uk.co.edgeorgedev.gtsmate.http;

import java.io.IOException;
import java.io.InputStream;

public class ResetableInputStream extends InputStream {

	private final InputStream stream;
	private boolean markingSupported;

	public ResetableInputStream(InputStream inputStream) {

		if(inputStream == null){
			throw new IllegalArgumentException("Stream cannot be null");
		}
		
		this.markingSupported = inputStream.markSupported();
		this.stream = inputStream;
		
		if (markingSupported) {
			stream.mark( 1 << 32);
		}
	}

	@Override
	public void close() throws IOException {
		if(markingSupported){
			stream.reset();
		}else{
			super.close();
		}
	}

	public void forceClose() throws IOException{
		super.close();
	}
	
	@Override
	public int read() throws IOException {
		return stream.read();
	}

	public boolean isMarkingSupported() {
		return markingSupported;
	}

}


