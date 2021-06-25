package com.gj.modules.oauth;

/**
 * CustomOauthException的序列化实现
 */
public class CustomOauthExceptionSerializer /*extends StdSerializer<CustomOauthException>*/ {
	/*public CustomOauthExceptionSerializer() {
		super(CustomOauthException.class);
	}

	@Override
	public void serialize(CustomOauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		gen.writeStartObject();
		gen.writeStringField("error", String.valueOf(value.getHttpErrorCode()));
		gen.writeStringField("message", value.getMessage());
//        gen.writeStringField("message", "用户名或密码错误");
		gen.writeStringField("path", request.getServletPath());
		gen.writeStringField("timestamp", String.valueOf(new Date().getTime()));
		gen.writeEndObject();
	}*/
}
