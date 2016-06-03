package data.web;

import data.Application;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.restdocs.snippet.Attributes.attributes;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class DictionaryControllerTests {

	@Rule
	public final RestDocumentation restDocumentation = new RestDocumentation("build/generated-snippets");

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	private RestDocumentationResultHandler document;

	@Before
	public void setUp() {
		//单个测试方法文档名生成规则
		this.document = document("{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()));
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation))
				.alwaysDo(this.document)
				.build();
	}

	@Test
	public void testPageOfDictionary() throws Exception {

//		this.document.snippets(requestFields(
//				fieldWithPath("name").type("String").description("名称"),
//				fieldWithPath("code").type("String").description("编码"),
//				fieldWithPath("page").type("Number").description("第几页条"),
//				fieldWithPath("size").type("Number").description("每一页条数"),
//				fieldWithPath("sort").type("String").description("排序字段")
//		));
		//请求参数列表
		this.document.snippets(requestParameters(
				parameterWithName("name").description("名称"),
				parameterWithName("code").description("编码"),
				parameterWithName("page").description("第几页"),
				parameterWithName("size").description("每页条数")
		));

		//返回参数列表
		this.document.snippets(responseFields(
				fieldWithPath("content").type("Array").description("内容"),
				fieldWithPath("content[].id").type("Number").description("ID"),
				fieldWithPath("content[].name").type("String").description("名称"),
				fieldWithPath("content[].code").type("String").description("编码"),
				fieldWithPath("content[].remark").type("String").description("备注"),
				fieldWithPath("content[].createTime").type("Number").description("创建时间"),
				fieldWithPath("content[].updateTime").type("Number").description("更新时间"),
				fieldWithPath("content[].createBy").type("Number").description("创建人"),
				fieldWithPath("content[].updateBy").type("Number").description("更新人"),
				fieldWithPath("last").description("是否最后一页"),
				fieldWithPath("totalElements").description("总条数"),
				fieldWithPath("totalPages").description("总页数"),
				fieldWithPath("sort").description("排序"),
				fieldWithPath("first").description("是否第一页"),
				fieldWithPath("numberOfElements").description("当前页面条数"),
				fieldWithPath("size").description("每页条数"),
				fieldWithPath("number").description("当前第几页")
		));

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/dictionaries");
		builder.queryParam("name", "");
		builder.queryParam("code", "");
		builder.queryParam("page", "0");
		builder.queryParam("size", "2");

		this.mockMvc.perform(get(builder.build().toUri()).accept(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());

	}


}
