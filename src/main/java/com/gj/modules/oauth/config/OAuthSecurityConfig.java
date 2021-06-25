package com.gj.modules.oauth.config;

import lombok.extern.slf4j.Slf4j;

//@Configuration
@Slf4j
public class OAuthSecurityConfig /*extends AuthorizationServerConfigurerAdapter*/ {

    /*@Autowired
    private AuthenticationManager auth;

    @Autowired
    private AuthServerConfig authServerConfig;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RsaKeyHelper rsaKeyHelper;

//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;

	@Autowired
	private WebResponseExceptionTranslator customWebResponseExceptionTranslator;

//    @Autowired
//    private LogService logService;

    @Autowired
    protected HttpServletRequest request;

//    @Autowired
//    private BizUserHouseBiz userHouseBiz;

//    @Autowired
//    private BizUserHouseMapper userHouseMapper;


//    @Bean
//    public RedisTokenStore redisTokenStore() {
//        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
//        redisTokenStore.setPrefix("AG:OAUTH:");
//        return redisTokenStore;
//    }
    @Bean
    public JwtTokenStore jwtTokenStore() throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        JwtTokenStore jwtTokenStore = new JwtTokenStore(accessTokenConverter());
        return jwtTokenStore;
    }

    //管理令牌（Managing Token）
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)
            throws Exception {
        security.allowFormAuthenticationForClients(); // 允许客户端发送表单来进行权限认证来获取令牌
//                .passwordEncoder(new Sha256PasswordEncoder())
                //允许所有资源服务器访问公钥端点（/oauth/token_key）
                //只允许验证用户访问令牌解析端点（/oauth/check_token）
//                .tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        //需要更换成加密模式
//        security.passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    //配置授权类型（Grant Types） 配置授权端点 URL（Endpoint URLs）
    //告诉Spring Security Token的生成方式
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints
                .authenticationManager(auth)
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(accessTokenConverter())
				.exceptionTranslator(customWebResponseExceptionTranslator)
        ;
    }

    //配置客户端详情
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        //需要更换成加密模式
        clients.inMemory() // 使用in-memory存储客户端信息
                .withClient(authServerConfig.getClientId()) // client_id
                .secret(authServerConfig.getClientSecret())  // client_secret
                .authorizedGrantTypes(authServerConfig.getGrantTypes().split(",")) // 该client允许的授权类型
                // 访问token过期时长为一周过期
                .accessTokenValiditySeconds(60 * 24 * 60 * 60)
                // 刷新token过期时长为两个月
                .refreshTokenValiditySeconds(120 * 24 * 60 * 60)
                .scopes(authServerConfig.getScope()); // 允许的授权范围
    }

    //使用同一个密钥来编码 JWT 中的  OAuth2 令牌
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        byte[] pri, pub = null;
        try {
            pri = rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RedisKeyConstants.REDIS_USER_PRI_KEY).toString());
            pub = rsaKeyHelper.toBytes(redisTemplate.opsForValue().get(RedisKeyConstants.REDIS_USER_PUB_KEY).toString());
        } catch (Exception e) {
            log.error("初始化用户认证公钥/密钥异常...", e);
            throw new RuntimeException("redis异常 或 未启动auth 服务,并保证app和auth处于同一个redis集群当中...");
        }
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter() {
            *//***
             * 重写增强token方法,用于自定义一些token返回的信息
             *//*
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                OauthUser user = (OauthUser) authentication.getUserAuthentication().getPrincipal();
                *//** 自定义一些token属性 ***//*
                final Map<String, Object> additionalInformation = new HashMap<>();
                Date expireTime = DateTime.now().plusSeconds(accessToken.getExpiresIn()).toDate();
                additionalInformation.put(CommonConstants.JWT_KEY_EXPIRE, expireTime);
                additionalInformation.put(CommonConstants.JWT_KEY_USER_ID, user.getId());
                additionalInformation.put(CommonConstants.JWT_KEY_NAME, user.getName());
                additionalInformation.put("sub", user.getUsername());
                additionalInformation.put("code", 200);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                OAuth2AccessToken enhancedToken = super.enhance(accessToken, authentication);

                return enhancedToken;
            }

        };
        accessTokenConverter.setKeyPair(new KeyPair(new RSAPublicKeyImpl(pub), RSAPrivateCrtKeyImpl.newKey(pri)));
        return accessTokenConverter;
    }

    @Configuration
    @Order(100)
    protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter {
        @Autowired
        private OauthUserDetailsService oauthUserDetailsService;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(oauthUserDetailsService).passwordEncoder(new Sha256PasswordEncoder());
        }
    }*/
}