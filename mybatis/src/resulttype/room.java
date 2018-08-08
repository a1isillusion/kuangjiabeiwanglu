package resulttype;

public class room {
public int id;
public String type;
public int price;
public int deposit;
public String status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getDeposit() {
	return deposit;
}
public void setDeposit(int deposit) {
	this.deposit = deposit;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "room [id=" + id + ", type=" + type + ", price=" + price + ", deposit=" + deposit + ", status=" + status
			+ "]";
}

}
