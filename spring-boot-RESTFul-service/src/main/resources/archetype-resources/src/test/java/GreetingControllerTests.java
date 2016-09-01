#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package};

import static ${groupId}.test.web.servlet.request.MockMvcRequestBuilders.get;
import static ${groupId}.test.web.servlet.result.MockMvcResultHandlers.print;
import static ${groupId}.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static ${groupId}.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ${groupId}.beans.factory.annotation.Autowired;
import ${groupId}.boot.test.SpringApplicationConfiguration;
import ${groupId}.test.context.junit4.SpringJUnit4ClassRunner;
import ${groupId}.test.context.web.WebAppConfiguration;
import ${groupId}.test.web.servlet.MockMvc;
import ${groupId}.test.web.servlet.setup.MockMvcBuilders;
import ${groupId}.web.context.WebApplicationContext;

/**
 * @author Greg Turnquist
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class GreetingControllerTests {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/greeting"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("${symbol_dollar}.content").value("Hello, World!"));
	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("${symbol_dollar}.content").value("Hello, Spring Community!"));
	}

}
