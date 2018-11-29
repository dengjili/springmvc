package priv.dengjl.converter;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("stringToArrayConverter")
public class MyGenericConverter implements ConditionalGenericConverter {

	@Autowired
	private StringToPojoConverter stringToPojoConverter;
	
	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return Collections.singleton(new ConvertiblePair(String.class, Object[].class));
	}

	// 转换方法
	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		String string = (String) source;
		String[] fields = StringUtils.commaDelimitedListToStringArray(string);
		// 转换目标
		Object target = Array.newInstance(targetType.getElementTypeDescriptor().getType(), fields.length);
		// 填充值
		for (int i = 0; i < fields.length; i++) {
			String sourceElement = fields[i];
			/*Object targetElement = this.conversionService.convert(sourceElement.trim(), sourceType,
					targetType.getElementTypeDescriptor());*/
			Object targetElement = stringToPojoConverter.convert(sourceElement.trim());
			Array.set(target, i, targetElement);
		}
		return target;
	}

	// 判断是否具有转换方法
	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return true;
	}

}
