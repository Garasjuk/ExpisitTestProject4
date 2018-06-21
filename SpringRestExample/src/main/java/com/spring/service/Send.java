package com.spring.service;

import java.io.IOException;

public interface Send {
	public void setSend(String to, String title, String text) throws IOException;

}
