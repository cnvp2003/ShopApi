package com.db;

import com.db.controllers.ShopController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ShopControllerTest {

	private MockMvc mvc;

	/*@Autowired
	private ShopService shopServiceMock;*/

	//private ShopService shopServiceMock = mock(ShopService.class);

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new ShopController()).build();
	}

	/*@Test
	public void create() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/shop").content("{\"id\":\"1\",\"name\":\"Dominos\",\"address\":{\"number\":null,\"city\":\"delhi\",\"postCode\":\"110002\"}}").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":\"1\",\"name\":\"Dominos\",\"address\":{\"number\":null,\"city\":\"delhi\",\"postCode\":\"110002\",\"location\":{\"lat\":28.6139391,\"lng\":77.2090212}}}")));
	}*/

	/*@Test
	public void getAll() throws Exception {
		Shop shop1 = new Shop();
		shop1.setId("1");
		shop1.setName("Dominos");

		Shop shop2 = new Shop();
		shop2.setId("2");
		shop2.setName("KFC");

		List<Shop> shopList = new ArrayList<Shop>();
		shopList.add(shop1);
		shopList.add(shop2);

		when(shopServiceMock.getAll()).thenReturn(shopList);

		mvc.perform(MockMvcRequestBuilders.get("/shop/all"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":\"1\",\"name\":\"Dominos\"} {\"id\":\"2\",\"name\":\"KFC\"}]")));
	}*/
}
