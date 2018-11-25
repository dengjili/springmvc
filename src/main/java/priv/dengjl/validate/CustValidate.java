package priv.dengjl.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import priv.dengjl.bean.JsrBean;

public class CustValidate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return JsrBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 已经判断过类型了，直接强转即可
		JsrBean jsrBean = (JsrBean) target;
		double banlance = jsrBean.getAmount() - (jsrBean.getQuantity() * jsrBean.getPrice());
		if (banlance < 0) {
			errors.rejectValue("amount", null, "实收金额不对");
		}
	}

}
