package com.example.design.patterns;

import com.example.design.patterns.creational.factory.enumeration.PetType;
import com.example.design.patterns.creational.factory.PetFactory;
import com.example.design.patterns.creational.factory.types.Cat;
import com.example.design.patterns.creational.factory.types.Dog;
import com.example.design.patterns.creational.prototype.PrototypeA;
import com.example.design.patterns.creational.prototype.PrototypeB;
import com.example.design.patterns.creational.singleton.SingletonA;
import com.example.design.patterns.creational.singleton.SingletonB;

import com.example.design.patterns.event.dispatcher.event.CustomEngineEvent;
import com.example.design.patterns.event.dispatcher.event.EngineClosedEvent;
import com.example.design.patterns.event.dispatcher.event.EngineCreatedEvent;
import com.example.design.patterns.event.dispatcher.listener.TestGlobalEventListener;
import com.example.design.patterns.event.dispatcher.listener.TestTypedEventListener;
import com.example.design.patterns.operational.event.dispatcher.dispatcher.EventDispatcher;
import com.example.design.patterns.operational.event.dispatcher.event.Event;
import com.example.design.patterns.operational.event.dispatcher.event.RuntimeEvent;
import com.example.design.patterns.operational.event.dispatcher.listener.CommonAbstractEventListener;
import com.example.design.patterns.operational.event.dispatcher.listener.EventListener;
import com.example.design.patterns.operational.event.dispatcher.type.EventType;
import com.example.design.patterns.operational.event.dispatcher.type.RuntimeEventType;
import com.example.design.patterns.operational.publish.subscribe.custom.OurCustomEvent;
import com.example.design.patterns.operational.publish.subscribe.custom.OurEventPublisher;
import com.example.design.patterns.operational.publish.subscribe.custom.OurSecondEventPublisher;
import com.example.design.patterns.operational.publish.subscribe.custom.generic.GenericSpringEventPublisher;
import com.example.design.patterns.operational.repository.SampleEntity;
import com.example.design.patterns.operational.repository.SampleRepository;
import com.example.design.patterns.operational.template.ImplementationA;
import com.example.design.patterns.operational.template.ImplementationB;
import com.example.design.patterns.operational.template.TemplateClass;
import com.example.design.patterns.structural.adapter.Apple;
import com.example.design.patterns.structural.adapter.AppleAdapter;
import com.example.design.patterns.structural.adapter.MandarineOrange;
import com.example.design.patterns.structural.adapter.Orange;
import com.example.design.patterns.structural.decorator.Pepperoni;
import com.example.design.patterns.structural.decorator.Pizza;
import com.example.design.patterns.structural.decorator.ThickCrustPizza;
import com.example.design.patterns.structural.proxy.ExpensiveObjectProxy;
import com.example.design.patterns.structural.proxy.RealExpensiveObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static com.example.design.patterns.operational.event.dispatcher.type.RuntimeEventType.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static java.lang.System.out;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes={ DesignPatternsExamplesApplication.class })
public class DesignPatternsExamplesApplicationTests {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private PetFactory petFactory;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void AdoptPets() throws Exception {

		//adopt a dog test
		when(petFactory.createPet(any(PetType.class))).thenReturn(new Dog());

		mockMvc.perform(post("/adoptPet/{type}/{name}", PetType.DOG, "Laika"))
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(header().string("Location", "adoptPet/DOG/Laika"))
				.andExpect(jsonPath("$.name").value("Laika"))
				.andExpect(jsonPath("$.hungry").value(false))
				.andExpect(jsonPath("$.type").value("DOG"));

		//adopt a cat test
		when(petFactory.createPet(any(PetType.class))).thenReturn(new Cat());

		mockMvc.perform(post("/adoptPet/{type}/{name}", PetType.CAT, "Ma7rouss"))
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(header().string("Location", "adoptPet/CAT/Ma7rouss"))
				.andExpect(jsonPath("$.name").value("Ma7rouss"))
				.andExpect(jsonPath("$.hungry").value(false))
				.andExpect(jsonPath("$.type").value("CAT"));
	}

	@Test
	public void personInfos() throws Exception {
//		try (MockedConstruction<PersonInfoBuilder> mocked = mockConstructionWithAnswer(PersonInfoBuilder.class,
//				// default answer for the first mock
//				invocation -> new PersonInfo("firstName1", "lastName1", "nickName1",
//						null, null, null, null, null, null, null),
//				// additional answer for all further mocks
//				invocation -> new PersonInfo("firstName2", "lastName2", "nickName2",
//						null, null, null, null, null, null, null))) {
//
//			PersonInfoBuilder firstPersonInfoBuilder = new PersonInfoBuilder().firstName("firstName1")
//					.lastName("lastName1").nickName("nickName1");
//			PersonInfo personInfo1 = new PersonInfo("firstName1", "lastName1", "nickName1",
//					null, null, null, null, null, null, null);
//			PersonInfoBuilder secondPersonInfoBuilder = new PersonInfoBuilder().firstName("firstName2")
//					.lastName("lastName2").nickName("nickName2");
//			PersonInfo personInfo2 = new PersonInfo("firstName2", "lastName2", "nickName2",
//					null, null, null, null, null, null, null);
//
//			assertEquals(personInfo1, firstPersonInfoBuilder.build());
//			assertEquals(personInfo2, secondPersonInfoBuilder.build());
//			assertEquals(personInfo2, secondPersonInfoBuilder.build());
//		}
					mockMvc.perform(get("/infos"))
							.andExpect(status().isOk())
							.andDo(print())
							.andExpect(content().contentType(MediaType.APPLICATION_JSON))
							.andExpect(header().string("Location", "infos"))
							.andExpect(jsonPath("$[*].firstName").value(containsInAnyOrder("firstName1", "firstName2")))
							.andExpect(jsonPath("$[*].lastName").value(containsInAnyOrder("lastName1", "lastName2")))
							.andExpect(jsonPath("$[*].nickName").value(containsInAnyOrder("nickName1", "nickName2")));

	}

	@Autowired
	SingletonB singletonB1;

	@Autowired
	SingletonB singletonB2;

	@Test
	public void testSingletons(){
		SingletonA singletonA1 = SingletonA.getInstance();
		SingletonA singletonA2 = SingletonA.getInstance();
		Assert.assertNotNull(singletonA1);
		Assert.assertNotNull(singletonA2);
		Assert.assertSame(singletonA1, singletonA2);

		Assert.assertNotNull(singletonB1);
		Assert.assertNotNull(singletonB2);
		Assert.assertSame(singletonB1, singletonB2);
	}




	@Autowired
	PrototypeB prototypeB1;

	@Autowired
	PrototypeB prototypeB2;

	@Test
	public void testPrototypes() throws CloneNotSupportedException {
		PrototypeA prototypeA1 = new PrototypeA(1,2);
		PrototypeA prototypeA2 = (PrototypeA) prototypeA1.clone();
		Assert.assertNotNull(prototypeA1);
		Assert.assertNotNull(prototypeA2);
		Assert.assertNotSame(prototypeA1, prototypeA2);

		Assert.assertNotNull(prototypeB1);
		Assert.assertNotNull(prototypeB2);
		Assert.assertNotSame(prototypeB1, prototypeB2);
	}

	@Test
	public void testAdapters(){
		Orange orange = new MandarineOrange();
		Apple apple = new AppleAdapter(orange);
		out.println(apple.getVariety());
		apple.eat();
	}

	@Test
	public void testDecorator(){
		Pizza pizza = new ThickCrustPizza();
		out.println(pizza.getDescription());
		out.println(pizza.getCost());

		Pepperoni pepperoni = new Pepperoni(pizza);
		out.println(pepperoni.getDescription());
		out.println(pepperoni.getCost());

		Pepperoni doublePepperoni = new Pepperoni(pepperoni);
		out.println(doublePepperoni.getDescription());
		out.println(doublePepperoni.getCost());

	}

	@Test
	public void testProxy(){
		RealExpensiveObject object = new ExpensiveObjectProxy();
		object.process();
		object.process();
	}


	@Autowired
	SampleRepository sampleRepository;

	@Test
	public void testRepository(){
		sampleRepository.save(new SampleEntity("name1","description1"));
		sampleRepository.save(new SampleEntity("name2","description2"));
		out.println(sampleRepository.findByName("name1"));
		out.println(sampleRepository.findByName("name2"));
		out.println(sampleRepository.findAll());
	}

	@Test
	public void testTemplate(){
		TemplateClass templateClassA = new ImplementationA();
		TemplateClass templateClassB = new ImplementationB();
		out.println(templateClassA.open());
		templateClassA.performWork();
		templateClassA.close();
		out.println();
		out.println(templateClassB.open());
		templateClassB.performWork();
		templateClassB.close();
	}

	@Autowired
	OurEventPublisher ourEventPublisher;

	@Autowired
	OurSecondEventPublisher ourSecondEventPublisher;


	@Test
	public void publishSubscribe(){
		ourEventPublisher.publishEvent("message from spring Application Aware Event Publisher");
		ourEventPublisher.publishEvent("message from spring boot Autowired Application Event Publisher");
	}

	@Autowired
	GenericSpringEventPublisher genericSpringEventPublisher;

	@Test
	public void genericPublishSubscribe(){
		genericSpringEventPublisher.publishEvent(1, true);
		genericSpringEventPublisher.publishEvent("String", false);
		genericSpringEventPublisher.publishEvent(true, false);
		OurCustomEvent customSpringEvent = new OurCustomEvent(this, "message from a generic spring Application Event Publisher");
		genericSpringEventPublisher.publishEvent(customSpringEvent, true);
		genericSpringEventPublisher.publishEvent(Arrays.asList("1","545","a"), false);
	}

	@Autowired
	EventDispatcher eventDispatcher;

	@Test
	public void eventDispatcher(){
		assertTrue(eventDispatcher.isEnabled());
		TestTypedEventListener testTypedEventListener = new TestTypedEventListener();
		TestGlobalEventListener testGlobalEventListener = new TestGlobalEventListener();
		eventDispatcher.addEventListener(testTypedEventListener);
		eventDispatcher.addEventListener(testGlobalEventListener);
		List<EventListener> eventListeners = eventDispatcher.getEventListeners();
		assertThat(eventListeners, hasSize(1));
		Map<EventType, List<EventListener>>  typedEventListener = eventDispatcher.getTypedListeners();
		assertThat(typedEventListener, hasKey(ENGINE_CREATED));
		assertThat(typedEventListener, hasKey(CUSTOM));
		assertThat(typedEventListener, hasKey(ENGINE_CLOSED));
		HashSet<RuntimeEventType> eventTypes = (HashSet<RuntimeEventType>) testTypedEventListener.getTypes();
		assertThat(eventTypes, hasSize(3));
		eventDispatcher.dispatchEvent(new EngineCreatedEvent());
		eventDispatcher.dispatchEvent(new CustomEngineEvent());
		eventDispatcher.dispatchEvent(new EngineClosedEvent());
		List<Event> eventsReceived = testTypedEventListener.getEventsReceived();
		assertThat(eventsReceived, hasSize(3));
	}
}
