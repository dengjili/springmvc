package priv.dengjl.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class FormatBean {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@NumberFormat(pattern = "#,###.##")
	private Double amount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
