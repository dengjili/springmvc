package priv.dengjl.bean;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class JsrBean {
	// 产品编号
	@NotNull
	private Long productId;
	
	// 用户编号
	@NotNull
	private Long userId;
	
	// 交易日期
	@NotNull
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	// 价格
	@NotNull
	@DecimalMin("0.5")
	private Double price;
	
	// 数量
	@NotNull
	@Max(100)
	@Min(1)
	private Integer quantity;
	
	// 交易金额
	@NotNull
	/*@DecimalMax("1000")*/
	private Double amount;
	
	// 电话号码
	@NotNull
	@Pattern(regexp = "^1[34578]\\d{9}$", message = "号码格式不对")
	private String phone;
	
	// 备注,0 - 255 个字符
	@Size(min = 0, max = 255)
	private String remarks;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
