package com.gj.modules.oauth.filter;

/**
 * 普通用户名，密码登陆
 *
 * @Auther: gengjian
 * @Date: 2021-01-05
 * @Description:
 */
public class OrdinaryAuthenticationFilter /*extends AbstractAuthenticationProcessingFilter*/ {
  /*  private String username = "username";
    private String password = "password";

    private BaseUserService baseUserService;

    public static final String defaultFilterProcessesUrl = "/oauth/ordinaryLogin";

    public OrdinaryAuthenticationFilter() {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, "POST"));
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String username = request.getParameter(this.username);
            String password = request.getParameter(this.password);
            String usernameDB = username;
            String passwordDB = password;
            BaseUserVO baseUserVO = baseUserService.getBaseUserByUserNameOrMobilePhone(username);
            if(!ObjectUtils.isEmpty(baseUserVO)){
                usernameDB = username;
                passwordDB = baseUserVO.getPassword();
            }
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(this.getParameterMap(request));
    }

    public static Map<String,String> getParameterMap(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            valueStr = org.apache.commons.lang.StringEscapeUtils.unescapeHtml(valueStr);
            params.put(name, valueStr);
        }
        return params;
    }

    public void setUsername(String username) {
        Assert.hasText(username, "Username parameter must not be empty or null");
        this.username = username;
    }

    public void setPassword(String password) {
        Assert.hasText(password, "Password parameter must not be empty or null");
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public BaseUserService getBaseUserService() {
        return baseUserService;
    }

    public void setBaseUserService(BaseUserService baseUserService) {
        this.baseUserService = baseUserService;
    }*/
}
