package com.hwk;
interface MessageService {
    String getMessage();
}
public class MessageServiceImpl implements MessageService {
    public String getMessage() {
        return "hello world";
    }
    public static void main(String[] args) {
		
	}
}