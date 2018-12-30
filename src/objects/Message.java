package objects;

public class Message {

	String sender;
	String date;
	String message;

	public Message() {

	}

	public Message(String sender, String date, String message) {
		super();
		this.sender = sender;
		this.date = date;
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", date=" + date + ", message=" + message + "]";
	}

}
