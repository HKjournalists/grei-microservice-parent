import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author 刘佳兴
 */
public class TestAttachmentController {

    @Test
    public void testUpload() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("http://localhost:9000/upload/user.image.a.b.c.d");

        FileSystemResource resource = new FileSystemResource("/home/liujx/Pictures/Selection_003.png");
        LinkedMultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("file", resource);

        String result = restTemplate.postForObject(uri, multiValueMap, String.class);

        System.out.println(result);

        Assert.assertNotNull(result);
    }

}
