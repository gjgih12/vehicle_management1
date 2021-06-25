package com.gj.modules.oauth;

/**
 * tokan校验失败返回信息
 */
public class AuthExceptionEntryPoint /*implements AuthenticationEntryPoint*/ {


	/*@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
			throws ServletException {

		Map<String,Object> map = new HashMap();
		map.put("error", 401);
//		map.put("message", authException.getMessage());
		map.put("message", "token错误");
		map.put("path", request.getServletPath());
		map.put("timestamp", String.valueOf(new Date().getTime()));
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(response.getOutputStream(), map);
		} catch (Exception e) {
			throw new ServletException();
		}
	}*/
}
