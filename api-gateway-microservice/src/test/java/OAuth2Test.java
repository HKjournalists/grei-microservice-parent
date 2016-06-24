import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘佳兴
 */
public class OAuth2Test {


    /**
     * 根据用户密码和客户端信息获取token
     *
     * @param username
     * @param password
     * @return
     */
    private String getAccessToken(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();

        String authorization = "Basic " + new String(Base64Utils.encode("clientapp:123456".getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorization);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);


        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(URI.create("http://localhost:10000/oauth/token"));
        builder.queryParam("username", username);
        builder.queryParam("password", password);
        builder.queryParam("grant_type", "password");
        builder.queryParam("scope", "read write xxxxxx");
        builder.queryParam("client_id", "clientapp");
        builder.queryParam("client_secret", "123456");


        ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST, new HttpEntity<>(headers), String.class);
        System.out.println(String.format("body: %s", responseEntity.getBody()));
        return responseEntity.getBody().substring(17, 53);
    }

    /**
     * 获取token
     */
    @Test
    public void accessToken() {
        System.out.println("access_token: " + getAccessToken("admin", "GREI@2016"));
    }

    @Test
    public void i3Courses() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "45647dfa-6865-44e0-80d8-766c65ebf3bb");

        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(URI.create("http://localhost:10000/i3/courses"));
//        builder.queryParam("token", "084efb5b-ce0b-4120-ae57-62397ea983e6");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, new HttpEntity<>(headers), String.class);

        System.out.println(responseEntity.getBody());
    }

    /**
     * 刷新token
     */
    @Test
    public void refreshToken() {

        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + "084efb5b-ce0b-4120-ae57-62397ea983e6");
        headers.set("Authorization", "Basic " + new String(Base64Utils.encode("clientapp:123456".getBytes())));

        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(URI.create("http://localhost:10000/oauth/token"));

        builder.queryParam("username", "admin");
        builder.queryParam("password", "GREI@2016");
        builder.queryParam("grant_type", "refresh_token");
        builder.queryParam("refresh_token", "59b2d81b-d00d-4b0e-9264-fb7b8821f11a");
        builder.queryParam("scope", "read write");
        builder.queryParam("client_id", "clientapp");
        builder.queryParam("client_secret", "123456");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST, new HttpEntity<>(headers), String.class);

        System.out.println(responseEntity.getBody());

    }

}
