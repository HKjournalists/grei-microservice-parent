package services.oauth2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import services.oauth2.service.AdminUserDetailsService;

import javax.sql.DataSource;

/**
 * oauth2 授权服务和资源服务配置
 *
 * @author 刘佳兴
 */
@Configuration
public class OAuth2ServerConfiguration {

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            super.configure(resources);
        }

        /**
         * 配置资源访问权限,除了获取token之外的链接，都需要经过校验，暂时没做详细的权限划分。
         *
         * @param http
         * @throws Exception
         */
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/**").authenticated();
            super.configure(http);
        }

    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private AdminUserDetailsService adminUserDetailsService;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(this.tokenStore())
                    .authenticationManager(this.authenticationManager)
                    .userDetailsService(adminUserDetailsService);

            super.configure(endpoints);
        }

        @Bean
        @ConfigurationProperties(prefix = "spring.datasource")
        public DataSource dataSource() {
            return DataSourceBuilder.create().build();
        }

        //配置客户端，后续可扩展通过数据库管理
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient("clientapp")
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("read", "write")
//                    .accessTokenValiditySeconds(2)  //配置token的时间
                    .secret("123456");
            super.configure(clients);
        }

        @Bean
        public TokenStore tokenStore() {
            return new JdbcTokenStore(dataSource());
        }

        @Primary
        @Bean
        public DefaultTokenServices defaultTokenServices() {
            DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
            defaultTokenServices.setSupportRefreshToken(true);
            defaultTokenServices.setTokenStore(tokenStore());
            return defaultTokenServices;
        }

    }



}
