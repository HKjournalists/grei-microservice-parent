package data.dto;

import lombok.Data;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@Data
public class AttachmentData {

    private String name;

    private String url;

    public AttachmentData() {

    }

    public AttachmentData(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
