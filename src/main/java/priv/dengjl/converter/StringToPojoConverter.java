package priv.dengjl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import priv.dengjl.bean.BeanParam;

@Component("stringToPojoConverter")
public class StringToPojoConverter implements Converter<String, BeanParam> {
	@Override
	public BeanParam convert(String source) {
		
		String[] split = source.split("-");
		BeanParam bean = new BeanParam();
		bean.setName(split[0]);
		bean.setNote(split[1]);
		return bean;
	}
}
